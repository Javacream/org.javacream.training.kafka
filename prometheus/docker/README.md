
# General

A docker-compose file containing inital setup for grafana/prometheus/pushgateway setup.

In the grafana folder there is a Dockerfile which installs several plugins once. 
It will be build when started with docker-compose. To rebuild: `docker-compose build` or `docker-compose up --build`.

Otherwise in the root directory just: `docker-compose up`

