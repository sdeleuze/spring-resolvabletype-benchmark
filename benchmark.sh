#!/bin/sh

mvn clean package -Dspring.version=3.1.4.RELEASE -Dspring.flex.version=1.5.2.RELEASE && java -jar target/microbenchmarks.jar -wi 5 -i 5 -f 1
mvn clean package -Dspring.version=4.1.0.RC2 -Dspring.flex.version=1.6.0.BUILD-SNAPSHOT && java -jar target/microbenchmarks.jar -wi 5 -i 5 -f 1
mvn clean package -Dspring.version=4.1.0.BUILD-SNAPSHOT -Dspring.flex.version=1.6.0.BUILD-SNAPSHOT && java -jar target/microbenchmarks.jar -wi 5 -i 5 -f 1
