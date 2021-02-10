#!/bin/bash
docker build . -t files-upload-test
mkdir -p build
docker run --rm --entrypoint cat files-upload-test  /home/application/files-upload-test.zip > build/files-upload-test.zip
