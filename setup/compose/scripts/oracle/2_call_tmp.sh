#!/bin/bash

sqlplus -s oraUser/oraUser123@//localhost/oraDB @/tmp/3_create_tables.sql
sqlplus -s oraUser/oraUser123@//localhost/oraDB @/tmp/4_insert_data.sql