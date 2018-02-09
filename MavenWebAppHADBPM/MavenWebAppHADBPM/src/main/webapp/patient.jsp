<%@include file="tete.jsp" %>



<!-- Beginning of the web site's content -->
<div class="container">
  <div class="section">

    <!--   Icon Section   -->


    <div class="row">

      <div class="col s8 offset-s2">
        <div class="card-panel grey lighten-5 z-depth-1">
          <div class="row valign-wrapper">
            <div class="col s4">
              <img src="materialize-css/person.png" alt="" class="circle responsive-img"> <!-- notice the "circle" class -->
              </div>
              <div id="info1" class="col s8">
                <h5><div id="names"></div></h5> <br><br>
                <b> Sexe : </b> <div id="sexe"></div> <br><br>
                <b> Birth : </b><div id="birth"></div></div><br><br>
                <b> Social Security Number : </b> <div id="socialSecurityNumber"></div> <br><br>
                <div class="right-align">
                  <a href="#" onclick="$('#info1').hide();$('#info2').show();"><i class="material-icons prefix">arrow_forward</i> </a>
                </div>
              </div>

              <div id="info2" class="col s8">
                <b> Adress : </b> <div id="adress"></div> <br><br>
                <b> Phone number : </b> <div id="phoneNumber"></div> <br><br>
                <b> Email : </b> <div id="email"></div> <br><br>
                <b> Marital Status : </b> <div id="maritalStatus"></div> <br><br>
                <b> Internet Access : </b> <div id="internet"></div>  <br><br>
                <div class="left-align">
                  <a href="#" onclick="$('#info2').hide();$('#info1').show();"><i class="material-icons prefix">arrow_back</i> </a>
                </div>
              </div>


            </div>
          </div>
        </div>
        <diV class="col s12">
          <nav>
            <div class="nav-wrapper grey">
              <ul class="hide-on-med-and-down">
                <li><a href="#" onclick="$('#patient_notes').hide();$('#medical_data').show();">Medical data</a></li>
                <li><a href="#" onclick="$('#medical_data').hide();$('#patient_notes').show();">Patient notes</a></li>
                <%-- <li class="active"><a href="collapsible.html">JavaScript</a></li> --%>
              </ul>
            </div>
          </nav>

        </div>
        <diV id="medical_data" class="col s12">





          <div class="col s4">
            <div class="card">
              <div class="card-content">
                <span><i class="material-icons prefix">accessibility</i><b> Size : </b> 164cm</span><br>
                <span><i class="material-icons prefix">linear_scale</i><b> Weight : </b> 10kg</span>
              </div>
            </div>
          </div>


          <div class="col s4">
            <div class="card">
              <div class="card-content">
              <span><i class="material-icons prefix">assignment</i><b> Allergies : </b> 8 rue borrel - 81100 Castres </span><br>
              <span><i class="material-icons prefix">assignment</i><b> Disease : </b> 06.22.67.51.92 </span><br>
              <span><i class="material-icons prefix">assignment</i><b> Previous : </b> Asthm </span>
            </div>
          </div>
          </div>

          <div class="col s4">
            <div class="card">
              <div class="card-content">
              <span><i class="material-icons prefix">linear_scale</i><b> Valid entourage : </b> yes </span><br>
              <span><i class="material-icons prefix">accessible</i><b> Accessible place : </b> yes </span>
            </div>
            </div>
          </div>








        </div>





        <diV id="patient_notes" class="col s12">
          <span>Pauline est une personne brillante !! </span>
        </div>
      </div>


    </div>
  </div>

  <!-- Display cards -->


  <%@include file="pied.jsp" %>
  <script type="text/javascript" src="patient.js"></script>

</body>

</html>
