#!/bin/bash
HOST="10.99.88.21"
PORT="15433"
DB="test"
#

if [ "$1" == "" ]; then
	echo "Specificare il database!"
	exit 1;
fi

if [ "$2" == "" ]; then
	echo "Specificare il file sql!"
	exit 1;
fi

DB="$1"
FILE="$2"

# psql -a postgresql://$HOST:$PORT/$DB -U infocube1 -e -f ${FILE}
# -a in caso di data-only, ma incompatibile con -c 
# -c in caso di clean degli oggetti
PGOPTIONS='--client-min-messages=error' pg_restore -a -d postgresql://$HOST:$PORT/${DB} -v -U infocube1  ${FILE} \
# 2>&1 ${FILE}.log
