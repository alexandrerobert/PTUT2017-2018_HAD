  <%@include file="tete.jsp" %>

  <div class="row">
    <div class="container">
      <h2 class="center"> WELCOME ! </h2>
          <div class="col s12 m6">
            <div class="card brown lighten-3" >
              <div class="card-content white-text" >
                <span class="card-title">Patient </span>
              </div>
              <div class="card-action">

                <div class="row">
                  <div class="col l3"></div>
                  <a href="addPatient.jsp" class="col l6 btn-large waves-effect waves-light btn orange"><i class="material-icons left">add</i>Add</a>
                  <div class="col l3"></div>
                </div>
                <div class="row">
                  <div class="col l3"></div>
                  <a href="searchPatient.jsp" class="col l6 btn-large waves-effect waves-light btn orange"><i class="material-icons left">search</i>Search</a>
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
                  <a href="addDisease.jsp" class="col l6 btn-large waves-effect waves-light btn orange"><i class="material-icons left">add</i>Add</a>
                  <div class="col l3"></div>
                </div>
                <div class="row">
                  <div class="col l3"></div>
                  <a href="searchDisease.jsp" class="col l6 btn-large waves-effect waves-light btn orange"><i class="material-icons left">search</i>Search</a>
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
  });

  $(document).ready(function() {
    $('select').material_select();
  });
  </script>
</body>
</html>
