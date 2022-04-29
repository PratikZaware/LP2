#include<bits/stdc++.h>
using namespace std;

void dfs(vector<int>graph[],bool visited[],int vertex)
{
	visited[vertex]=true;
	cout<<vertex<<" visited\n";
	for(int i=0;i<graph[vertex].size();i++)
	{
		int adjvertex=graph[vertex][i];
		if(!visited[adjvertex])
		{
			dfs(graph,visited,adjvertex);
		}
	}
}


void bfs(vector<int>graph[],bool visited[],int vertex)
{
	queue<int>que;
	que.push(vertex);
	cout<<vertex<<" visited\n";
	visited[vertex]=true;
	
	while(!que.empty())
	{
		int vertex=que.front();
		que.pop();
		
		for(int i=0;i<graph[vertex].size();i++)
		{
			int adj=graph[vertex][i];
			if(!visited[adj])
			{
				que.push(adj);
				visited[adj]=true;
				cout<<adj<<" visited\n";
			}
		}
	}
}

int main()
{
	int vertices,edges;
	vector<int>graph[100];
	
	cout<<"Enter no of vertices:";
	cin>>vertices;
	
	cout<<"Enter no of edges:";
	cin>>edges;
	
	for(int i=0;i<edges;i++)
	{
		int src,dest;
		cin>>src>>dest;
		
		graph[src].push_back(dest);
		graph[dest].push_back(src);
	}
	
	
	
	for(int i=0;i<10;i++)
	{
		for(int j=0;j<graph[i].size();j++)
		{
			cout<<"Edge between "<<i<<" and "<<graph[i][j]<<"\n";
		}
	}
	
	bool visited[100];
	for(int i=0;i<100;i++)
	{
		visited[i]=false;
	}
	int start;
	cout<<"Start : ";
	cin>>start;
	
//	dfs(graph,visited,start);


// 	visited array update krna na bhule


	bfs(graph,visited,start);
	
 	return 0;
}





