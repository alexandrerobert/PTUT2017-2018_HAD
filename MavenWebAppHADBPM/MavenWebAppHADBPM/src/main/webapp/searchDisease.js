function showInter(id){
  for(i=0; i<5; i++){
    $("#tab" + i).removeClass("active");
    
    $("#inter-" + i).hide();
  }
  $("#tab-" + id).addClass("active");
  $("#inter-" + id).show();
  
};


$(document).ready(function () {

  // var listDisease;
  // var tab = '{}';
  //
  var liste = $.ajax({
     url:'SearchDisease',
     method: 'GET',
     success: function(data) {
        // Stop the progress bar
        $("#progress").hide();
        return data;
     },dataType:'json',
     async: false
   });
 
 
   // Put the result of the ajax request in json
   liste = JSON.parse(liste.responseText);  
   
   console.log(liste);
   var idDisease = 0;
   var idInter  = 0;

   
   $(liste.disease).each(function() {
       // Pagination for the disease
       var page = "";
       
       // Create the pagination
       $(this.interventions).each(function() {
              page = page + '<li id="tab-' + idInter + '" class="waves-effect"><a onclick="showInter(' + idInter + ')">' + this.name + '</a></li>';
              idInter++;
        });
       
       // REINITIALISATION
       idInter = 0;
       
       // header of the disease layout
       var head = '<div id="disease-' + idDisease + '" class="' + this.name + ' card-panel light-grey">'
            +'<h5>' + this.name + '</h5>'
            +'<div class="list-disease">'
                +'<ul class="pagination">'
                +'<li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>'
                + page
                +'<li class="waves-effect"><a><i class="material-icons">chevron_right</i></a></li>'
                +'</ul>'
                +'<div id="inters" class="row interventionsDetails" style="border:solid grey; border-radius: 35px;">';
        
        $("#lst").append(head);
          
          
          

            $(this.interventions).each(function() {
          diziz = '<div class="inter" id="inter-' + idInter + '">'
      +           ' <div class="col s6">'
      +                '<div class="row">'
      +                    '<div class="input-field col s12">'
      +                        '<i class="material-icons prefix">account_circle</i>'
      +                        '<input value="' + this.typeActor + '" id="first_name-' + idInter + '" type="text" disabled >'
      +                        '<label for="autocomplete-input">Actor</label>'
      +                    '</div>'
      +                '</div>'
      +            '</div>'

      +            '<div class="input-field col s6">'
      +                '<div class="row">'
      +                    '<input value="' + this.homeCareStructure + '" id="first_name-' + idInter + '" type="text" disabled >'
      +                    '<label>HomeCareStructure</label>'
      +                '</div>'
      +            '</div>'

      +            '<div class="row">'
      +                '<div class="col s3">'
      +                    '<div class="row">'
      +                        '<div class="input-field col s12">'
      +                            '<i class="material-icons prefix">description</i>'
      +                            '<input value="' + this + '" id="first_name-' + idInter + '" type="text" disabled >'
      +                            '<label for="autocomplete-input">Action</label>'
      +                       '</div>'
      +                    '</div>'
      +                '</div>'

      +                '<div class="input-field col s1">'
      +                    '<input value="' + this.unityFrequency + '" id="freq-' + idInter + '" type="text" disabled >'
      +                    '<label for="freq">Nb</label>'
      +                '</div>'

      +                '<div class="input-field col s2">'
      +                    '<input value="' + this.frequency + '" id="first_name2" type="text" disabled >'
      +                    '<label>Frequency</label>'
      +                '</div>'

      +                '<div class="input-field col s3">'
      +                    '<input value="' + this.moment + '" id="first_name2" type="text" disabled >'
      +                    '<label>Moment</label>'
      +                '</div>'

      +                '<div class="input-field col s1">'
      +                    '<input value="' +  this.unityDuration + '" id="first_name2" type="text" disabled >'
      +                    '<label for="freq">Nb</label>'
      +                '</div>'

      +                '<div class="input-field col s2">'
      +                    '<input value="years" id="first_name2" type="text" disabled >'
      +                    '<label>Duration</label>'
      +                '</div>'
      +            '</div>'
      +        '</div>';


          $('#inters').append(diziz);
          if (idInter > 0) {
              $('#inter-' + idInter).hide();
          }
          idInter++;

      });
      
      idDisease++;
      // Activate  
      showInter(0);
      
   });
    






  $('.disease').autocomplete({
    data: {
      "Arthritis": null,
      "Depression": null
    },
    limit: 3,
    minLength: 0,
    onAutocomplete: function(val) {
      for(i=1; i<3; i++){
        $("#disease-" + i).hide();
      }
      $("." + val).show();
   }
  });

//  $("#autocomplete-input").on('input',function(){
      // Show the corresponding patient to pattern given
      // ($('.disease').val());
      // Display the result on the cards

  //});

  // $('#pagination').pagination({
  //    align: 'left',
  //    lastPage:  10,
  //    firstPage:  1,
  //    urlParameter: 'page',
  //    useUrlParameter: true,
  //    onClickCallback: function(requestedPage){
  //        console.log('Requested page is '+ requestedPage);
  //    }
  //});

});
