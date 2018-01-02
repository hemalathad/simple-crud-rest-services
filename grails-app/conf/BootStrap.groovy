import com.simple.Subscriber
import com.simple.Employee

class BootStrap {

    def init = { servletContext ->
        new Subscriber(name:"x",lastName:"a",status:"true").save()
        new Subscriber(name:"xx",lastName:"aa",status:"true").save()
        new Subscriber(name:"xxxx",lastName:"aaaa",status:"true").save()

        new Employee(name:"emp01",email:"a@b.com").save()
        new Employee(name:"emp02",email:"b@d.com").save()
        new Employee(name:"emp03",email:"c@b.com").save()

    }
    def destroy = {
    }
}
