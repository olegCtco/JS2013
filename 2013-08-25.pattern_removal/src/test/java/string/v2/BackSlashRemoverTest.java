package string.v2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackSlashRemoverTest {

    private BackSlashRemover remover;

    @Before
    public void setUp() throws Exception {
        remover = new BackSlashRemover();
    }

    @Test
    public void test1() throws Exception {
        String s = "a\\b\\\\c\\\\\\d";
        assertEquals("a\\b\\\\c\\\\\\d", remover.process(s));
    }
    @Test
    public void test2() throws Exception {
        String s = "a\\\nb\\\\\nc\\\\\\\nd";
        assertEquals("abcd", remover.process(s));
    }
    @Test
    public void test3() throws Exception {
        String s = "a\\\n\\b\\\\\n\\c\\\\\\\n\\d";
        assertEquals("a\\b\\c\\d", remover.process(s));
    }
}
