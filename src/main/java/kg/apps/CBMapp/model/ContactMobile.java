package kg.apps.CBMapp.model;


import javax.persistence.*;

@Entity
@Table(name = "mobile")
public class ContactMobile {

    @Id
    @GeneratedValue
    private long id;

    private String phoneNumber;

    //Foreign Keys
    @ManyToOne
    @JoinColumn(name = "ContactId")
    private Contact contact;

    public ContactMobile() {
    }

    public ContactMobile(String phoneNumber, Contact contact) {
        this.phoneNumber = phoneNumber;
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
