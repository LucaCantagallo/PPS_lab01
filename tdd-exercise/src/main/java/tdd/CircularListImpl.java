package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> list;
    private int index;

    public CircularListImpl(){
        this.list = new ArrayList<>();
        this.index = 0;
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if(index>=list.size()-1){
            this.index = 0;
            return Optional.of(list.get(index));
        }
        return Optional.of(list.get(++index));
    }

    @Override
    public Optional<Integer> previous() {
        if(index<=0){
            this.index = list.size()-1;
            return Optional.of(list.get(index));
        }
        return Optional.of(list.get(--index));
    }

    @Override
    public void reset() {
        this.index=0;
    }

}
