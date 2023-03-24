public class ArrayList<T extends Comparable<T>> implements List<T> {
    private T[] a;
    private boolean isSorted;
    public ArrayList(){
        a = (T[]) new Comparable[2];
    }
    public boolean add(T element){
        return true;
    }
    public boolean add(int index, T element){
        return true;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void sort() {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public void equalTo(T element) {

    }

    @Override
    public void reverse() {

    }

    @Override
    public void merge(List<T> otherList) {

    }

    @Override
    public boolean rotate(int n) {
        return false;
    }

    @Override
    public boolean isSorted() {
        return false;
    }

}
