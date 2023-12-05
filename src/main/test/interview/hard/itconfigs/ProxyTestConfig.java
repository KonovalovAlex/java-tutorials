package interview.hard.itconfigs;


import interview.medium.services.TestTransactionalService;
import interview.hard.classes.BeanA;
import interview.hard.classes.BeanB;
import interview.hard.classes.ComplexTransactionalService;
import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
public class ProxyTestConfig {
    @Bean
    public BeanA beanA(@Lazy BeanB beanB) {
        return new BeanA(beanB);
    }

    @Bean
    public BeanB beanB(@Lazy BeanA beanA) {
        return new BeanB(beanA);
    }

    @Bean
    public ComplexTransactionalService complexTransactionalService(TestTransactionalService transactionalService) {
        return new ComplexTransactionalService(transactionalService);
    }

    @Bean
    public TaskExecutor taskExecutor() {
        return new TaskExecutorBuilder().build();
    }
}
