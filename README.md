# Assignment 1 - DECIDE

This repository contains the source code, unit tests, build files and documentation for the DECIDE mini project (assignment 1 for DD2480).

## DECIDE

This program is part of a hypothetical anti-ballistic missile system. It determines whether to issue a launch signal based on radar data.

## Building and testing

The project uses Gradle to build and test the program. The unit tests are implemented with JUnit. DECIDE can be built and tested with the following commands:

1. `gradle wrapper`
2. `./gradle build`

## Generating documentation

1. From the base directory, execute `javadoc -d doc -sourcepath app/src/main/java decide`

## Statement of contributions

### Minchong Li

* Wrote the spec and implemented the interface for all CMV methods.
* Implemented CMV method 7, 8, 11 and 12 along with their unit tests.
* Implemented LAUNCH method and its unit tests.

### Ali Shahwali

* Implemented Decide class, CMV 2, 3, 4 along with helper functions and unit tests
* Initialised gradle project

### Elias Thiele

* Implemented CMV method 0 and unit tests.
* Implemented the main DECIDE method.
* Wrote documentation.

### Zihao Xu

* Implemented CMV method 1, 5, 6, 9, 10, 13, 14 and their unit tests, along with helper functions.
* Implemented PUM method and unit tests.
* Implemented FUV method and unit tests.
* Wrote DECIDE positive test.

## Way of working assessment

Based on our assessment, we are in the `Working well` stage of the way of working-checklist. We have a well defined workflow with regards to working on this small software project. The tools and practices are typical of collaborative software development. The main repository is hosted on GitHub and we continually build on the project by creating issues describing atomic additions and modifications, working on branches connected to an issue, and finally by merging the branch into the main trunk. The tools and practices are utilized by each team member and the project been developing smoothly. This workflow was already familiar to the members of the team, and the members have been able to follow it with little issue or conflict. The main obstacle to reach the `Retired` state is completing the project and reflecting on the project in order to draw lessons for future projects.