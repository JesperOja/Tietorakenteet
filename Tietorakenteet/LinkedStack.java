import java.util.*;

public class LinkedStack {
    private LinkedList<String> list;
    private int mSize = 0;

    public LinkedStack(){
        list = new LinkedList<String>();
    }

    public void push(String aData){
        list.add(aData);
        mSize++;
    }

    public String pop(){
        String removed;
        if(list == null){
            removed = null;
        }else{
            mSize--;
            removed = list.removeLast();
        }
    
        return removed;
    }

    public void printItems(){
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());    
        }
    }

    public int getSize(){
        return this.mSize;
    }
}
