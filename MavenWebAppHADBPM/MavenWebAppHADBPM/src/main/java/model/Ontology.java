package model;

import com.mycompany.mavenwebapphadbpm.Info;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asUnorderedSet;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.coode.owlapi.manchesterowlsyntax.ManchesterOWLSyntaxEditorParser;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.expression.ParserException;
import org.semanticweb.owlapi.expression.ShortFormEntityChecker;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.semanticweb.owlapi.util.BidirectionalShortFormProvider;
import org.semanticweb.owlapi.util.BidirectionalShortFormProviderAdapter;
import org.semanticweb.owlapi.util.ShortFormProvider;
import org.semanticweb.owlapi.util.SimpleShortFormProvider;
import org.semanticweb.owlapi.vocab.OWL2Datatype;

/**
 * This class will represent the DAO of the app HADBPM<br />
 * Contains all the methods to read and write the ontology
 * @author lexr
 */
public class Ontology {

    int nbIndPatient = 0;
    int nbTot = 0;
    OWLClass patient;
    OWLClass disease;
    private OWLOntology onto;
    private String owlIRI;
    private OWLOntologyManager man;

    /**
     * Constructor
     *
     * @param file The ontology file
     */
    public Ontology(File file) {
        // Create the ontology manager
        man = OWLManager.createOWLOntologyManager();
        try {
            onto = man.loadOntologyFromOntologyDocument(new File(file.getAbsolutePath()));
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }
        // Get the IRI of the owl file
        owlIRI = onto.getOntologyID().getOntologyIRI().get().toString();
    }

    /**
     * Give the Ontology
     *
     * @return The ontology OWLOntology
     */
    public OWLOntology getOntology() {
        return onto;
    }

    /**
     * Create a reasoner for the ontology
     *
     * @param o the ontology on wich the reasoner will compute
     * @return The settled reasoner
     */
    public OWLReasoner useReasoner(OWLOntology o) {

        // Call the factory to use a reasoner
        OWLReasonerFactory orf = new StructuralReasonerFactory();
        // Create the reasoner for the ontology
        OWLReasoner reasoner = orf.createReasoner(o);
        // Look for inferences in the ontology
        reasoner.precomputeInferences();

        return reasoner;

    }

    
    
    /**
     *
     * Display all the individual from a class
     *
     * @param reasoner
     * @param individualName the Name of the ontology class in which the
     * indivuals are
     * @return An ArrayList<String> Containing all the individual from a
     * specified class
     */
    public ArrayList<Patient> getPatientInOntology(OWLReasoner reasoner, String individualName) {
        reasoner.precomputeInferences();
        ArrayList<Patient> pats = new ArrayList<>();
        //ArrayList<String> liste = new ArrayList<>();
        onto.classesInSignature().forEach(c -> {
          
            if (c.getIRI().getFragment().equals(individualName)) {
                patient = c;
            }
          
        });
       
        // Display all the individual
        for (OWLNamedIndividual cls : reasoner.getInstances(patient).getFlattened()) {
                pats.add(searchPatient(cls.getIRI().getFragment(), reasoner));
            
        }

        return pats;
    }
    
    /**
     *
     * Display all the individual from a class
     *
     * @param reasoner
     * @param individualName the Name of the ontology class in which the
     * indivuals are
     * @return An ArrayList<String> Containing all the individual from a
     * specified class
     */
    public ArrayList<String> searchDisease(OWLReasoner reasoner, String individualName) {
        ArrayList<String> pats = new ArrayList<>();
        
        // Get all the Disease Individual
        onto.classesInSignature().forEach(c -> {
            if (c.getIRI().getFragment().equals(individualName)) {
                disease = c;
            }
        });

        // Display all the individual
        for (OWLNamedIndividual cls : reasoner.getInstances(disease).getFlattened()) {
            pats.add(cls.getIRI().getRemainder().get());
        }

        return pats;
    }
    
    
    

