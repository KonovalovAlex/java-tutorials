package tutorials.java8;

import java.util.Optional;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Person person2 = (s) -> {
            System.out.println(s);
            return s;
        };
        person2.giveMeStr("asd");
    }
    Person person = new Person() {
        @Override
        public String giveMeStr(String s) {
            System.out.println(s);
            return s;
        }
    };
}


interface Person {
    String giveMeStr(String s);
}

class OptionalMapFlapMapExample {

    public static void main(String[] args) {

        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional:: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOtionalGender = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + nonEmptyOtionalGender);
        System.out.println("Optional.map     :: " + nonEmptyOtionalGender.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + nonEmptyOtionalGender.flatMap(new Function<Optional<String>, Optional<String>>() {
            @Override
            public Optional<String> apply(Optional<String> gender) {
                return gender.map(String::toUpperCase);
            }
        }));
    }

}
