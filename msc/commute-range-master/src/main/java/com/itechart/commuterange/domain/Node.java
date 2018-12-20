package com.itechart.commuterange.domain;

import java.util.*;

/**
 * This class represents a node of the graph.
 * Each node has city name, time from a start node,
 * and map of neighbour nodes with time, that is required
 * to reach the neighbour node.
 */
public class Node {
    private String city;
    private int timeFromStart;
    private Map<Node, Integer> neighbours = new HashMap<>();

    public Node() {
    }

    public Node(String city) {
        this.city = city;
    }

    public Node(String city, int timeFromStart, Map<Node, Integer> neighbours) {
        this.city = city;
        this.timeFromStart = timeFromStart;
        this.neighbours = neighbours;
    }

    public void addNeighbour(Node node, Integer time) {
        neighbours.put(node, time);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTimeFromStart() {
        return timeFromStart;
    }

    public void setTimeFromStart(int timeFromStart) {
        this.timeFromStart = timeFromStart;
    }

    public Map<Node, Integer> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Map<Node, Integer> neighbours) {
        this.neighbours = neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(city, node.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city);
    }

    @Override
    public String toString() {
        return "Node{" +
                "city='" + city + '\'' +
                ", timeFromStart=" + timeFromStart;
    }
}
