public class ListItem {
    private String mData;
    private ListItem mNext;

    public String getData(){
        return this.mData;
    }

    public ListItem getNext(){
        return this.mNext;
    }

    public void setData(String mData){
        this.mData = mData;
    }

    public void setNext(ListItem mNext){
        this.mNext = mNext;
    }
}
