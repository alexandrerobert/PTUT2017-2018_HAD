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
            <div class="col s12" id="lst">
                <!-- progressBar only while loading data -->
                <div id="progress" class="col l6 s6 offset-s3 offset-l3 progress">
                    <div class="indeterminate orange darken-2s"></div>
                </div>
                
                
            </div>
        </div>



    </div>
</div>


<%@include file="pied.jsp" %>


</body>

</html>
<script type="text/javascript" src="searchDisease.js"></script>
