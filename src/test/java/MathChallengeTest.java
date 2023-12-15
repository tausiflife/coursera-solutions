import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathChallengeTest {
    @Test
    public void testEncodeConsonants1() {
        MathChallenge mathChallenge = new MathChallenge();
        int encoded = mathChallenge.findSmallestNumberGreaterThanGivenNumber(68976543);
        assertEquals(69345678, encoded);

        int encoded1 = mathChallenge.findSmallestNumberGreaterThanGivenNumber(12453);
        assertEquals(12534, encoded1);
        int encoded2 = mathChallenge.findSmallestNumberGreaterThanGivenNumber(999);
        assertEquals(-1, encoded2);

        int encoded3 = mathChallenge.findSmallestNumberGreaterThanGivenNumber(669876543);
        assertEquals(673456689, encoded3);
    }


    private void addToList(List list) {
        list.add("hello");
    }
}
