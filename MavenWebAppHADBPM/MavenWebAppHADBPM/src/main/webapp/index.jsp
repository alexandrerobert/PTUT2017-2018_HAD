<%@include file="tete.jsp" %>

<div class="row section no-pad-bot">
  <div class="container">

  <div class="slider">
    <ul class="slides">
      <li>
        <img src="materialize-css/car1.jpg">
        <div class="caption left-align">
          <h2 style="color : black; background-color:white">Welcome !</h2>
        </div>
      </li>

      <li>
        <img src="materialize-css/car2.jpg">
        <div class="caption center-align">
          <h3 style="color : black; background-color:white">This is the application for HAD!</h3>
        </div>
      </li>
    </ul>
  </div>





    <div class="col s12 m6">
      <div class="card blue-grey darken-1" >
        <div class="card-content white-text" >
          <span class="card-title">Patient </span>
        </div>
        <div class="card-action">

          <div class="row">
            <div class="col l3"></div>
            <a href="addPatient.jsp" class="col l6 btn-large waves-effect waves-light btn"><i class="material-icons left">add</i>Add</a>
            <div class="col l3"></div>
          </div>
          <div class="row">
            <div class="col l3"></div>
            <a href="searchPatient.jsp" class="col l6 btn-large waves-effect waves-light btn"><i class="material-icons left">search</i>Search</a>
            <div class="col l3"></div>
          </div>

        </div>
      </div>
    </div>
    <div class="col s12 m6">
      <div class="card blue-grey darken-1">
        <div class="card-content white-text">
          <span class="card-title">Disease</span>
        </div>
        <div class="card-action">

          <div class="row">
            <div class="col l3"></div>
            <a href="addDisease.jsp" class="col l6 btn-large waves-effect waves-light btn"><i class="material-icons left">add</i>Add</a>
            <div class="col l3"></div>
          </div>
          <div class="row">
            <div class="col l3"></div>
            <a href="searchDisease.jsp" class="col l6 btn-large waves-effect waves-light btn"><i class="material-icons left">search</i>Search</a>
            <div class="col l3"></div>
          </div>

        </div>
      </div>
    </div>
  </div>
</div>

<%@include file="pied.jsp" %>
<script>


$(document).ready(function(){
  $('.collapsible').collapsible();

  $('.carousel.carousel-slider').carousel({fullWidth: false});
  $('.carousel').carousel({
    padding: 200
});
autoplay()
function autoplay() {
    $('.carousel').carousel('next');
    setTimeout(autoplay, 2500);
}
});

$(document).ready(function(){
  $('.slider').slider();
});


$(document).ready(function() {
  $('select').material_select();
});
</script>
</body>
</html>
