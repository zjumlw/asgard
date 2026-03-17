# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Asgard is a multi-module Maven project for learning and practicing various Java technologies. The project uses a Nordic mythology naming convention where each module represents a different learning domain:

- **asgard-common**: Common utilities, tools, and shared components used across all modules
- **asgard-loki**: Experimental testing and validation - miscellaneous code for verification
- **asgard-thor**: Spring Framework learning module - contains Spring-related examples and demos
- **asgard-frigg**: MyBatis learning module - database persistence examples
- **asgard-pattern**: Design pattern learning module - implementations of various design patterns
- **asgard-underlying**: Low-level Java learning - JVM internals, JUC, etc.
- **asgard-algo**: Algorithm practice - LeetCode problems and common algorithms

## Build and Test Commands

### Build the entire project
```bash
mvn clean install
```

### Build a specific module
```bash
mvn clean install -pl asgard-common
mvn clean install -pl asgard-thor
```

### Run all tests
```bash
mvn test
```

### Run tests for a specific module
```bash
mvn test -pl asgard-algo
```

### Run a single test class
```bash
mvn test -Dtest=Problem1Test -pl asgard-algo
```

### Skip tests during build
```bash
mvn clean install -DskipTests
```

## Architecture

### Multi-Module Maven Structure
The parent POM (`/pom.xml`) manages:
- Shared dependency versions (Spring, MyBatis, Log4j2, Guava, etc.)
- Java version (1.8)
- Maven compiler plugin configuration

Each web module (`asgard-loki-web`, `asgard-thor-web`) packages as WAR with traditional Java web configuration using `web.xml`.

### Module Dependencies
- Most modules depend on `asgard-common` for shared utilities
- `asgard-loki` and `asgard-frigg` depend on MyBatis for database access
- `asgard-thor` uses Spring Framework with AOP support

### Common Utilities (asgard-common)
Key shared classes:
- `HttpUtil`: HTTP client utilities
- `GsonUtil`: JSON serialization/deserialization
- `GuavaBloomFilter`, `BloomFilter`: Bloom filter implementations
- Various utility classes for dates, images, videos, random generation, etc.

### Code Organization Patterns
- Algorithm solutions in `asgard-algo` are named by problem number (e.g., `Problem1.java`, `Problem141.java`)
- Design patterns in `asgard-pattern` are organized by pattern type (singleton, strategy, observer, factory, decorator, etc.)
- Tests mirror the main class names with `Test` suffix

## Technology Stack
- Java 8
- Maven 3.x
- JUnit 4.13.1
- Spring Framework 5.3.30
- Spring Security 5.4.6
- MyBatis 3.5.6
- Log4j2 2.23.1
- Guava 33.4.8-jre
- MySQL Connector 8.0.18
