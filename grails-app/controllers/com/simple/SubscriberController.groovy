package com.simple

import grails.rest.RestfulController
import org.restapidoc.annotation.*
import org.restapidoc.pojo.RestApiParamType
import grails.converters.JSON
import org.restapidoc.pojo.RestApiVerb

//@GrailsCompileStatic
@RestApi(name = "subscriber services", description = "Methods for managing subscribers")
class SubscriberController extends RestfulController {
    static responseFormats = ['json', 'xml']
    SubscriberService subscriberService
    //  static scaffold = true
    //static scaffold = true
    /*def index() {
        Subscriber subscriber = new Subscriber(name:"xxx",lastName:"aaa",status:"false")
        [subscriber:subscriber]
    }*/

    SubscriberController() {
        super(Subscriber)
    }

    @Override
    def save() {
        def jsonParams = request.JSON
        render new Subscriber(name: jsonParams.name, lastName: jsonParams.lastName, status: jsonParams.status).save() as JSON
    }

    @RestApiMethod(description = "Gets required subscriber details")
    @RestApiParams(params = [
            @RestApiParam(
                    name = "name",
                    type = "String",
                    paramType = RestApiParamType.PATH,
                    description = "Provides subscriber name")
    ])
    Object show(Long id) {
        respond Subscriber.get(id), formats: ['json', 'json', 'html']
    }
    @RestApiMethod(description = "Gets required subscriber details")
    @RestApiParams(params = [
            @RestApiParam(
                    name = "name",
                    type = "String",
                    paramType = RestApiParamType.PATH,
                    description = "Provides subscriber name")
    ])
    Object showByName(String fName) {
        respond subscriberService.showByName(fName), formats: ['json', 'json', 'html']
    }

    @RestApiMethod(description = "updates required subscriber details")
    @RestApiParams(params = [
            @RestApiParam(
                    name = "name",
                    type = "String",
                    paramType = RestApiParamType.PATH,
                    description = "Updates subscriber name and lastname")
    ])
    def update(Subscriber updatedSubscriber) {
        println("Inupdate")
        Subscriber.withTransaction {
            updatedSubscriber.save()
            respond updatedSubscriber
        }
    }

    @RestApiMethod(verb = RestApiVerb.GET, description = "returns required subscriber details based on search string")
    @RestApiParams(params = [
            @RestApiParam(
                    name = "name",
                    type = "String",
                    paramType = RestApiParamType.PATH,

                    description = "provides subscriber details based on search crieteria")
    ])
    def searchSubscriber() {
        respond subscriberService.searchSubscriber(params), formats: ['json', 'json', 'html']

    }




}