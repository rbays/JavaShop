package Logic.PeopleClasses;

/**
 * Created by student on 01-Jul-16.
 */
public abstract class Person {
    String firstName;
    String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
