package Task_LinkedList;

public class SearchTree implements NodeList {
    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null){
            //The tree was empty, so our item becomes the head of the tree:
            this.root = newItem;
            return true;
        }

        //Otherwise, start comparing from the head of the tree:
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = (currentItem.compareTo(newItem));
            if(comparison < 0){
                //Newitem is greater, move right if possible:
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                }else{
                    //There is no node to the right, so add at this point:
                    currentItem.setNext(newItem);
                    return true;
                }
            }else if(comparison > 0){
                //New item is less, move left if possible:
                if(currentItem.previous() != null){
                    currentItem = currentItem.previous();
                }else{
                    //There is no node to the left, so add at this point:
                    currentItem.setPrevious(newItem);
                    return true;
                }
            }else{
                //Equal, so don't add:
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }
        //We cant actually get here, but java complaints if theres no return
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null){
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;

        while (currentItem != null){
            int comparison = (currentItem.compareTo(item));
            if(comparison < 0){
                parentItem = currentItem;
                currentItem = currentItem.next();
            }else if(comparison > 0 ){
                parentItem = currentItem;
                currentItem = currentItem.previous();
            }else{
                //Equal: we've found the item so remove it:
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval(ListItem item, ListItem parent){
        //Remove item from the tree;
        if(item.next() == null){
            //No right tree, so make parent point to left tree(which may be null)
            if(parent.next() == item){
                // item is right child of its parent:
                parent.setNext(item.previous());
            }else if(parent.previous() == item){
                //Item is left child of its parent:
                parent.setPrevious(item.previous());
            }else{
                // parent must be item, which means we were looking at the root of the tree:
                this.root = item.previous();
            }
        }else if(item.previous() == null){
            // No left tree, so make parent point to right tree(which may be null)
            if(parent.next() == item){
                //Item is right child of its parent
                parent.setNext(item.next());
            }else if(parent.previous() == item){
                //Item is left child of its parent:
                parent.setPrevious(item.next());
            }else {
                //Again we are deleting the root
                this.root = item.next();
            }
        }else{
            //Neither left nor right are null, deletion is now a lot trickier!
            //From the right sub-tree, find the smallest value (i.e., the leftmost).
            ListItem current = item.next();
            ListItem leftMostParent = item;
            while(current.previous() != null){
                leftMostParent = current;
                current = current.previous();
            }
            //Now put the smallest value into our node to be deleted:
            item.setValue(current.getValue());
            //And delete the smallest
            if(leftMostParent == item){
                //There was no leftmost node, so "Current" points to the smallest node
                item.setNext(current.next());
            }else{
                //Set the smallest nodes parent to point to the smallest nodes right child
                leftMostParent.setPrevious(current.next());
            }
        }
    }

    @Override
    public void traverse(ListItem root) {
        // Recursive method
        if(root != null){
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }

    }
}
