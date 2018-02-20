$(document).ready(function () {

  $("#info2").hide();
  $("#patient_notes").hide();

  var patientsName = "{";
  var url = window.document.URL;
  var index = (url.indexOf('=')) + 1;
  var pat = url.substring(index);
  console.log(pat);
  // Retrieve all the patients in the owl
  var val = $.ajax({
    url: 'InfoPatient',
    data: 'id='+pat,
    method: 'GET',
    success: function (data) {
      return val;
    },
    dataType: 'json',
    async: false
  });

  var data = val.responseJSON.info;
  console.log(data);

  $('#names').text(data[1].firstName + " " + data[0].name);
  $('#sexe').text(data[2].sexe);
  $('#birth').text(data[3].birth + " at " + data[4].placeBirth);
  $('#socialSecurityNumber').text(data[5].socialSecurityNumber);
  $('#adress').text(data[7].adress);
  $('#phoneNumber').text(data[8].phoneNumber);
  $('#email').text(data[9].email);
  $('#maritalStatus').text(data[10].maritalStatus);
  $('#internet').text(data[3].birth + " at " + data[4].placeBirth);
  $('#weight').text(data[12].weight + " kg");
  $('#size').text(data[13].size + " cm");
  $('#hasAllergies').text(data[15].hasAllergies);
  $('#hasPrevious').text(data[16].hasPrevious);
  $('#hasValidEntourage').text(data[17].hasValidEntourage);
  $('#hasAccessiblePlace').text(data[18].hasAccessiblePlace);
  $('#hasNotes').text(data[19].hasNotes);
  $('#hasDisease').text(data[20].hasDiseases);//PAS DE LIENS
  console.log(data);

});
