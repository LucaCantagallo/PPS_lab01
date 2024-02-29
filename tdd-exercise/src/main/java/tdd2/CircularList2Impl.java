package tdd2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Iterator;

public class CircularList2Impl implements CircularList2 {

    private List<Integer> list;
    private Iterator<Integer> iterator;
    private boolean first;

    public CircularList2Impl(){
        this.list = new ArrayList<>();
        this.first=true;
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

    private void initIterator(){
        if(first || !iterator.hasNext()){
            this.iterator= list.iterator();
            first=false;
        }       
    }

    @Override
    public Optional<Integer> forwardIterator() {
        if(list.isEmpty()){
            return Optional.empty();
        }
        initIterator();

        return Optional.ofNullable(iterator.next());
    }


    @Override
    public Optional<Integer> backwardIterator() {
        if(list.isEmpty()){
            return Optional.empty();
        }

        int listSize=list.size();

        initIterator();

        for(int i=0; i<listSize-2;i++){
            this.forwardIterator();
        }

        return this.forwardIterator();
    }

}
