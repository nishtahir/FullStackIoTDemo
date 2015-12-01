Holiday Hacking
===============

Dependencies
============
* Java SE8
* Groovy 2.4
* msp430-gcc
* msp430-libc,
* msp430-binutils
* mspdebug
* (Optional) Gradle 2.7

Hardware
========
* A computer
* MSP430 Launchpad

Setup
=====
To install the msp430 dependencies, use the following command in terminal.
```sh
$ sudo apt-get install binutils-msp430 gcc-msp430 msp430-libc mspdebug
```

##Compile and run the Server application

```Groovy
./gradlew Server:run
```

##Compile and run the Client application

```Groovy
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
