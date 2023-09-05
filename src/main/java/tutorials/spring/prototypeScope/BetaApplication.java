package tutorials.spring.prototypeScope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
public class BetaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetaApplication.class, args);

        //go to test
    }
}

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class MessageBuilder {

    private static final AtomicInteger instanceCounter = new AtomicInteger(0);

    MessageBuilder() {
        instanceCounter.incrementAndGet();
    }

    static int getInstanceCounter() {
        return instanceCounter.get();
    }
    private String content;
    private String receiver;

    MessageBuilder withContent(String content) {
        this.content = content;
        return this;
    }

    MessageBuilder withReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    Message build() {
        return new Message(content, receiver);
    }
}

class Message{
    Message(String s , String s1) {
    }
}