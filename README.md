# springboot-testexecutionlistener-order
Project for demonstrating a bug considering the orders of custom TestExectionListeners

Prerequisites
===

- install FireFox > version 48 (Selenium driver is installed automatically by Gradle plugin!)
- install Java 8

Getting started
===

```sh
./gradlew clean test --info
```
Pay attention to the log statements after the Spring Boot Banner! 
There you will find log statements reflecting the order execution of the test execution listeners.

DO NOT pay attention to the failed "test". I just want to demonstrate the problem when taking Screenshots in case of test failures! 
