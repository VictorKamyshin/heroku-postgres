package ru.mail.park.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.park.domain.Greeting;
import ru.mail.park.entity.GreetingEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class GreetingService {

    @PersistenceContext
    private EntityManager em;

    public void create(Greeting greeting) {
        GreetingEntity entity = new GreetingEntity();
        entity.setName(greeting.getName());
        entity.setGreeting(greeting.getGreeting());
        em.persist(entity);
    }

    public List<Greeting> list() {
        System.out.println();
        return em.createQuery("select g from GreetingEntity g", GreetingEntity.class)
                .getResultList()
                .stream()
                .map(GreetingEntity::toDto)
                .collect(Collectors.toList());
    }

}
