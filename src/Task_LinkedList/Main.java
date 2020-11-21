package Task_LinkedList;

public class Main {
    public static void main(String[] args) {
//        MyLinkedList list = new MyLinkedList(null);
//        list.traverse(list.getRoot());
//
//        String stringData = "0 1 3 2 9 8 5 7";
//        String[] data = stringData.split(" ");
//        for(String s : data){
//            list.addItem(new Node(s));
//        }
//        list.traverse(list.getRoot());
//        list.removeItem(new Node("3"));
//        list.traverse(list.getRoot());
//
//        list.removeItem(new Node("2"));
//        list.traverse(list.getRoot());
//
//        list.removeItem(new Node("9"));
//        list.traverse(list.getRoot());
//
//        list.removeItem(new Node("4"));
//        list.traverse(list.getRoot());

        //SEARCH TREE:
        SearchTree tree = new SearchTree(null);
        tree.traverse(tree.getRoot());

        String stringData = "0 1 3 2 9 8 5 7";
       // String stringData = "Grimstad Kristiandsand Bergen Oslo Lillehammer Trondheim Grimstad Tromsø Bodø";
        String[] data = stringData.split(" ");
        for(String s : data){
            tree.addItem(new Node(s));
        }
        tree.traverse(tree.getRoot());
        tree.removeItem(new Node("3"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("2"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("9"));
        tree.traverse(tree.getRoot());

        tree.removeItem(new Node("4"));
        tree.traverse(tree.getRoot());
    }
}
