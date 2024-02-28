package java_17.list_concepts;

import java.util.Arrays;
import java.util.ArrayList;

public class ExerciseFortyFour {
    
    public static void main(String[] args) {
        MobilePhone mp = new MobilePhone("12345");
        mp.addNewContact(new Contact("Paul", "54321"));
        System.out.println(mp.addNewContact(new Contact("Paul", "54321")));
        System.out.println(mp.queryContact("Paul"));
        mp.printContacts();
    }
}

class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;
    
    public MobilePhone(String myNumber) { 
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }
    
    public boolean addNewContact(Contact contact) {
        boolean flag = false;
        if (this.findContact(contact) == -1) {
            this.myContacts.add(contact);
            flag = true;
        }
        return flag;
    }
    
    public boolean updateContact(Contact contactOld, Contact contactNew) {
        int index = this.findContact(contactOld);
        if (index > -1) {
            this.myContacts.set(index, Contact.createContact(contactNew.getName(), contactNew.getPhoneNumber()));
            return true;
        }
        return false;
    }
    
    public boolean removeContact(Contact contact) {
        int index = this.findContact(contact);
        if (this.findContact(contact) > -1) {
            myContacts.remove(index);
            return true;
        }
        return false;
    }
    
    private int findContact(Contact contact) {
        return this.findContact(contact.getName());
    }
    
    private int findContact(String contactInfo) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            if (this.myContacts.get(i).getName() == contactInfo) {
                return i;
            }
        }
        return -1;
    }
    
    public Contact queryContact(String name) {
        Contact contact = null;
        for (var element : this.myContacts) {
            if (name == element.getName()) {
                contact = element;
                break;
            }
        }
        return contact;
    }
    
    public void printContacts() {
        System.out.println("Contact List:");
        int contactCount = 1;
        for (var contact : this.myContacts) {
            System.out.println(contactCount + ". " + contact.getName() + " -> " + contact.getPhoneNumber());
            contactCount++;
        }
    }
}

class Contact {
    private String name;
    private String phoneNumber;
    
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName() {
        return this.name;
    } 
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }
}
