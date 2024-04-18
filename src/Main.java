import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Graph<String> g1 = new Graph();

        // distance from Node1 -> Node4 = 3
        g1.addEdge("Node1", "Node2");
        g1.addEdge("Node2", "Node3");
        g1.addEdge("Node3", "Node4");

        HashMap<String, Integer> d1 = g1.bfs("Node1");
        System.out.println("Distance from Node1 to Node4 is: " + d1.get("Node4"));
        System.out.println("Distance from Node1 to Node1 is: " + d1.get("Node1"));
    }
}