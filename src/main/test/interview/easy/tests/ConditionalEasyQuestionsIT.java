package interview.easy.tests;


import interview.easy.itconfigs.ConditionalOnBeanTestConfig;
import interview.easy.testclasses.BadHashDistribution;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


@ContextConfiguration(classes = ConditionalOnBeanTestConfig.class)
@SpringBootTest(properties = {"my.custom.value=true"})
public class ConditionalEasyQuestionsIT {
    @Autowired
    private BadHashDistribution bean;

    @Value("${my.custom.value}")
    private String value;

    @Test
    public void conditionalOn_Demo(){
        System.out.println(value);
        Assertions.assertEquals("Condition 1", bean.getName());
    }
}
