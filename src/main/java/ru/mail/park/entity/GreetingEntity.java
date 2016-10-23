package ru.mail.park.entity;

/**
 * Created by victor on 23.10.16.
 */
import ru.mail.park.domain.Greeting;

import javax.persistence.*;

@Entity
@Table(name = "greetings")
public class GreetingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "greeting")
    private String greeting;

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

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public Greeting toDto() {
        return new Greeting(name, greeting);
    }

}