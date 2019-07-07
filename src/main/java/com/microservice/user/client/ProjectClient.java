package com.microservice.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${services.project-service.name}", url = "${services.project-service.url}")
public interface ProjectClient {
    @RequestMapping(path = "/projects", method = RequestMethod.GET)
    String listProjects();
}
