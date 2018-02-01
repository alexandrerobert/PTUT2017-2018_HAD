$(document).ready(function () {

  var cards = document.getElementsByClassName("card");

  // Créé la carte d'un patient
  var cardPatients = new Map();
  var card = function (id, pat) {
    cardPatients.set(id, pat);
    // the card
    var c = '<div class="pat col s12 m3">' +
    '<div id="pat-' + id + '" class="pat card">' +
    '<div class="card-image">' +
    '<img src="materialize-css/person_icon.png" width="5" height="100">' +
    '<a class="btn-floating halfway-fab waves-effect waves-light red">' +
    '<i class="material-icons">add</i>' +
    '</a>' +
    '</div>' +
    '<div class="card-content">' +
    '<p>' + pat + '</p>' +
    '</div>' +
    '<div class="back-info">' +
    '<div class="info" style="visibility: hidden; display: none;">' +
    '<p>Informations sur le patient</p>' +
    '</div>' +
    '</div>' +
    '</div>' +
    '</div>';

    // Add the cards to the page again with style !!!
    $('#place').append(c);
    // Make an effect
    $('#pat-' + id).hide();
    $('#pat-' + id).show(500);

  };

  // Performed every time a card is created
  var clic = function () {
    $('.card').each(function () {
      $(this).click(function () {
        console.log($(this));
        // Check where the user has clicked
        if ($(this).attr('id') === 'ajoutPat') {
          window.location.assign('addPatient.jsp');
        } else {
          info = document.getElementsByClassName('infoPatient');
          info['0'].style.visibility = "visible";
          // var dataPatient = $.ajax({
          //   url: 'InfoPatient',
          //   method: 'GET',
          //   success: function (data) {
          //     console.log(val);
          //     return val;
          //   }, dataType: 'json',
          //   async: false
          // });
        }

      });
    });
  };

  var patientsName = "{";
  // Retrieve all the patients in the owl
  var val = $.ajax({
    url: 'SearchPatient',
    method: 'GET',
    success: function (data) {
      $.each(data.patients, function() {
        patientsName = patientsName +  JSON.stringify(this.name) + ': null,';
      });
      patientsName = patientsName.substring(0,patientsName.length-1);
      patientsName = patientsName + "}";
      patientsName=(JSON.parse(patientsName));
      return val;
    }, dataType: 'json',
    async: false
  });

  // Data retrieved by the ajax call
  var data = val.responseJSON;
  // Counter
  var id = 0;
  // Patient for the autocomplete

  var patientName;
  $(data.patients).each(function () {
    // Limit the number of card on the page
    if (id < 12) {            // create the card for the patient
      card(id, this.name);
    }
    id++;
  });

  // Give the Patient table to the autocomplete
  $('input.autocomplete').autocomplete({
    data: patientsName,
    limit: 10, // The max amount of results that can be shown at once. Default: Infinity.
    minLength: 0, // The minimum length of the input for the autocomplete to start. Default: 1.
    onAutocomplete: function(val) {
      $('.pat').each(function() {
        $(this).hide();
      });
      card(0,val)
      clic();
    }
  });

  // Make all the cards clickable
  clic();

  // Change the cards according to what is given by the input
  $('input.autocomplete').on('input', function () {
    var filt = {};
    // Value of the autocomplete
    var pers = $(this).val();
    // Counter
    var i = 0;
    $('.pat').each(function() {
      $(this).hide();
    });
    // Look for the value among the patients
    $(data.patients).each(function () {
      if (pers.length > 0) {
        // The value is in the data
        if (this.name.indexOf(pers) !== -1) {
          // Display the card
          card(i,this.name);
          i++;
        }
      }
    });
    clic();
  });

  // Initialise the collapsible
  $('.collapsible').collapsible();
});
