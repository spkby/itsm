package com.itechart.commuterange;

import com.itechart.commuterange.domain.Graph;
import com.itechart.commuterange.domain.Node;
import com.itechart.commuterange.repository.EdgeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@SpringBootApplication
public class CommuteRangeApplication implements CommandLineRunner {

    @Autowired
    private Graph graph;

    @Autowired
    private EdgeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(CommuteRangeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.findAll().forEach(edge -> {
            Node node = new Node(edge.getCityFrom());
            if (!graph.getNodesWithIndexes().containsKey(node)) {
                graph.addNode(node);
            } else {
                int index = graph.getNodesWithIndexes().get(node);
                node = graph.getNodes().get(index);
            }
            Node neighbour = new Node(edge.getCityTo());
            if (!graph.getNodesWithIndexes().containsKey(neighbour)) {
                graph.addNode(neighbour);
            } else {
                int index = graph.getNodesWithIndexes().get(neighbour);
                neighbour = graph.getNodes().get(index);
            }
            node.getNeighbours().put(neighbour, edge.getTime());
        });
    }
}
