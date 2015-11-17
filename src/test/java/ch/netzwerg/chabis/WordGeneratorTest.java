package ch.netzwerg.chabis;

import javaslang.collection.Array;
import javaslang.collection.Stream;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class WordGeneratorTest {

    private Random random;

    @Before
    public void before() {
        this.random = new Random(42);
    }

    @Test
    public void oneThousandWords() {
        assertEquals(1000, WordGenerator.ALL_WORDS.length());
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
        assertEquals(333, new WordGenerator().randomWords(333).length());
    }

    @Test
    public void deterministicRandomWords() {
        Stream<String> randomWords = WordGenerator.randomWords(this.random, 3);
        assertTrue(Array.ofAll("Büülä", "Schnoderbueb", "Döller").eq(randomWords));
    }

    @Test
    public void uniqueRandomWords() {
        assertEquals(333, new WordGenerator().uniqueRandomWords(333).length());
    }

    @Test
    public void deterministicUniqueRandomWords() {
        Stream<String> words = WordGenerator.uniqueRandomWords(this.random, 333);
        assertEquals(333, words.length());
        assertEquals(333, words.distinct().length());
        assertTrue(Array.ofAll("Mutz", "Schroppä", "Kösi").eq(WordGenerator.uniqueRandomWords(this.random, 3)));
    }

}
