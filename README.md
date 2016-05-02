Full stack IoT demo
===================

A small project aimed at demonstrating together to show Client, Server and Embedded device interaction. While some scripts were put together with a Unix environment in mind (Tested on Ubuntu 15). The vast majority of the code should be platform independent.

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

Server
======

## Setup

All dependencies for the front end can be resolved using `bower`. A local installation
of `npm` and `bower` can be downloaded using the relevant task in the build script

```sh
./gradlew bowerInstall
```

While building, dependencies can be copied into the project using

```sh
./gradlew bowerSync
```


## Package

To package the application for deployment, it's important to package the application along with it's dependencies. This includes the resources needed in order to serve the front end as as other dependencies that may be required.

```sh
./gradlew bowerSync shadowJar
```

## Deploy

The Embedded Jetty Server typically runs on port 4567 however the `-p` switch is used to specify
a port for the application.

```sh
java -jar ./build/libs/HolidayHacking-Server-all.jar -p [port number]
```

Hardware
========
* At least 1 computer
* MSP430 Launchpad

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
