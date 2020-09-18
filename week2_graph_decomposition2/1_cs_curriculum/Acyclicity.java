import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
    public static boolean iscyclic(ArrayList<Integer>[] adj,boolean[] visited,boolean[] restack,int v)
    {
        visited[v]=true;
        restack[v]=true;
        for(int i=0;i<adj[v].size();i++)
        {
            if(!visited[adj[v].get(i)])
            {
                if(iscyclic(adj,visited,restack,adj[v].get(i)))
                return true;
            }
            else
            {
                if(restack[adj[v].get(i)])
                return true;
            }
        }
        restack[v]=false;
        return false;
    }
    private static int acyclic(ArrayList<Integer>[] adj) {
        boolean[] visited=new boolean[adj.length];
        boolean[] restack=new boolean[adj.length];
        for(int i=0;i<adj.length;i++)
        if(!visited[i])
        if(iscyclic(adj,visited,restack,i))
        return 1;
        return 0;
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
        System.out.println(acyclic(adj));
    }
}
