package com.ooad.ludo.generator;

import java.security.SecureRandom;
import java.util.Random;

public class DiceNumberGenerator implements NumberGenerator {
    @Override
    public int generate() {
        Random random = new SecureRandom();
        return random.nextInt(6);
    }
}
