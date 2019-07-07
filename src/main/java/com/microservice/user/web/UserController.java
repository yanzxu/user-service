package com.microservice.user.web;

import com.microservice.user.client.ProjectClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
//    @Autowired
    private ProjectClient projectClient;

    @Autowired
    UserController(ProjectClient projectClient){
        this.projectClient = projectClient;
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ResponseEntity listUsers(){
        return ResponseEntity.ok().body("===== this is user service =====");
    }

    @RequestMapping(path = "/projects", method = RequestMethod.GET)
    public ResponseEntity listProject(){
        return ResponseEntity.ok().body(projectClient.listProjects());
    }

}
