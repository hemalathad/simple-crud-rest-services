package com.simple

import grails.transaction.Transactional

@Transactional
class SubscriberServiceMainService implements SubscriberService{

    def searchSubscriber(params) {
        // return Subscriber.find(where name  %$name% )
        // params.max = Math.min(params.max ? params.int('max') : 5, 100)

        def subscriberList = Subscriber.createCriteria().list(params) {
            if (params.query) {
                ilike("name", "%${params.query}%")
            }
        }
        return subscriberList

    }
    def Object showByName(String fName) {
        return  Subscriber.get(firstName)
    }
}
