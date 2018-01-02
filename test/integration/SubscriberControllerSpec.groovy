import com.simple.Subscriber
import com.simple.SubscriberController
import grails.test.spock.IntegrationSpec

import spock.lang.Shared

class SubscriberControllerSpec extends IntegrationSpec {

    @Shared SubscriberController controller = new SubscriberController()

    def setup() {
        // Initialize DB
        new Subscriber(name: "title1",lastName:"lastname1",status:"true").save()
    }

    def cleanup() {
    }

    void "test creating a subscriber"() {
        when:
        // Set request JSON body
        controller.request.json = [
                name: "name2",
                lastName:"lastName2",
                status:"true"
        ]
        controller.save()
        def response = controller.response.json

        then:
        response.name == "name2"
        Subscriber.count == 2
    }
}
