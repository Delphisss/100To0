// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Stack;
import java.util.*;

@SuppressWarnings("unchecked")
public class HashGraph extends Graph{
    
    int p; // Big Prime (for PolyHash())
    int x; // Small number (for PolyHash())
    
    // This is complete, no need to edit
    public HashGraph(int cap, int p, int x){
        super(cap); // Forward the parameter to Graph's constructor
        this.p = p;
        this.x = x;
    }
    
    
    public static int polyHash(String s, int p, int x){
        // Pls use code from the previous problem
        int hash = 0;
        for(int i = s.length()-1; i >= 0; i--){
            hash = (hash * x + (int)s.charAt(i)) % p;
        }
        return hash;
    }
    
    public int getListIndex(String s){
        // Pls use code from the previous problem
        int index = polyHash(s, this.p, this.x) % cap; // Hash and Cardinality Fix
        if(vertexList[index] == null) return index; // 2.
        if(vertexList[index].strKey == s) return index; // 3.
         // Quadratic Probing
        for (int k = 0; k < cap; ++k){
            index = (index + k) % cap;
            if(vertexList[index] == null) return index; // 2.
            if(vertexList[index].strKey == s) return index; // 3.
        }
        return index;
    }
    
    
    public void addVertex(String key){
        if (size==cap){
            System.out.println("Vertex list is full. You need to recreate the Graph");
            return;
        }
        
        // Map the String key to the array index (use getListIndex())
        // Pls use code from the previous problem as the starter
        Vertex v = new Vertex(key);
        int index = getListIndex(key);
        vertexList[index] = v;
        adjacencyList[index] = new LinkedList<Integer>();
        size++;
    }
    
    public void addEdge(String source, String destination){
        // Map String's source and destination (city name) to Integer's u, v (array index)
        int srcHash = getListIndex(source);
        int desHash = getListIndex(destination);
        // You may call super.addEdge(u, v); for simpler implementation
        super.addEdge(srcHash, desHash);
    }
    

    public void BFS(Vertex s){
        // Set all Vertex.dist to Infinity (Use Integer.MAX_VALUE to represent Infinity)
        for(Vertex v : vertexList){
            if(v != null)
            v.dist = Integer.MAX_VALUE;
        }
        // Set dist of the start vertex (s) to 0
        s.dist = 0;
        // Push the start vertex to an empty queue
        Queue<Vertex> q = new LinkedList<Vertex>();
        q.add(s);
        // [*] Check if the queue is not empty
        // Pop queue and get the current vertex
        // Extract the list of all vertices that are connected to current vertex
        // Traverse all the list check if the dist value of anyone are still infinity or not
        // If yes,  set push that vertex into the queue
        //          increase the dist variable of that vertex by one
        //          set the prev variable of that vertex to the current vertex
        while(!q.isEmpty()){
            Vertex current = q.poll();
            int u = getListIndex(current.strKey);
            for(int v : adjacencyList[u]){
                if(vertexList[v].dist == Integer.MAX_VALUE){
                    q.add(vertexList[v]);
                    vertexList[v].dist = current.dist + 1;
                    vertexList[v].prev = current;
                }
            }
        }
        // Repeat [*]
    }

    
    public Stack<Vertex> getShortestPathList(Vertex S, Vertex U){
        
        // Create a stack
        Stack<Vertex> s = new Stack<Vertex>();
        // Start from city U
        // [*] push the current city into the stack
        // Go back one city using U.prev
        // Repeat [*] until you reach the city S
        while(U != S){
            s.push(U);
            U = U.prev;
        }
        s.push(S);
        // return the stack
        return s; // Fix this
    }
    
    public void printShortestPath(String s_str, String u_str){
        
        // Map city names to index numbers
        int sIdx = getListIndex(s_str);
        int uIdx = getListIndex(u_str);
        // Get vertices from the vertexList
        Vertex s = vertexList[sIdx];
        Vertex u = vertexList[uIdx];
        // Run BFS() at the starting city
        BFS(s);
        // Get shortestPartList(starting city, ending city)
        Stack<Vertex> shortPath = getShortestPathList(s,u);
        // Traverse all the stack and print the city name
        while(!shortPath.isEmpty()){
            String city = shortPath.pop().strKey;
            System.out.print(city + " -> ");
        }
    }
    
    // This function is complete, no need to edit
    public void showVertexList(){
        for (int i=0; i<vertexList.length; i++){
            if (vertexList[i]!=null)
                System.out.println("vertexList["+i+"] contains "+vertexList[i].strKey);
            else
                System.out.println("vertexList["+i+"] null");
        }
    }


    // This is editable test case, but no need to edit
    public static HashGraph constructGraph(){
        
        int p = 101111; // Big Prime (Hash key1)
        int x = 101;    // Small number (Hash key2)
        HashGraph graph = new HashGraph(32, p, x); 
        
        String[] cities = new String[]{"Dublin", "Edinburgh", "Manchester", 
            "Copenhagen", "Lisbon", "London", "Berlin", "Prague", "Madrid", 
            "Paris", "Vienna", "Budapest", "Geneva", "Milan", "Zurich", "Rome"};
        for (int i=0; i<16; i++){
            graph.addVertex(cities[i]);
        }
        
        return graph;
    }
    
    // This is editable test case, but no need to edit
    public static HashGraph connectEdges(HashGraph graph){
        graph.addEdge("Dublin", "Edinburgh");
        graph.addEdge("Dublin", "London");                
        graph.addEdge("Dublin", "Lisbon");
        graph.addEdge("Edinburgh", "Manchester");
        graph.addEdge("Manchester", "London");
        graph.addEdge("Manchester", "Copenhagen");
        graph.addEdge("Copenhagen", "Berlin");
        graph.addEdge("Lisbon", "Madrid");
        graph.addEdge("London", "Paris");
        graph.addEdge("Berlin", "Prague");
        graph.addEdge("Berlin", "Vienna");
        graph.addEdge("Berlin", "Paris");
        graph.addEdge("Prague", "Zurich");
        graph.addEdge("Madrid", "Paris");
        graph.addEdge("Madrid", "Milan");
        graph.addEdge("Madrid", "Geneva");
        graph.addEdge("Vienna", "Zurich");
        graph.addEdge("Budapest", "Rome");
        graph.addEdge("Milan", "Zurich");
        graph.addEdge("Zurich", "Rome");
        return graph;
    }
}
