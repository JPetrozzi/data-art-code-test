package org.dataart.codetest.two;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamApiCodeChallenge {

    static final int AGE_TO_FILTER = 21;

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(1, "test1", 22, Arrays.asList("music", "dance", "tennis")),
                new Person(2, "test2", 18, Collections.singletonList("volleyball")),
                new Person(3, "test3", 25, Arrays.asList("volleyball", "football")),
                new Person(4, "test4", 14, Arrays.asList("football", "music"))
        );

        System.out.println(String.format("Interests of people older than 21 years: %s",
                people.stream()
                        .filter(person -> person.getAge() >= AGE_TO_FILTER)
                        .flatMap(person -> person.getInterests().stream())
                        .distinct()
                        .sorted()
                        .collect(Collectors.joining(", "))));
    }

}

class Person {
    private final int id;
    private final String name;
    private final int age;
    private final List<String> interests;

    public Person(int id, String name, int age, List<String> interests) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.interests = Collections.unmodifiableList(interests);
    }

    public int getAge() {
        return age;
    }

    public List<String> getInterests() {
        return interests;
    }
}
