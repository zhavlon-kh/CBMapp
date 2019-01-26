package kg.apps.CBMapp.model;

import javax.persistence.*;

@Entity
@Table(name = "email")
public class ContactEmail {

    @Id
    @GeneratedValue
    private long id;

    private String email;

    @ManyToOne
    private Contact contact;

    public ContactEmail() {
    }

    public ContactEmail(String email, Contact contact) {
        this.email = email;
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
