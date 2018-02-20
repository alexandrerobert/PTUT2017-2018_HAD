package com.mycompany.mavenwebapphadbpm;

import Model.Intervention;
import Model.MaritalStatus;
import Model.Patient;
import Model.Sexe;
import static org.semanticweb.owlapi.util.OWLAPIStreamUtils.asUnorderedSet;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.coode.owlapi.manchesterowlsyntax.ManchesterOWLSyntaxEditorParser;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.expression.OWLEntityChecker;
import org.semanticweb.owlapi.expression.ParserException;
import org.semanticweb.owlapi.expression.ShortFormEntityChecker;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLClassExpression;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLProperty;
import org.semanticweb.owlapi.model.OWLPropertyAssertionObject;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.semanticweb.owlapi.util.BidirectionalShortFormProvider;
import org.semanticweb.owlapi.util.BidirectionalShortFormProviderAdapter;
import org.semanticweb.owlapi.util.ShortFormProvider;

/**
 * This class will represent the DAO of the app HADBPM
 *
 * @author lexr
 */
public class Ontology {

    int nbIndPatient = 0;
    int nbTot = 0;
    OWLClass patient = null;
    private OWLOntology onto = null;
    private String owlIRI = "";
    private OWLOntologyManager man = null;

    /**
     * Constructor
     *
     * @param file The ontology file
     */
    public Ontology(File file) {
        // Create the ontology manager
        man = OWLManager.createOWLOntologyManager();
        try {
            onto = man.loadOntologyFromOntologyDocument(file);
        } catch (OWLOntologyCreationException e) {
            // TODO Auto-generated catch block
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
     * In the ontology get each individual and display for each of them the
     * Object property value inferred by the reasoner
     *
     * @param reasoner
     */
    public void getAllIndividual(OWLReasoner reasoner) {
        onto.individualsInSignature().forEach(i -> onto.objectPropertiesInSignature().forEach(p -> {
            NodeSet<OWLNamedIndividual> individualValues = reasoner.getObjectPropertyValues(i, p);
            Set<OWLNamedIndividual> values = asUnorderedSet(individualValues.entities());
            String head = "The property values for " + p + " for individual " + i + " are: \n";
            System.out.println(head);
            for (OWLNamedIndividual ind : values) {
                String rs = "\t" + ind + "\n";
                System.out.println(rs);
            }
        }));
    }

    /**
     * In the ontology get each individual and display for each of them the Data
     * property value inferred by the reasoner
     *
     * @param reasoner
     * @throws IOException
     */
    public void displayAllIndividualProperties(OWLReasoner reasoner) throws IOException {
        // Create a file for the property value of an individual
        File propValue = new File("propertiesValues.txt");
        @SuppressWarnings("resource")
        FileWriter propValueWriter = new FileWriter(propValue);

        onto.individualsInSignature().forEach(i -> onto.dataPropertiesInSignature().forEach(p -> {
            Set<OWLLiteral> individualValues = reasoner.getDataPropertyValues(i, p);
            Set<OWLLiteral> values = asUnorderedSet(individualValues.parallelStream());
            String head = "The property values for " + p + " for individual " + i + " are: \n";
            // System.out.println(head);
            try {
                propValueWriter.write(head);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (OWLLiteral ind : values) {

                String rs = "\t" + ind + "\n";
                // System.out.println(rs);
                try {
                    propValueWriter.write(rs);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }));
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
        ArrayList<Patient> pats = new ArrayList<>();
        //ArrayList<String> liste = new ArrayList<>();
        onto.classesInSignature().forEach(c -> {
            if (c.getIRI().getFragment().equals(individualName)) {
                patient = c;
            }
        });

        // Display all the individual
        for (OWLNamedIndividual cls : reasoner.getInstances(patient).getFlattened()) {
            //liste.add(cls.getIRI().getRemainder().get());
            //pats.add()

            //System.out.println("cls : " + cls.getIRI().getRemainder().get());
            pats.add(searchPatient(cls.getIRI().getRemainder().get(), reasoner));
        }

        return pats;
    }

    /**
     * Get All the properties for an individual an displays the values
     *
     * @param reasoner Reasoner that will make the inferences
     * @param individual The String Name of the Individual
     * @return An HashMap<String, String> with the name of the DataProperties
     * and the value for an individual
     */
    public HashMap<String, String> getIndividualProperties(OWLReasoner reasoner, String individual) {
        HashMap<String, String> properties = new HashMap<>();
        // Test to retrieve a particular value for a particular individual (WORKING)
        onto.individualsInSignature().forEach(i -> onto.dataPropertiesInSignature().forEach(p -> {
            // Put each individual in a set
            Set<OWLLiteral> individualValues = reasoner.getDataPropertyValues(i, p);
            // Read the value corresponding to the DataProperty and put it in a set
            Set<OWLLiteral> values = asUnorderedSet(individualValues.parallelStream());
            // Display the property for the individual
            if (i.getIRI().toString().equals(owlIRI + "#" + individual)) {
                //String head = "The property values for " + p + " for individual " + i + " are: \n";
                // System.out.println(head);
                for (OWLLiteral ind : values) {
                    //String rs = "\t" + ind + "\n";
                    properties.put(p.getIRI().getRemainder().get(), ind.getLiteral());
                    // System.out.println(rs);
                    // properties.add(p.getIRI().getFragment());
                }
                // System.out.println(p);

            }
        }));

        return properties;
    }

    /**
     * Give all the infromation for a given id of a patient
     * @param id The id of the patient to look for
     * @param reasoner
     * @return The Patient
     */
    public Patient searchPatient(String id, OWLReasoner reasoner) {
        Patient pat = new Patient();
        onto.individualsInSignature().forEach(i -> onto.dataPropertiesInSignature().forEach(p -> {
            if (i.getIRI().getRemainder().get().equals(id)) {
                pat.setId(id);

                Set<OWLLiteral> prop = reasoner.getDataPropertyValues(i, p);
                Set<OWLLiteral> values = asUnorderedSet(prop.parallelStream());

                for (OWLLiteral v : values) {
                    if (p.getIRI().getRemainder().get().equals("hasFirstName")) {
                        pat.setFirstName(v.getLiteral());
                    }
                    if (p.getIRI().getRemainder().get().equals("hasName")) {
                        pat.setName(v.getLiteral());
                    }
                }

            }

        }));
        return pat;
    }

    /**
     * Add all the information
     *
     * @param data the array with all the data that will be inserted in the owl
     * document
     * @param name The name of the individual to add to the ontology
     */
    public void addPatientIndividual(ArrayList<Info> data, String name) {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLDataFactory df = OWLManager.getOWLDataFactory();

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
        manager.applyChange(axiomType);

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
        manager.applyChange(addAxiomHasDisease);

        data.remove(data.get(0));

        for (AddAxiom axiom : addDataProperties(data, patient)) {
            manager.applyChange(axiom);
        }

        // Save the ontology
        try {
            // Create a blank file
            //File f = new File("//home//lexr//Documents//testowl.xml"); //Alexandre
            File f = new File("HCO.owl");

            // Link the blank file to an IRI
            IRI documentIRI = IRI.create(f);
            // Save the new ontology
            manager.saveOntology(onto, new OWLXMLDocumentFormat(), documentIRI);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /**
     * Give all the OWL Classes of the document file
     *
     * @return A list with all the Classes that are in the owl file
     */
    @SuppressWarnings("deprecation")
    public ArrayList<OWLClass> getAllClasses() {
        ArrayList<OWLClass> list = new ArrayList<>();
        for (OWLClass cls : onto.getClassesInSignature()) {
            list.add(cls);
        }
        return list;
    }

    /**
     * Display all the interventions for a disease
     *
     * @param reasoner
     * @param disease
     */
    public void /*HashMap<String, String> */ getInterventions(OWLReasoner reasoner, String disease) {
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLDataFactory df = OWLManager.getOWLDataFactory();
        System.out.println("Affichage des interventions pour une maladie \n\n\n");

        onto.individualsInSignature().forEach(i -> onto.objectPropertiesInSignature().forEach(p -> {
            NodeSet<OWLNamedIndividual> individualValues = reasoner.getObjectPropertyValues(i, p);
            Set<OWLNamedIndividual> values = asUnorderedSet(individualValues.entities());
            if (i.getIRI().toString().equals(owlIRI + "#" + disease)) {
                System.out.println("The property values for " + p.getIRI().getRemainder() + " for individual " + i.getIRI().getRemainder() + " are: ");
                for (OWLNamedIndividual ind : values) {
                    System.out.println(" " + ind.getIRI().getRemainder() + ".");
                    NodeSet<OWLNamedIndividual> indV = reasoner.getObjectPropertyValues(ind, p);
                    Set<OWLNamedIndividual> val = asUnorderedSet(indV.entities());
                    for (OWLNamedIndividual id : val) {
                        System.out.println(" " + ind.getIRI().getRemainder());
                    }

                }
            }

        }));

    }

    public void /*HashMap<String,ArrayList<String>>*/ test(OWLReasoner reasoner, String ind) {
        HashMap<String, ArrayList<String>> obj = null;
        ArrayList<String> test = null;

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        OWLDataFactory df = OWLManager.getOWLDataFactory();
        //System.out.println("Affichage des interventions pour une maladie \n\n\n");

        onto.individualsInSignature().forEach(i -> onto.objectPropertiesInSignature().forEach(p -> {
            NodeSet<OWLNamedIndividual> individualValues = reasoner.getObjectPropertyValues(i, p);
            Set<OWLNamedIndividual> values = asUnorderedSet(individualValues.entities());
            if (i.getIRI().toString().equals(owlIRI + "#" + ind)) {
                System.out.println("The property values for " + p.getIRI().getRemainder() + " for individual " + i.getIRI().getRemainder() + " are: ");
                //obj.put(p.getIRI().getRemainder().toString(), i.getIRI().getRemainder().toString());

                for (OWLNamedIndividual indi : values) {
                    System.out.println(" " + indi.getIRI().getRemainder() + ".");
                    NodeSet<OWLNamedIndividual> indV = reasoner.getObjectPropertyValues(indi, p);
                    Set<OWLNamedIndividual> val = asUnorderedSet(indV.entities());

                    test(reasoner, indi.getIRI().getFragment().toString());
                }

            }

        }));

        //return obj;
    }

    /**
     * Add all the dataProperties in a list of axioms
     *
     * @param data all the dataProperties with their values and type
     * @param patient the patient on which the dataProperties are on
     * @return the list of axioms to add to the ontology
     */
    public ArrayList<AddAxiom> addDataProperties(ArrayList<Info> data, OWLIndividual patient) {
        ArrayList<AddAxiom> axioms = new ArrayList<>();
        OWLDataFactory df = OWLManager.getOWLDataFactory();

        for (Info dp : data) {
            // Add data Properties to the individual
            OWLDataProperty hasProp = df.getOWLDataProperty(IRI.create(owlIRI + "#" + dp.getRelation()));
            OWLDataPropertyAssertionAxiom axiom = null;
            // Link the patient to the has Age and the value
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
                case "Date":
                    axiom = df.getOWLDataPropertyAssertionAxiom(hasProp, patient, dp.getValue());
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
     * donne toutes les informations sur une interventions en renvoyant une
     * liste d'interventions
     *
     * @param rq La Maladie
     * @throws OWLOntologyCreationException
     */
    public ArrayList<Intervention> listeActions(String disease) throws OWLOntologyCreationException {
        query b = new query();
        ArrayList<Intervention> actions = new ArrayList<>();

        // Get the actions for a disease
        String listeActs = "isInvolvedToCareDisease value " + disease;
        for (String a : b.DLQuery(listeActs)) {
            System.out.println("Creation de l'intervetion " + a);
            // Create the action
            Intervention inter = new Intervention(a);

            // Set the actor to the action
            String actor = "performsAction value " + a;
            ArrayList<String> act = b.DLQuery(actor);
            if (!act.isEmpty()) {
                inter.setTypeActor(act.get(0));
            }

            // Set the HomecareStructure
            // Set the duration of the action
            // Set the frequency
            String preFreq = "isFrequencyActionForDisease value " + a;
            String freq = "isFrequencyOfAction value " + b.DLQuery(preFreq).get(0);
            ArrayList<String> f = b.DLQuery(freq);
            if (!f.isEmpty()) {
                inter.setFrequency(f.get(0));
            }

            // Set the Number of time it has to be performed
            // Set the moment of the day that have to be performed
            String moment = "isTimeOfDayToPerformsAction value " + a;
            ArrayList<String> listMoment = b.DLQuery(moment);
            if (!listMoment.isEmpty()) {
                inter.setMoment(listMoment);
            }

            // Add the complete intervention to the list
            actions.add(inter);
        }

        for (Intervention i: actions)  
            System.out.println(i);
        
        return actions;

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

        public void askQuery(String classExpression) {
            if (classExpression.length() == 0) {
                System.out.println("No class expression specified");
            } else {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("\nQUERY:   ").append(classExpression).append("\n\n");

                    Set<OWLNamedIndividual> individuals = dlQueryEngine.getInstances(
                            classExpression, true);
                    System.out.println(sb.toString());
                    for (OWLNamedIndividual i : individuals) {
                        System.out.println(i.getIRI().getRemainder().get());
                    }

                } catch (ParserException e) {
                    System.out.println(e.getMessage());
                }
            }
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
                        rs.add(i.getIRI().getRemainder().get());
                    }
                    //rs = listEntities("Instances", individuals, sb);
                    System.out.println(sb.toString());
                } catch (ParserException e) {
                    System.out.println(e.getMessage());
                }
            }
            return rs;
        }

    }
}
