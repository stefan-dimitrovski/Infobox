var mymap = L.map('mapid').setView([41.996243, 21.428146], 13);
//pk.eyJ1IjoicDFheWVyIiwiYSI6ImNraGUyYTBrNzA3cXgyd3FvZWJ6dDA5N28ifQ.lLfGB-VZBrqEhsjIERV4Qg
L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,
    id: 'mapbox/streets-v11',
    tileSize: 512,
    zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoicDFheWVyIiwiYSI6ImNraGUyYTBrNzA3cXgyd3FvZWJ6dDA5N28ifQ.lLfGB-VZBrqEhsjIERV4Qg'
}).addTo(mymap);