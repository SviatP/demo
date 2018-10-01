
# to run the application download it and run from project root commands below:

```
mvn clean install
docker-compose build
docker-compose up

```

```
To authentificate use next data:
* Login: ben
* Password: benspassword
```
* task2: http://localhost:8087/api/cinema/session?start=_`%yyyy-mm-dd%`_&end=_`%yyyy-mm-dd%`_&count=_`%count%`_
* task2 example: http://localhost:8087/api/cinema/session?start=2012-06-06&end=2022-06-06&count=2



* task3: http://localhost:8087/api/movie/search?name=_`%searchName_or_pattern%`_
* task3 example: http://localhost:8087/api/movie/search?name=Watch



* task4: http://localhost:8087/api/cinema/_`%cinema name%`_/brakes?start=_`%yyyy-mm-dd%`_&end=_`%yyyy-mm-dd%`
* task4 example: http://localhost:8087/api/cinema/Ultramarine/brakes?start=2012-06-06&end=2020-02-02



* task5: http://localhost:8087/api/movie/_`%film name%`_/calculate?start=_`%yyyy-mm-dd%`_&end=_`%yyyy-mm-dd%`
* task5 example: http://localhost:8087/api/movie/Watchers/calculate?start=2012-06-06&end=2020-02-02
