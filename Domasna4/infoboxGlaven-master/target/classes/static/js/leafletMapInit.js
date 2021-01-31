
// ako ne raboti api-ot treba da se stavi adresata na host-ot bez / na kraj
// staveno e da vleche avtomatski sega, vo sluchaj da treba mozhe da se stavi fix-no da e
var hostIP = window.location.href.substr(0, window.location.href.indexOf('/explore')).replace(':8080', '') + ':8081';

var mymap = L.map('mapid').setView([41.996243, 21.428146], 13);
//pk.eyJ1IjoicDFheWVyIiwiYSI6ImNraGUyYTBrNzA3cXgyd3FvZWJ6dDA5N28ifQ.lLfGB-VZBrqEhsjIERV4Qg
L.tileLayer('https://api.mapbox.com/styles/v1/{id}/tiles/{z}/{x}/{y}?access_token={accessToken}', {
    attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors, <a href="https://creativecommons.org/licenses/by-sa/2.0/">CC-BY-SA</a>, Imagery © <a href="https://www.mapbox.com/">Mapbox</a>',
    maxZoom: 18,        id: 'mapbox/streets-v11',
    tileSize: 512,      zoomOffset: -1,
    accessToken: 'pk.eyJ1IjoicDFheWVyIiwiYSI6ImNraGUyYTBrNzA3cXgyd3FvZWJ6dDA5N28ifQ.lLfGB-VZBrqEhsjIERV4Qg'
}).addTo(mymap);

var localization = {
    id: "ID_TEMP",                          lon: "LON_TEMP",
    lat: "LAT_TEMP",                        name: "Name: ",
    email: "Email: ",                       phone: "Phone: ",
    amenity: "Amenity: ",                   cuisine: "Cuisine: ",
    smoking: "Smoking: ",                   name_en: "Name eng: ",
    website: "Website: ",                   addr_city: "City address: ",
    addr_street: "Street address: ",        addr_postcode: "Postcode: ",
    opening_hours: "Opening hours: ",       outdoorseating: "Outdoor seating: ",
    addr_housenumber: "House number: ",     wheelchair: "",
    building: "Building: ",                 drive_through: "Drive trough: ",
    shop: "Shop: ",                         takeaway: "Takeaway: ",
    internet_access: "Internet access: ",   drive_in: "Drive-in: ",
    delivery: "Delivery: ",                 abandoned: "Abandoned: ",
    seasonal: "Seasonal: ",                 wifi: "Wi-Fi: ",
    operator: "Operator: ",                 organic: "Organic: ",
    payment_mastercard: "Mastercard: ",     payment_visa: "Visa: ",
    capacity: "Capacity: "
};

function showInfo(place) {
    var infoArea = document.getElementById("infoArea");
    infoArea.innerHTML = "";
    for (let i in place) {
        // Komentiraj go ovoj if za debug-iranje
        if (i == "id" || i == "lat" || i == "lon" || i == "amenity") continue;
        if (place[i] != null) {
            if (i == "website") {
                infoArea.innerHTML += "<b>" + localization[i] + "</b><a href=" + place[i] + "target=\"_blank\">" + place[i] + "</a><br>";
            }
            else if (i == "cuisine") {
                infoArea.innerHTML += "<b>" + localization[i] + "</b>" + place[i].replaceAll(";", ", ").replaceAll("_", " ") + "<br>";
            }
            else {
                infoArea.innerHTML += "<b>" + localization[i] + "</b>" + place[i] + "<br>";
            }
        }
    }
}

var getID = document.getElementById("passDataToJS");
if ( getID != null ) {
    $.ajax(hostIP + '/api?id=' + getID.getAttribute("data-id"), {
        success: function(data, stauts, xhr) {
            if (data == null) {
                document.getElementById("infoArea").innerHTML = "ERROR: Location not found.";
            }
            else {
                L.marker([data["lat"], data["lon"]]).addTo(mymap);
                mymap.setView([data["lat"], data["lon"]], 13);
                showInfo(data);
            }
        },
        error: function () {
            document.getElementById("infoArea").innerHTML = "ERROR: Location not found.";
        }
    });
}

var cafe = [];

var layerGroup = L.layerGroup().addTo(mymap);
function addMarkers() {
    // remove all the markers in one go
    layerGroup.clearLayers();
    // L.marker([latUser, lonUser], {icon: userIcon}).addTo(mymap);
    if (document.getElementById("choosePlace").value == "return") return;
    $.ajax(hostIP + '/api/amenity?type=' + document.getElementById("choosePlace").value, {
        success: function(data, stauts, xhr) {
            cafe = data;
            for (let i = 0; i < cafe.length; i++) {
                L.marker([cafe[i].lat, cafe[i].lon]).on('click', function () { showInfo(cafe[i]) }).addTo(layerGroup);
            }
        }
    });
}
