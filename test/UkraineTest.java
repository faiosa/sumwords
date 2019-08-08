import org.junit.Test;

import static org.junit.Assert.*;

public class UkraineTest {

    @Test
    public void inwords() {
        Ukraine ukraine = new Ukraine();
        String actual = ukraine.inwords(100000);
        String expected  = "сто тисяч гривень ноль копійок";
        assertEquals(expected, actual);

        String actual1 = ukraine.inwords(0.0);
        String expected1  = "ноль копійок";
        assertEquals(expected1, actual1);

        String actual2 = ukraine.inwords(222.22);
        String expected2  = "двісті двадцять два гривні двадцять дві копійки";
        assertEquals(expected2, actual2);

        String actual3 = ukraine.inwords(-12);
        String expected3  = "Введіть число від 0 до 2147483647";
        assertEquals(expected3, actual3);

        String actual4 = ukraine.inwords(0.01);
        String expected4  = "одна копійка";
        assertEquals(expected4, actual4);


    }
}