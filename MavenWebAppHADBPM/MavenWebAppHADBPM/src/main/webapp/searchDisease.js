function showInter(id){
  for(i=1; i<5; i++){
    $("#inter-" + i).hide();
  }
  $("#inter-" + id).show();
};


$(document).ready(function () {
  showInter(1);



  // var listDisease;
  // var tab = '{}';
  //
  // $.ajax({
  //   url:'SearchDisease',
  //   method: 'GET',
  //   success: function(data) {
  //     tab = '{';
  //     listDisease = data;
  //     console.log(data);
  //
  //       console.log(tab);
  //       for (id = 0; id < listDisease.diseases.length; id++) {
  //         console.log(listDisease.diseases[id])
  //           if (id>0) {
  //               tab += ',';
  //           }
  //           tab +="\""+ listDisease.diseases[id].name +"\": null";
  //
  //         }
  //         tab += '}'
  //
  //   }, error: function(){
  //     console.log("et merde");
  //   },
  //
  //   dataType:'json'
  // });


  // for (id = 0; id < listDisease.diseases.length; id++) {
  //   console.log(listDisease.diseases[id])
  //     if (id>0) {
  //         tab += ',';
  //     }
  //     tab +="\""+ listDisease.diseases[id].name +"\": null";
  //
  //   }
  //   tab += '}'





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
