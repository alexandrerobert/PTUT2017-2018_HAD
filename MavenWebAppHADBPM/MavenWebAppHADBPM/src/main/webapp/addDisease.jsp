<%@include file="tete.jsp" %>


<!-- Beginning of the web site's content -->
<div class="container">
  <div class="section">

    <div class="row">
      <h1 class="header center blue-text">Fill intervention for a disease</h1>
      <div class="center">
        <div class="input-field col s12">
          <div class="input-field col s6">
            <input id="nameDisease" type="text" class="validate" required="true">
              <label>Name of disease</label>
            </div>
            <div class="input-field col offset-s3">
              <button onclick="addDisease()" class="btn waves-effect waves-light" name="action">Add disease
                <i class="material-icons right">add</i>
              </button>
            </div>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col s10">
          <ul id="interventions" class="tabs">
            <li class="tab" id="item-0"><a onclick="showInter(0)" id="0">New intervention</a></li>
          </ul>
        </div>
        <div class="col s2">
          <a class="btn-floating btn-large waves-effect waves-light red" id="addInt">
            <i class="material-icons">add</i>
          </a>
        </div>
      </div>

      <div class="row interventionsDetails" style="border:solid orange; border-radius: 35px;">

        <div class="inter" id="inter-0">
          <div class="col s6">
            <div class="row">
              <div class="input-field col s12">
                <i class="material-icons prefix">account_circle</i>
                <input type="text" id="actor-0" class="actor">
                  <label for="autocomplete-input">Actor</label>
                </div>
              </div>
            </div>

            <div class="input-field col s6">
              <div class="row">
                <select id="HomeCareStructure-0">
                  <option value="" disabled selected>HomeCareStructure</option>
                  <option value="At Home">At Home</option>
                  <option value="HomeCare">HomeCare</option>
                  <option value="Laboratory">Laboratory</option>
                </select>
                <label>HomeCareStructure</label>
              </div>
            </div>

            <div class="row">
              <div class="col s3">
                <div class="row">
                  <div class="input-field col s12">
                    <i class="material-icons prefix">description</i>
                    <input type="text" id="action-0" class="action">
                      <label for="autocomplete-input">Action</label>
                    </div>
                  </div>
                </div>

                <div class="input-field col s1">
                  <input id="freq-0" type="text" class="validate">
                    <label for="freq">Nb</label>
                  </div>

                  <div class="input-field col s2">
                    <select id="freqUnit-0">
                      <option value="Day">Day</option>
                      <option value="Week">Week</option>
                      <option value="Month">Month</option>
                    </select>
                    <label>Frequency</label>
                  </div>

                  <div class="input-field col s3">
                    <select multiple id="freqMoment-0">
                      <option value="Morning">Morning</option>
                      <option value="Afternoon">Afternoon</option>
                      <option value="Evening">Evening</option>
                      <option value="Night">Night</option>
                    </select>
                    <label>Moment</label>
                  </div>

                  <div class="input-field col s1">
                    <input id="duration-0" type="text" class="validate">
                      <label for="freq">Nb</label>
                    </div>

                    <div class="input-field col s2">
                      <select id="durationUnit-0">
                        <option value="" disabled selected>Duration</option>
                        <option value="Day">Day</option>
                        <option value="Week">Week</option>
                        <option value="Month">Month</option>
                        <option value="Year">Year</option>
                      </select>
                      <label>Duration</label>
                    </div>
                  </div>
                  <div class="col offset-s11">
                    <a onclick="deleteItem(0)" class="btn-floating btn-large waves-effect waves-light grey" id="addInt">
                      <i class="material-icons">delete</i>
                    </a>
                  </div>
                </div>






              </div>


            </div>
          </div>

          <%@include file="pied.jsp" %>


        </body>

      </html>
      <script type="text/javascript" src="addDisease.js"></script>
