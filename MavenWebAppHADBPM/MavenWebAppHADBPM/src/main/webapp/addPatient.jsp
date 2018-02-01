<%@include file="tete.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h1 class="header center orange-text">Add patient</h1>
      <br><br>
    </div>
  </div>

  <div class="row">
    <div class="container">
      <form class="col s12">
        <div class="row">
          <ul class="collapsible" data-collapsible="accordion">

            <!-- Personal Data -->
            <li>
              <div class="collapsible-header"><i class="material-icons">account_circle</i>Personal data</div>
              <div class="collapsible-body">
                <div class="row">
                  <div class="input-field col s4">
                    <input name="lastName" id="hasLastName" type="text" class="validate" required="true">
                    <label>Last Name</label>
                  </div>

                  <div class="input-field col s4">
                    <input name ="firstName" id="hasFirstName" type="text" class="validate" required="true">
                    <label>First name</label>
                  </div>

                  <div class="input-field col s4">
                    <select name=sexe" id="hasSex">
                      <option value="" disabled selected>Sexe</option>
                      <option value="1" >Male</option>
                      <option value="2" >Female</option>
                    </select>
                  </div>

                  <div class="input-field col s3">
                    <i class="material-icons prefix">today</i>
                    <input name="dob" id="hasDateOfBirth" type="text" class="datepicker" required="true" max="2019-01-01" min="1900-12-31">
                    <label>Date of birth</label>
                  </div>

                  <div class="input-field col s1">
                    <label>at</label>
                  </div>

                  <div class="input-field col s8">
                    <input name="pob" id="hasPlaceOfBirth" type="text" class="validate" required="true">
                    <label>Place of birth</label>
                  </div>

                  <div class="input-field col s4">
                    <i class="material-icons prefix">add_circle</i>
                    <input name="socialSecurityNumber" id="hasSocialSecurityNumber" type="text" class="validate" required="true">
                    <label>Social Security Number</label>
                  </div>

                  <div class="input-field col s8">
                    <i class="material-icons prefix">location_on</i>
                    <input name="address" id="hasAddress" type="text" class="validate" required="true">
                    <label>Adress</label>
                  </div>

                  <div class="input-field col s6">
                    <i class="material-icons prefix">phone</i>
                    <input name="phoneNumber" id="hasPhoneNumber" type="tel" class="validate">
                    <label>Phone number</label>
                  </div>

                  <div class="input-field col s6">
                    <i class="material-icons prefix">email</i>
                    <input name="email" id="hasEmail" type="email" class="validate">
                    <label>Email</label>
                  </div>

                  <div class="input-field col s6">
                    <i class="material-icons prefix">add_circle</i>
                    <select name="marital" id="hasMaritalStatus">
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
                        <input name=internet" id="hasInternetAccess" type="checkbox">
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
                    <input name=size" id="hasSize" type="text" class="validate">
                    <label>Size</label>
                  </div>

                  <div class="input-field col s6">
                    <i class="material-icons prefix">linear_scale</i>
                    <input name="weight" id="hasWeight" type="text" class="validate">
                    <label>Weight</label>
                  </div>

                  <div class="input-field col s6">
                    <i class="material-icons prefix">add_circle</i>
                    <input name="allergies" id="hasAllergies" type="text" class="validate">
                    <label>Allergies</label>
                  </div>

                  <div class="input-field col s6">
                    <i class="material-icons prefix">add_circle</i>
                    <select name="disease" id="hasDisease" multiple>
                      <option value="" disabled selected>Disease</option>
                      <option value="1">Anaemia</option>
                      <option value="2">Arthritis</option>
                      <option value="3">Diabetes</option>
                    </select>
                  </div>

                  <div class="input-field col s6">
                    <i class="material-icons prefix">add_circle</i>
                    <input name="previous" id="hasPrevious" type="text" class="validate">
                    <label>Previous</label>
                  </div>

                  <div class="col s12">
                    <i class="material-icons prefix">wifi</i>
                    Valid entourage ?
                    <div class="switch" style="display: inline-block">
                      <label>
                        No
                        <input name="entourage" id="hasValidEntourage" type="checkbox">
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
                        <input name="place" id="hasAccessiblePlace" type="checkbox">
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
                    <textarea name="note" id="hasNotes" id="icon_prefix2" class="materialize-textarea"></textarea>
                    <label>Note</label>
                  </div>
                </div>
              </div>
            </li>
          </ul>
        </div>
      </form>
      <div class="input-field col s12">
        <button class="btn waves-effect waves-light" type="submit" name="action">Validate
          <i class="material-icons right">send</i>
        </button>
      </div>
    </div>
  </div>

  <%@include file="pied.jsp" %>

  <script>
  $('.datepicker').pickadate({
    selectMonths: true, // Creates a dropdown to control month
    selectYears: 120, // Creates a dropdown of 15 years to control year,
    closeOnSelect: false, // Close upon selecting a date,
  });

  $(document).ready(function(){
    $('.collapsible').collapsible();
  });

  $(document).ready(function() {
    $('select').material_select();
  });
  </script>
</body>
</html>
