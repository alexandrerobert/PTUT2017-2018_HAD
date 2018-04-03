// indexInitialization
var idInt = 0;
var itemSelected = 0;
var decalage = 0;

$(document).ready(function () {
  autocompleteField();

  //Add intervention
  $("#add_inter").click(function() {
    renameItem(itemSelected);
    hideInter();
    idInt += 1,
    itemSelected = idInt;
    $("#menu_inter").append("<a class='menu_inter col s12 waves-effect waves-light btn blue-grey darken-4' id=" + idInt +">"
                            +"<i class='material-icons prefix'>folder_open</i>"
                            +"</a>");
    var newInter = '<div class="inter" id="inter_' + idInt + '">'
                   +'<div class="col s6">'
                   +  '<div class="row">'
                   +    '<div class="input-field col s12">'
                   +      '<i class="material-icons prefix">account_circle</i>'
                   +      '<input type="text" id="actor-' + idInt + '"class="actor">'
                   +        '<label for="autocomplete-input">Actor</label>'
                   +      '</div>'
                   +    '</div>'
                   +  '</div>'
                   +  '<div class="input-field col s6">'
                   +    '<div class="row">'
                   +      '<select id="HomeCareStructure-' + idInt + '">'
                   +        '<option value="" disabled selected>HomeCareStructure</option>'
                   +        '<option value="1">At Home</option>'
                   +        '<option value="2">HomeCare</option>'
                   +        '<option value="3">Laboratory</option>'
                   +      '</select>'
                   +      '<label>HomeCareStructure</label>'
                   +    '</div>'
                   +  '</div>'
                   +  '<div class="row">'
                   +    '<div class="col s3">'
                   +      '<div class="row">'
                   +        '<div class="input-field col s12">'
                   +          '<i class="material-icons prefix">description</i>'
                   +          '<input type="text" id="action-' + idInt + '" class="action">'
                   +            '<label for="autocomplete-input">Action</label>'
                   +          '</div>'
                   +        '</div>'
                   +      '</div>'
                   +      '<div class="input-field col s1">'
                   +        '<input id="freq-' + idInt + '" type="text" class="validate">'
                   +          '<label for="freq">Nb</label>'
                   +        '</div>'
                   +        '<div class="input-field col s2">'
                   +          '<select id="freqUnit-' + idInt + '">'
                   +            '<option value="1">Day</option>'
                   +            '<option value="2">Week</option>'
                   +            '<option value="3">Month</option>'
                   +          '</select>'
                   +          '<label>Frequency</label>'
                   +        '</div>'
                   +        '<div class="input-field col s3">'
                   +          '<select multiple id="freqMoment-' + idInt + '">'
                   +            '<option value="1">Morning</option>'
                   +            '<option value="2">Afternoon</option>'
                   +            '<option value="3">Evening</option>'
                   +            '<option value="4">Night</option>'
                   +          '</select>'
                   +          '<label>Moment</label>'
                   +        '</div>'
                   +        '<div class="input-field col s1">'
                   +          '<input id="duration-' + idInt + '" type="text" class="validate">'
                   +            '<label for="freq">Nb</label>'
                   +          '</div>'
                   +          '<div class="input-field col s2">'
                   +            '<select id="durationUnit-' + idInt + '">'
                   +              '<option value="" disabled selected>Duration</option>'
                   +              '<option value="Day">Day</option>'
                   +              '<option value="Week">Week</option>'
                   +              '<option value="Month">Month</option>'
                   +              '<option value="Year">Year</option>'
                   +            '</select>'
                   +            '<label>Duration</label>'
                   +          '</div>'
                   +        '</div>'
                   +      '</div>'
                   +     '</div>';
    $(".interventionsDetails").append(newInter);

    autocompleteField();

    $("a.menu_inter").click(function() {
      renameItem(itemSelected);
      var id = $(this).attr('id');
      hideInter();
      $("#inter_"+id).show();
      itemSelected = $(this).attr('id');
    })

    if(idInt==5){
      $("#up").show();
      $("#menu_inter").append("<a class='col s12 waves-effect waves-light btn blue-grey darken-4' id='down'>"
                              +"<i class='material-icons prefix'>arrow_downward</i></a>");
    }

    if(idInt>4){
      hideMenu();
      decalage = decalage +1;
      showMenu();
    }

  });

  $("#up").click(function() {
    if ((idInt + decalage) > 6)
      decalage = decalage - 1 ;
    hideMenu();
    showMenu();
  });

  // Rename item with the name of action
  function renameItem(id){
      var newName = $("#action-" + id).val();
      if(newName)
        $("#" + itemSelected).html(newName);
  };

  // Hide all interventions
  function hideInter() {
     for(i=0; i<idInt+1; i++){
     if($("#inter_" + i))
        $("#inter_" + i).hide();
     }
     
  };

  function hideMenu() {
    for(i=0; i<idInt+1; i++){
       $("#" + i).hide();
    }
    $("#down").remove();
  };

  function showMenu() {
    for(i=0; i<5; i++){
      var val = i + decalage;
      $("#" + val).show();
    };
    $("#menu_inter").append("<a class='col s12 waves-effect waves-light btn blue-grey darken-4' id='down'>"
                              +"<i class='material-icons prefix'>arrow_downward</i></a>");
    $("#down").click(function() {
      if ((idInt - decalage) > 6)
        decalage = decalage + 1 ;
      hideMenu();
      showMenu();
    });
  }

 
  function autocompleteField(){
    $('select').material_select();

    // Field for actors
    $('.actor').autocomplete({
      data: {
        "CareAid": null,
        "CleaningAgent": null,
        "Dietician": null,
        "FamilyDoctor": null,
        "HeadNurse": null,
        "Nurse": null,
        "Nutritionist": null,
        "Patient": null,
        "Pharmacist": null,
        "PhysicalTherapist": null,
        "Psychologist": null,
        "Secretary": null,
        "SocialWorker": null,
        "SpeechTherapist": null
      },
      limit: 5,
      minLength: 0
    });

    // Field of actions
    $('.action').autocomplete({
      data: {
        "ActorConfirmation": null,
        "AskInformation": null,
        "AssignActor": null,
        "AssignMembersOfEu": null,
        "AuthorizeNursingCareService": null,
        "AuthorizeRehabilitation": null,
        "ConfirmOrModifyWaitingLists": null,
        "ControlPerformanceOfActivities": null,
        "ChangesTheSheets": null,
        "CleaningRoom": null,
        "ForwardTheBloodTransfusionRequest": null,
        "ProvideInformation": null,
        "ReferTheAdmitedPatientForCA": null,
        "ScheduleActivity": null,
        "SendMessageToThePatient": null,
        "SendTransfusionReport": null,
        "SpeechTherapist": null,
        "SuperviseAchievementOfActivities": null,
        "SuperviseHCPInformation": null,
        "SuperviseIP": null
      },
      limit: 5,
      minLength: 0
    });


    $("#addDisease").click(function() {
      json = '{ "interventions" : [';
      dataJson = "";
      if(idInt>0){
        for(i=0; i<idInt+1; i++){
          json += '[{ "Actor" : "' + $("#actor-"+i).val() + '"},';
          json += '{ "HomeCareStructure" : "' + $("#HomeCareStructure-"+i).val() + '"},';
          json += '{ "Action" : "' + $("#action-"+i).val() + '"},';
          json += '{ "Frequence" : "' + $("#freq-"+i).val() + '"},';
          json += '{ "FrequenceUnit" : "' + $("#freqUnit-"+i).val() + '"},';
          json += '{ "FrequenceMoment" : "' + $("#freqMoment-"+i).val() + '"},';
          json += '{ "Duration" : "' + $("#duration-"+i).val() + '"},';
          json += '{ "Duration Unit" : "' + $("#durationUnit-"+i).val() + '"}],';  
        };
        json = json.substring(0,json.length-1);
        json += ']}';
        dataJson = jQuery.parseJSON(json);
        console.log(dataJson);
      }
      if($("#nameDisease").val()!==""){
        $.ajax({
          url: 'AddDisease',
          method: 'POST',
          data : { "interventions" : json,
                    "name" : $("#nameDisease").val()},
          dataType : "text/html"      
        });
      }   
    })
  };

 

 



});
