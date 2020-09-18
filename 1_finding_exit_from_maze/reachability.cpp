#include<bits/stdc++.h>

using std::vector;
using std::pair;

bool explore(vector<vector<int> > &adj,bool visited[],int x,int y)
{
    if(x==y)
    return true;
    visited[x]=true;
    for(auto it=adj[x].begin();it!=adj[x].end();it++)
    if(!visited[*it])
   { 
       if(explore(adj,visited,*it,y))
       return true;
   }
   return false;
}
int reach(vector<vector<int> > &adj, int x, int y) {
  bool visited[adj.size()]={false};
  if(explore(adj,visited,x,y)==true)
  return 1;
  else
  return 0;
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
  int x, y;
  std::cin >> x >> y;
  std::cout << reach(adj, x - 1, y - 1);
}