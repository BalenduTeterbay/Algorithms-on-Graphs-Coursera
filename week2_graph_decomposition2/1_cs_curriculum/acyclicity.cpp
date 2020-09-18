#include <iostream>
#include <vector>

using std::vector;
using std::pair;
bool iscyclic(vector<vector<int> > &adj,bool visited[],bool restack[],int v)
{
    visited[v]=true;
    restack[v]=true;
    for(auto it=adj[v].begin();it!=adj[v].end();it++)
    {
        if(!visited[*it])
        {
            if(iscyclic(adj,visited,restack,*it))
            return true;
        }
        else
        {
            if(restack[*it])
            return true;
        }
    }
    restack[v]=false;
    return false;
}
int acyclic(vector<vector<int> > &adj) {
  bool visited[adj.size()]={false};
  bool restack[adj.size()]={false};
  for(int i=0;i<adj.size();i++)
  if(!visited[i])
  if(iscyclic(adj,visited,restack,i))
  return 1;
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
  }
  std::cout << acyclic(adj);
}