package org.DreamTeam;

import java.util.Comparator;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return ("FirstName : "+this.getFirstName()+
                "\tLastName : "+ this.getLastName() +
                "\tPhone : "+ this.getPhoneNumber());
    }

    public static Comparator<Contact> contactFirstName = new Comparator<Contact>() {

        public int compare(Contact s1, Contact s2) {
            String ContactFirstName1 = s1.getFirstName().toUpperCase();
            String ContactFirstName2 = s2.getFirstName().toUpperCase();

            return ContactFirstName1.compareTo(ContactFirstName2);
        }
    };

    public static Comparator<Contact> contactLastName = new Comparator<Contact>() {

        public int compare(Contact s1, Contact s2) {
            String ContactLastName1 = s1.getLastName().toUpperCase();
            String ContactLastName2 = s2.getLastName().toUpperCase();

            return ContactLastName1.compareTo(ContactLastName2);
        }
    };

    public static Comparator<Contact> contactPhoneNumber = new Comparator<Contact>() {

        public int compare(Contact s1, Contact s2) {
            String ContactPhoneNumber1 = s1.getFirstName().toUpperCase();
            String ContactPhoneNumber2 = s2.getFirstName().toUpperCase();

            return ContactPhoneNumber1.compareTo(ContactPhoneNumber2);
        }
    };

}
