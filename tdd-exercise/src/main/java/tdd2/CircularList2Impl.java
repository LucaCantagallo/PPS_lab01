package tdd2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.swing.text.html.Option;

import java.util.Iterator;

public class CircularList2Impl implements CircularList2 {

    private List<Integer> list;
    private Iterator<Integer> iterator;
    private boolean first;
    private boolean firstPrev;

    public CircularList2Impl(){
        this.list = new ArrayList<>();
        this.first=true;
        this.firstPrev=true;
    }

    private void onlyFirst(){
        this.first = false;
    }

    /*
     * Senza questo, se da una lista si chiamava la prev come primo elemento da restituire, 
     * veniva restituito il penultimo invece che l'ultimo
     */
    private void onlyFirstPrev(){
        if(first){
            this.iterator.next();
        }
        onlyFirst();
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
        if(first || (!list.isEmpty() && !iterator.hasNext())){
            this.iterator= list.iterator();
        }       
    }

    @Override
    public Optional<Integer> forwardIterator() {
        this.initIterator();
        this.onlyFirst();
        return this.list.isEmpty() ? Optional.empty() : Optional.of(this.iterator.next());
    }


    @Override
    public Optional<Integer> backwardIterator() {
        this.initIterator();
        this.onlyFirstPrev();
        return this.list.isEmpty() ? Optional.empty() : this.previous();
    }

    private Optional<Integer> previous() {
        for(int i=0; i<this.list.size()-2;i++){
            this.forwardIterator();
        }
        return this.forwardIterator();
    }

}
