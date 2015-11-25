#!/bin/sh

docker run --rm -t -i \
    -v "$PWD":/evernote_to_markdown \
    -v "$PWD"/docker/m2repo:/var/m2repo \
    evernote2markdown \
    mvn clean install

