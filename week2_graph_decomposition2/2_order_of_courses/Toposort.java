import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {
    public static void toposortutil(ArrayList<Integer>[] adj,int used[],ArrayList<Integer>order,int v)
    {
        used[v]=1;
        for(int i=0;i<adj[v].size();i++)
        {
            if(used[adj[v].get(i)]==0)
            toposortutil(adj,used,order,adj[v].get(i));
        }
        order.add(0,v);
    }
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int used[] = new int[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        for(int i=0;i<adj.length;i++)
        if(used[i]==0)
        toposortutil(adj,used,order,i);
        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {
      //write your code here
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
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}
