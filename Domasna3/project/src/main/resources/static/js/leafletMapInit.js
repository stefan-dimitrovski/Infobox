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

var localization = {
    id: "ID_TEMP: ",
    lat: "LAT_TEMP: ",
    lon: "LOT_TEMP: ",
    amenity: "AMENITY_TEMP: ",
    name: "Name: ",
    cuisine: "Cuisine: ",
    addr_street: "Street: ",
    addr_postcode: "Postcode: ",
    building: "Building: ",
    addr_city: "City: ",
    opening_hours: "Opening hour: ",
    internet_access: "Internet access: ",
    addr_housenumber: "House number: ",
    phone: "Phone: ",
    smoking: "Smoking: ",
    outdoor_seating: "Outdoor seating: ",
    website: "Website: ",
    takeaway: "Takeaway: ",
    wheelchair: "Wheelchair: ",
    operator_: "Operator: ",
    email: "Email: ",
    delivery: "Delivery: ",
    drive_through: "Drive trough: ",
    organic: "Organic: ",
    capacity: "Capacity: ",
    payment_mastercard: "Mastercard: "
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
            else {
                infoArea.innerHTML += "<b>" + localization[i] + "</b>" + place[i] + "<br>";
            }
        }
    }
}

var getID = document.getElementById("passDataToJS");
if ( getID != null ) {
    $.ajax('http://localhost:8080/api?id=' + getID.getAttribute("data-id"), {
        success: function(data, stauts, xhr) {
            showInfo(data);
        }
    });
}



