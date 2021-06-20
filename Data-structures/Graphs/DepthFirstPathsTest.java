package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import stack.Stack;

public class DepthFirstPathsTest {
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(DepthFirstPathsTest.class.getClassLoader().getResourceAsStream("road_find.txt")));
		
		// read the first line value 6
        int total = Integer.parseInt(br.readLine());

        // build a Graph according to the first line value
        Graph G = new Graph(total);
        // read the second line value 8
        int edgeNumbers = Integer.parseInt(br.readLine());
        // continue to loop to read two points of every edge related, use addEdge method, add edge
        for (int i = 1; i <= edgeNumbers; i++){
            String edge = br.readLine();//0 1
            String[] str = edge.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            G.addEdge(v,w);
        }

        // set start as 0
        DepthFirstPaths paths = new DepthFirstPaths(G, 0);
        // call pathTo(4), find path from 0 to 4, return stack
        Stack<Integer> path = paths.pathTo(4);
        StringBuilder sb = new StringBuilder();
        for (Integer v : path) {
            sb.append(v + " - ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
	}
}
