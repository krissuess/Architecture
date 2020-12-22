package qa.model;

import java.util.Objects;

public class ContactData {
    private String lastName;
    private final String name;
    private final String address;
    private final String mobile;

    public ContactData(String lastName, String name, String address, String mobile) {
        this.lastName=lastName;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public ContactData(String name, String address, String mobile) {
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(lastName, that.lastName) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, name);
    }
}
