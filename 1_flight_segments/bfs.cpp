#include<bits/stdc++.h>

using std::vector;
using std::queue;

int distance(vector<vector<int> > &adj, int s, int t) {
 if(s==t)
 return 0;
 vector<int>dist(adj.size(),INT_MAX);
 queue<int>q;
 dist[s]=0;
 q.push(s);
 while(!q.empty())
 {
     int x=q.front();
     q.pop();
     for(int i=0;i<adj[x].size();i++)
     {
         int u=adj[x][i];
         if(dist[u]>dist[x]+1)
         {
             dist[u]=dist[x]+1;
             q.push(adj[x][i]);
         }
     }
 }
 if(dist[t]==INT_MAX)
 return -1;
 else
 return dist[t];
}

int main() {
  int n, m;
  std::cin >> n >> m;
  vector<vector<int> > adj(n, vector<int>());
  for (int i = 0; i < m; i++) {
    int x, y;
    std::cin >> x >> y;
    adj[x - 1].push_back(y - 1);
    adj[y - 1].push_back(x - 1);
  }
  int s, t;
  std::cin >> s >> t;
  s--, t--;
  std::cout << distance(adj, s, t);
}