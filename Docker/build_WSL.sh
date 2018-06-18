#!/bin/bash

./cmd.exe /c docker build . -f Dockerfile2 -t ptut:1.0
./cmd.exe /c docker rm lala

./cmd.exe /c docker run -p 8080:8080 --name lala ptut:1.0
