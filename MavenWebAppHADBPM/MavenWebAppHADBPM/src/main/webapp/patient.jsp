<%@include file="tete.jsp" %>

<div class="container">
  <div class="section">

    <div class="row">

      <div class="col s8 offset-s2">
        <div class="card-panel grey lighten-5 z-depth-1">
          <div class="row valign-wrapper">
            <div class="col s4">
              <img src="materialize-css/person.png" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
              </div>

              <div class="col s8">
                <h5><div id="names"></div></h5><br>
                <b> Sexe : </b> <div id="sex"></div><br>
                <b> Birth : </b><div id="birth"></div><br>
                <b> Adress : </b> <div id="adress"></div><br>
                <b> S.S.N. : </b> <div id="socialSecurityNumber"></div>
              </div>





            </div>
          </div>
        </div>
        <diV class="col s12">
          <nav id="navItems">
            <div class="nav-wrapper grey">
              <ul class="hide-on-med-and-down">
                <li class="col s4 center"><a href="#" onclick="$('#patient_notes').hide();$('#medical_data').hide();$('#info_patient').show();$(this).parent().siblings().removeClass('active');$(this).parent().addClass('active')">Info patient</a></li>
                <li class="col s4 center"><a href="#" onclick="$('#patient_notes').hide();$('#info_patient').hide();$('#medical_data').show();$(this).parent().siblings().removeClass('active');$(this).parent().addClass('active')">Medical Data</a></li>
                <li class="col s4 center"><a href="#" onclick="$('#medical_data').hide();$('#info_patient').hide();$('#patient_notes').show();$(this).parent().siblings().removeClass('active');$(this).parent().addClass('active')">Patient notes</a></li>
              </ul>
            </div>
          </nav>

        </div>

        <diV id="info_patient" class="col s12">
          <div class="col s4">
            <div class="card">
              <div class="card-content">
                <b> Phone number : </b> <div id="phoneNumber"></div><br>
                <b> Email : </b> <div id="email"></div><br>
                <b> Marital Status : </b> <div id="maritalStatus"></div>
              </div>
            </div>
          </div>
          <div class="col s4">
            <div class="card">
              <div class="card-content">
                <b> Internet access : </b> <div id="internet"></div><br>
                <b> Valide : </b> <div id="valide"></div><br>
                <b> Family valide : </b> <div id="valideFamily"></div><br>
                <b> Accessible place : </b> <div id="accessiblePlace"></div>
              </div>
            </div>
          </div>
          <div class="col s4">
            <div class="card">
              <div class="card-content">
                <b> Smoking : </b> <div id="smoking"></div><br>
                <b> Sport : </b> <div id="sport"></div>
              </div>
            </div>
          </div>
        </div>

        <diV id="medical_data" class="col s12">
          <div class="col s6">
            <div class="card">
              <div class="card-content">
                <span><i class="material-icons prefix">accessibility</i><b> Size : </b><div id="size"></div></span><br>
                <span><i class="material-icons prefix">linear_scale</i><b> Weight : </b><div id="weight"></div></span>
              </div>
            </div>
          </div>
          <div class="col s6">
            <div class="card">
              <div class="card-content">
                <span><i class="material-icons prefix">assignment</i><b> Allergies : </b><div id="allergies"></div> </span><br>
                <span><i class="material-icons prefix">assignment</i><b> Disease : </b><div id="disease"></div> </span><br>
                <span><i class="material-icons prefix">assignment</i><b> Previous : </b> <div id="previous"></div> </span>
              </div>
            </div>
          </div>
        </div>

        <diV id="patient_notes" class="col s12">
          <div class="col s12">
            <div class="card">
              <div class="card-content">
                <span><div id="notes"></div> </span>
              </div>
            </div>
          </div>

        </div>
      </div>


    </div>
  </div>
  <!-- Display cards -->


  <%@include file="pied.jsp" %>
  <script type="text/javascript" src="patient.js"></script>

</body>

</html>
