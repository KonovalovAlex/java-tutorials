package tutorials.spring.transactionProxy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Controller1 {
    private final Service1 service1;

    public Controller1(Service1 service1) {
        this.service1 = service1;
    }

    @GetMapping("/asd/{s}")
    public void show(@PathVariable String s){
        service1.method1(s);
    }
}
