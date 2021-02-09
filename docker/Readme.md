# Installation des 33127 - Apache Kafka

## Prüfen der Server-Dateien

* Wechseln in das Verzeichnis _training
* Prüfen, ob die beiden Dateien docker-compose.yml und .env vorhanden sind
* Prüfen, ob in der Datei .env der Eintrag HOST_NAME=<IP-Adresse des Rechners, NICHT localhost> enthalten ist

## Starten der Server-Umgebung

In einer Eingabeaufforderung im Verzeichnis _training den Befehl docker-compose up -d ausführen. Nach einem Download der Docker-Images fahren die Server hoch

## Prüfen der Server-Umgebung

* http://localhost:9000 öffnet die Web-Oberflächge von Kafdrop. Darin sind drei Broker vorhanden
* http://localhost:8080/hawtio öffnet die Einstiegsseite in HawtIo
* http://localhost:9192/jolokia zeigt als Ergebnis eine Jolokia-Standardausgabe

## Starten der Client-Umgebung

In einer Eingabeaufforderung im Verzeichnis _training den Befehl docker run --rm -it javacream/kafka_env ausführen

## Prüfen der Client-Umgebung

* in der Konsole eingeben ./bin/kafka-broker-api-versions.sh --bootstrap-server <<IP-Adresse des Rechners, NICHT localhost>>:9092
* es erfolgt eine etwas längere Statusausgabe
