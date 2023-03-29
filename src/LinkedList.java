public class LinkedList<T extends Comparable<T>> implements List<T> {
    private boolean isSorted = true;
    private Node<T> start;
    private int size;
    private Node<T> currNode;



    public LinkedList(){
        this.start = new Node(null);
        isSorted = false;
        size = 0;
    }

    public boolean isSorted(){ return isSorted; }

    public int size(){ return size; }

    public boolean add(T data){
        if(data == null){
            return false;
        }
        Node<T> node = new Node(data);
        if(this.start.getNext() == null){
            this.start.setNext(node);
            size += 1;
            return true;
        }
        currNode = start.getNext();
        if(currNode == null){
            return false;
        }
        while(currNode.getNext()!=null){
            currNode = currNode.getNext();
        }
        currNode.setNext(node);
        size += 1;
        return true;
    }

    public boolean add(int i, T data){
        if(data == null){ return false; }
        if(i > size + 1){ return false;}
        if(this.isEmpty()){return false;}
        currNode = start.getNext();
        Node<T> node = new Node<>(data);
        int j;
        for(j = 0; j < i-1; j++){
            currNode = currNode.getNext(); 
        }
        if(j == i-1) {
            node.setNext(currNode.getNext());
            currNode.setNext(node);
            size += 1;
            return true;
        }
        return false;
    }

    public int indexOf(T element){
        currNode = start.getNext();
        if(this.isEmpty()){ return -1; }
        if(element == null){ return -1; }
        for(int i = 0; i <= size; i++){
            if(currNode == null){ return -1;}
            else if (currNode.getData() == element){ return i;}
            currNode = currNode.getNext();
        }
        return -1;
    }


    public T get(int i){
        if(this.isEmpty()){ return null;}
        if(i > size){return null; }
        currNode = start.getNext();
        for(int j = 0; j < i; j++){
            currNode = currNode.getNext();
        }
        if(currNode==null){ return null;}
        return currNode.getData();
    } 


    public void equalTo(T element){
        int i = 0;
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
        if(!this.isSorted){
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
        currNode = start.getNext();
        if(this.isEmpty()){
            return false;
        }
        Node<T> temp = start.getNext();
        for(int i = 0; i < size-n; i++){
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
        currNode = start.getNext();
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
        currNode = start.getNext();
        int i = 0;
        while(currNode != null){
            array[i] = currNode.getData();
            currNode = currNode.getNext();
            i++;
        }
        return array;
    }

    public boolean isEmpty(){
        return start.getNext() == null;
    }

    public void sort(){
        if(this.isEmpty()){ return; }
        currNode = start.getNext();
        Node<T> nextNode;
        while(currNode.getNext() != null){
            if(currNode==null){ return;}
            nextNode = currNode.getNext();
            while(currNode.getData().compareTo(nextNode.getData()) > 0){
                if(nextNode.getNext()==null){
                    currNode.setNext(null);
                    nextNode.setNext(currNode);
                    currNode = nextNode;
                    return;
                }
                currNode.setNext(nextNode.getNext());
                nextNode.setNext(currNode);
                currNode = nextNode;
            }
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
        currNode = start.getNext();
        Node<T> temp;
        if(currNode == null){
            return;
        }
        while(currNode.getNext()!=null){
            currNode.setData(null);
            currNode = currNode.getNext();
        }
    }

    public T remove(int i){
        for(int j = 0; j < i-1; j++){
        for(int j = 1; j < i-1; j++){

            currNode = currNode.getNext();
        }
        Node<T> temp = currNode.getNext();
        currNode.setNext(temp.getNext());
        return temp.getData();
    }


}

