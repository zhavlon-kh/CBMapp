package kg.apps.CBMapp.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Contact {

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    private String nickname;
    private String company;
    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "ContactBookId")
    private User user;

    @OneToMany(mappedBy = "contact", fetch = FetchType.EAGER)
    private Set<ContactMobile> mobiles;

    @OneToMany(mappedBy = "contact", fetch = FetchType.EAGER)
    private Set<ContactEmail> emails;

    public Contact() {
    }

    public Contact(String name, String surname, String nickname, String company, Date birthdate, User user, Set<ContactMobile> mobiles, Set<ContactEmail> emails) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.company = company;
        this.birthday = birthdate;
        this.user = user;
        this.mobiles = mobiles;
        this.emails = emails;
    }

    public Contact(Contact contact) {
        this.name = contact.getName();
        this.surname = contact.getSurname();
        this.nickname = contact.getNickname();
        this.company = contact.getCompany();
        this.birthday = contact.getBirthday();
        this.user = contact.getUser();
        this.mobiles = contact.getMobiles();
        this.emails = contact.getEmails();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ContactMobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(Set<ContactMobile> mobiles) {
        this.mobiles = mobiles;
    }

    public Set<ContactEmail> getEmails() {
        return emails;
    }

    public void setEmails(Set<ContactEmail> emails) {
        this.emails = emails;
    }
}
