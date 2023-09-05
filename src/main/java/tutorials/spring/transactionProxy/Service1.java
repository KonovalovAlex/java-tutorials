package tutorials.spring.transactionProxy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Service1 {

    @Transactional
    public void method1(String s){
        method2(s);
    }
    public void method2(String s){
        System.out.println(s);
    }
}
