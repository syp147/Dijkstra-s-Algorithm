import java.text.*;
import java.util.*; 
import java.lang.*; 
import java.security.*;
import java.math.*;
import java.io.*; 

  
public class Shortest_Path { 
   
    static final int V = 9; 
    
    int minimumdistanceance(int distance[], Boolean sptSet[]) 
    { 
        //  initialization of minimum value 
        
        int minimum = Integer.MAX_VALUE;
        int minimum_index = -1; 
  
        for (int i = 0; i < V; i++) 
			
            if (sptSet[i] == false && distance[i] <= minimum) { 
			
                minimum = distance[i]; 
                minimum_index = i; 
            
			} 
  
        return minimum_index; 
    } 
  
    // Printing the array 
	
    void printSolution(int distance[]) 
    { 
        System.out.println("Vertex \t\t distanceance from Source"); 
        for (int i = 0; i < V; i++) 
            System.out.println(i + " \t\t\t\t\t " + distance[i]); 
    } 
  
    // Dijkstra's shortest_path finding the distanceance from source using adjacent matrix 9x9
    
    
    void dijkstra(int graph[][], int src) 
    { 
        int distance[] = new int[V];
        
        Boolean sptSet[] = new Boolean[V]; 
  

        for (int i = 0; i < V; i++) { 
            
            distance[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
       
        } 
  

        distance[src] = 0; 
  
        for (int cnt = 0; cnt < V - 1; cnt++) { 
        
            int u = minimumdistanceance(distance, sptSet); 
  
            sptSet[u] = true; 
 
            for (int i = 0; i < V; i++) 

                if (!sptSet[i] && graph[u][i] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][i] < distance[i]) {
                    
                    distance[i] = distance[u] + graph[u][i]; 
                    
                }
                
                   
        } 
  
        printSolution(distance); 
    } 
  
    // void main with the input 9 x 9 matrix 
    public static void main(String[] args) 
    { 
      
        int graph[][] = new int[][] { 
            { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                     
             { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            
             { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            
             { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            
             { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            
             { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
            
             { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
            
             { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
        
             { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 
             
             
        Shortest_Path t = new Shortest_Path(); 
        
        t.dijkstra(graph, 0); 
    } 
} 