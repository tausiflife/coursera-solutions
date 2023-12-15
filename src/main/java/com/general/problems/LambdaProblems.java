package com.general.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class LambdaProblems {

    /**
     * There is a class Country that has methods getContinentO and
     * getPopulationO. Write a function int get Population (List<Country> countries,
     * String continent) that computes the total population of a given continent, given a list of all
     * countries and the name of a continent
     * @return
     */
    public long getPopulationOfContinent(List<Country> countryList, final String continent) {
        return countryList.stream().filter(c -> c.getContinent().equals(continent))
                .mapToLong(Country::getPopulation).sum();
    }

    /**
     * Using Lambda expressions, write a function List<Integer>
     * getRandomSubset (List< Integer> list) that returns a random subset of arbitrary size. All
     * subsets (including the empty set) should be equally likely to be chosen
     * @param list
     * @return
     */
    public List<Integer> getRandomSubset(List<Integer> list) {
        Collections.shuffle(list);
        int randomNum = ThreadLocalRandom.current().nextInt(0, list.size());
        return list.stream().limit(randomNum).collect(Collectors.toList());
    }


}
class Country {
    private String continent;
    private long population;

    public Country(String continent, long population) {
        this.continent = continent;
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public long getPopulation() {
        return population;
    }
}
