#!/bin/bash

# Indexing
curl -XPUT -H 'Content-Type: application/json' -d -u elastic:elastic_admin http://localhost:9200/shakespeare/ -d@/home/spark/workspace/courses/elastic/setup/compose/scripts/elastic/data/mappings/movies-mapping.json
curl -XPUT -H 'Content-Type: application/json' -u elastic:elastic_admin http://localhost:9200/movies/ -d@/home/spark/workspace/courses/elastic/setup/compose/scripts/elastic/data/mappings/shakes-mapping.json


