import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void createCircularList(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    public void sizeEmptyList(){
        assertEquals(0, circularList.size());
    }

    @Test
    public void addElementInList(){
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    public void sizeList(){
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
    public void nextElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        assertEquals(1, circularList.next().get());
    }

    @Test
    public void secondElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        circularList.next();
        assertEquals(2, circularList.next().get());
    }

    @Test
    public void fifthElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        for(int i = 0; i < 5; i++){
            circularList.next();
        }
        assertEquals(6, circularList.next().get());
    }

    @Test
    public void previousElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        assertEquals(9, circularList.previous().get());
    }

    @Test
    public void fourthElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        for(int i = 0; i < 5; i++){
            circularList.next();
        }
        circularList.previous();
        assertEquals(3, circularList.previous().get());
    }

    @Test
    public void circolarPreviousElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        circularList.previous();
        assertEquals(8, circularList.previous().get());
    }

    @Test
    public void circolarNextElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        circularList.previous();
        assertEquals(0, circularList.next().get());
    }

    @Test
    public void nextAndPrevElement(){
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
        assertEquals(4, circularList.next().get());
    }

    @Test
    public void resetElement(){
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
        assertEquals(1, circularList.next().get());
    }


    





}
