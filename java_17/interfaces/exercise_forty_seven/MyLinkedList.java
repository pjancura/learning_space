package java_17.interfaces.exercise_forty_seven;

public class MyLinkedList implements NodeList {
    // write code 
    private ListItem root;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return root;
    }

    @Override
    public boolean addItem(ListItem listItem) {
        // System.out.println("MyLinkedList.addItem()");
        if (this.root == null) {
            System.out.println("\t\t\t\tfirst root: " + listItem.getValue());
            this.root = listItem;
            return true;
        }
        ListItem currNode = this.root;
        while (true) {
            System.out.println("currNode: " + currNode.getValue() + "\tlistItem: " + listItem.getValue());
            if (currNode.next() == null) {
                if (currNode.compareTo(listItem) == 0) {
                    System.out.println("\t\t\t\tfound duplicate");
                    return false;
                }
                if (currNode.compareTo(listItem) == 1) {
                    System.out.println("\t\t\t\tadding " + listItem.getValue() + "\tbefore: " + currNode.getValue() + "\t\t.next() == null");
                    if (currNode.previous() == null) {
                        listItem.setNext(currNode);
                        currNode.setPrevious(listItem);
                        this.root = listItem;
                        return true;
                    }
                    currNode.previous().setNext(listItem);
                    if (currNode.previous() != null) {
                        listItem.setPrevious(currNode.previous());
                    }
                    currNode.setPrevious(listItem);
                    listItem.setNext(currNode);
                    return true;
                }
                System.out.println("\t\t\t\tadded at end: " + listItem.getValue());
                currNode.setNext(listItem);
                listItem.setPrevious(currNode);
                return true;
            }
            if (currNode.compareTo(listItem) == 0) {
                System.out.println("\t\t\t\tfound duplicate");
                return false;
            } 
            if (currNode.compareTo(listItem) == -1) {
                currNode = currNode.next();
                continue;
            } 
            if (currNode.compareTo(listItem) == 1) {
                System.out.println("\t\t\t\tadding: " + listItem.getValue() + "\tbefore: " + currNode.getValue() + "\t\t.next() NOT null");
                if (currNode.previous() == null) {
                    listItem.setNext(currNode);
                    currNode.setPrevious(listItem);
                    this.root = listItem;
                    return true;
                }
                currNode.previous().setNext(listItem);
                if (currNode.previous() != null) {
                    listItem.setPrevious(currNode.previous());
                }
                currNode.setPrevious(listItem);
                listItem.setNext(currNode);
                return true;
            }
        }
    }

    @Override
    public boolean removeItem(ListItem listItem) {
        // System.out.println("MyLinkdList.removeItem()");
        if (this.root == null || listItem == null) {
            return false;
        }
        ListItem currNode = this.root;
        while (currNode != null) {
            if (currNode.compareTo(listItem) == 0) {
                if (currNode.next() != null) {
                    currNode.previous().setNext(currNode.next());
                } else {
                    currNode.setNext(null);
                }
                return true;
            }
            currNode = currNode.next();
        }
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        // System.out.println("MyLinkedList.traverse()");
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            // print all values of List
            while (root != null) {
                System.out.print(root.getValue() + ", ");
                root = root.next();
            }
        }
    }
}