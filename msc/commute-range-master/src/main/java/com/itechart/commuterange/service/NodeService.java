package com.itechart.commuterange.service;

import com.itechart.commuterange.domain.SearchDetails;

import java.util.List;

public interface NodeService {

    List<String> findCities(SearchDetails searchDetails);
}
