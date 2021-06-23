package graph_advanced;

public class DirectedEdge {
	private final int v;
	private final int w;
	private final double weight;
	
	public DirectedEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	// get weight of edge
	public double weight() {
		return weight;
	}
	
	// get the start point of directed edge
	public int from() {
		return v;
	}
	
	public int to() {
		return w;
	}
}
