REM So pomosh na ovaa skripta mozheme da izvlecheme odredeni informacii koi ni se potrebni
REM Za sekoj red definirame vo --keep koi lokacii da bidat izvlecheni
REM So "csvArgs" definirame koi vrednosti da vidat zachuvani vo .csv file

REM Otkako kje zavrshi skriptata kje bide ispechatena DONE poraka i mozheme da go izgasime terminalot

set "osmConvert=osmconvert.exe"
set "osmFilter=osmfilter.exe"
set "file=macedonia-latest.osm.pbf"
set "csvArgs=@id @lat @lon amenity name cuisine addr:street addr:postcode building addr:city opening_hours internet_access addr:housenumber phone smoking outdoor_seating website takeaway wheelchair operator email delivery drive_through organic capacity payment:mastercard payment:visa"
cls
%osmFilter% %file% --keep="amenity=ice_cream" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="ice_cream.csv"
%osmFilter% %file% --keep="amenity=pub" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="pub.csv"
%osmFilter% %file% --keep="amenity=restaurant" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="restaurant.csv"
%osmFilter% %file% --keep="amenity=fast_food" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="fast_food.csv"
%osmFilter% %file% --keep="amenity=bar" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="bar.csv"
%osmFilter% %file% --keep="amenity=cafe" | %osmConvert% - --all-to-nodes --csv="%csvArgs%" --csv-headline --csv-separator="," -o="cafe.csv"

echo DONE

pause>nul


