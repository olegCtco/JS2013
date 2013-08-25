package string;

import org.junit.Test;

import static org.junit.Assert.*;
import static string.BackSlashRemoverState.*;

public class StringTest {
    @Test
    public void shouldInitedInStateFind() throws Exception {
        BackSlashRemover m = new BackSlashRemover();
        assertEquals(BackSlashRemoverState.FIND, m.getState());
    }

    @Test
    public void shouldMoveFRomFIND2FINDED_ifReceivedBackSlash() throws Exception {
        BackSlashRemover m = new BackSlashRemover();
        m.send('\\');
        assertEquals(FOUNDED, m.getState());
    }
    @Test
    public void shouldMoveFoomFINDEDE2FIND_ifReceivedENTER() throws Exception {
        BackSlashRemover m = new BackSlashRemover();
        m.state = FOUNDED;
        m.send('\n');
        assertEquals(FIND, m.getState());
    }

    @Test
    public void shouldCreateREsultString() throws Exception {
        BackSlashRemover m = new BackSlashRemover();
        assertEquals("",m.getResult());
    }
    @Test
    public void shouldReturnResultString() throws Exception {
        BackSlashRemover m = new BackSlashRemover();
        m.send('a');
        assertEquals("a", m.getResult());
    }

    @Test
    public void shouldStayInFINDED_IfBS() throws Exception {
        BackSlashRemover m = new BackSlashRemover();
        m.state= FOUNDED;
        m.send('\\');
        assertEquals(FOUNDED, m.getState());
    }
    @Test
         public void shouldREturnCOMPETEString_ISTateFINDED() throws Exception {
        BackSlashRemover m = new BackSlashRemover();
        m.send('a');
        m.send('\\');
        assertEquals("a\\", m.getResult());
    }


    @Test
    public void test1() throws Exception {
        String s = "a\\b\\\\c\\\\\\d";
        BackSlashRemover m = new BackSlashRemover();
        for (char c:s.toCharArray()){
            m.send(c);
        }
        assertEquals("a\\b\\\\c\\\\\\d", m.getResult());
    }
    @Test
    public void test2() throws Exception {
        String s = "a\\\nb\\\\\nc\\\\\\\nd";
        BackSlashRemover m = new BackSlashRemover();
        for (char c:s.toCharArray()){
            m.send(c);
        }
        assertEquals("abcd", m.getResult());
    }
    @Test
    public void test3() throws Exception {
        String s = "a\\\n\\b\\\\\n\\c\\\\\\\n\\d";
        BackSlashRemover m = new BackSlashRemover();
        for (char c:s.toCharArray()){
            m.send(c);
        }
        assertEquals("a\\b\\c\\d", m.getResult());
    }
}