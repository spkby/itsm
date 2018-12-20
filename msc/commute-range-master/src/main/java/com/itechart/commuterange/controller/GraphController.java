package com.itechart.commuterange.controller;

import com.itechart.commuterange.domain.SearchDetails;
import com.itechart.commuterange.service.NodeServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GraphController {
    private NodeServiceImpl nodeService;

    public GraphController(NodeServiceImpl nodeService) {
        this.nodeService = nodeService;
    }

    @PostMapping("/cities")
    public List<String> getCities(@RequestBody SearchDetails details) {
        System.out.println("city: " + details.getCity());
        System.out.println("time: " + details.getTime());
        return nodeService.findCities(details);
    }
}
