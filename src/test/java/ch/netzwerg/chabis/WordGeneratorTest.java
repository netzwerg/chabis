package ch.netzwerg.chabis;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WordGeneratorTest {

    private Random random;

    @Before
    public void before() {
        this.random = new Random(42);
    }

    @Test
    public void oneThousandWords() {
        assertEquals(1000, WordGenerator.ALL_WORDS.size());
    }

    @Test
    public void randomWord() {
        assertNotNull(new WordGenerator().randomWord());
    }

    @Test
    public void deterministicRandomWord() {
        assertEquals("Büülä", WordGenerator.randomWord(this.random));
    }

    @Test
    public void randomWords() {
        assertEquals(333, new WordGenerator().randomWords(333).size());
    }

    @Test
    public void deterministicRandomWords() {
        List<String> randomWords = WordGenerator.randomWords(this.random, 3);
        assertEquals(Arrays.asList("Büülä", "Schnoderbueb", "Döller" ), randomWords);
    }

    @Test
    public void uniqueRandomWords() {
        assertEquals(333, new WordGenerator().uniqueRandomWords(333).size());
    }

    @Test
    public void deterministicUniqueRandomWords() {
        List<String> words = WordGenerator.uniqueRandomWords(this.random, 333);
        assertEquals(333, words.size());
        assertEquals(333, words.stream().distinct().count());
        assertEquals(Arrays.asList("Mutz", "Schroppä", "Kösi" ), WordGenerator.uniqueRandomWords(this.random, 3));
    }

}
