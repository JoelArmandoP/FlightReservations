# FlightReservations

Coursework for Birkbeck University MSc Learning Technologies, Component-Based Software Development, 2016.

There seems to be [some kind of trouble](http://stackoverflow.com/questions/15122890/java-lang-verifyerror-expecting-a-stackmap-frame-at-branch-target-jdk-1-7) with deploying the project to embedded Glassfish (compiler version mismatch with the libraries we depend on?). To get the project to deploy, you need to execute:

    MAVEN_OPTS=-noverify mvn install
