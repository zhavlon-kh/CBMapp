package kg.apps.CBMapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ContactBook {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private User user;

    public ContactBook(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }
}
