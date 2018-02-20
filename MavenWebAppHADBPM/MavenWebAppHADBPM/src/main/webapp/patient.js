$(document).ready(function () {

  $("#info2").hide();
  $("#patient_notes").hide();

  var patientsName = "{";
  // Retrieve all the patients in the owl
  var val = $.ajax({
    url: 'InfoPatient',
    method: 'GET',
    success: function (data) {
      return val;
    },
    dataType: 'json',
    async: false
  });

  var data = val.responseJSON.info;

  $('#names').text(data[1].firstName + " " + data[0].name);
  $('#sexe').text(data[2].sexe);
  $('#birth').text(data[3].birth + " at " + data[4].placeBirth);
$('#socialSecurityNumber').text(data[5].birth);
$('#adress').text(data[7].adress);
$('#phoneNumber').text(data[3].birth + " at " + data[4].placeBirth);
$('#email').text(data[3].birth + " at " + data[4].placeBirth);
$('#maritalStatus').text(data[3].birth + " at " + data[4].placeBirth);
$('#internet').text(data[3].birth + " at " + data[4].placeBirth);
  console.log(data);

});
