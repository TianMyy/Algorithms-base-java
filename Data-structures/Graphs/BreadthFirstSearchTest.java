package graph;

public class BreadthFirstSearchTest {
	public static void main(String[] args) {
		Graph G = new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(5,3);
        G.addEdge(5,4);
        G.addEdge(3,4);
        G.addEdge(4,6);
        G.addEdge(7,8);
        G.addEdge(9,11);
        G.addEdge(9,10);
        G.addEdge(9,12);
        G.addEdge(11,12);

        BreadthFirstSearch search = new BreadthFirstSearch(G, 0);
        System.out.println("number of linked points to start point 0 is: " + search.count());
        System.out.println("is point 5 connected to start point 0: " + search.marked(5));
        System.out.println("is point 7 connected to start point 0: " + search.marked(7));
	}
}
