package qa.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private String lastName;
    private String name;
    private String address;
    private String mobile;
    private String homePhone;
    private String workPhone;
    private String allPhones;


    public ContactData(String lastName, String name, String address, String mobile) {
        this.lastName=lastName;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData(int id , String lastName, String name, String address, String mobile) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
    }

    public ContactData() {
    }

    public int getId() {
        return id;
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

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withHomePhone(String phone) {
        this.homePhone=phone;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
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
