package tutorials.spring.prototypeScope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.ServiceLoader;

@Service
public class MessageService {
    public static void main(String[] args) {
        Integer a = 5;
        Integer b = a;
        b=6;
        System.out.println(a);
    }
    

    private final ObjectFactory<MessageBuilder> messageBuilder;

    MessageService(ObjectFactory<MessageBuilder> messageBuilder) {
        this.messageBuilder = messageBuilder;
    }

    Message createMessage(String content, String receiver) {
        return messageBuilder.getObject()
                .withContent(content)
                .withReceiver(receiver)
                .build();
    }


}
@Component
@Scope("prototype")
class PrototypeBean {
    // ... prototype-scoped state
}
class AppConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  //  @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
    //если добавить в аннотацию proxyMode = ScopedProxyMode.TARGET_CLASS каждый раз при обращении будет выдаваться новый бин
    //даже если мы обращаемся внутри одного метода
    public PrototypeBean prototypeBean() {
        return new PrototypeBean();
    }
}
@Component
class SingletonLookupBean {

    @Lookup
    public PrototypeBean getPrototypeBean() {
        return null;
    }
//    По сути, Spring переопределит наш аннотированный метод и будет использовать возвращаемый тип и параметры
//    нашего метода в качестве аргументов для BeanFactory#getBean
}