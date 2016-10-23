package ru.mail.park.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.mail.park.domain.Greeting;
import ru.mail.park.service.GreetingService;

import java.util.List;

@RestController
public class GreetingController {

  @Autowired
  private final GreetingService service;

  public GreetingController(GreetingService service) {
    this.service = service;
  }

  @RequestMapping("/")
  public List<Greeting> greetings() {
    return service.list();
  }

  @RequestMapping("/greet")
  public void greet(@RequestParam String name, @RequestParam String greeting) {
    service.create(new Greeting(name, greeting));
  }

}
