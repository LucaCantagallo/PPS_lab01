package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private List<Integer> list;
    private int index;
    private boolean first;

    public CircularListImpl(){
        this.list = new ArrayList<>();
        this.first=true;
    }

    private void onlyFirst(){
        this.first = false;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    private Optional<Integer> getOptionalChecked(int index){
        return this.isEmpty() ? Optional.empty() : Optional.of(list.get(this.index));
    }

    @Override
    public Optional<Integer> next() {
        this.index = first ? -1 : this.index >= this.list.size()-1 ? -1 : this.index;
        this.onlyFirst();
        return getOptionalChecked(++this.index);
    }

    @Override
    public Optional<Integer> previous() {
        this.index = first ? this.list.size() : this.index <= 0 ? this.list.size() : this.index;
        this.onlyFirst();
        return getOptionalChecked(--this.index);
    }

    @Override
    public void reset() {
        this.first=true;
        this.index=0;
    }

}
