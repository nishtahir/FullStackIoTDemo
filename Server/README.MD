#HolidayHacking (Server)

[![Build Status](https://travis-ci.org/nishtahir/HolidayHacking-Server.svg?branch=master)](https://travis-ci.org/nishtahir/HolidayHacking-Server)

Small project to allow random people on the internet control things in my home.

#Setup

All dependencies for the frontend can be resolved using `bower`. A project local installation
of `npm` and `bower` can be downloaded using the gradle build script

```sh
./gradlew bowerInstall
```

Dependencies can then be copied into the project using

```sh
./gradlew bowerSync
```


#Package

```sh
./gradlew bowerSync shadowJar
```

#Deploy

The Embedded Jetty Server typically runs on port 4567 however the `-p` switch is used to specify
a port for the application.

```sh
java -jar ./build/libs/HolidayHacking-Server-all.jar -p [port number]
```

#License
Copyright 2014 Nish Tahir

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
