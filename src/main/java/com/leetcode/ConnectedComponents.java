package com.leetcode;

import java.util.ArrayList;

class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        int components=0;
        int[] visited = new int[n];

        ArrayList<Integer>[] adjList = new ArrayList[n];

        for(int i=0;i<n;i++) {
            adjList[i]=new ArrayList<Integer>();
        }

        for(int i=0;i<edges.length;i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        for(int i=0;i<n;i++) {
            if(visited[i]==0) {
                components++;
                dfs(visited,i,adjList);
            }
        }
        return components;
    }

    public void dfs(int[] visited, int element, ArrayList<Integer>[] adjList) {
        visited[element] = 1;

        for(int i=0;i<adjList[element].size();i++) {
            if(visited[adjList[element].get(i)]==0) {
                dfs(visited, adjList[element].get(i),adjList);
            }
        }
    }
}


