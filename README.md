# simple-curd-rest-services
It has REST SPI for basic curd operations and a userdefined search end point
Few details of this app is mentioned below:
1. REST API basic operations create,update,read and delete are placed in
two methods. One is using @Resource annotation on top of domain class
and second one is by extending Rest Controller.
It has one custom rest end point which gives search string based result.

2. Rest api related document can be viewed as rest-api-doc file  in project root.

Pre requisites:
1. SQL server running on default port 1433
2. Data bases to be mentioned in datasources.groovy

