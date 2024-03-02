import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    public CircularList circularList;

    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
    }

    @Test
    public void createEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    public void sizeEmpty(){
        assertEquals(0, circularList.size());
    }

    @Test
    public void addAndIsNotEmpty(){
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    public void addAndSize(){
        circularList.add(1);
        assertEquals(1, circularList.size());
    }

    @Test
    public void sizeLongList(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        assertEquals(10, circularList.size());
    }

    @Test
    public void nextNull(){
        assertEquals(Optional.empty(), circularList.next());
    }

    @Test
    public void nextElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        assertEquals(Optional.of(0), circularList.next());
    }

    @Test
    public void secondElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        circularList.next();
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    public void fifthElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        for(int i = 0; i < 5; i++){
            circularList.next();
        }
        assertEquals(Optional.of(5), circularList.next());
    }

    @Test
    public void previousElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        assertEquals(Optional.of(9), circularList.previous());
    }

    @Test
    public void mixedSteps(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        for(int i = 0; i < 5; i++){
            circularList.next();
        }
        circularList.previous();
        assertEquals(Optional.of(2), circularList.previous());
    }

    @Test
    public void startWithPrevious(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        circularList.previous();
        assertEquals(Optional.of(8), circularList.previous());
    }

    @Test
    public void previousAndNext(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        circularList.previous();
        assertEquals(Optional.of(0), circularList.next());
    }

    @Test
    public void manySteps(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        circularList.previous();
        circularList.next();
        circularList.next();
        circularList.next();
        circularList.previous();
        circularList.next();
        circularList.next();
        assertEquals(Optional.of(4), circularList.next());
    }

    @Test
    public void reset(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        circularList.previous();
        circularList.next();
        circularList.next();
        circularList.next();
        circularList.previous();
        circularList.next();
        circularList.next();
        circularList.reset();
        assertEquals(Optional.of(0), circularList.next());
    }

}
