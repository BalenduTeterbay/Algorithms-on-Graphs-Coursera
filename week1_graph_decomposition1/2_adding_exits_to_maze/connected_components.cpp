#include <iostream>
#include <vector>

using std::vector;
using std::pair;
void explore(vector<vector<int>>&adj,bool visited[],int i)
{
    visited[i]=true;
    for(int v=0;v<adj[i].size();v++)
    if(!visited[adj[i][v]])
    explore(adj,visited,adj[i][v]);
}
int number_of_components(vector<vector<int> > &adj) {
  int res = 0;
  bool visited[adj.size()]={false};
  for(int i=0;i<adj.size();i++)
  {
      if(!visited[i])
     {
      explore(adj,visited,i);
      res++;
     }
  }
  return res;
}

int main() {
  size_t n, m;
  std::cin >> n >> m;
  vector<vector<int> > adj(n, vector<int>());
  for (size_t i = 0; i < m; i++) {
    int x, y;
    std::cin >> x >> y;
    adj[x - 1].push_back(y - 1);
    adj[y - 1].push_back(x - 1);
  }
  std::cout << number_of_components(adj);
}