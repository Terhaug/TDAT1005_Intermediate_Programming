package Astar;

public class Node implements Comparable<Node>{
    int id;
    boolean checked;
    String cellData; //this is input from the files which is used to draw board
    Node prevNode; //References previous node in path, (Linked list)
    int pri; //score of the priority of a node, used for the priority queue (f-score)
    int pathCost; //The cost of traveling (g-cost)
    Position position; //the x and y coordinates on the 2D-grid
    int weight; //Weight of the node
    Node(){
        pathCost = Integer.MAX_VALUE/100; //Before evaluation, it is set to an infinite cost
        checked = false; // Used to see if a node has been checked before
    }

    @Override
    public int compareTo(Node node) {
        return pri-node.pri;
    }
}
