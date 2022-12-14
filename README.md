# Alba-man
Web Service for hiring & recruitment 



## Prerequisites

- Ubuntu 20.04.4 LTS
- Gradle 7.4
- JDK 18

or
- window


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
- Builds are run in "~/AlbaMan/" directory

### < In Ubuntu >
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

### < In window >

```
gradlew

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

    
---

    
## How to build testcode in command line

### < In window >

💡Please refer to the attached test code documentation for class name.

```
gradlew clean test --test <testcode class name>.<testcode method name> -i
```

for example

```
ex) gradlew clean test --tests AccountTest.IndividualSignupSuccess -i
```

    
![성공샷](https://user-images.githubusercontent.com/86733856/207552076-3142d7fa-c9ba-45a3-bcda-6791e1e1620b.png)




## Built With

* [Gradle](https://gradle.org/)
