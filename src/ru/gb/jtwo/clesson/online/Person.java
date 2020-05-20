package ru.gb.jtwo.clesson.online;

import java.util.Objects;

public class Person {
    int phone;
    String email;

    Person(int p, String e) {
        phone = p;
        email = e;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getPhone() == person.getPhone() &&
                Objects.equals(getEmail(), person.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPhone(), getEmail());
    }
}
