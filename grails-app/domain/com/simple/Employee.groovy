package com.simple

import grails.rest.*



//import grails.rest.*
@Resource(uri='/employees', formats=['json', 'xml'])
//@RestApiObject(name = "author", description = "An author write books")
class Employee {

    String name
    String email

    static constraints = {
    }
}