    /**
     * Get All the properties for an individual an displays the values <br />
     * Method used in InfoPatient
     *
     * @param reasoner Reasoner that will make the inferences
     * @param individual The String Name of the Individual
     * @return patient the representation of a patient
     */
    public Patient getIndividualProperties(OWLReasoner reasoner, String individual) {
        Patient pat = new Patient();
        HashMap<String, String> properties = new HashMap<>();
        // Test to retrieve a particular value for a particular individual (WORKING)
        onto.individualsInSignature().forEach(i -> onto.dataPropertiesInSignature().forEach(p -> {
            // Put each individual in a set
            Set<OWLLiteral> individualValues = reasoner.getDataPropertyValues(i, p);
            // Read the value corresponding to the DataProperty and put it in a set
            Set<OWLLiteral> values = asUnorderedSet(individualValues.parallelStream());
            // Display the property for the individual
            if (i.getIRI().toString().equals(owlIRI + "#" + individual)) {
                for (OWLLiteral ind : values) {
                    try {
                        switch (p.getIRI().getRemainder().get()) {
                            case "hasName":
                                pat.setHasName(ind.getLiteral());
                                break;
                            case "hasFirstName":
                                pat.setHasFirstName(ind.getLiteral());
                                break;
                            case "hasSex":
                                if (ind.getLiteral().equals("Male")) {
                                    pat.setHasSex(Sexe.Male);
                                } else {
                                    pat.setHasSex(Sexe.Female);
                                }
                                break;
                            case "hasDateOfBirth":
                                String strDate = ind.getLiteral();
                                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                Date date = format.parse(strDate);
                                System.out.println(date);
                                pat.setHasDateOfBirth(date);
                                break;
                            case "hasPlaceOfBirth":
                                pat.setHasPlaceOfBirth(ind.getLiteral());
                                break;
                            case "hasSocialSecurityNumberID":
                                pat.setHasSocialSecurityNumberID(Integer.parseInt(ind.getLiteral()));
                                break;
                            case "hasAdress":
                                pat.setHasAdress(ind.getLiteral());
                                break;
                            case "hasPhoneNumber":
                                pat.setHasPhoneNumber(Integer.parseInt(ind.getLiteral()));
                                break;
                            case "hasEmail":
                                pat.setHasEmail(ind.getLiteral());
                                break;
                            case "hasMaritalStatus":
                                switch (ind.getLiteral()) {
                                    case "Divorced":
                                        pat.setHasMaritalStatus(MaritalStatus.Divorced);
                                        break;
                                    case "Legelly separated":
                                        pat.setHasMaritalStatus(MaritalStatus.LegallySeparated);
                                        break;
                                    case "Married":
                                        pat.setHasMaritalStatus(MaritalStatus.Married);
                                        break;
                                    case "Single":
                                        pat.setHasMaritalStatus(MaritalStatus.Single);
                                        break;
                                    case "Widowed":
                                        pat.setHasMaritalStatus(MaritalStatus.Widowed);
                                        break;                                   
                                }
                                break;
                            case "isInternet":
                                switch (ind.getLiteral()) {
                                    case "true":
                                        pat.setIsInternet(Boolean.TRUE);
                                        break;
                                    case "false":
                                        pat.setIsInternet(Boolean.FALSE);
                                        break;
                                }
                                break;
                            case "hasSize":
                                pat.setHasSize(Float.parseFloat(ind.getLiteral()));
                                break;
                            case "hasWeight":
                                pat.setHasWeight(Float.parseFloat(ind.getLiteral()));
                                break;
                            case "hasAllergies":
                                pat.setHasAllergies(ind.getLiteral());
                                break;
                            case "hasDisease":
                                //pat.set
                                break;
                            case "hasPrevious":
                                pat.setHasPrevious(ind.getLiteral());
                                break;
                            case "isValideFamily":
                                if (ind.getLiteral().equals("true")) {
                                    pat.setIsValideFamily(Boolean.TRUE);
                                } else {
                                    pat.setIsValideFamily(Boolean.FALSE);
                                }
                                break;
                            case "isValide":
                                if (ind.getLiteral().equals("true")) {
                                    pat.setIsValide(Boolean.TRUE);
                                } else {
                                    pat.setIsValide(Boolean.FALSE);
                                }
                                break;
                            case "isAccessiblePlace":
                                if (ind.getLiteral().equals("true")) {
                                    pat.setIsAccessiblePlace(Boolean.TRUE);
                                } else {
                                    pat.setIsAccessiblePlace(Boolean.FALSE);
                                }
                                break;
                            case "hasNotes":
                                pat.setHasNotes(ind.getLiteral());
                                break;
                            case "isSport":
                                if (ind.getLiteral().equals("true")) {
                                    pat.setIsSport(Boolean.TRUE);
                                } else {
                                    pat.setIsSport(Boolean.FALSE);
                                }
                                break;
                            case "isSmoking":
                                if (ind.getLiteral().equals("true")) {
                                    pat.setIsSmoking(Boolean.TRUE);
                                } else {
                                    pat.setIsSmoking(Boolean.FALSE);
                                }
                                break;
                        }
                    } catch (ParseException ex) {
                        Logger.getLogger(Ontology.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }));
        return pat;
    }

    /**
     * Give all the infromation for a given id of a patient<br />
     * Method used in
     * searchPatient
     *
     * @param id The id of the patient to look for
     * @param reasoner
     * @return The Patient
     */
    public Patient searchPatient(String id, OWLReasoner reasoner) {
        Patient pat = new Patient();
        try {
            System.out.println(onto.getAxiomCount());
        } catch (Exception e) {
            
                System.out.println("Erreur ou pas ?");
                e.printStackTrace();
           
        }
        pat.setId(id);
        //System.out.println(id); 
        onto.individualsInSignature().forEach(i -> onto.dataPropertiesInSignature().forEach(p -> {     
            
            if (i.getIRI().getFragment().equals(id)) {
//                pat.setId(id);

                Set<OWLLiteral> prop = reasoner.getDataPropertyValues(i, p);
                Set<OWLLiteral> values = asUnorderedSet(prop.parallelStream());
            
                for (OWLLiteral v : values) {
                    if (p.getIRI().getFragment().equals("hasFirstName")) {
                        pat.setHasFirstName(v.getLiteral());
                    }
                    if (p.getIRI().getFragment().equals("hasName")) {
                        pat.setHasName(v.getLiteral());
                    }
                }

            }

        }));
        return pat;
    }
    
    /**
     * Look in the ontology to retrieve all the disease
     * Method to list the disease<br />
     * Used in addPatient.jsp
     * @return The list of Disease as a String
     */
    public List<String> getListofDisease() {
        ArrayList disease = new ArrayList<>();
        onto.getClassesInSignature().forEach(c -> {
            //System.out.println(cls);
            if (c.getIRI().getRemainder().get().equals("Disease")) { 
                for (OWLNamedIndividual d : useReasoner(onto).getInstances(c).getFlattened()) {
                    System.out.println(d.getIRI().getRemainder().get());
                    disease.add(d.getIRI().getRemainder().get());
                }
            }
        });
        return disease;
    }

    /**
     * Add all the information of the patient in the ontology <br />
     * Method used in addPatient
     *
     * @param data the array with all the data that will be inserted in the owl
     * document
     * @param name The name of the individual to add to the ontology
     */
    public void addPatientIndividual(ArrayList<Info> data, String name) {
        OWLDataFactory df = man.getOWLDataFactory();

        // Actor's IRI
        OWLClass actorIRI = df.getOWLClass(IRI.create(owlIRI + "#Patient"));

        // Patient individual
        OWLIndividual patient = df.getOWLNamedIndividual(IRI.create(owlIRI + "#" + name));

        // Create a link between the class patient and the individual
        OWLClassAssertionAxiom type = df.getOWLClassAssertionAxiom(actorIRI, patient);
        // Create the axiom corresponding to the link between the patient and the
        // individual
        AddAxiom axiomType = new AddAxiom(onto, type);
        // Add the former link to the ontology
        man.applyChange(axiomType);

        // Disease individual
        OWLIndividual disease = df.getOWLNamedIndividual(owlIRI + "#" + ((Info) data.get(0)).getValue());
        // Create the property which is already in the owl the name of the patient to
        // the individual
        OWLObjectProperty hasDisease = df.getOWLObjectProperty(owlIRI + "#hasDisease");
        // Link the disease to the patient
        OWLObjectPropertyAssertionAxiom axiomHasDisease = df.getOWLObjectPropertyAssertionAxiom(hasDisease, patient,
                disease);
        // Create the axiom
        AddAxiom addAxiomHasDisease = new AddAxiom(onto, axiomHasDisease);
        // Apply the axiom to the ontology
        man.applyChange(addAxiomHasDisease);

        // Delete the axiom of the disease
        data.remove(data.get(0));

        for (AddAxiom axiom : addDataProperties(data, patient)) {
            man.applyChange(axiom);
        }

        // Save the ontology
        try {
            onto.saveOntology(onto.getFormat(), man.getOntologyDocumentIRI(onto));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Add a disease and all it's information in the ontology
     * @param d The definition of the disease to add
     * @param name The name of the disease
     */
    public void addDisease(Disease d, String name) {
        OWLDataFactory df = man.getOWLDataFactory();

        // Disease's IRI
        OWLClass diseaseIRI = df.getOWLClass(IRI.create(owlIRI + "#Disease"));

        // Individual disease
        OWLIndividual disease = df.getOWLNamedIndividual(IRI.create(owlIRI + "#" + name));

        // Create a link between the class disease and the individual's disease
        OWLClassAssertionAxiom type = df.getOWLClassAssertionAxiom(diseaseIRI, disease);
        // Create the axiom corresponding to the link between the disease 
        // and the individual's disease
        AddAxiom axiomType = new AddAxiom(onto, type);
        // Add the former link to the ontology
        man.applyChange(axiomType);

       
        // Actions
        for (Intervention i : d.getInterventions()) {
            // Action to be linked to the disease
            OWLIndividual action = df.getOWLNamedIndividual(owlIRI + "#"+i.getName());
            OWLObjectProperty involvesAction = df.getOWLObjectProperty(owlIRI + "#InvolvesAction");
            // Link the disease to the action
            OWLObjectPropertyAssertionAxiom axiomInvolvesAction = df.getOWLObjectPropertyAssertionAxiom(involvesAction, disease, action);
            // Add the axiom to the ontology
            AddAxiom addAxiomInvolvesAction = new AddAxiom(onto, axiomInvolvesAction);
            // Save the axiom in the ontology
            man.applyChange(addAxiomInvolvesAction);
           
            // Create the new frequency
            OWLIndividual freqClassDisease = df.getOWLNamedIndividual(IRI.create(owlIRI + "#Frequency" + i.getName() + name)); 
            // Look for the class Frequency
            OWLClass frequency = df.getOWLClass(owlIRI + "#FrequencyOfActionToDisease");  
            // Link the new individual to the class
            OWLClassAssertionAxiom assertionFrequency = df.getOWLClassAssertionAxiom(frequency, freqClassDisease);
            AddAxiom axiomFrequency = new AddAxiom(onto, assertionFrequency);
            man.applyChange(axiomFrequency); // Save the axiom in the ontology
             
            
            // Look for the link hasFrequencyForAction
            OWLObjectProperty hasFrequencyForAction = df.getOWLObjectProperty(owlIRI + "#hasFrequencyForAction");
            // Link the Intervention to the disease
            OWLObjectPropertyAssertionAxiom hasFrequencyForActionAxiom = df.getOWLObjectPropertyAssertionAxiom(hasFrequencyForAction, disease, freqClassDisease);
            // Create the axiom to add in the ontology
            AddAxiom axiomHasFrequencyForAction = new AddAxiom(onto, hasFrequencyForActionAxiom);
            // Save the link in the ontology            
            man.applyChange(axiomHasFrequencyForAction);
            
            
            // Look for the Object Property that will link the action to it's frequency
            OWLObjectProperty hasFrequencyForDisease =  df.getOWLObjectProperty(owlIRI + "#hasFrequencyForDisease");
            // Link the action to it's frequency
            OWLObjectPropertyAssertionAxiom axiomHasFrequencyForDisease = df.getOWLObjectPropertyAssertionAxiom(hasFrequencyForDisease, action, freqClassDisease);
            AddAxiom axiomHasFrequency = new AddAxiom(onto, axiomHasFrequencyForDisease);
            man.applyChange(axiomHasFrequency); // Save the axiom in the ontology
            
            
            OWLObjectProperty hasFrequency = df.getOWLObjectProperty(owlIRI + "#hasFrequency");
            //System.out.println(i.toString());
            
            String f =  i.getFrequency();
            try {
                String uf = i.getUnityFrequency().name();
                OWLIndividual freq = df.getOWLNamedIndividual(owlIRI + "#" + f + uf);

                OWLObjectPropertyAssertionAxiom objectAxiomHasFrequency = df.getOWLObjectPropertyAssertionAxiom(hasFrequency, freqClassDisease, freq);
                AddAxiom aAxiomHasFrequency = new AddAxiom(onto, objectAxiomHasFrequency);
                man.applyChange(aAxiomHasFrequency);
            } catch(Exception e) {
                //e.printStackTrace();
                System.out.println("Erreur");
            }
        }

        // Save the ontology
        try {
            onto.saveOntology(onto.getFormat(), man.getOntologyDocumentIRI(onto));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    
    /**
     * Add all the dataProperties in a list of axioms Method used in addPatient<br />
     * Used by the method addPatientIndividual
     *
     * @param data all the dataProperties with their values and type
     * @param patient the patient on which the dataProperties are on
     * @return the list of axioms to add to the ontology
     */
    public ArrayList<AddAxiom> addDataProperties(ArrayList<Info> data, OWLIndividual patient) {
        ArrayList<AddAxiom> axioms = new ArrayList<>();
        OWLDataFactory df = man.getOWLDataFactory();

        for (Info dp : data) {
            // Add data Properties to the individual
            OWLDataProperty hasProp = df.getOWLDataProperty(IRI.create(owlIRI + "#" + dp.getRelation()));
            OWLDataPropertyAssertionAxiom axiom = null;
            // Link the patient to the has Age and the value
            System.out.println("Relation : " + dp.getRelation() + " valeur : " + dp.getValue());
            switch (dp.getType()) {
                case "String":
                    axiom = df.getOWLDataPropertyAssertionAxiom(hasProp, patient, dp.getValue());
                    break;
                case "int":
                    axiom = df.getOWLDataPropertyAssertionAxiom(hasProp, patient, Integer.parseInt(dp.getValue()));
                    break;
                case "float":
                    axiom = df.getOWLDataPropertyAssertionAxiom(hasProp, patient, Float.parseFloat(dp.getValue()));
                    break;
                case "boolean":
                    if (dp.getValue() == null) {
                        axiom = df.getOWLDataPropertyAssertionAxiom(hasProp, patient, false);
                    } else {
                        axiom = df.getOWLDataPropertyAssertionAxiom(hasProp, patient, true);
                    }
                    break;
                case "Date":
                    try {
                        String strDate = dp.getValue();
                        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        Date date = format.parse(strDate);
                        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        String date2 = format2.format(date);
                        
                        // Créer un literal
                        OWLDatatype type = man.getOWLDataFactory().getOWLDatatype(OWL2Datatype.XSD_DATE_TIME);
                        OWLLiteral literal = man.getOWLDataFactory().getOWLLiteral(date2, type);
                        //System.out.println(literal);
                        axiom = df.getOWLDataPropertyAssertionAxiom(hasProp, patient,literal);
                    } catch (ParseException ex) {
                        Logger.getLogger(Ontology.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    break;
            }
            // Create the axiom to add in the ontology
            AddAxiom addAxiom = new AddAxiom(onto, axiom);

            // Add to the list
            axioms.add(addAxiom);
            
        }

        return axioms;
    }

    /**
     * Give all the informations about an intervention <br />
     * Method used in SearchDisease
     *
     * @param rq La Maladie
     * @return A list of Interventions
     * @throws OWLOntologyCreationException
     */
    public ArrayList<Intervention> listeActions(String disease) throws OWLOntologyCreationException {
        //query b = new query();
        ArrayList<Intervention> actions = new ArrayList<>();

        // Get the actions for a disease
        String listeActs = "isInvolvedToCareDisease value " + disease;
        for (String action : DLQuery(listeActs)) {
            //System.out.println("Creation de l'intervetion " + a);
            // Create the action
            Intervention inter = new Intervention(action);

            // Set the actor to the action
            String actor = "performsAction value " + action;
            ArrayList<String> act = DLQuery(actor);
            if (!act.isEmpty()) {
                inter.setTypeActor(act.get(0));
            }

            // Set the HomecareStructure
            
            // Set the duration of the action
            
            // Set the frequency
            String preFreq = "isFrequencyActionForDisease value " + action;
            
                String freq = "";
                try {
                    freq = "isFrequencyOfAction value " + DLQuery(preFreq).get(0);
                } catch(Exception e ){
                    e.printStackTrace();
                }
                ArrayList<String> f = DLQuery(freq);
                if (!f.isEmpty()) {
                    inter.setFrequency(f.get(0));
                }
            
//            if (DLQuery(preFreq).isEmpty()) {
//                String freq = "";
//                try {
//                    freq = "isFrequencyOfAction value " + DLQuery(preFreq).get(0);
//                } catch(Exception e ){
//                    e.printStackTrace();
//                }
//                ArrayList<String> f = DLQuery(freq);
//                if (!f.isEmpty()) {
//                    System.out.println("Frequency : " + f.toString());
//                    inter.setFrequency(f.get(0));
//                }
//            }
            
            

            // Set the Number of time it has to be performed
            
            // Set the moment of the day that have to be performed
            String isTod = "isFrequencyActionForDisease value " + action;
            
                String tod = "";
                try {
                    //isTimeOfDayToPerformsAction
                    tod = "isFrequencyOfAction value " + DLQuery(isTod).get(0); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ArrayList<String> t = DLQuery(tod);
                if (!t.isEmpty()) {
          
                    // Seek the nb of the Duration
                    String pattern = "([1-9]|[/])+";
                    Pattern exp = Pattern.compile(pattern);
                    Matcher m = exp.matcher(t.get(0));
                    if (m.find()) {
                        System.out.println(m.group(0));
                            inter.setDuration(m.group(0));
                        
                        
                        //inter.setDuration(val);
                    }
                    // Seek the Duration
                    String pattern2 = "([A-Z])\\w+";
                    Pattern exp2 = Pattern.compile(pattern2);
                    Matcher m2 = exp2.matcher(t.get(0));
                    if (m2.find()) {
                        inter.setFrequency(m2.group(0));
                    }
                }
            

            // Add the complete intervention to the list
            actions.add(inter);
        }
        /*
        for (Intervention i: actions)  
            System.out.println(i);
         */
        return actions;

    }
    

    /**
     * *************************************************************************
     * Used to make the DL-Queries Work                                        *
     * *************************************************************************
     */
    
    ArrayList<String> DLQuery(String query) throws OWLOntologyCreationException {
        OWLOntologyManager om = OWLManager.createOWLOntologyManager();

        File file = new File("//home//lexr//Documents//4A//S1//PTUT//HCO.owl");

        OWLOntology pressInnovOntology = om.loadOntologyFromOntologyDocument(file);

        OWLReasoner reasoner = new Reasoner.ReasonerFactory().createReasoner(pressInnovOntology);
        ShortFormProvider shortFormProvider = new SimpleShortFormProvider();
        DLQueryPrinter dlQueryPrinter = new DLQueryPrinter(new DLQueryEngine(reasoner, shortFormProvider), shortFormProvider);
        //dlQueryPrinter.askQuery(query);     
        
        return dlQueryPrinter.ask(query);

    }
    
    /**
     * Run the DL Queries (Reasoner)
     */
    class DLQueryEngine {

        private final OWLReasoner reasoner;
        private final DLQueryParser parser;

        public DLQueryEngine(OWLReasoner reasoner, ShortFormProvider shortFormProvider) {
            this.reasoner = reasoner;
            parser = new DLQueryParser(reasoner.getRootOntology(), shortFormProvider);
        }

        public Set<OWLClass> getSuperClasses(String classExpressionString, boolean direct) {
            if (classExpressionString.trim().length() == 0) {
                return Collections.emptySet();
            }
            OWLClassExpression classExpression = parser
                    .parseClassExpression(classExpressionString);
            NodeSet<OWLClass> superClasses = reasoner
                    .getSuperClasses(classExpression, direct);
            return superClasses.getFlattened();
        }

        public Set<OWLClass> getEquivalentClasses(String classExpressionString) {
            if (classExpressionString.trim().length() == 0) {
                return Collections.emptySet();
            }
            OWLClassExpression classExpression = parser
                    .parseClassExpression(classExpressionString);
            Node<OWLClass> equivalentClasses = reasoner.getEquivalentClasses(classExpression);
            Set<OWLClass> result = null;
            if (classExpression.isAnonymous()) {
                result = equivalentClasses.getEntities();
            } else {
                result = equivalentClasses.getEntitiesMinus(classExpression.asOWLClass());
            }
            return result;
        }

        public Set<OWLClass> getSubClasses(String classExpressionString, boolean direct) {
            if (classExpressionString.trim().length() == 0) {
                return Collections.emptySet();
            }
            OWLClassExpression classExpression = parser
                    .parseClassExpression(classExpressionString);
            NodeSet<OWLClass> subClasses = reasoner.getSubClasses(classExpression, direct);
            return subClasses.getFlattened();
        }

        public Set<OWLNamedIndividual> getInstances(String classExpressionString,
                boolean direct) {
            if (classExpressionString.trim().length() == 0) {
                return Collections.emptySet();
            }
            OWLClassExpression classExpression = parser
                    .parseClassExpression(classExpressionString);
            NodeSet<OWLNamedIndividual> individuals = reasoner.getInstances(classExpression,
                    direct);
            return individuals.getFlattened();
        }
    }

    class DLQueryParser {

        private final OWLOntology rootOntology;
        private final BidirectionalShortFormProvider bidiShortFormProvider;

        public DLQueryParser(OWLOntology rootOntology, ShortFormProvider shortFormProvider) {
            this.rootOntology = rootOntology;
            OWLOntologyManager manager = rootOntology.getOWLOntologyManager();
            Set<OWLOntology> importsClosure = rootOntology.getImportsClosure();
            // Create a bidirectional short form provider to do the actual mapping.
            // It will generate names using the input
            // short form provider.
            bidiShortFormProvider = new BidirectionalShortFormProviderAdapter(manager,
                    importsClosure, shortFormProvider);
        }

        public OWLClassExpression parseClassExpression(String classExpressionString) {
            OWLDataFactory dataFactory = rootOntology.getOWLOntologyManager()
                    .getOWLDataFactory();
            ManchesterOWLSyntaxEditorParser parser = new ManchesterOWLSyntaxEditorParser(
                    dataFactory, classExpressionString);
            parser.setDefaultOntology(rootOntology);
            OWLEntityChecker entityChecker = new ShortFormEntityChecker(bidiShortFormProvider);
            parser.setOWLEntityChecker(entityChecker);
            return parser.parseClassExpression();
        }
    }

    /**
     * Print the result of the reasoner
     */
    class DLQueryPrinter {

        private final DLQueryEngine dlQueryEngine;
        private final ShortFormProvider shortFormProvider;

        public DLQueryPrinter(DLQueryEngine engine, ShortFormProvider shortFormProvider) {
            this.shortFormProvider = shortFormProvider;
            dlQueryEngine = engine;
        }

        public ArrayList<String> ask(String classExpression) {
            ArrayList<String> rs = new ArrayList<>();
            if (classExpression.length() == 0) {
                System.out.println("No class expression specified");
            } else {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("\nQUERY:   ").append(classExpression).append("\n\n");

                    Set<OWLNamedIndividual> individuals = dlQueryEngine.getInstances(
                            classExpression, true);

                    for (OWLNamedIndividual i : individuals) {
                        rs.add(i.getIRI().toString().split("#")[1]);
                    }
                    //rs = listEntities("Instances", individuals, sb);
                    //System.out.println(sb.toString());
                    
                } catch (ParserException e) {
                    System.out.println(e.getMessage());
                }
            }
            return rs;
        }

    }
}
