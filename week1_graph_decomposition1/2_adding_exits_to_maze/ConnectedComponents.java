import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    public static void explore(ArrayList<Integer>[] adj,boolean[] visited,int i)
    {
        visited[i]=true;
        for(int v=0;v<adj[i].size();v++)
        if(!visited[adj[i].get(v)])
        explore(adj,visited,adj[i].get(v));
        
        
    }
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        boolean[] visited=new boolean[adj.length];
        for(int i=0;i<adj.length;i++)
        {
            if(!visited[i])
            {
                explore(adj,visited,i);
                result++;
            }
        }
        return result;
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
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}
