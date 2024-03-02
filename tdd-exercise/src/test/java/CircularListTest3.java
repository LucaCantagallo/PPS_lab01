import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tdd3.CircularList3;
import tdd3.CircularList3Impl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest3 {

    public CircularList3 circularList3;

    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

    @BeforeEach
    void beforeEach(){
        circularList3 = new CircularList3Impl();
    }

    @Test
    public void createEmptyCircularList(){
        assertTrue(circularList3.isEmpty());
    }

    @Test
    public void sizeZero(){
        assertEquals(0, circularList3.size());
    }

    @Test
    public void addOneElement(){
        circularList3.add(1);
        assertFalse(circularList3.isEmpty());
    }

    @Test
    public void sizeOne(){
        circularList3.add(1);
        assertEquals(1, circularList3.size());
    }

    @Test
    public void nextOfEmptyList(){
        assertEquals(Optional.empty(), circularList3.next());
    }

    @Test
    public void firstNextElement(){
        for(int i=0; i<=10; i++){
            circularList3.add(i);
        }
        assertEquals(Optional.of(1), circularList3.next());
    }

    @Test
    public void secondNextElement(){
        for(int i=0; i<=10; i++){
            circularList3.add(i);
        }
        circularList3.next();
        assertEquals(Optional.of(1), circularList3.next());
    }

    @Test
    public void firstPreviousElement(){
        for(int i=0; i<=10; i++){
            circularList3.add(i);
        }
        assertEquals(Optional.of(10), circularList3.previous());
    }

    @Test
    public void secondPreviousElement(){
        for(int i=0; i<=10; i++){
            circularList3.add(i);
        }
        circularList3.previous();
        assertEquals(Optional.of(9), circularList3.previous());
    }

    @Test
    public void filteredNextInEmpty(){
        assertEquals(Optional.empty(), circularList3.filteredNext(i -> (i < 1)));
    }

    @Test
    public void filteredNextEqualsFive(){
        for(int i=0; i<=10; i++){
            circularList3.add(i);
        }
        assertEquals(Optional.of(5), circularList3.filteredNext(i -> (i == 5)));
    }   

    @Test
    public void filteredNextNotPresent(){
        for(int i=0; i<=10; i++){
            circularList3.add(i);
        }
        assertEquals(Optional.empty(), circularList3.filteredNext(i -> (i >11)));
    }   

}
