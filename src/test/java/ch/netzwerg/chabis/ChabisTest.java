package ch.netzwerg.chabis;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ChabisTest {

    private static final Random RANDOM = new Random(42);

    @Test
    public void oneThousandWords() {
        assertEquals(1000, Chabis.ALL_WORDS.size());
    }

    @Test
    public void randomWords() {
        assertEquals(333, Chabis.randomWords(333).size());
    }

    @Test
    public void deterministicRandomWords() {
        List<String> randomWords = Chabis.randomWords(RANDOM, 3);
        assertEquals(Arrays.asList("Büülä", "Schnoderbueb", "Döller" ), randomWords);
    }

    @Test
    public void uniqueRandomWords() {
        assertEquals(333, Chabis.uniqueRandomWords(333).size());
    }

    @Test
    public void deterministicUniqueRandomWords() {
        List<String> words = Chabis.uniqueRandomWords(RANDOM, 333);
        assertEquals(333, words.size());
        assertEquals(333, words.stream().distinct().count());
        assertEquals(Arrays.asList("Gonfi", "Manzälä", "Läufterli" ), Chabis.uniqueRandomWords(RANDOM, 3));
    }

}
