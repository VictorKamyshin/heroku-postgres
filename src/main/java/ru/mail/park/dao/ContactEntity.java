package ru.mail.park.dao;

import javax.persistence.*;

/**
 * Created by Nick on 05.09.2015.
 */

@Entity
@Table(name = "contact")
public class ContactEntity {
    private int id;
    private String name;
    private String greetings;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 60)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "greetings", nullable = true, insertable = true, updatable = true, length = 60)
    public String getGreetings() {
        return greetings;
    }

    public void setGreetings(String greetings) {
        this.greetings = greetings;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntity that = (ContactEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (greetings != null ? !greetings.equals(that.greetings) : that.greetings != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (greetings != null ? greetings.hashCode() : 0);
        return result;
    }
}
