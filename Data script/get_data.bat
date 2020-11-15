REM So pomosh na ovaa skripta mozheme da izvlecheme odredeni informacii koi ni se potrebni
REM Za sekoj red definirame vo --keep koi lokacii da bidat izvlecheni
REM So "csvArgs" definirame koi vrednosti da vidat zachuvani vo .csv file

REM Otkako kje zavrshi skriptata kje bide ispechatena DONE poraka i mozheme da go izgasime terminalot

set "osmConvert=osmconvert.exe"
set "osmFilter=osmfilter.exe"
set "file=macedonia-latest.osm"
set "csvArgs=@id @lon @lat name email phone cuisine smoking name:en website addr:city addr:street addr:postcode opening_hours outdoor_seating addr:housenumber wheelchair building drive_through shop takeaway internet_access drive_in delivery abandoned seasonal wifi operator organic capacity payment:mastercard payment:visa"
cls

mkdir csvs

%osmFilter% %file% --keep="amenity=ice_cream" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="ice_cream.csv"


%osmFilter% %file% --keep="amenity=pub" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="pub.csv"


%osmFilter% %file% --keep="amenity=restaurant" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="restaurant.csv"


%osmFilter% %file% --keep="amenity=fast_food" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="fast_food.csv"


%osmFilter% %file% --keep="amenity=bar" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="bar.csv"


%osmFilter% %file% --keep="amenity=cafe" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="cafe.csv"

move .\*.csv .\csvs\

echo "DONE"

pause>nul


