import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Graph<N> {
    private HashMap<N, ArrayList<N>> adjacencyList;
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }
    public void addEdge(N from, N to) {
        this.addNode(from);
        this.addNode(to);
        this.adjacencyList.get(from).add(to);
    }

    private void addNode(N a) {
        if (!this.adjacencyList.containsKey(a)) {
            this.adjacencyList.put(a, new ArrayList<>());
        }
    }

    public HashMap<N, Integer> bfs(N startNode) {
        // You could use a LinkedList, or an ArrayList, just treat it like a Stack
        Stack<N> nodesToVisit = new Stack();
        // Why don't we use a ArrayList? Because, HashSet lookup is O(1), while ArrayList lookup is O(n)
        HashSet<N> nodesVisited = new HashSet<>();
        // Easy data structure for us to keep track of distanecs
        HashMap<N, Integer> distances = new HashMap<>();

        // We have to put our start node so BFS knows where to start from
        nodesToVisit.add(startNode);
        // The distance of the start node from the start node is 0.
        distances.put(startNode, 0);

        // This means while there's still nodes to keep exploring, keeping running BFS.
        // Now, this will not catch non-connected components.
        while(!nodesToVisit.isEmpty()) {
            // Grab the top node from the stack
            N currentNode = nodesToVisit.pop();
            // Get the neighbors for this node
            ArrayList<N> nodeNeighbors = this.adjacencyList.get(currentNode);

            // For each neighbor of the current node
            for(N neighbor : nodeNeighbors) {
                // If we've already visited this node, don't explore it (this prevents infinite loops from back tracking)
                // This also means that BFS won't really find the *shortest* distance. You will learn about djikstras in 191 and 250
                if (!nodesVisited.contains(neighbor)) {
                    // Add this neighbor to our queue to explore
                    nodesToVisit.add(neighbor);
                    // Add this to our visited nodes to make sure it doesn't get explored again
                    nodesVisited.add(neighbor);
                }

                // Let's break this down. We get the distance of the parent node (currentNode) of this neighbor node
                // That's because a neighbor node is always going to just be 1 away from its parent in an unweighted graph.
                // Otherwise, it wouldn't be the parent.
                distances.put(neighbor, distances.get(currentNode) + 1);
            }
        }

        return distances;
    }
}