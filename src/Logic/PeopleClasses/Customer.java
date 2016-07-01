package Logic.PeopleClasses;

import Logic.CompuerClasses.Computer;

/**
 * Created by student on 01-Jul-16.
 */
public class Customer extends Person{
    Computer ideal;
    Computer matchedComputer;
    Boolean satisfied = false;

    public Computer getIdeal() {
        return ideal;
    }
    public void setIdeal(Computer ideal) {
        this.ideal = ideal;
    }
    public Computer getComputer() {
        return matchedComputer;
    }
    public void setComputer(Computer computer) {
        this.matchedComputer = computer;
    }
    public Boolean getSatisfied() {
        return satisfied;
    }
    public void setSatisfied(Boolean satisfied) {
        this.satisfied = satisfied;
    }

    public Customer(String firstName, String lastname) {
        super(firstName,lastname);
    }
}

