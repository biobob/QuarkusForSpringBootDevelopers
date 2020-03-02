#!/bin/bash
set -e

WD="${PWD}/docker/data"
SQL_PROD="${PWD}/docker/data/import.prod.sql"
SQL_DEV="${PWD}/docker/data/import.sql"

if test -f "$SQL_PROD" -a -f "$SQL_DEV"; then
  echo "SQL Files exist... skiping file creation."
else
  echo "SQL Files doesnt exist... creating."
  rm -f $SQL_PROD 2>/dev/null && rm -f $SQL_DEV 2>/dev/null
  docker run -it --rm -v "$WD":/usr/src/myapp -w /usr/src/myapp python:3.8-slim python generate_ddl.py
fi

