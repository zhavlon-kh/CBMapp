package kg.apps.CBMapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mobile_type")
public class ContactMobileType {
    @Id
    @GeneratedValue
    private long id;

    private String mobileType;

    public ContactMobileType() {
    }

    public ContactMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    public long getId() {
        return id;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }
}
