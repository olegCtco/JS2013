package enums;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrafficLightTest {
    @Test
    public void shouldThrowException() throws Exception {
        TrafficLight tl = new TrafficLight();
        try {
            tl.setColor(567);
            fail();
        } catch (TrafficLightException ignored) {
        }
        ;
    }

    @Test
    public void shouldDontThrowException() throws Exception {
        TrafficLight tl = new TrafficLight();
        tl.setColor(TrafficLigthColor.GREEN);
    }
    @Test
    public void shouldUseCOlorEnumAsColor() throws Exception {
        TrafficLight tl = new TrafficLight();
        tl.setColor(Color.GREEN);
    }
}
