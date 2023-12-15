package com.general.problems;

import com.general.ood.ricksapp.*;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.randomizers.AbstractRandomizer;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class LambdaProblemsTest {

    private LambdaProblems lambdaProblems = new LambdaProblems();

    @Test
    public void testLambdaRandom() {
        EasyRandom generator = new EasyRandom();
        List<Integer> list = generator.objects(Integer.class, 30).collect(Collectors.toList());
        List<Integer> result = lambdaProblems.getRandomSubset(list);
        System.out.println(result.size());

        result = lambdaProblems.getRandomSubset(list);
        System.out.println(result.size());

        result = lambdaProblems.getRandomSubset(list);
        System.out.println(result.size());
    }

    @Test
    public void testPopulationOfContinent() {
        /*EasyRandomParameters parameters = new EasyRandomParameters();
        Continents[] continents = Continents.values();
        parameters.randomize(String.class, () -> ThreadLocalRandom.current().nextInt(0,continents.length));
        parameters.randomize(Long.class, () -> (long)ThreadLocalRandom.current().nextInt(1000, Integer.MAX_VALUE));
        EasyRandom generator = new EasyRandom(parameters);
        List<Country> countries = generator.objects(Country.class, 10).collect(Collectors.toList());
        long population = lambdaProblems.getPopulationOfContinent(countries, continents[0].toString());
        System.out.println(population);*/
    }

}

enum Continents {
    ASIA, EUROPE, AFRICA, NORTH_AMERICA, SOUTH_AMERICA, AUSTRALIA, ANTARCTICA;
}
