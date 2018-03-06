$(document).ready(function () {

  $("#patient_notes").hide();
  $("#medical_data").hide();
  $('#navItems li:first-child').addClass('active');

  var patientsName = "{";
  var url = window.document.URL;
  var index = (url.indexOf('=')) + 1;
  var pat = url.substring(index);
//  console.log(pat);
  // Retrieve all the patients in the owl
  var val = $.ajax({
    url: 'InfoPatient',
    data: 'id='+pat,
    method: 'GET',
    success: function (data) {
      return data;
    },
    error: function (data) {
      console.log("zut");
    },
    dataType: 'json',
    async: false
  });

  var data = val.responseJSON.info;
  console.log(data);
  $('#names').text(data[1].hasFirstName + " " + data[0].hasName);
  $('#sex').text(data[2].hasSex);
  $('#birth').text(data[3].hasDateOfBirth + " at " + data[4].hasPlaceOfBirth);
  $('#socialSecurityNumber').text(data[5].hasSocialSecurityNumberID);
  $('#adress').text(data[6].hasAdress);
  $('#phoneNumber').text(data[7].hasPhoneNumber);
  $('#email').text(data[8].hasEmail);
  $('#maritalStatus').text(data[9].hasMaritalStatus);
  $('#internet').text(data[10].isInternet);
  $('#weight').text(data[11].hasWeight + " kg");
  $('#size').text(data[12].hasSize + " cm");
  $('#valide').text(data[13].isValide);
  $('#allergies').text(data[14].hasAllergies);
  $('#previous').text(data[15].hasPrevious);
  $('#valideFamily').text(data[16].isValideFamily);
  $('#accessiblePlace').text(data[17].isAccessiblePlace);
  $('#notes').text(data[18].hasNotes);
  $('#disease').text(data[19].hasDiseases);//PAS DE LIENS
  $('#smoking').text(data[20].isSmoking);
  $('#sport').text(data[21].isSport);


});
