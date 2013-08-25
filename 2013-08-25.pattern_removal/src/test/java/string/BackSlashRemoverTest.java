package string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackSlashRemoverTest {

    @Test
    public void test1() throws Exception {
        String s = "a\\b\\\\c\\\\\\d";
        BackSlashRemover m = new BackSlashRemover();
        for (char c:s.toCharArray()){
            m.send_v2(c);
        }
        assertEquals("a\\b\\\\c\\\\\\d", m.getResult());
    }
    @Test
    public void test2() throws Exception {
        String s = "a\\\nb\\\\\nc\\\\\\\nd";
        BackSlashRemover m = new BackSlashRemover();
        for (char c:s.toCharArray()){
            m.send_v2(c);
        }
        assertEquals("abcd", m.getResult());
    }
    @Test
    public void test3() throws Exception {
        String s = "a\\\n\\b\\\\\n\\c\\\\\\\n\\d";
        BackSlashRemover m = new BackSlashRemover();
        for (char c:s.toCharArray()){
            m.send_v2(c);
        }
        assertEquals("a\\b\\c\\d", m.getResult());
    }}
