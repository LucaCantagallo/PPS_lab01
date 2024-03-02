package tdd2;

import java.util.Optional;
import tdd_general.CircularListBase;

public interface CircularList2 extends CircularListBase {

    Optional<Integer> forwardIterator();

    Optional<Integer> backwardIterator();

}
