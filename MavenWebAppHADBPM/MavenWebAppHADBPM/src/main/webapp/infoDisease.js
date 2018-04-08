$(document).ready(function () {
    // Get the entire url
    var url = window.document.URL;
    // Split to have the name of the page and it's params
    var index = (url.indexOf('=')) + 1;
    // Get the name of the disease
    var disease = url.substring(index);
    
    var liste = $.ajax({
        url: 'InfoDisease?disease=' + disease,
        method: 'GET',
        success: function (data) {
            // Stop the progress bar
            $("#progress").hide();
            return data;
        }, dataType: 'json',
        async: false
    });


    // Put the result of the ajax request in json
    liste = JSON.parse(liste.responseText);

    console.log(liste.interventions);
    var idDisease = 0;
    var idInter = 0;
    // Pagination for the disease
    var page = "";
    // Length of the list of intervention
    var lg = liste.interventions.length -1
    
    // Create the pagination
    $(liste.interventions).each(function () {
        //console.log(this.name);
        page = page + '<li id="tab-' + idInter + '" class="inter waves-effect"><a>' + this.name + '</a></li>';
        idInter++;
    });


    // Display the header of the disease layout
    var head = '<div class="' + disease + ' card-panel light-grey">'
            + '<h5>' + disease + '</h5>'
            + '<div class="list-disease">'
            + '<ul class="pagination">'
            + '<li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>'
            + page
            + '<li class="waves-effect"><a><i class="material-icons">chevron_right</i></a></li>'
            + '</ul>'
            + '<div id="inters" class="row interventionsDetails" style="border:solid grey; border-radius: 35px;">';

    $("#lst").append(head);

    // For each tab create the listener for a click on it
    $('.inter').each(function() {   
        if ($(this).attr('id') == 'tab-0') {
            $(this).addClass("active");
        }
        $(this).click(function(){
            // Delete .active for the others tab
            $('.inter').each(function() { 
                $(this).removeClass("active");
                $("#inter-" + id).show();
            });
            // Put the selected item active
            $(this).addClass("active");
           
            var i = 0;
            for (i; i < lg; i++) {
                // hide the data of the others cards
                $("#inter-" + i).hide();
            }
            var id = $(this).attr('id').substring($(this).attr('id').indexOf('-')+1);
            $("#inter-" + id).show();
            
        });
    });
    
    // REINITIALISATION
    idInter = 0;

    $(liste.interventions).each(function () {
        inters = '<div class="inter" id="inter-' + idInter + '">'
                + ' <div class="col s6">'
                + '<div class="row">'
                + '<div class="input-field col s12">'
                + '<i class="material-icons prefix">account_circle</i>'
                + '<input value="' + this.typeActor + '" id="first_name-' + idInter + '" type="text" disabled >'
                + '<label for="autocomplete-input">Actor</label>'
                + '</div>'
                + '</div>'
                + '</div>'

                + '<div class="input-field col s6">'
                + '<div class="row">'
                + '<input value="' + this.homeCareStructure + '" id="first_name-' + idInter + '" type="text" disabled >'
                + '<label>HomeCareStructure</label>'
                + '</div>'
                + '</div>'

                + '<div class="row">'
                + '<div class="col s3">'
                + '<div class="row">'
                + '<div class="input-field col s12">'
                + '<i class="material-icons prefix">description</i>'
                + '<input value="' + this.name + '" id="first_name-' + idInter + '" type="text" disabled >'
                + '<label for="autocomplete-input">Action</label>'
                + '</div>'
                + '</div>'
                + '</div>'

                + '<div class="input-field col s1">'
                + '<input value="' + this.unityFrequency + '" id="freq-' + idInter + '" type="text" disabled >'
                + '<label for="freq">Nb</label>'
                + '</div>'

                + '<div class="input-field col s2">'
                + '<input value="' + this.frequency + '" id="first_name2" type="text" disabled >'
                + '<label>Frequency</label>'
                + '</div>'

                + '<div class="input-field col s3">'
                + '<input value="' + this.moment + '" id="first_name2" type="text" disabled >'
                + '<label>Moment</label>'
                + '</div>'

                + '<div class="input-field col s1">'
                + '<input value="' + this.unityDuration + '" id="first_name2" type="text" disabled >'
                + '<label for="freq">Nb</label>'
                + '</div>'

                + '<div class="input-field col s2">'
                + '<input value="years" id="first_name2" type="text" disabled >'
                + '<label>Duration</label>'
                + '</div>'
                + '</div>'
                + '</div>';


        $('#inters').append(inters);
        if (idInter > 0) {
            $('#inter-' + idInter).hide();
        }
        idInter++;

        idDisease++;
        // Activate  

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
});
