<%@include file="tete.jsp" %>

<!-- Beginning of the web site's content -->
<div class="container">
  <div class="section">

    <!--   Icon Section   -->
    <div class="row">

      <div class="col l3 m3 s12"></div>

      <div class="col l6 m6 s12">
        <div class="row">
          <div class="input-field col s12">
            <i class="material-icons prefix">textsms</i>
            <input type="text" id="autocomplete-input" class="autocomplete">
              <label for="autocomplete-input">Patient's name</label>
            </div>
          </div>
        </div>

        <div class="col l3 m3 s12"></div>

      </div>

      <!-- Display cards -->
      <div class="row" id="place">

        <div class="col s12 m3">
          <div id="ajoutPat" class="card">
            <div class="card-image">
              <img style="background-color: #f44336;" height="100">
                <span class="card-title">Add Patient</span>
                <a class="btn-floating halfway-fab waves-effect waves-light red">
                  <i class="material-icons">add</i>
                </a>
              </div>
              <div class="card-content">
                <p><br /></p>
              </div>
            </div>
          </div>
        </div>



      </div>
      <br>
        <br>
        </div>

        <div class="infoPatient" style="z-index: 15; left: 0px; top: 200px; bottom: 0px; right: 0px; position: absolute; display: block; visibility: hidden">
          <%-- //style="; display: none;"> --%>
          <div class="container">
            <form class="col s12">
              <div class="row" style=" background-color : white">
                <ul class="collapsible" data-collapsible="accordion">

                  <!-- Personal Data -->
                  <li>
                    <div class="collapsible-header"><i class="material-icons">account_circle</i>Personal data</div>
                    <div class="collapsible-body">
                      <div class="row">
                        <div class="col s4">
                          <b>Last Name : </b>
                          <label id="hasLastName">Textarea</label>
                        </div>

                        <div class="col s4">
                            <b>First Name : </b>
                            <label id="hasFirstName">Textarea</label>
                          </div>

                          <div class="col s4">
                            <b>Sexe : </b>
                            <label id="hasSex">Female</label>
                          </div>

                          <div class="col s5">
                            <i class="material-icons prefix">today</i>
                            <b>Date of birth : </b>
                            <label id="hasDateOfBirth">03/02/1996</label>
                            </div>

                            <div class="col s1">
                              <b>at</b>
                            </div>

                            <div class="col s6">
                              <label id="hasPlaceOfBirth">Cambon</label>
                              </div>

                              <div class="input-field col s4">
                                <i class="material-icons prefix">add_circle</i>
                                <input id="hasSocialSecurityNumber" type="text" class="validate" required="true">
                                  <label>Social Security Number</label>
                                </div>

                                <div class="input-field col s8">
                                  <i class="material-icons prefix">location_on</i>
                                  <input id="hasAdress" type="text" class="validate" required="true">
                                    <label>Adress</label>
                                  </div>

                                  <div class="input-field col s6">
                                    <i class="material-icons prefix">phone</i>
                                    <input id="hasPhoneNumber" type="tel" class="validate">
                                      <label>Phone number</label>
                                    </div>

                                    <div class="input-field col s6">
                                      <i class="material-icons prefix">email</i>
                                      <input id="hasEmail" type="email" class="validate">
                                        <label>Email</label>
                                      </div>

                                      <div class="input-field col s6">
                                        <i class="material-icons prefix">add_circle</i>
                                        <select id="hasMaritalStatus">
                                          <option value="" disabled selected>Marital status</option>
                                          <option value="1">Single</option>
                                          <option value="2">Married</option>
                                          <option value="3">Relation ship</option>
                                          <option value="4">Divorced</option>
                                          <option value="5">Legally separated</option>
                                          <option value="6">Widowed</option>
                                        </select>
                                      </div>

                                      <div class="col s6">
                                        <i class="material-icons prefix">wifi</i>
                                        Internet access ?
                                        <div class="switch" style="display: inline-block">
                                          <label>
                                            No
                                            <input id="hasInternetAccess" type="checkbox">
                                              <span class="lever"></span>
                                              Yes
                                            </label>
                                          </div>
                                        </div>
                                      </div>
                                    </div>
                                  </li>

                                  <!-- Medical data -->
                                  <li>
                                    <div class="collapsible-header"><i class="material-icons">assignment</i>Medical data</div>
                                    <div class="collapsible-body">
                                      <div class="row">

                                        <div class="input-field col s6">
                                          <i class="material-icons prefix">accessibility</i>
                                          <input id="hasSize" type="text" class="validate">
                                            <label>Size</label>
                                          </div>

                                          <div class="input-field col s6">
                                            <i class="material-icons prefix">linear_scale</i>
                                            <input id="hasWeight" type="text" class="validate">
                                              <label>Weight</label>
                                            </div>

                                            <div class="input-field col s6">
                                              <i class="material-icons prefix">add_circle</i>
                                              <input id="hasAllergies" type="text" class="validate">
                                                <label>Allergies</label>
                                              </div>

                                              <div class="input-field col s6">
                                                <i class="material-icons prefix">add_circle</i>
                                                <select id="hasDisease" multiple>
                                                  <option value="" disabled selected>Disease</option>
                                                  <option value="1">Anaemia</option>
                                                  <option value="2">Arthritis</option>
                                                  <option value="3">Diabetes</option>
                                                </select>
                                              </div>

                                              <div class="input-field col s6">
                                                <i class="material-icons prefix">add_circle</i>
                                                <input id="hasPrevious" type="text" class="validate">
                                                  <label>Previous</label>
                                                </div>

                                                <div class="col s12">
                                                  <i class="material-icons prefix">wifi</i>
                                                  Valid entourage ?
                                                  <div class="switch" style="display: inline-block">
                                                    <label>
                                                      No
                                                      <input id="hasValidEntourage" type="checkbox">
                                                        <span class="lever"></span>
                                                        Yes
                                                      </label>
                                                    </div>
                                                  </div>

                                                  <div class="col s12">
                                                    <i class="material-icons prefix">wifi</i>
                                                    Accessible place ?
                                                    <div class="switch" style="display: inline-block">
                                                      <label>
                                                        No
                                                        <input id="hasAccessiblePlace" type="checkbox">
                                                          <span class="lever"></span>
                                                          Yes
                                                        </label>
                                                      </div>
                                                    </div>
                                                  </div>
                                                </div>
                                              </li>

                                              <li>
                                                <div class="collapsible-header"><i class="material-icons">create</i>Patient notes</div>
                                                <div class="collapsible-body">
                                                  <div class="row">
                                                    <div class="input-field col s12">
                                                      <textarea id="hasNotes" id="icon_prefix2" class="materialize-textarea"></textarea>
                                                      <label>Note</label>
                                                    </div>
                                                  </div>
                                                </div>
                                              </li>
                                            </ul>
                                          </div>
                                        </form>
                                      </div>
                                    </div>



                                    <%@include file="pied.jsp" %>
                                    <script type="text/javascript" src="searchPatient.js"></script>

                                  </body>

                                </html>
