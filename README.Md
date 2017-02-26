# Lotus

## Pre-requisites
Install Java-8 and Latest Maven or Maven Version -1

## Initial Setup

```properties
git clone git@github.com:mahendran-pandurangan/Lotus.git
cd Lotus
```


## Usage

Tests can be executed by specifying using below mvn commands

```bash
KeywordMortCalcTest.java -- > mvn clean test -P regression -DbrowserType=chrome
LinearMortCalcTest.java ----> Right click run as TestNG test
SpringMortCalcTest.java ----> mvn clean install -P regression -DrunOnEnv=firefox
```

## To generate code coverage report

```bash
mvn clean package
```
