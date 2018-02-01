<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="materialize-css/dist/css/materialize.min.css"  media="screen,projection"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <meta charset="UTF-8">
      </head>

      <body>

        <nav class="orange" style="background-color: rgba(51,51,51,0.08);" role="navigation">
          <div class="nav-wrapper container">
            <a href="index.jsp" class="brand-logo">#HADBPMN</a>
            <ul class="right col-xs-12">
              <li><a class="dropdown-button" href="#!" data-activates="dropdown1"><i class="material-icons">more_vert</i></a></li>
              <li><a href="#!"><i class="material-icons">power_settings_new</i></a></li>
            </ul>
          </div>


        </nav>
        <ul id="dropdown1" class="dropdown-content">
          <li><a href="addPatient.jsp">Add patient</a></li>
          <li><a href="searchPatient.jsp">Search patient</a></li>
          <li class="divider"></li>
          <li><a href="addDisease.jsp">Add disease</a></li>
          <li><a href="searchDisease.jsp">Search disease</a></li>
        </ul>
