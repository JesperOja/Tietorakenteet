public class Stack {
    private ListItem mTop = null;
    private int mSize;

    public Stack(){
        mTop = null;
        mSize = 0;
    }

    public void push(String aData){
        ListItem newItem = new ListItem();
        mSize++;
        newItem.setData(aData);
        newItem.setNext(mTop);
        mTop = newItem;
    }

    public ListItem pop(){
        ListItem removed;
        if(mTop == null){
            removed = null;
        }else{
            mSize--;
            removed = mTop;
            mTop = mTop.getNext();
        }
    
        return removed;
    }

    public void printItems(){
        ListItem list = mTop;
        while(list != null){
            System.out.println(list.getData() + ", ");
            list = list.getNext();
        }
    }

    public int getSize(){
        return this.mSize;
    }
}
