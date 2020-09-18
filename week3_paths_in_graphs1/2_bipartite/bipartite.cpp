#include <iostream>
#include <vector>
#include <queue>

using std::vector;
using std::queue;
bool bfs(int x,int colorArr[],vector<vector<int> > &adj)
{
    queue<int> queue;
  queue.push(x);
  while(!queue.empty()) {
	int u = queue.front();
	queue.pop();
	for(int i=0; i < adj[u].size(); ++i) {
      int v = adj[u][i];
	  if (colorArr[v] == -1) {
        colorArr[v] = 1- colorArr[u];
		queue.push(v);
	  }
	  else if (colorArr[v] == colorArr[u])
        return true;
	}
  }
  return false;
}
int bipartite(vector<vector<int> > &adj) {
  int colorArr[adj.size()];
  for (int i = 0; i < adj.size(); ++i)
    colorArr[i] = -1;
  for(int u=0;u<adj.size();u++)
  {
      if(colorArr[u]==-1)
      {
          colorArr[u]=1;
          if(bfs(u,colorArr,adj))
          return 0;
      }
  }
  return 1;
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
  std::cout << bipartite(adj);
}