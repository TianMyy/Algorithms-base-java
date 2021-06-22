package graph_advanced;

public class Edge implements Comparable<Edge> {
	private final int v; // point one
	private final int w; // point two
	private final double weight; // weighted value of current edge
	
	public Edge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public double weight() {
		return weight;
	}
	
	// get a point of edge
	public int either() {
		return v;
	}
	
	// get another point of edge except point vertex
	public int other(int vertex) {
		if(vertex == v) {
			return w;
		}else {
			return v;
		}
	}
	
	// compare weight between current edge and edge that
	// if current is higher, return 1, if the same return 0, else return -1
	@Override
	public int compareTo(Edge that) {
		int comp;
		if(this.weight() > that.weight) {
			comp = 1;
		}else if(this.weight() == that.weight) {
			comp = 0;
		}else {
			comp = -1;
		}
		return comp;
	}
}
