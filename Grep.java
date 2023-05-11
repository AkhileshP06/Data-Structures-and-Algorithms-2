import java.util.LinkedList;

class Grep {
  private int V; // number of vertices
  private LinkedList<Integer>[] adj; // adjacency list
  private int[][] adjMatrix; // adjacency matrix

  // Constructor
  Grep(int V) {
    this.V = V;
    adj = new LinkedList[V];
    for (int i = 0; i < V; i++)
      adj[i] = new LinkedList<Integer>();
    adjMatrix = new int[V][V];
  }

  // Function to add an edge to the graph using the adjacency list representation
  void addEdgeList(int v, int w) {
    adj[v].add(w); // Add w to v's list.
  }

  // Function to add an edge to the graph using the adjacency matrix representation
  void addEdgeMatrix(int i, int j) {
    adjMatrix[i][j] = 1;
  }
  void displayList() {
	    for (int i = 0; i < V; i++) {
	      System.out.print("Vertex " + i + ": ");
	      for (Integer j : adj[i]) {
	        System.out.print(j + " ");
	      }
	      System.out.println();
	    }
	  }

	  // Function to display the adjacency matrix representation of the graph
	  void displayMatrix() {
	    for (int i = 0; i < V; i++) {
	      for (int j = 0; j < V; j++) {
	        System.out.print(adjMatrix[i][j] + " ");
	      }
	      System.out.println();
	    }
	  }
	  public static void main(String[] args) {
		  // Create a graph with 4 vertices
		  Grep g = new Grep(4);

		  // Add some edges using the adjacency list representation
		  g.addEdgeList(0, 1);
		  g.addEdgeList(0, 2);
		  g.addEdgeList(1, 2);
		  g.addEdgeList(2, 0);
		  g.addEdgeList(2, 3);

		  // Add some edges using the adjacency matrix representation
		  g.addEdgeMatrix(1, 3);
		  g.addEdgeMatrix(3, 1);

		  // Display the adjacency list representation of the graph
		  g.displayList();

		  // Display the adjacency matrix representation of the graph
		  g.displayMatrix();
		}

}
