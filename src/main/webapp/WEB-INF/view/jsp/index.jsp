<%-- 
    Document   : index
    Created on : Oct 20, 2015, 7:56:10 PM
    Author     : gurkan0791
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="cp" value="${pageContext.request.servletContext.contextPath}" scope="request"></c:set>

<!DOCTYPE html>
<html ng-app="myApp">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!--<link rel="stylesheet" type="text/css" href="${cp}/resources/css/site.css" />-->
        <link rel='stylesheet' href='${cp}/webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <!--<link rel='stylesheet' href='${cp}/webjars/leaflet-markercluster/0.4.0/MarkerCluster.css'>-->
    
        <title>JSP Page</title>
        <script>
            var elements = [
           <c:forEach var="row" items="${mark}">
                   {"id": '<c:out value="${row.id}" />',
                    "latLng" : [<c:out value="${row.lat}" />,
                              <c:out value="${row.lng}" />],
                    "title" : '<c:out value="${row.title}" />',
                    "icon":  '<c:out value="${row.icon}" />',
                    "content" : '<c:out value="${row.content}" />'},
            </c:forEach>   ];  
        </script>
    </head>
    <body>
        
    <div ng-controller="MarkerCtrl">
        <div class="container">
            <h1>GOOGLE MAP V3 ANGULARJS MONGODB DEMO</h1>
        </div>
        <map style="height: 500px;" center="39.095963, 35.419922" zoom="6" scrollwheel="false" center="36.900,30.70 "  map-type-id="ROADMAP" on-click="placeMarker()">
        </map>

        <br />
        <hr />
        <div class="container text-center">
        <h2><p>MAKER INFORMATION</p></h2>
        <!--<p id="demo">Click me to change my HTML content (innerHTML).</p>-->
        
        <div ng-show="{{deleteID !== null }}">
            <form:form class="form-horizontal" modelAttribute="marker" action="${cp}/insert" method="GET" >
                <form:hidden  path="id" name="id" id="id" />    
            <div class="form-group">
              <label for="inputEmail3" class="col-sm-2 control-label">Lat</label>
              <div class="col-sm-10">
                  <form:input path="lat" type="text" class="form-control" id="lat" placeholder="Lat" disabled="disabled" />
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-2 control-label">Lng</label>
              <div class="col-sm-10">
                <form:input path="lng"  type="text" class="form-control" id="lng" placeholder="Lng" disabled="disabled"/>
              </div>
            </div>
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-2 control-label">Title</label>
              <div class="col-sm-10">
                <form:input path="title"  type="text" class="form-control" id="title" placeholder="Marker Title here!" />
              </div>
            </div> 
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-2 control-label">Icon</label>
              <div class="col-sm-10">
                <form:input path="icon"  type="text" class="form-control" id="icon" placeholder="Marker Icon Here!" />
              </div>
            </div> 
            <div class="form-group">
              <label for="inputPassword3" class="col-sm-2 control-label">Content</label>
              <div class="col-sm-10">
                <form:input path="content"  type="text" class="form-control" id="content" placeholder="Marker Content Here!" />
              </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                  <input type="submit"  class="btn btn-success" value="ADD MARKER" id="addOrUpdate" />
                  <a href="${cp}/delete?id={{deleteID}}"  class="btn btn-warning" ng-disabled="isDelete" id="deleteMarker" >DELETE Marker</a>
                </div>
            </div>
        </form:form>
        </div>
        
        </div>
     </div>
        <!--Script Bootstrap & Jquery -->
        <!--src="https://maps.googleapis.com/maps/api/js?sensor=false&v=3.exp&libraries=places&signed_in=true&region=tr&language=tr&key=AIzaSyDY0kkJiTPVd2U7aTOAwhc9ySH6oHxOIYM"-->
        <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&libraries=weather,visualization,panoramio"></script>
        <script type="text/javascript" src="${cp}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${cp}/webjars/jquery/2.1.1/jquery.min.js"></script> 
        <script type="text/javascript" src="${cp}/webjars/angularjs/1.4.7/angular.min.js"></script> 
        <script src="https://rawgit.com/allenhwkim/angularjs-google-maps/master/build/scripts/ng-map.js"></script>
        <!--<script type="text/javascript" src="${cp}/webjars/leaflet-markercluster/0.4.0/leaflet.markercluster.js"></script>--> 
        <!--<script type="text/javascript" src="${cp}/webjars/leaflet-markercluster/0.4.0/leaflet.markercluster-src.js"></script>--> 
        <script type="text/javascript" src="${cp}/resources/js/markercluster.js"></script>
        <script type="text/javascript" src="${cp}/resources/js/app.js"></script>
    </body>
</html>
