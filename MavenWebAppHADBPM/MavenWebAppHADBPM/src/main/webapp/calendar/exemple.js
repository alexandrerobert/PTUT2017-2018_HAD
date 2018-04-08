//var selectedEvent;
var dp1;
var dp2;
var isClicked = false;
var startDate;
var endDate;
var isAllDay;
var title;
var selectedEvent;
var cal ;
var events;

function setIsAllDay (state) {
  if (state){
    isAllDay=true;
  }
  else {
    isAllDay=false;
  }
}

function setSelectedEvent (event) {
  selectedEvent= event;
  date_debut = (event.start.toISOString());
  setStart(date_debut);


  try {
    date_fin = (event.end.toISOString());
    setEnd(date_fin);
  }
  catch(error) {
    console.error(error);
  }

  $('#event_title').val(event.title);

}

function setStart (date) {
  startDate=moment(date).utc().toISOString();

  date=moment(date).utc().toISOString();

  dp1.setDate(date);
}

function setEnd (date) {
  endDate=moment(date).utc().toISOString();
  date=moment(date).utc().toISOString();
  dp2.setDate(date);
}

function updateMode () {
  $('#add').prop('disabled', true);
  $('#update').prop('disabled', false);

}

function addMode () {
    $('#update').prop('disabled', true);
    $('#add').prop('disabled', false);
}

function jsonImport(json){

stick=true;
  var formattedEventData = [];
  json.forEach(function(obj) {
    console.log(obj.subject);
    formattedEventData.push({
        title: obj.subject,
        start: obj.begin,
        end: obj.end,
        description: obj.description
  });
});
  $('#calendar').fullCalendar('renderEvents', formattedEventData, true  );
}

function jsonImport_2(json){


console.log(json); 

stick=true;
  var formattedEventData = [];
  date = 12;
  json.interventions.forEach(function(obj) {
    console.log(obj.subject);

    desc = obj.typeActor + ';'+obj.frequency;
    s= "2017-07-"+date+"T12:00:00";
    e= "2017-07-"+date+"T12:30:00";
    formattedEventData.push({
        title: obj.name,
        start: s,
        end: e,
        description: desc
  });
});
  $('#calendar').fullCalendar('renderEvents', formattedEventData, true  );
}

function jsonRequest(){

  var data = $.ajax({
    datatype: 'json',
    method: 'GET',
    url:'http://localhost:8080/MavenWebAppHADBPM/infoDisease.jsp?Disease=VesicularPeritonitis',
    sucess:function(data){
      return data;
    },
    async:false
  });

  return data;
}


$(function() { // document ready



// todo : DL JSON
$.getJSON("data.json", function(json) {

    //jsonImport(json);

});

jsonImport_2(jsonRequest());





 dp1 =  $("#datepicker_debut").flatpickr({
    altInput: true,
    altFormat: 'l j F Y at H:i',
    enableTime: true,
    dateFormat: 'z',
  });

 dp2 =  $("#datepicker_fin").flatpickr({
    altInput: true,
    altFormat: 'l j F Y at H:i',
    enableTime: true,
    dateFormat: 'z',
  });



var calendar = $('#calendar').fullCalendar({
    header: {
      left: 'prev,next today',
      center: 'title',
      right: 'month,agendaWeek,agendaDay'
    },
    defaultDate: '2017-07-12',
    editable: true,
    eventLimit: true, // allow "more" link when too many events
    defaultView: 'agendaDay',
    selectable: true, //permite sa selectezi mai multe zile
    selectHelper: true, //coloreaza selctia ta
    firstDay: 1,
    eventClick: function(event, jsEvent, view) {
      $(".cont").show().data('event', event);

      titre = event.title ;


      setSelectedEvent(event);

      updateMode();

    },


    dayClick: function(date, jsEvent, view) {


     },




    select: function(start, end, jsEvent, view) {


                    var starttime = start;
                    var endtime = end;
                    var allDay = !start.hasTime() && !end.hasTime();

                    setStart(starttime);
                    setEnd(endtime);
                    setIsAllDay(allDay);

                    addMode();


                  },
    events: [{
        title: 'titleEvent',
        start: '2014-11-12',
        allDay: false // will make the time show
      },

    ]
  });



  $("#add").click(function(e) {

    start=moment(startDate).toISOString();
    end=moment(endDate).toISOString();

    title=$('#event_title').val();


    $('#calendar').fullCalendar('renderEvent', {
              title: title,
              start: start,
              end: end,
              allDay: isAllDay
            }, stick );
  });

  $("#update").click(function(e) {



    title=$('#event_title').val();

    selectedEvent.title=title;
    selectedEvent.start=start;
    selectedEvent.end=end;

    $('#calendar').fullCalendar('updateEvent', selectedEvent);

  });


  $("#export").click(function(e) {

    export_to_ics();

  });

});
