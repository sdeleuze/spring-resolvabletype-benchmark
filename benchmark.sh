#!/bin/sh

mvn clean package -Dspring.version=3.1.4.RELEASE && java -jar target/microbenchmarks.jar -wi 5 -i 5 -f 1
mvn clean package -Dspring.version=3.2.0.RELEASE && java -jar target/microbenchmarks.jar -wi 5 -i 5 -f 1
mvn clean package -Dspring.version=4.0.5.RELEASE && java -jar target/microbenchmarks.jar -wi 5 -i 5 -f 1
