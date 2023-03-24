import javax.naming.SizeLimitExceededException;

public class ArrayList<T extends Comparable<T>> implements List<T> {
    private T[] a;
    private boolean isSorted;

    public ArrayList(){
        a = (T[]) new Comparable[2];
    }
}
