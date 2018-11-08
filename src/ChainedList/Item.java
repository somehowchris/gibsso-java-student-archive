package ChainedList;

public class Item {
    private Object obj = null;
    private Item next = null;
    private Item previous = null;

    public Object getObj() {
        return obj;
    }

    public Item(Object obj,Item history) {
        this.obj = obj;
        previous = history;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Item getNext() {
        return next;
    }

    public void setNext(Item item) {
        this.next = item;
    }

    public boolean hasNext(){
        return next != null;
    }

    public Item getPrevious() {
        return previous;
    }

    public void setPrevious(Item previous) {
        this.previous = previous;
    }
}
