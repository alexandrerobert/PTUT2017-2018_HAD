<%@include file="tete.jsp" %>


<!-- Beginning of the web site's content -->
<div class="container">
  <div class="section">

    <%-- Search disease --%>
    <div class="row">
      <div class="input-field col s6 offset-s3">
        <i class="material-icons prefix">search</i>
        <input type="text" class="disease">
          <label for="autocomplete-input">Search disease</label>
        </div>
      </div>


      <div class="row">
        <div class="col s12">

          <div id="disease-1" class="Arthritis card-panel light-grey">

            <h5> Arthritis </h5>

            <div class="list-disease">

              <ul class="pagination">
                <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
                <li class="waves-effect"><a onclick="showInter(1)">ChangesTheSheets</a></li>
                <li class="waves-effect"><a onclick="showInter(2)">SpeechTherapist</a></li>
                <li class="waves-effect"><a onclick="showInter(3)">CleaningRoom</a></li>
                <li class="waves-effect"><a onclick="showInter(4)">SendMessageToThePatient</a></li>
                <li class="waves-effect"><a><i class="material-icons">chevron_right</i></a></li>
              </ul>

              <div class="row interventionsDetails" style="border:solid grey; border-radius: 35px;">

                <div class="inter" id="inter-1">
                  <div class="col s6">
                    <div class="row">
                      <div class="input-field col s12">
                        <i class="material-icons prefix">account_circle</i>
                        <input value="Nurse" id="first_name2" type="text" disabled >
                          <label for="autocomplete-input">Actor</label>
                        </div>
                      </div>
                    </div>

                    <div class="input-field col s6">
                      <div class="row">
                        <input value="At Home" id="first_name2" type="text" disabled >
                          <label>HomeCareStructure</label>
                        </div>
                      </div>

                      <div class="row">
                        <div class="col s3">
                          <div class="row">
                            <div class="input-field col s12">
                              <i class="material-icons prefix">description</i>
                              <input value="ChangeSheets" id="first_name2" type="text" disabled >
                                <label for="autocomplete-input">Action</label>
                              </div>
                            </div>
                          </div>

                          <div class="input-field col s1">
                            <input value="1" id="first_name2" type="text" disabled >
                              <label for="freq">Nb</label>
                            </div>

                            <div class="input-field col s2">
                              <input value="Month" id="first_name2" type="text" disabled >
                                <label>Frequency</label>
                              </div>

                              <div class="input-field col s3">
                                <input value=" " id="first_name2" type="text" disabled >
                                  <label>Moment</label>
                                </div>

                                <div class="input-field col s1">
                                  <input value="3" id="first_name2" type="text" disabled >
                                    <label for="freq">Nb</label>
                                  </div>

                                  <div class="input-field col s2">
                                    <input value="Years" id="first_name2" type="text" disabled >
                                      <label>Duration</label>
                                    </div>
                                  </div>
                                </div>

                                <div class="inter" id="inter-2">
                                  <div class="col s6">
                                    <div class="row">
                                      <div class="input-field col s12">
                                        <i class="material-icons prefix">account_circle</i>
                                        <input value="Therapist" id="first_name2" type="text" disabled >
                                          <label for="autocomplete-input">Actor</label>
                                        </div>
                                      </div>
                                    </div>

                                    <div class="input-field col s6">
                                      <div class="row">
                                        <input value="At Home" id="first_name2" type="text" disabled >
                                          <label>HomeCareStructure</label>
                                        </div>
                                      </div>

                                      <div class="row">
                                        <div class="col s3">
                                          <div class="row">
                                            <div class="input-field col s12">
                                              <i class="material-icons prefix">description</i>
                                              <input value="SpeechTherapist" id="first_name2" type="text" disabled >
                                                <label for="autocomplete-input">Action</label>
                                              </div>
                                            </div>
                                          </div>

                                          <div class="input-field col s1">
                                            <input value="1" id="first_name2" type="text" disabled >
                                              <label for="freq">Nb</label>
                                            </div>

                                            <div class="input-field col s2">
                                              <input value="Week" id="first_name2" type="text" disabled >
                                                <label>Frequency</label>
                                              </div>

                                              <div class="input-field col s3">
                                                <input value=" " id="first_name2" type="text" disabled >
                                                  <label>Moment</label>
                                                </div>

                                                <div class="input-field col s1">
                                                  <input value="3" id="first_name2" type="text" disabled >
                                                    <label for="freq">Nb</label>
                                                  </div>

                                                  <div class="input-field col s2">
                                                    <input value="Years" id="first_name2" type="text" disabled >
                                                      <label>Duration</label>
                                                    </div>
                                                  </div>
                                                </div>
                                                <div class="inter" id="inter-3">
                                                  <div class="col s6">
                                                    <div class="row">
                                                      <div class="input-field col s12">
                                                        <i class="material-icons prefix">account_circle</i>
                                                        <input value="CareAid" id="first_name2" type="text" disabled >
                                                          <label for="autocomplete-input">Actor</label>
                                                        </div>
                                                      </div>
                                                    </div>

                                                    <div class="input-field col s6">
                                                      <div class="row">
                                                        <input value="At Home" id="first_name2" type="text" disabled >
                                                          <label>HomeCareStructure</label>
                                                        </div>
                                                      </div>

                                                      <div class="row">
                                                        <div class="col s3">
                                                          <div class="row">
                                                            <div class="input-field col s12">
                                                              <i class="material-icons prefix">description</i>
                                                              <input value="CleaningRoom" id="first_name2" type="text" disabled >
                                                                <label for="autocomplete-input">Action</label>
                                                              </div>
                                                            </div>
                                                          </div>

                                                          <div class="input-field col s1">
                                                            <input value="2" id="first_name2" type="text" disabled >
                                                              <label for="freq">Nb</label>
                                                            </div>

                                                            <div class="input-field col s2">
                                                              <input value="Week" id="first_name2" type="text" disabled >
                                                                <label>Frequency</label>
                                                              </div>

                                                              <div class="input-field col s3">
                                                                <input value="Morning" id="first_name2" type="text" disabled >
                                                                  <label>Moment</label>
                                                                </div>

                                                                <div class="input-field col s1">
                                                                  <input value="2" id="first_name2" type="text" disabled >
                                                                    <label for="freq">Nb</label>
                                                                  </div>

                                                                  <div class="input-field col s2">
                                                                    <input value="Years" id="first_name2" type="text" disabled >
                                                                      <label>Duration</label>
                                                                    </div>
                                                                  </div>
                                                                </div>
                                                                <div class="inter" id="inter-4">
                                                                  <div class="col s6">
                                                                    <div class="row">
                                                                      <div class="input-field col s12">
                                                                        <i class="material-icons prefix">account_circle</i>
                                                                        <input value="Nurse" id="first_name2" type="text" disabled >
                                                                          <label for="autocomplete-input">Actor</label>
                                                                        </div>
                                                                      </div>
                                                                    </div>

                                                                    <div class="input-field col s6">
                                                                      <div class="row">
                                                                        <input value="At Home" id="first_name2" type="text" disabled >
                                                                          <label>HomeCareStructure</label>
                                                                        </div>
                                                                      </div>

                                                                      <div class="row">
                                                                        <div class="col s3">
                                                                          <div class="row">
                                                                            <div class="input-field col s12">
                                                                              <i class="material-icons prefix">description</i>
                                                                              <input value="SendMessageToThePatient" id="first_name2" type="text" disabled >
                                                                                <label for="autocomplete-input">Action</label>
                                                                              </div>
                                                                            </div>
                                                                          </div>

                                                                          <div class="input-field col s1">
                                                                            <input value="8" id="first_name2" type="text" disabled >
                                                                              <label for="freq">Nb</label>
                                                                            </div>

                                                                            <div class="input-field col s2">
                                                                              <input value="Month" id="first_name2" type="text" disabled >
                                                                                <label>Frequency</label>
                                                                              </div>

                                                                              <div class="input-field col s3">
                                                                                <input value="Morning - Night" id="first_name2" type="text" disabled >
                                                                                  <label>Moment</label>
                                                                                </div>

                                                                                <div class="input-field col s1">
                                                                                  <input value="3" id="first_name2" type="text" disabled >
                                                                                    <label for="freq">Nb</label>
                                                                                  </div>

                                                                                  <div class="input-field col s2">
                                                                                    <input value="Years" id="first_name2" type="text" disabled >
                                                                                      <label>Duration</label>
                                                                                    </div>
                                                                                  </div>
                                                                                </div>

                                                                              </div>

                                                                            </div>
                                                                          </div>


                                                                          <div id="disease-2" class="Depression card-panel light-grey">

                                                                            <h5> Depression </h5>

                                                                            <div class="list-disease">

                                                                              <ul class="pagination">
                                                                                <li class="disabled"><a href="#!"><i class="material-icons">chevron_left</i></a></li>
                                                                                <li class="waves-effect"><a href="#!"><i class="material-icons">chevron_right</i></a></li>
                                                                              </ul>

                                                                              <div class="row interventionsDetails" style="border:solid grey; border-radius: 35px;">

                                                                                <div class="inter" id="inter-8">
                                                                                  <div class="col s6">
                                                                                    <div class="row">
                                                                                      <div class="input-field col s12">
                                                                                        <i class="material-icons prefix">account_circle</i>
                                                                                        <input value="Nurse" id="first_name2" type="text" disabled >
                                                                                          <label for="autocomplete-input">Actor</label>
                                                                                        </div>
                                                                                      </div>
                                                                                    </div>

                                                                                    <div class="input-field col s6">
                                                                                      <div class="row">
                                                                                        <input value="At Home" id="first_name2" type="text" disabled >
                                                                                          <label>HomeCareStructure</label>
                                                                                        </div>
                                                                                      </div>

                                                                                      <div class="row">
                                                                                        <div class="col s3">
                                                                                          <div class="row">
                                                                                            <div class="input-field col s12">
                                                                                              <i class="material-icons prefix">description</i>
                                                                                              <input value="ChangeSheets" id="first_name2" type="text" disabled >
                                                                                                <label for="autocomplete-input">Action</label>
                                                                                              </div>
                                                                                            </div>
                                                                                          </div>

                                                                                          <div class="input-field col s1">
                                                                                            <input value="8" id="first_name2" type="text" disabled >
                                                                                              <label for="freq">Nb</label>
                                                                                            </div>

                                                                                            <div class="input-field col s2">
                                                                                              <input value="Month" id="first_name2" type="text" disabled >
                                                                                                <label>Frequency</label>
                                                                                              </div>

                                                                                              <div class="input-field col s3">
                                                                                                <input value="Morning - Night" id="first_name2" type="text" disabled >
                                                                                                  <label>Moment</label>
                                                                                                </div>

                                                                                                <div class="input-field col s1">
                                                                                                  <input value="3" id="first_name2" type="text" disabled >
                                                                                                    <label for="freq">Nb</label>
                                                                                                  </div>

                                                                                                  <div class="input-field col s2">
                                                                                                    <input value="Years" id="first_name2" type="text" disabled >
                                                                                                      <label>Duration</label>
                                                                                                    </div>
                                                                                                  </div>
                                                                                                </div>






                                                                                              </div>


                                                                                            </div>
                                                                                          </div>
                                                                                        </div>
                                                                                      </div>



                                                                                    </div>
                                                                                  </div>


                                                                                  <%@include file="pied.jsp" %>


                                                                                </body>

                                                                              </html>
                                                                              <script type="text/javascript" src="searchDisease.js"></script>
