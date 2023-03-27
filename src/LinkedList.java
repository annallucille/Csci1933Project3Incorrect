import java.util.List;


public class LinkedList<T extends Comparable<T>> implements List<T> {
    private boolean isSorted;
    private Node start;
    private List list;
    private Node currNode = start.getNext();

    public LinkedList(){
        this.start = new Node("\0");
        isSorted = false;
    }

    public void add(Node node){
        if(this.start.getNext()==null){
            this.start.setNext(node);
        }

        while(currNode.getNext()!=null){
            currNode = currNode.getNext();
        }
        currNode.setNext(node);
    }

    public boolean sort(){
        while(currNode.getNext()!=null){
            Node nextNode = currNode.getNext();
            Node temp;
            if(currNode.getData().compareTo(nextNode.getData())==1){
                temp = nextNode;
                nextNode.setNext(currNode);
                currNode = temp.getNext();
            }
            else{
                currNode = nextNode;
            }
        }
        isSorted = true;
        return isSorted;
    }


}
