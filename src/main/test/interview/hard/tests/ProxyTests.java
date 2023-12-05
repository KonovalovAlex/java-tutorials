package interview.hard.tests;

import interview.hard.classes.BeanA;
import interview.hard.classes.BeanB;
import interview.hard.classes.ComplexTransactionalService;
import interview.hard.itconfigs.ProxyTestConfig;
import interview.medium.itconfigs.TransactionalTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {
        TransactionalTestConfig.class,
        ProxyTestConfig.class})
@SpringBootTest
public class ProxyTests {
    @Autowired
    private BeanA beanA;
    @Autowired
    private BeanB beanB;
    @Autowired
    private ComplexTransactionalService complexTransactionalService;

    /**
     * https://www.baeldung.com/circular-dependencies-in-spring
     * https://www.geeksforgeeks.org/circular-dependencies-in-spring/
     */
    @Test
    public void circularDependencyTest() {
        assert beanA != null;
        assert beanB != null;
    }

    /**
     * https://akshayhavale.medium.com/use-of-async-asynchronous-method-transactional-transaction-processing-499f6d7889a8
     * https://stackoverflow.com/questions/71322509/async-and-transactional
     */
    @Test
    public void wrappersCombinationTests() throws InterruptedException {
        complexTransactionalService.executeInTransactionMakeAsyncUnderHood();

        complexTransactionalService.asyncMethod();

        complexTransactionalService.regularTransaction();
    }
}
