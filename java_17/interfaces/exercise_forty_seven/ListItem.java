package java_17.interfaces.exercise_forty_seven;

public abstract class ListItem {
    protected ListItem rightLink;
    protected ListItem leftLink;
    protected Object value;

    public ListItem(Object object) {
        this.rightLink = null;
        this.leftLink = null;
        this.value = object;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    // line 24 is an example of setting an abstract method to "package-private"
    //      that is default access modifier in java
    abstract ListItem next();

    abstract ListItem setNext(ListItem listItem);

    abstract ListItem previous();

    abstract ListItem setPrevious(ListItem listItem);

    abstract int compareTo(ListItem listItem);


}


