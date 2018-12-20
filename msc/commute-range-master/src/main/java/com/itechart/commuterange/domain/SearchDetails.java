package com.itechart.commuterange.domain;

import java.util.Objects;

/**
 * This class represents user`s input.
 * Field city represents city name of starting point.
 * Field time represents time for searching cities,
 * that can be reached for this time
 */
public class SearchDetails {
    private String city;
    private int time;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchDetails that = (SearchDetails) o;
        return time == that.time &&
                Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, time);
    }
}
