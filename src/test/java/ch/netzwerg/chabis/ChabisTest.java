package ch.netzwerg.chabis;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class ChabisTest {

    @Test
    public void words() {
        assertEquals(Chabis.WORD_COUNT, Chabis.words().size());
    }

    @Test
    public void randomWords() {
        assertEquals(333, Chabis.randomWords(333).size());
    }

    @Test
    public void deterministicRandomWords() {
        Random random = new Random(999);
        List<String> randomWords = Chabis.randomWords(random, 3);
        assertEquals(Arrays.asList("Grittibänz", "Chuttä", "Güsel"), randomWords);
    }

}
