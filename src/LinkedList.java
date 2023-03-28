import java.util.List;


public class LinkedList<T extends Comparable<T>> implements List<T> {

   public LinkedList(){
        this.start = new Node("\0");
        isSorted = false;
        size = 0;
    }


    public int size(){
        return size;
    }

    public boolean add(T data){
        Node<T> node = new Node(data);
        if(this.start.getNext() == null){
            this.start.setNext(node);
            size += 1;
        }

        while(currNode.getNext()!=null){
            currNode = currNode.getNext();
        }
        currNode.setNext(node);
        size += 1;
        return true;
    }

    public boolean add(int i, T data){
        Node<T> node = new Node(data);
        for(int j = 1; j < i; j++){
            currNode = currNode.getNext(); 
        }
        node.setNext(currNode.getNext());
        currNode.setNext(node);
        return true;
    }

    public T set(int i, T data){
        for(int j = 1; j < i; j++){
            currNode = currNode.getNext(); 
        }
        currNode.setData(data);
        return data;
    }

    public T get(int i){
        for(int j = 1; j < i; j++){
            currNode = currNode.getNext();
        }
        return currNode.getData();
    } 

    public int getIndex(T data){
        for(int i = 1; i <= size; i++){
            if(currNode.getData()==data){
                return i;
            }
            currNode = currNode.getNext();
        }
        return 0;
    }

    public void equalTo(T element){
        int i = 1;
        while(currNode.getNext()!=null) {
            if (currNode.getData() != element){
                currNode = currNode.getNext();
                this.remove(i);
                i++;
            }
            else{
                currNode = currNode.getNext();
                i++;
            }

        }
    }

    public void merge(List<T> otherList){
        LinkedList<T> other = (LinkedList<T>) otherList;
        other.sort();
        if(this.isSorted != true){
            this.sort();
        }
        while(other.currNode != null){
            while(this.currNode != null){
                if(this.currNode.equals(other.currNode)){
                    this.currNode = this.currNode.getNext();
                    other.currNode = other.currNode.getNext();
                }
            this.currNode = this.currNode.getNext();
            }
            this.add(other.currNode.getData());
            other.currNode = other.currNode.getNext();
        }
        this.sort();
    }

    public boolean rotate(int n){
        if(this.isEmpty()){
            return false;
        }
        Node<T> temp = start.getNext();
        for(int i = 1; i < size-n; i++){
            currNode = currNode.getNext();
        }
        for(int j = (size - n); j == size; j++){
            if(j == (size - n)){
                start.setNext(currNode);
            }
            else if(currNode.getNext() == null){
                currNode.setNext(temp);
            }
            else{
                currNode.setNext(currNode.getNext());
            }
        }
        return true;
    }

    public String toString(){
        String s = "";
        while(currNode != null){
            s += currNode.getData() + "\n";
            if(currNode.getNext() == null){
                return s;
            }
            currNode = currNode.getNext();
        }
        return s;
    }

    public T[] toArray(T[] array){
        int i = 0;
        while(currNode != null){
            array[i] = currNode.getData();
            currNode = currNode.getNext();
            i++;
        }
        return array;
    }

    public boolean isEmpty(){
        if(start.getNext() == null){
            return true;
        }
        return false;
    }

    public boolean sort(){
        Node<T> nextNode;
        if(this.isEmpty() == true){
            return false;
        }
        while(currNode.getNext() != null){
            nextNode = currNode.getNext();
            while(currNode.getData().compareTo(nextNode.getData()) == 1){
                currNode.setNext(nextNode.getNext());
                nextNode.setNext(currNode);
                currNode = currNode.getNext();
            }
            currNode = nextNode;
        }
        isSorted = true;
        return isSorted;
    }

    public void reverse(){
        Node<T> nextNode;
        while(currNode.getNext() != null){
            nextNode = currNode.getNext();
            currNode.setNext(nextNode.getNext());
            nextNode.setNext(currNode);
            currNode = nextNode;
        } 
        start.setNext(currNode);
    }

    public void clear(){
        while(currNode.getNext()!=null){
            currNode.setData(null);
            currNode = currNode.getNext();
        }
    }

    public T remove(int i){
        for(int j = 1; j < i-1; j++){
            currNode = currNode.getNext();
        }
        Node<T> temp = currNode.getNext();
        currNode.setNext(temp.getNext());
        return temp.getData();
    }


}
