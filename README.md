Holiday Hacking
===============

This project contains the client and Hardware components. See 

A small project hacked together to show Client, Server and Embedded device interaction. Build scripts are currently designed to work with Unix systems (Tested on Ubuntu 15). Your mileage may vary on other systems.

Dependencies
============
* JavaSE 8 JDK
```sh
sudo apt-get install openjdk-8-jdk
```
* Groovy 2.4
```sh
sudo apt-get install groovy
```
* Expect
```sh
sudo apt-get install expect
```
* MSP430 tools
```sh
$ sudo apt-get install binutils-msp430 gcc-msp430 msp430-libc mspdebug
```

* (Optional) Gradle 2.7

Hardware
========
* A computer
* MSP430 Launchpad

Setup
=====


Usage
=====

Program your device using. By default, `main.c` is compiled and programmed on to the MSP430
```sh
./gradlew program
```

Launch the client using the command
```sh
./gradlew Client:run
```

LICENSE
=======

Copyright 2015 Nish Tahir

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
