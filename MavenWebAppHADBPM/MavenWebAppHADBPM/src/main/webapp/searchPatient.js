$(document).ready(function () {

  var cards = document.getElementsByClassName("card");

  // Créé la carte d'un patient
  var card = function (id, firstName, lastName) {

    var c = '<div class="pat col s12 m3">' +
    '<div id="pat-' + id + '" class="pat card">' +
    '<div class="card-image">' +
    '<img src="materialize-css/person_icon.png" width="5" height="100">' +
    '<a class="btn-floating halfway-fab waves-effect waves-light red">' +
    '<i class="material-icons">add</i>' +
    '</a>' +
    '</div>' +
    '<div class="card-content">' +
    '<p>' + firstName + " " + lastName + '</p>' +
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

    // Rediriger vers la page patient
    $('#pat-' + id).click(function() {
      window.location.href="patient.jsp?id="+id;
    });
  };

  var patientsName = "{";
  // Retrieve all the patients in the owl
  var val = $.ajax({
    url: 'SearchPatient',
    method: 'GET',
    success: function (data) {
      $.each(data.patients, function() {
        patientsName = patientsName +  JSON.stringify(this.name + " " + this.lastName) + ': null,';
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
  // Patient for the autocomplete

  $(data.patients).each(function () {
    card(this.id, this.name, this.lastName);
  });

  // Give the Patient table to the autocomplete
  $('input.autocomplete').autocomplete({
    data: patientsName,
    limit: 3, // The max amount of results that can be shown at once. Default: Infinity.
    minLength: 0, // The minimum length of the input for the autocomplete to start. Default: 1.
    onAutocomplete: function(val) {
      $('.pat').each(function() {
        $(this).hide();
      });
      $(data.patients).each(function () {
        if(val == this.name + " " + this.lastName)
        card(this.id, this.name, this.lastName);
      });

    }
  });

  // Change the cards according to what is given by the input
  $('input.autocomplete').on('input', function () {
    if (this.value == ""){
      $('.pat').each(function() {
        $(this).hide();
      });
      $(data.patients).each(function () {
        card(this.id, this.name, this.lastName);
      });
    }
  });

  // Initialise the collapsible
  $('.collapsible').collapsible();
});
