public class Queue {
    private ListItem mTop = null;
    private int mSize;
    private ListItem helper = null;

    public Queue() {
        mTop = null;
        mSize = 0;
    }

    public void push(String aData) {
        ListItem newItem = new ListItem();
        if (mTop == null) {
            newItem.setData(aData);
            newItem.setNext(null);
            mTop = newItem;

            mSize++;
        } else {
            mSize++;
            newItem.setData(aData);
            newItem.setNext(null);
            if(helper == null){
                helper = newItem;
                mTop.setNext(helper);
            }
            else{
                helper.setNext(newItem);
                helper = newItem;
            }
        }

    }

    public ListItem pop() {
        ListItem removed;
        if (mTop == null) {
            removed = null;
        } else {
            mSize--;
            removed = mTop;
            mTop = mTop.getNext();
        }

        return removed;
    }

    public void printItems() {
        ListItem list = mTop;
        //System.out.println(list.getNext());
        while (list != null) {
            System.out.println(list.getData() + ", ");
            list = list.getNext();
        }
    }

    public int getSize() {
        return this.mSize;
    }
}
