# Alba-man
Web Service for hiring & recruitment 



## Prerequisites

- Ubuntu 20.04.4 LTS
- Gradle 7.4
- JDK 18


### Project Settings

```
git clone ...
```

project directory added ~/AlbaMan

```
cd AlbaMan
~/AlbaMan$

```


### Build
Builds are run in "~/AlbaMan/" directory

make Gradle Wrapper

```
./gradlew

BUILD SUCCESSFUL in 2s

```

Build

```
./gradlew build

BUILD SUCCESSFUL in 3s

```

### tree

```
├─.gradle
│  ├─7.4
│  │  ├─checksums
│  │  ├─dependencies-accessors
│  │  ├─executionHistory
│  │  ├─fileChanges
│  │  ├─fileHashes
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  └─vcs-1
├─.idea
│  └─libraries
├─build
│  ├─classes
│  │  └─java
│  │      └─main
│  │          ├─boundary
│  │          ├─controller
│  │          └─model
│  ├─libs
│  └─tmp
│      ├─compileJava
│      └─jar
├─gradle
│  └─wrapper
└─src
    ├─main
    │  └─java
    │      ├─boundary
    │      ├─controller
    │      └─model
    └─test
```


## How to build testcode in command line

<aside>
💡 gradlew clean test --test <testcode class name>.<testcode method name> -i

</aside>

ex) gradlew clean test --tests AccountTest.IndividualSignupSuccess -i

![성공샷.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/27994d61-41aa-4fda-ad22-261ae025048a/%EC%84%B1%EA%B3%B5%EC%83%B7.png)



## Built With

* [Gradle](https://gradle.org/)
