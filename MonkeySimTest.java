import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.*;
import java.util.List;
import java.util.ArrayList;

public class MonkeySimTest{

    public MonkeySim _sim;

    @Before
    public void setup(){
        _sim = new MonkeySim();
    }

    @Test
    public void testGetFirstMonkeySingleMonkey() throws NoIdException{
        List<Monkey> monkeyList = new ArrayList<Monkey>();
        for (int i = 0; i < 2; i++)
            monkeyList.add(new Monkey());
        
        Monkey firstMonkey = _sim.getFirstMonkey(monkeyList);
        assertEquals(firstMonkey.getId(), 1);
    }

    @Test
    public void testGetFirstMonkeyMultipleMonkeys() throws NoIdException{
        List<Monkey> monkeyList = new ArrayList<Monkey>();
        for (int i = 0; i < 10; i++)
            monkeyList.add(new Monkey());
        
        Monkey firstMonkey = _sim.getFirstMonkey(monkeyList);
        assertEquals(firstMonkey.getId(), 1);
    }

    @Test
    public void testStringifyResultsValid() throws NoIdException{
        Monkey monkey1 = mock(Monkey.class);
        when(monkey1.getMonkeyNum()).thenReturn(8);
        when(monkey1.getId()).thenReturn(8);
        Monkey monkey2 = mock(Monkey.class);
        when(monkey2.getMonkeyNum()).thenReturn(4);
        when(monkey2.getId()).thenReturn(4);
        String results = _sim.stringifyResults(1, monkey1, monkey2);

        assertEquals(results,"//Round 1: Threw banana from Monkey (#8 / ID 8) to Monkey (#4 / ID 4");
    }

    @Test
    public void testStringifyResultsInvalid() throws NoIdException{
        Monkey monkey1 = mock(Monkey.class);
        when(monkey1.getMonkeyNum()).thenThrow(NoIdException.class);
        when(monkey1.getId()).thenReturn(8);
        Monkey monkey2 = mock(Monkey.class);
        when(monkey2.getMonkeyNum()).thenReturn(4);
        when(monkey2.getId()).thenReturn(4);
        String results = _sim.stringifyResults(1, monkey1, monkey2);

        assertEquals(results,"INVALID MONKEY!");
    }
}