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

    @ManyToOne
    @JoinColumn(name = "MobileTypeId")
    private ContactMobileType mobileType;

    public ContactMobile() {
    }

    public ContactMobile(String phoneNumber, Contact contact, ContactMobileType mobileType) {
        this.phoneNumber = phoneNumber;
        this.contact = contact;
        this.mobileType = mobileType;
    }

    public long getId() {
        return id;
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

    public ContactMobileType getMobileType() {
        return mobileType;
    }

    public void setMobileType(ContactMobileType mobileType) {
        this.mobileType = mobileType;
    }
}
