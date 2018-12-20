package com.itechart.commuterange;

import com.itechart.commuterange.domain.Graph;
import com.itechart.commuterange.domain.SearchDetails;
import com.itechart.commuterange.service.NodeService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommuteRangeApplicationTests {

    @Autowired
    private NodeService nodeService;
    @Autowired
    private Graph graph;

    @Test
    public void ifResultListIsEmpty() {
        SearchDetails details = new SearchDetails();
        details.setCity("San Francisco");
        details.setTime(32);

        Assert.assertTrue(!nodeService.findCities(details).isEmpty());
        details.setCity("San Francisco");
        details.setTime(0);

        Assert.assertTrue(nodeService.findCities(details).isEmpty());
    }

    @Test
    public void ifCacheIsNotEmpty() {
        SearchDetails details = new SearchDetails();
        details.setCity("San Francisco");
        details.setTime(32);
        nodeService.findCities(details);
        Assert.assertNotNull(graph.getCache().get(details));
    }

}
