import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    public static boolean bfs(int x,int[] color, ArrayList<Integer>[] adj)
    {
      Queue<Integer>q=new LinkedList<Integer>();
        q.add(x);
        while(!q.isEmpty())
        {
            int u=q.poll();
            for(int i=0;i<adj[u].size();i++)
            {
                int z=adj[u].get(i);
                if(color[z]==-1)
                {
                    color[z]=1-color[u];
                    q.add(z);
                }
                else if(color[z]==color[u])
                return true;
            }
        }
        return false;
    }

    private static int bipartite(ArrayList<Integer>[] adj) {
        int[] color=new int[adj.length];
        for(int i=0;i<adj.length;i++)
        color[i]=-1;
        for(int u=0;u<adj.length;u++)
        {
            if(color[u]==-1)
            {
                color[u]=1;
                if(bfs(u,color,adj))
                return 0;
            }
        }
        return 1;
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
        System.out.println(bipartite(adj));
    }
}