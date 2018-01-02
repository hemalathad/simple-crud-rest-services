class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/subscribers"(resources:"subscriber")
        "/search/subscriber/$query" (controller: "subscriber", action: "searchSubscriber")
        "/"(view:"/index")
        "500"(view:'/error')
	}
}
