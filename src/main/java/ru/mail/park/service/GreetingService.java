package ru.mail.park.service;

import org.hibernate.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.park.dao.ContactEntity;
import ru.mail.park.domain.Greeting;
import ru.mail.park.utils.HibernateSessionFactory;

import java.util.List;

@Service
@Transactional
public class GreetingService {
  private final JdbcTemplate template;

 //   @Autowired ???
//    private final HibernateSessionFactory sessionFactory;

  public GreetingService(JdbcTemplate template) {
    this.template = template;
  }

  public List<Greeting> list() {
 /*     Session session = HibernateSessionFactory.getSessionFactory().openSession();
      session.beginTransaction();

      List<ContactEntity> list = session.createCriteria(ContactEntity.class).list();
      session.getTransaction().commit();
      session.close();
      return list;
*/
     return template.query("select * from greetings",
        (rs, rowNum) -> new Greeting(rs.getString("name"), rs.getString("greeting")));
  }

  public void create(Greeting greeting) {
    //вообще у нас нет гарантии что у более новой записи будет больший id

    Session session = HibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    ContactEntity contactEntity = new ContactEntity();

    contactEntity.setGreetings(greeting.getGreeting());
    contactEntity.setName(greeting.getName());

    session.save(contactEntity);
    session.getTransaction().commit();
    session.close();
/*
    template.update(
        "delete from greetings where id < (select min(id) from (select id from greetings order by id desc limit 100) as desc_ids)");
    
    template.update("insert into greetings(name, greeting) values(?,?)", greeting.getName(),
        greeting.getGreeting());
  }

    public void mytest(String name) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        List<ContactEntity> list = session.createCriteria(ContactEntity.class).list();
        session.getTransaction().commit();
        session.close(); */
    }

}
