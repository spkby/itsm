package com.itechart.commuterange.domain;

import com.itechart.commuterange.cache.Cache;
import com.itechart.commuterange.cache.CitiesCache;
import com.itechart.commuterange.util.Constants;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Graph {
    private Map<Node, Integer> nodesWithIndexes = new HashMap<>();
    private List<Node> nodes = new ArrayList<>();
    private Cache<SearchDetails, List<String>> cache = new CitiesCache<>(Constants.CACHE_SIZE);

    public void addNode(Node node) {
        nodes.add(node);
        nodesWithIndexes.put(node, nodes.size() - 1);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Map<Node, Integer> getNodesWithIndexes() {
        return nodesWithIndexes;
    }

    public void setNodesWithIndexes(Map<Node, Integer> nodesWithIndexes) {
        this.nodesWithIndexes = nodesWithIndexes;
    }

    public Cache<SearchDetails, List<String>> getCache() {
        return cache;
    }

    public void setCache(Cache<SearchDetails, List<String>> cache) {
        this.cache = cache;
    }
}
