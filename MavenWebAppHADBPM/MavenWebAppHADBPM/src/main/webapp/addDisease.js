// indexInitialization
var idInt = 0;
var itemSelected = 0;

// Create table with data of disease for API
function addDisease(){
  var finalInter = [];
  finalInter.push(document.getElementById("nameDisease").value);
  for (i=0; i<idInt+1; i++){
    if($("#inter-" + i)){
      var inter = [];
      inter.push(document.getElementById("actor-"+i).value);
      inter.push(document.getElementById("HomeCareStructure-"+i).value);
      inter.push(document.getElementById("action-"+i).value);
      inter.push(document.getElementById("freq-"+i).value);
      inter.push(document.getElementById("freqUnit-"+i).value);
      var freqMoment = [];
      for(var j=0; j< document.getElementById("freqMoment-"+i).options.length; j++){
        if(document.getElementById("freqMoment-"+i).options[j].selected === true){
          freqMoment.push(document.getElementById("freqMoment-"+i).options[j].value);
        };
      };
      inter.push(freqMoment);
      inter.push(document.getElementById("duration-"+i).value);
      inter.push(document.getElementById("durationUnit-"+i).value);
      finalInter.push(inter);
    }
  };
}

// Rename item with the name of action
function renameItem(id){
  document.getElementById("item-"+id).innerHTML = "<a onclick='showInter("+ id +")' id=" + id + ">" + document.getElementById("action-" + id).value + "</a>";
}

// Show the good intervention
function showInter(id){
  if(document.getElementById("action-" + itemSelected)){
    if (document.getElementById("action-" + itemSelected).value !== ""){
      renameItem(itemSelected);
    };
  };
  itemSelected = id ;
  hideInter();
  $("#inter-" + id).show();
};

// Hide all interventions
function hideInter() {
  for(i=0; i<idInt+1; i++){
    if($("#inter-" + i))
    $("#inter-" + i).hide();
  }
}

function deleteItem(id){
  $("#inter-" + id).remove();
  $("#item-" + id).remove();
  $('ul.tabs').tabs();
  showInter(0);
}

$(document).ready(function () {

  autocompleteField();


  $('select').material_select();


  $('#addInt').click(function() {
    $('#'+idInt).removeClass('active');
    $('#item-'+idInt).removeClass('active')

    if(document.getElementById("action-" + idInt)){
      if (document.getElementById("action-" + idInt).value !== ""){
        renameItem(idInt);
      };
    }

    idInt = idInt + 1 ;

    if(document.getElementById("action-" + itemSelected)){
      if (document.getElementById("action-" + itemSelected).value !== ""){
        renameItem(itemSelected);
      };
    }

    hideInter(); // Hide all interventions

    // Create new item
    document.getElementById("interventions").innerHTML += "<li class='tab' id=item-" + idInt + "><a onclick='showInter("+ idInt +")' id="+idInt+">New intervention</a></li>";
    $('#'+idInt).addClass('active');
    $('ul.tabs').tabs();

    // Create new intervention
    var newInter = '<div class="inter" id="inter-' + idInt + '">'
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
    +        '<div class="col offset-s11">'
    +          '<a onclick="deleteItem(' + idInt + ')" class="btn-floating btn-large waves-effect waves-light grey" id="addInt">'
    +            '<i class="material-icons">delete</i>'
    +          '</a>'
    +        '</div>'
    +      '</div>'
    +     '</div>';
    $('.interventionsDetails').append(newInter);

    // Reactualisation field autocomplete and select
    autocompleteField();

  });

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
  };

});
