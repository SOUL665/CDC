// Answer - 1

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int V = sc.nextInt();
        
        if (!sc.hasNextInt()) return;
        int E = sc.nextInt();
        
        List<List<Integer>> adj = new ArrayList<>(V);
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            if(u >= 0 && u < V && v >= 0 && v < V){
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
        }
        
        for (int i = 0; i < V ; i++){
            System.out.println("Adjacency list of vertex " + i);
            System.out.print("head");
            for(int neighbor : adj.get(i)){
                System.out.println(" ->" + neighbor);
            }
            System.out.println();
        }
        
        sc.close();
    }
}


// Answer - 2

import java.util.*;

public class Main{
    static int visitedCount = 0;
    static List<List<Integer>> adj;
    static boolean[] visited;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        int V = sc.nextInt();
        
        if(!sc.hasNextInt()) return;
        int E = sc.nextInt();
        
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < E ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        visited = new boolean[V];
        boolean hasCycle = false;
        
        for (int i = 0; i < V ; i++){
            if(!visited[i]){
                if(isCyclic(i , -1)){
                    hasCycle = true;
                    break;
                }
            }
        }
        
        System.out.println(hasCycle ? 1 : 0);
        System.out.println("Number of nodes visited: " + visitedCount);
        sc.close();
    }
    
    static boolean isCyclic(int u , int p){
        visited[u] = true;
        visitedCount++ ; 
        for (int v : adj.get(u)){
            if(!visited[v]){
                if (isCyclic(v,u)) return true;
            }
            else if(v != p){
                return true;
            }
        }
        return false;
    }
}
