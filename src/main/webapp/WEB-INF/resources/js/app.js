
(function(){
  var app=angular.module('myApp', ['ngMap']);
  app.controller('MarkerCtrl',['$scope', function($scope) {
  
  
  var beforeMarker = null;
  
  //var markers = [];
  $scope.deleteID = "";
  $scope.elements = elements;  
  $scope.isDelete = true;
  var map;
  var infoWindow;
  $scope.dynMarkers = [];
  $scope.$on('mapInitialized', function(evt, evtMap) {
    map = evtMap;
    
    for (var i=0; i<$scope.elements.length; i++) { 
      
      setMarker(map,new google.maps.LatLng($scope.elements[i].latLng[0],$scope.elements[i].latLng[1]),$scope.elements[i].title,
      $scope.elements[i].icon,$scope.elements[i].content,$scope.elements[i].id);
    }
    
    
  //  for (var i=0; i<$scope.elements.length; i++) {
    //    var latLng = new google.maps.LatLng($scope.elements[i].latLng[0], $scope.elements[i].latLng[1]);
      //  $scope.dynMarkers.push(new google.maps.Marker({position:latLng}));
    //}
    $scope.markerClusterer = new MarkerClusterer(map, $scope.dynMarkers, {});
    
    $scope.placeMarker = function(e) {
      var marker;
                    if (beforeMarker !== null) {
                        
                        beforeMarker.setMap(null);
                        marker = new google.maps.Marker({position: e.latLng, map: map});
                        map.panTo(e.latLng);
                        $("#lat").val(marker.position.lat);
                        $("#lng").val(marker.position.lng);
                        $("#id").val("");
                        $("#title").val("");
                        $("#icon").val("");
                        $("#content").val("");
                        $('#addOrUpdate').val('ADD MARKER'); 
                        $scope.isDelete = true;
                    }else {
                        marker = new google.maps.Marker({position: e.latLng, map: map});
                        map.panTo(e.latLng);
                        $("#lat").val(marker.position.lat);
                        $("#lng").val(marker.position.lng);
                        $("#id").val("");
                        $("#title").val("");
                        $("#icon").val("");
                        $("#content").val("");
                        $('#addOrUpdate').val('ADD MARKER');
                        $scope.isDelete = true;
                    }
      
      beforeMarker = marker;
      
      
    }
  });
  
   // place a marker
        function setMarker(map, position, title, icon, content,id) {
            var marker;
            var markerOptions = {
                position: position,
                map: map,
                title: title,
                icon: icon,
                content: content,
                id:id
            };

            marker = new google.maps.Marker(markerOptions);
            //markers.push(marker); // add marker to array
            $scope.dynMarkers.push(marker);
            google.maps.event.addListener(marker, 'click', function () {
                // close window if not undefined
                if (infoWindow !== void 0) {
                    infoWindow.close();
                }
                // create new window
                var infoWindowOptions = {
                    content: content
                };
                infoWindow = new google.maps.InfoWindow(infoWindowOptions);
                infoWindow.open(map, marker);
                
                $("#id").val(marker.id);
                $("#lat").val(marker.position.lat);
                 $("#lng").val(marker.position.lng);
                  $("#title").val(marker.title);
                   $("#icon").val(marker.icon);
                    $("#content").val(marker.content);
                $('#addOrUpdate').val('UPDATE MARKER');    
                $scope.$apply(function () {
                  $scope.isDelete = false;
                  $scope.deleteID = marker.id;
                  
                });
              
            });
        }
  
  
}]);
  
//  var elements = [
//    {
//      id :1,
//      latLng : [36.900,30.70],
//      title: "Title1",
//      icon: 'https://maps.google.com/mapfiles/ms/icons/green-dot.png',
//      content: "Content1"
//    },{
//      id : 2,
//      latLng : [36.900,30.70042],
//      title: "Title2",
//      icon: 'https://maps.google.com/mapfiles/ms/icons/green-dot.png',
//      content: "Content2"
//    },{
//      id : 3,
//      latLng : [36.90054,30.70052],
//      title: "Title3",
//      icon: 'https://maps.google.com/mapfiles/ms/icons/green-dot.png',
//      content: "Content3"
//    }
//    
//  ];
  
  
  
  
  
})();


