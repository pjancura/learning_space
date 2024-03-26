package java_17.interfaces.exercise_forty_seven;

public interface NodeList {
    ListItem getRoot();

    boolean addItem(ListItem listItem);

    boolean removeItem(ListItem listItem);

    void traverse(ListItem root);
}
