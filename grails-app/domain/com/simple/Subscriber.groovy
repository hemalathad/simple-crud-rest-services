package com.simple

import grails.rest.Resource
import org.restapidoc.annotation.*

class Subscriber {

    //Integer id
    @RestApiObjectField(description = "The firstname of the subscriber")
    String name
    @RestApiObjectField(description = "The lasttname of the subscriber")
    String lastName
    @RestApiObjectField(description = "The status of the subscriber")
    String status

    static constraints = {
        name blank:false
        lastName blank:false
        status blank:false
    }
}