$(document).ready(function(){
    
    // Get the list of disease to display
    var list = $.ajax({
        url:'GetDisease',
        method: 'GET',
        sucess:function(data) {
            return data;
        }, async: false
    });
    list = JSON.parse(list.responseText);
    console.log(list.diseases);
    for (i = 0; i < list.diseases.length; i++) {
        console.log(list.diseases[i].name);
        $("#hasDisease").append('<option value="' + list.diseases[i].name + '">' + list.diseases[i].name + '</option>');
    }
    
    
    $('.datepicker').pickadate({
        selectMonths: true, // Creates a dropdown to control month
        selectYears: 120, // Creates a dropdown of 15 years to control year,
        closeOnSelect: false, // Close upon selecting a date,
        format: 'dd/mm/yyyy'
      });


    $('.collapsible').collapsible();

    $('select').material_select();
   
    $.ajax({
        url:'GetDisease',
        method: 'POST',
        data: {val : "Coucou"}
    });
    
});