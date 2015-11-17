package ch.netzwerg.chabis;

import javaslang.collection.Stream;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class DemoTest {

    private WordGenerator wordGenerator;

    @Before
    public void before() {
        this.wordGenerator = new WordGenerator(new Random(42));
    }

    @Test
    public void demo() {
        Stream<String> words = this.wordGenerator.randomWords(3);
        assertEquals(Arrays.asList("Büülä", "Schnoderbueb", "Döller"), words.toJavaList());
    }

}
