$(document).ready(function () {
    // var listDisease;
    // var tab = '{}';
    //
    var liste = $.ajax({
        url: 'SearchDisease',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            // Stop the progress bar
            $("#progress").hide();
            return data;
        },
        async: false
    });


    // Put the result of the ajax request in json
    liste = JSON.parse(liste.responseText);

    console.log(liste);
    var idDisease = 0;
    var idInter = 0;


    $(liste.disease).each(function () {

        // header of the disease layout
        var head = '<div class="pat col s12 m3">' +
                '<div id="' + this.name + '" class="pat card">' +
                '<div class="card-content">' +
                '<p style="display: inline" >' + this.name + '</p>' +
                '<a class="btn-floating halfway-fab waves-effect waves-light red" style="display: inline">' +
                '<i class="material-icons">send</i>' +
                '</a>' +
                '</div>' +
                '<div class="back-info">' +
                '<div class="info" style="visibility: hidden; display: none;">' +
                '<p>Informations sur le patient</p>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>';


        $("#lst").append(head);

        // Rediriger vers la page patient
        $('#'+ this.name).click(function () {
            window.location.href = "infoDisease.jsp?Disease=" + this.id;
        });

    });

    $('.disease').autocomplete({
        data: {
            "Arthritis": null,
            "Depression": null
        },
        limit: 3,
        minLength: 0,
        onAutocomplete: function (val) {
            for (i = 1; i < 3; i++) {
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
