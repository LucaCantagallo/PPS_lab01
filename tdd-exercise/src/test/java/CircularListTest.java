import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import tdd.CircularList;
import tdd.CircularListImpl;
import tdd2.CircularList2;
import tdd2.CircularList2Impl;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    public CircularList circularList;
    public CircularList2 circularList2;

    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
        circularList2 = new CircularList2Impl();
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
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    public void secondElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        circularList.next();
        assertEquals(Optional.of(2), circularList.next());
    }

    @Test
    public void fifthElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        for(int i = 0; i < 5; i++){
            circularList.next();
        }
        assertEquals(Optional.of(6), circularList.next());
    }

    @Test
    public void previousElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        assertEquals(Optional.of(9), circularList.previous());
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
        assertEquals(Optional.of(3), circularList.previous());
    }

    @Test
    public void circolarPreviousElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        circularList.previous();
        assertEquals(Optional.of(8), circularList.previous());
    }

    @Test
    public void circolarNextElement(){
        for(int i = 0; i < 10; i++){
            circularList.add(i);
        }
        circularList.previous();
        assertEquals(Optional.of(0), circularList.next());
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
        assertEquals(Optional.of(4), circularList.next());
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
        assertEquals(Optional.of(1), circularList.next());
    }

    //STEP 2:
    @Test
    public void addElementsAndSize(){
        for(int i = 0; i < 10; i++){
            circularList2.add(i);
        }
        assertEquals(10, circularList2.size());        
    }

    @Test
    public void addAndIsEmpty(){
        circularList2.add(1);
        assertFalse(circularList2.isEmpty());        
    }

    @Test
    public void forwardIterator(){
        for(int i = 0; i < 10; i++){
            circularList2.add(i);
        }
        assertEquals(Optional.of(0), circularList2.forwardIterator()); 
    }

    @Test
    public void forwardIteratorSomeNexts(){
        for(int i = 0; i < 10; i++){
            circularList2.add(i);
        }
        circularList2.forwardIterator();
        circularList2.forwardIterator();
        assertEquals(Optional.of(2), circularList2.forwardIterator()); 
    }


    @Test
    public void forwardIteratorCircle(){
        for(int i = 0; i < 3; i++){
            circularList2.add(i);
        }
        circularList2.forwardIterator();
        circularList2.forwardIterator();
        circularList2.forwardIterator();
        circularList2.forwardIterator();
        assertEquals(Optional.of(1), circularList2.forwardIterator()); 
    }

    @Test
    public void backwardIteratorEmpty(){
        assertEquals(Optional.empty(), circularList2.backwardIterator()); 
    }

    @Test
    public void backwardIteratorNextAndPrev(){
        for(int i = 0; i < 10; i++){
            circularList2.add(i);
        }
        circularList2.forwardIterator(); //0
        circularList2.forwardIterator();  //1
        circularList2.forwardIterator(); //2
        assertEquals(Optional.of(1), circularList2.backwardIterator()); 
    }

    @Test
    public void forwardIterator(){
        for(int i = 0; i < 10; i++){
            circularList2.add(i);
        }
        assertEquals(Optional.of(8), circularList2.backwardIterator()); //interessante: perché il puntatore inizialmente sta sull'ultimo?
    }

    @Test
    public void bothStepIterator(){
        for(int i = 0; i < 10; i++){
            circularList2.add(i);
        }
        circularList2.forwardIterator();//0
        circularList2.forwardIterator();//1
        circularList2.forwardIterator();//2
        circularList2.backwardIterator();//1
        circularList2.forwardIterator();//2
        circularList2.forwardIterator();//3
        circularList2.backwardIterator();//2
        circularList2.forwardIterator();//3
        assertEquals(Optional.of(2), circularList2.backwardIterator()); //2
    }




    


    





}
