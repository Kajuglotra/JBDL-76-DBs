package org.gfg.dbs.controller;

import org.gfg.dbs.entity.Person;
import org.gfg.dbs.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller // view as response
@ResponseBody // response into something http understand
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping("/personData")
    public List<Person> getPersonInfo(){
        return service.getPersonInfo();
    }

    @PostMapping("/addPerson")
    public int addPerson(@RequestParam(value = "name", required = false) String name,
                         @RequestParam("id") int id){
        return  service.addPersonWithJPA(name, id);
    }
}
// put : updates, create one
// get : browser can hit a get request,
// u cannot make a post hit directly  from the browser(address bar ). fe (ajax, js)
// postman : website , application
// one more http client for testing apis
// we use as hhtp client ? terminal
// get : there is no body  : url
// Response Body