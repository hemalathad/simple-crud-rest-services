package com.simple
import com.simple.Subscriber
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.test.spock.IntegrationSpec
import spock.lang.Shared



class SubscriberControllerFunctionalSpec extends IntegrationSpec {

    @Shared
    def grailsApplication

    def setup() {
        // Initialize DB
        new Subscriber(name: "name1",lastName:"lastName1",status:"true").save()
    }

    def cleanup() {
    }

    void "test creating a subscriber"() {
        given:
        RestBuilder rest = new RestBuilder()

        when:
        RestResponse response = rest.post("http://localhost:8080/${grailsApplication.metadata.'app.name'}/subscribers") {
            json([
                    name: "name1",
                    lastName:"lastName1",
                    status:"true"
            ])
        }

        then:
        response.status == 200
        response.json.name == "name1"
        response.json.lastName == "lastName1"
        response.json.status == "true"
        Subscriber.count == 2
    }
}
