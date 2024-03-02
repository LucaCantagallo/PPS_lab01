import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tdd2.CircularList2;
import tdd2.CircularList2Impl;

public class CircularListTest2 {

    public CircularList2 circularList2;

    @Disabled
    @Test public void testTodo(){
        Assertions.fail();
    }

    @BeforeEach
    void beforeEach(){
        circularList2 = new CircularList2Impl();
    }

    @Test
    public void createCircularList(){
        assertTrue(circularList2.isEmpty());
    }

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
    public void forwardIteratorEmpty(){
        assertEquals(Optional.empty(), circularList2.forwardIterator()); 
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
    public void backwardIterator(){
        for(int i = 0; i < 10; i++){
            circularList2.add(i);
        }
        assertEquals(Optional.of(9), circularList2.backwardIterator()); 
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

