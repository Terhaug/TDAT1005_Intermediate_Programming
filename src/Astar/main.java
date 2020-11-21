package Astar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
//Main class containing A*
public class main {
    static ArrayList<Node> nodes;
    static ArrayList<Node> closedSet = new ArrayList<>();
    static Queue<Node> nodeQueue;
    static Node xstartNode;
    static Node xgoalNode;
    static int checkedCount;
    static boolean drawOpenSet;
    static boolean drawClosedSet;
    static int NODE_AMOUNT = 0, EDGE_AMOUNT = 0;

    private static String getPath(String board){
        switch (board){
            case "5-1a":
                return "/Data/boards/board-5-1a.csv";
            case "5-1b":
                return "/Data/boards/board-5-1b.csv";
            case "5-2":
                return "/Data/boards/board-5-2.csv";
            case "5-3":
                return "/Data/boards/board-5-3.csv";
            default:
                return "Data/boards/board-5-1a.csv";
        }
    }

    static int calcDistance (Node thisNode, Node goal, int minimumWeight){
        return minimumWeight+Math.abs(goal.position.x-thisNode.position.x) +
                Math.abs(goal.position.y-thisNode.position.y);
    }
    // Used nodeTo update priorities.
    static void updateCost(Node node, Node nodeTo, Node goal, boolean dijkstra, boolean bfs){
        int bfsWeight = 1;
        if(nodeTo.weight == 0) bfsWeight = 0;
        //if(nodeTo.weight > 50) bfsWeight = Integer.MAX_VALUE/10;
        if(nodeTo.pathCost > node.pathCost + (!bfs?nodeTo.weight : bfsWeight)){
            nodeTo.pathCost = node.pathCost + (!bfs?nodeTo.weight : bfsWeight);
            nodeTo.prevNode = node; // Build linked list
            // Priority, fscore.
            nodeTo.pri = node.pathCost + (!bfs? nodeTo.weight : 1) + (!dijkstra && !bfs? calcDistance(nodeTo, goal, BoardReader.minimumWeight) : 0);

            // If we've already found the node, remove and add it again nodeTo see effect of changed priority.
            if(nodeQueue.contains(nodeTo)) {
                nodeQueue.remove(nodeTo);
                nodeQueue.add(nodeTo);
            }
            else {
                // We've discovered a new node, add it nodeTo find priority in line.
                nodeQueue.add(nodeTo);
                nodeTo.checked = true;
            }
        }
    }

// Method for finding neighbors north,south, east and west
    static ArrayList<Node> findNeighbors(Node n){
        ArrayList<Node> neighbors = new ArrayList<>();
        int[][] idGrid = BoardReader.idGrid;
        int col = n.position.x;
        int row = n.position.y;
        if(col > 0) neighbors.add(nodes.get(idGrid[col - 1][row]));
        if(col + 1 < idGrid.length) neighbors.add(nodes.get(idGrid[col + 1][row]));
        if(row > 0) neighbors.add(nodes.get(idGrid[col][row - 1]));
        if(row + 1 < idGrid.length) neighbors.add(nodes.get(idGrid[col][row + 1]));

        return neighbors;
    }
//Algorithm handling queue.
    static void astar(Node startNode, Node goalNode, String algorithm){
        boolean dijkstra = algorithm.equals("d");
        boolean bfs = algorithm.equals("bfs");
        nodeQueue =  bfs ? new LinkedList<>() :  new PriorityQueue<>(); // BFS uses a stack, an open queue
        startNode.weight = 0;
        startNode.pathCost = 0;
        startNode.checked = true;
        nodeQueue.add(startNode);

        while (!nodeQueue.isEmpty()) {
            Node curr = nodeQueue.poll(); // Remove first element from priorityqueue
            closedSet.add(curr);
            checkedCount++; // Counter used to check efficiency of algorithm
            if(curr != null && curr.id == goalNode.id) {
                System.out.println("found goal");
                reconstructPath(startNode,goalNode);
                break;
            }
            for(Node neighbor : findNeighbors(curr)) {
                // We've discovered a new node, add it nodeTo find priority in line.
                if(curr.prevNode != null && neighbor.id != curr.prevNode.id || curr.id == startNode.id) {
                    // Check for each neighbor which is not the node we came from
                    updateCost(curr, neighbor, goalNode, dijkstra, bfs);
                }
            }

        }
    }

    static void reconstructPath(Node startNode, Node goalNode){
        System.out.println("Reconstructing path");
        System.out.println("Path: ), open nodes: N, closed nodes: X");
        System.out.println("-----------------------------------------------------------------");
        Node n = goalNode;
        ArrayList<Node> path = new ArrayList<>();

        // Traverse the built linkedlist
        while (n != startNode) {
            path.add(n);
            n = n.prevNode;
        }

        for (int k = 0; k < BoardReader.idGrid[0].length; k++) {
            for (int j = 0; j < BoardReader.idGrid.length; j++) {
                Node node = nodes.get(BoardReader.idGrid[j][k]);
                String cell = node.cellData;
                if(node.cellData.equals("-1")) cell ="#";
                if(node.cellData.equals("1") || node.cellData.equals("2") || node.cellData.equals("3") || node.cellData.equals("4")) cell = ".";
                if(nodeQueue.contains(node) && drawOpenSet) cell = "N";
                else if(closedSet.contains(node) && drawClosedSet) cell = "X";
                if(path.contains(node)) cell = ")";
                if(node.id == startNode.id) cell = "A";
                if(node.id == goalNode.id) cell = "B";

                System.out.print(cell+ " ");
            }
            System.out.println();
        }
        System.out.println("Checked nodes: "+ checkedCount);
        System.out.println("Cost: "+(goalNode.pathCost));
    }

    public static void main(String[] args) {
        try{
            String boardNumber = "5-3"; //(Task1: "5-1a", Task2: "5-1b", Task3: "5-2", Task 4: "5-3")
            String boardFilePath = getPath(boardNumber);
            nodes = BoardReader.generateNodes(boardFilePath);
            drawOpenSet = false;
            drawClosedSet = false;
            BoardReader.printInitialBoards(nodes);
            String algorithm = ""; //bfs: bfs, d: dijkstra, empty: Astar
            astar(BoardReader.startNode, BoardReader.goalNode, algorithm);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
