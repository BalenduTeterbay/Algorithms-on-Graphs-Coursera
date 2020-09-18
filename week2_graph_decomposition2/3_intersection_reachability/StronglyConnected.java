import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnected {
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		int visited[] = new int[adj.length];
		for(int i = 0; i < adj.length; i++){
			if(visited[i] == 0){
				dfs(adj, i, visited, stack);
			}
		}
	    ArrayList<Integer>[] rAdj = reverseEdges(adj);
		visited = new int[adj.length];
		
	    while (! stack.isEmpty()) {
			int x = stack.pop();
			
			if(visited[x] == 0){
				dfs(rAdj, x, visited, new Stack<Integer>());
				result++;
			}
		}
        return result;
    }
	
	private static void dfs(ArrayList<Integer>[] adj, int x, int visited[], Stack<Integer> stack){
	    visited[x] = 1;
		for(int i = 0; i < adj[x].size(); i++){
			if(visited[adj[x].get(i)] == 0){
				visited[adj[x].get(i)] = 1;
				dfs(adj, adj[x].get(i), visited, stack);
			}	
		}
        stack.push(x);
	}
	
	private static ArrayList<Integer>[] reverseEdges(ArrayList<Integer>[] adj){
		ArrayList<Integer>[] rAdj = new ArrayList[adj.length];
		for(int i = 0; i < adj.length; i++){
			rAdj[i] = new ArrayList<Integer>();
		}	
		for(int i = 0; i < adj.length; i++){
			for(int j = 0; j < adj[i].size(); j++){
				rAdj[adj[i].get(j)].add(i);
			}
		}
		return rAdj;
	}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}