package tdd3;

import java.util.Optional;
import java.util.function.Predicate;
import tdd.CircularList;
import tdd.CircularListImpl;

public class CircularList3Impl implements CircularList3 {

    private CircularList circularList;

    public CircularList3Impl(){
        this.circularList = new CircularListImpl();
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return this.circularList.next();
    }

    @Override
    public Optional<Integer> previous() {
        return this.circularList.previous();
    }

    @Override
    public void reset() {
        this.circularList.reset();
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> predicate) {
        if(this.circularList.isEmpty()){
            return Optional.empty();
        }
        Optional<Integer> res = circularList.next();
        int i = 0;
        while(!predicate.test(res.get())){
            if(i >= circularList.size()){
                return Optional.empty();
            }
            res=circularList.next();
            i++;
        }
        return res;
    }

}