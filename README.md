# Micro services Architecture Patterns Training

## To start Zipkin
```
cd <project folder path>
java -jar zipkin.jar
```
Open the browser http://localhost:9411/zipkin/

## To start the ELK, File beat stack.
NOTE:- Change the log file location in each module application.yml files, Keep location same for all. Also change the same path in docker-compose.yml at line 22. 
```
cd <project folder path>/infrastructure/
docker-compose up
```
Open the browser localhost:5601 and follow link https://logz.io/learn/complete-guide-elk-stack/ for setting up the Kibana dashboard.

## To start the Prometheus
```
cd <project folder path>/infrastructure/
docker-compose -f docker-compose-prometheus.yml up
```
Open the browser localhost:3000 and follow link https://prometheus.io/docs/visualization/grafana/ for setting up the dashboard.