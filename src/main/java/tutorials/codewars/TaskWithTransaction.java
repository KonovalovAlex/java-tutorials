package tutorials.codewars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public class TaskWithTransaction {
    //транзакция откатится так как транзакция в Б классе  по умолчанию - requared(в рамках текущей транзакции)

    @Service
    class A {
        @Autowired
        private B b;

        // исходный вызов приходит сюда
        @Transactional
        public void doA() {
            // some work with BD A

            try {
                b.doB();
            } catch (Exception ex) {
                // just log
            }
        }
    }

    @Service
    class B {

        @Transactional
        public void doB() {
            // some work with DB B

            if (true) { // some operation with exception
                throw new IllegalStateException();
            }
        }
    }
}
