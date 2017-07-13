import static org.junit.Assert.*;
import org.junit.*;

public class MonkeyTest{

    public Monkey _m;

    @Before
    public void setup(){
        _m = new Monkey();
    }

    @Test
    public void testGenerateId1(){
        assertEquals(_m.generateId(5), 5);
    }

    @Test
    public void testGenerateId2(){
        assertEquals(_m.generateId(10), 10);
    }
}