package com.itechart.commuterange.service;

import com.itechart.commuterange.domain.Graph;
import com.itechart.commuterange.domain.Node;
import com.itechart.commuterange.domain.SearchDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

@Service
public class NodeServiceImpl implements NodeService {
    private Graph graph;

    public NodeServiceImpl(Graph graph) {
        this.graph = graph;
    }

    /**
     * This method represents implementation of depth first search algorithm.
     * At start it gets starting point from searchDetails parameter,
     * checks if cache consists search details with such parameters. If so,
     * it returns list of cities from cache.
     * Then it checks if stack is not empty, retrieves the last element from it
     * and iterates by collections of node`s neighbours, checks if
     * neighbour is reachable from starting point for a given
     * amount of time. If so, it adds city to cities list and adds node to stack.
     * Execution of method ends when there is no elements in the stack.
     *
     * @param searchDetails represents an entity of user`s input,
     *                      it contains name of city(starting point) and amount of given time
     * @return list of cities that are reachable from the city that
     * has been got from user`s request in a given amount of time
     */
    public List<String> findCities(SearchDetails searchDetails) {
        if (graph.getCache().get(searchDetails) != null) {
            return graph.getCache().get(searchDetails);
        }
        graph.getCache().put(searchDetails, new ArrayList<>());
        List<String> cities = graph.getCache().get(searchDetails);
        Node node = new Node(searchDetails.getCity());
        int time = searchDetails.getTime();
        if (!graph.getNodesWithIndexes().containsKey(node)) {
            throw new RuntimeException();
        }
        int index = graph.getNodesWithIndexes().get(node);
        node = graph.getNodes().get(index);
        node = new Node(node.getCity(), node.getTimeFromStart(), node.getNeighbours());
        Node startCity = node;
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        /*
        check if there are nodes in the stack
         */
        while (!stack.empty()) {
            //last element of stack retrieving
            node = stack.pop();
            int timeFromStart = node.getTimeFromStart();
            if (!node.getNeighbours().keySet().isEmpty()) {
                for (Map.Entry<Node, Integer> entry : node.getNeighbours().entrySet()) {
                    Node neighbour = entry.getKey();
                    neighbour = new Node(neighbour.getCity(),
                            neighbour.getTimeFromStart(), neighbour.getNeighbours());
                    if (neighbour.getTimeFromStart() != 0) {
                        if ((entry.getValue() + timeFromStart) < neighbour.getTimeFromStart()) {
                            neighbour.setTimeFromStart(entry.getValue() + timeFromStart);
                        }
                    } else {
                        neighbour.setTimeFromStart(entry.getValue() + timeFromStart);
                    }
                    if (neighbour.getTimeFromStart() <= time) {
                        if (!cities.contains(neighbour.getCity()) &&
                                !neighbour.getCity().equals(startCity.getCity())) {
                            cities.add(neighbour.getCity());
                        }
                        stack.push(neighbour);
                    }
                }
            }
        }

        return graph.getCache().get(searchDetails);
    }
}
