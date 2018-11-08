package ChainedList;

import java.util.Iterator;

public class ChainedList implements Iterable<Object>{

    private Item first = null;
    private int count = 0;

    public Object last(){
        Item i = first;
        while(i.hasNext()){
            i = i.getNext();
        }
        return i.getObj();
    }

    public Item lastItem(){
        Item i = first;
        if(first != null) {
            while (i.hasNext()) {
                i = i.getNext();
            }
        }
        return i;
    }

    public void add(Object obj){
        Item item = new Item(obj,lastItem());
        if(first != null){
            lastItem().setNext(item);
        }else{
            first = item;
        }
    }

    public Object first(){
        return first.getObj();
    }
    public Item firstItem(){
        return first;
    }
    public Object next(){
        Item item = first;
        for(int i = 0;i<count;i++){
            item = item.getNext();
        }
        count++;
        return item.getObj();
    }
    public void addFirst(Object obj){
        Item item = new Item(obj,null);
        if(first != null){
            item.setNext(first);
        }
        first.setPrevious(item);
        first = item;
    }
    public void removeLast(){
        Item last = lastItem();
        Item search = first;
        while(search.getNext() != last){
            search = search.getNext();
        }
        search.setNext(null);
        last = null;
    }
    public int count(){
        int i = 1;
        Item counter = first;
        if(counter != null) {
            while (counter.hasNext()) {
                counter = counter.getNext();
                i++;
            }
            return i;
        }else{
            return 0;
        }
    }
    public void removeFirst(){
        first = first.getNext();
        first.setPrevious(null);
    }
    public boolean contains(Object obj){
        Item search = first;
        while(search.getObj().equals(obj) == false){
            if(search.hasNext()) {
                search = search.getNext();
            }else{
                return false;
            }
        }
        return true;

    }
    public ChainedList(Object obj) {
        Item item = new Item(obj,null);
        first = item;
    }

    public ChainedList() {
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object> () {
            Item current = null;
            @Override
            public boolean hasNext() {
                if(current != null) {
                    return current.hasNext();
                }else{
                    if(first != null){
                        return true;
                    }else {
                        return false;
                    }
                }
            }

            @Override
            public Object next() {
                boolean next = false;
                if(current == null && first != null){
                    current = first;
                    next = true;
                }else if(current.hasNext()){
                    next = true;
                    current = current.getNext();
                }
                Object obj = current.getObj();
                return next ? obj : null;
            }
        };
    }
}
