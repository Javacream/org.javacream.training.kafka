FROM grafana/grafana:latest
USER root

RUN mkdir -p /app/grafana/plugins && chown -R 472:0 /app/grafana/plugins

RUN  grafana-cli --pluginsDir "/app/grafana/plugins" plugins install ae3e-plotly-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install agenty-flowcharting-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install briangann-datatable-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install briangann-gauge-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install camptocamp-prometheus-alertmanager-datasource\
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install flant-statusmap-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install grafana-clock-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install grafana-opensearch-datasource\
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install grafana-piechart-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install grafana-polystat-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install magnesium-wordcloud-panel\
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install marcusolsson-static-datasource\
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install marcusolsson-json-datasource \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install marcusolsson-csv-datasource \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install marcusolsson-dynamictext-panel\
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install marcusolsson-hourly-heatmap-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install marcusolsson-hexmap-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install marcusolsson-treemap-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install michaeldmoore-multistat-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install mtanda-histogram-panel \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install pue-solr-datasource \
 && grafana-cli --pluginsDir "/app/grafana/plugins" plugins install vonage-status-panel

USER grafana
