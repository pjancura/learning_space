package java_17.interfaces.exercise_forty_seven;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchTree implements NodeList {
    private ListItem root;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem item) {
        if (this.root == null) {
            this.root = item;
            return true;
        }
        if (item == null) {
            return false;
        }
        // System.out.println(" ");
        ListItem currNode = this.root;
        boolean adding = true;
        while (adding) {
            // System.out.println("\t\t\t\t\t" + currNode.getValue());
            if (currNode.compareTo(item) == 0) {
                System.out.println("\t\t\t\t\tFOUND DUPLICATE");
                break;
            } else if (currNode.compareTo(item) == 1) {
                if (currNode.previous() != null) {
                    currNode = currNode.previous();
                    continue;
                }
                currNode.setPrevious(item);
                return true;
            } else {
                if (currNode.next() != null) {
                    currNode = currNode.next();
                    continue;
                }
                currNode.setNext(item);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem node) {
        if (node == null || root == null) {
            return false;
        }
 
        ArrayList<ListItem> foundItems = this.findValue(node);
        ListItem currNode = foundItems.get(0);
        ListItem parent = foundItems.get(1);
        System.out.println("Deleting: " + node.getValue());
        String currNodeValue = "";
        String parentNodeValue = ""; 
        if (currNode == null) {
            currNodeValue = "null";
        } else {
            currNodeValue = String.valueOf(currNode.getValue());
        }
        if (parent == null) {
            parentNodeValue = "null";
        } else {
            parentNodeValue = String.valueOf(parent.getValue());
        }
        System.out.println("FOUND: " + currNodeValue + "\tPARENT: " + parentNodeValue);
        if (currNode == null) {
            System.out.println("Item not found in tree");
            return false;
        } else {
            System.out.println("Found a match, removing item");
            performRemoval(currNode, parent);
            return true;
        }
    }

        // while (true) {
        //     if (currNode == null) {
        //         System.out.println("Couldn't find the matching node");
        //         return false;
        //     }
        //     System.out.println("currNode: " + currNode.getValue());
        //     if (node.compareTo(currNode) == 0) {
        //         System.out.println("Found a match");
        //         performRemoval(node, parent);
        //         return true;
        //     }
        //     parent = currNode;
        //     if (currNode.compareTo(node) == -1) {
        //         currNode = currNode.next();
        //     } else {
        //         currNode = currNode.previous();
        //     }
        // }
    
    // Call performRemoval() from removeItem() when the item is found
    private void performRemoval(ListItem itemToRemove, ListItem parent) {
        // item ToRemove has no branches
        if (itemToRemove.previous() == null && itemToRemove.next() == null) {
            if (parent != null) {
                if (itemToRemove == parent.next()) {
                    parent.setNext(null);
                } else {
                    parent.setPrevious(null);
                }
            } else {
                this.root = null;
            }
        }
        // itemToRemove has no left branch
        else if (itemToRemove.previous() == null) {
            if (parent != null) {
                if (itemToRemove == parent.next()) {
                    parent.setNext(itemToRemove.next());
                } else {
                    parent.setPrevious(itemToRemove.next());
                }
            }
            itemToRemove = itemToRemove.next();
        } // itemToRemove has no right branch
        else if (itemToRemove.next() == null) {
            if (parent != null) {
                if (itemToRemove == parent.next()) {
                    parent.setNext(itemToRemove.previous());
                } else {
                    parent.setPrevious(itemToRemove.previous());
                }
            }
            itemToRemove = itemToRemove.previous();
        } // itemToRemove has left and right branches
        else {
            ListItem minItem = this.findMinValue(itemToRemove.next());
            ArrayList<ListItem> foundItems = this.findValue(minItem);
            ListItem currNode = foundItems.get(0);
            ListItem newParent = foundItems.get(1);
            itemToRemove.value = minItem.getValue();
            System.out.println("currNode: " + currNode.getValue() + " newParent: " + newParent.getValue());
            this.performRemoval(currNode, newParent);
        }


    }

    @Override
    public void traverse(ListItem root) {
        // System.out.println("SearchTree.traverse()");
        if (root == null) {
            // System.out.println("  ROOT == NULL\n");
            return;
        }
        // System.out.print("ROOT: " + root.getValue() + "  ");
        // System.out.print("root.previous(), ");
        this.traverse(root.previous());
        System.out.print(root.getValue() + ", ");
        // System.out.print("ROOT: " + root.getValue() + "  ");
        // System.out.print("root.next(), ");
        this.traverse(root.next());

    }

    public ArrayList<ListItem> findValue(ListItem listItem) {
        ArrayList<ListItem> foundItems = new ArrayList<ListItem>(Arrays.asList(null, null));
        if (listItem == null || this.root == null) {
            return foundItems;
        }
        int counter = 1;

        ListItem currNode = this.root;
        while (true) {
            if (currNode == null) {
                System.out.println("Value doesn't exist in tree");
                break;
            }
            if (currNode.compareTo(listItem) == 0) {
                foundItems.set(0, currNode);        // sets the node where the value was found
                System.out.println("Found Item: " + foundItems.get(0).getValue());
                break;
            }
            foundItems.set(1, currNode);            // sets parent node
            if (currNode.compareTo(listItem) == 1) {
                currNode = currNode.previous();
            } else {
                currNode = currNode.next();
            }
            counter++;
        }
        System.out.println("\tLoop Count: " + counter);
        return foundItems;
    }

    public ListItem findMinValue(ListItem startNode) {
        if (startNode == null) {
            return null;
        }
        ListItem minValue = startNode;
        while (minValue.previous() != null) {
            System.out.println("Current Min Value: " + minValue.getValue());
            minValue = minValue.previous();
        }
        return minValue;
    }
}
