package java_17.interfaces.exercise_forty_seven;



public class Node extends ListItem {
    
    public Node(Object object) {
        super(object);
    }

    @Override
    public ListItem next() {
        // return list item to the right
        return this.rightLink;
    }

    @Override
    public ListItem setNext(ListItem listItem) {
        // sets the listItem as the right link 
        // return the rightLink
        this.rightLink = listItem;
        return this.rightLink;
    }

    @Override
    public ListItem previous() {
        // returns listItem to the left
        return this.leftLink;
    }

    @Override
    public ListItem setPrevious(ListItem listItem) {
        // sets the listItem as the left link
        // returns the left link
        this.leftLink = listItem;
        return this.leftLink;
    }

    public Integer getIntFromNode(ListItem listItem) {
        return Integer.valueOf(String.valueOf(listItem.getValue()));
    }

    @Override
    public int compareTo(ListItem listItem) {
        // compares the 'this' to the argument
        // use the value stored for comparison
        int x = this.getIntFromNode(this);
        int y = this.getIntFromNode(listItem);
        return x == y ? 0 : ((x > y) ? 1 : -1);
    }


}
