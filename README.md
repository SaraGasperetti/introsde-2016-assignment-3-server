# introsde-2016-assignment-3-server
**Third assignment | University of Trento**

Documentation about assignment 03: SOAP Web Services

## Server structure
The client is divided into 4 packages:

* ```introsde.assignment.dao```: it contains ```LifeCoachDao.java``` that manages the connection to the database;
* ```introsde.assignment.endpoint```: it contains ```PeoplePublisher.java``` that exposes the server functionalities;
* ```introsde.assignment.model```: it contains ```Person.java``` and ```Measure.java``` that represent the corresponding tables in the database. They also contain methods to query the database;
* ```introsde.assignment.soap```: it contains the interface ```People.java``` and its implementation ```PeopleImpl.java``` that respectively declare and implements all the server functionalities.

## Configuration files

The configuration files are:

* ```build.xml```: it contains all the targets to run the code;
* ```ivy.xml```: it contains all the dependencies needed to run the project and it downloads them.

## Setup

The server is deployed on Heroku and it is possible to clone it with:
* ```https://github.com/SaraGasperetti/introsde-2016-assignment-3-server.git```

