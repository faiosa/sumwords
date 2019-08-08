import org.junit.Test;

import static org.junit.Assert.*;

public class EnglishTest {

    @Test
    public void inwords() {
        English english = new English();
        String actual = english.inwords(100000);
        String expected  = "one hundred thousands dollars and zero cents";
        assertEquals(expected, actual);

        String actual1 = english.inwords(0);
        String expected1  = "zero cents";
        assertEquals(expected1, actual1);

        String actual2 = english.inwords(222.22);
        String expected2  = "two hundred twenty two dollars and twenty two cents";
        assertEquals(expected2, actual2);

        String actual3 = english.inwords(-12);
        String expected3  = "Input your number in range from 0 to 2147483647";
        assertEquals(expected3, actual3);

        String actual4 = english.inwords(0.01);
        String expected4  = "one  cent";
        assertEquals(expected4, actual4);

    }
}