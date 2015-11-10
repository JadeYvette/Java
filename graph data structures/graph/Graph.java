//Jade Wilkins Directory ID:jwilkin1  UID:112450816 Section:201 
//I pledge on my honor that I have not given or received any unauthorized assistance on this 
//assignment.



package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
//to create a Graph Object and the appropriate methods
public class Graph<V extends Comparable<V>> {
	   // used to create the   Edges of the graph 
	   private class Edge <V extends Comparable<V>>{
		   V source;
		   V dest;
		   int value;
		   
		   public Edge(V sourceIn,V destIn, int valueIn){
			   
			   source = sourceIn;
			   dest = destIn;
			   value = valueIn;
			   
			   
		   }
		   
		  public  String HashCode(){
			
			  return  source.toString() + dest.toString();
			
		  }
		   
		   public String toString(){
			
			   return HashCode();
			   
		   }
		  
		  
	   }
	
	
	
	private HashMap<V, ArrayList<V>> adjacencyList; 
	private LinkedHashSet<V>vertices;
	private LinkedHashMap<String,Edge> edges;
	private LinkedHashSet<Edge> edgeSet;
    private HashMap<V,String> active = new HashMap<V,String>();
    
	

  public Graph() { 
	 adjacencyList = new HashMap<V,ArrayList<V>>();
     vertices  = new LinkedHashSet<V>();
     edges = new LinkedHashMap<String,Edge>();
     edgeSet = new LinkedHashSet<Edge>();
    
     
     
     
  }
  
  // adds vertex to the graph
  public void addVertex(V vertex) throws IllegalArgumentException {
       // if the vertex is in the current map throws an exception because there
	  // cannot be two of the same vertex
	  if ( vertices.contains(vertex) == true ){
   
    	   throw new IllegalArgumentException();
       } else {
    	   // adds the vertex V to the vertices set, the adjacencyList,and the 
    	   // map active used for the isInCycle method
    	   
    	   
    	   active.put(vertex, "unprocessed");
    	   vertices.add(vertex);
    	   adjacencyList.put(vertex, new ArrayList<V>());
    	  
       }
  }
  // returns a boolean based on if the current graph contains the object V
  // vertex or not
  public boolean hasVertex(V vertex) {
	// returns true vertex is in the set of all the vertices
    return vertices.contains(vertex);
  }

  // return all the vertices in the graph
  public Collection<V> getVertices() {
  // returns the set vertices which contains all the vertices in the map
    return vertices;
  }
  // removes the indicated vertex
  public void removeVertex(V vertex) throws IllegalArgumentException {
	// creates a set of edges that will need to be removed
	// edges that are connected to the vertex thats getting deleted
    // will be in this set
	 HashSet<Edge> toRemove = new HashSet<Edge>();
	  
	
	 
	// if the vertex is not in the graph this method throws an exception  
   if (vertices.contains(vertex) == false) {
	   throw new IllegalArgumentException();
        } else {
        	 // removes the vertex from the adjacencyList
	          adjacencyList.remove(vertex);
	  
	          
	        //goes through every Edge in the graph  
		     for (Edge E : edgeSet) {
		    	// if E is the vertex were deleting remove that edge from the 
		    	// Edge set
		    	 if (E.dest.equals(vertex)) {
		    	    adjacencyList.get(E.source).remove(vertex);
		    	 }
		    		
		    	 
		    	 
		    	 if (E.dest.equals(vertex) || E.source.equals(vertex) ) {
		              toRemove.add(E);
		    		  edges.put(E.HashCode(), null);
		    		 
		    		  
		    		 
		    	 }

		    	    
		    	    
		    	    
		    	 }
		    	 
		    	 
		    	 
		    	
		    	 
		    	 
		     }
		   
		     
		       
		   
		  
		  
		  
		  
		  vertices.remove(vertex); 
		  edgeSet.removeAll(toRemove);
	  }
      
   
  
 // adds  and creates an edge to the graph 
 //with the arguments being passed through
  public void addEdge(V source, V dest, int cost){
	  
	  // creates the key for the Edge to be added
	  String K = source.toString() + dest.toString();
	  
	   
	  
	    // if the arguments dest or source are not in the map this method creates
	   // those vertices
          if (vertices.contains(source) == false) {
        	  addVertex(source);
          }
	  
	      if (vertices.contains(dest) == false) {
	    	 addVertex(dest);
	      }
	  
	  
	  
	     
	  
	  
	  // creates the new edge with the information passed through the parameters
	  Edge current = new Edge(source,dest,cost);
	  // adds the new Edge to the Edge set & the Edge Map
             edgeSet.add(current);
        	 edges.put(K, current);
       // adds the dest vertex to the adjacencyList of the source Vertex
        	 adjacencyList.get(source).add(dest);
        	 
         
	  
	  
	  
	  
	  
  }
 // returns the edge being requested by the arguments
  public int getEdge(V source, V dest) {
	// creates the key to find the Edge described by the arguments 
    String K = source.toString() + dest.toString();
    // stores the edge requested
    Edge current  = edges.get(K);
    // returns the value of the edge being requested
    return current.value;
  }
//removes the edge being requested by the arguments;
  public void removeEdge(V source, V dest) throws IllegalArgumentException {
	 String K = source.toString() + dest.toString();
      adjacencyList.get(source).remove(dest);
      
    edgeSet.remove(edges.get(K));
    edges.remove(K);
      
  }
//returns the neighbors of the  vertex V
  public Collection<V> getNeighbors(V vertex) throws IllegalArgumentException {
       ArrayList<V> current = adjacencyList.get(vertex);
        LinkedHashSet<V> returnVal = new LinkedHashSet<V>();
       for(V V : current){
    	   returnVal.add(V);
       }
       
     return returnVal;  
  }
// returns the predecessors of the vertex V
  public Collection<V> getPredecessors(V vertex) throws IllegalArgumentException
  {
	  //creates a new set to hold all the predecessors
	  LinkedHashSet<V> returnVal = new LinkedHashSet<V>();
	  
	  //if the vertex is not in the current object it return false;
	  if ( vertices.contains(vertex) == false) {
          throw new IllegalArgumentException();
        	   
        } else {
        	  // goes through all the edges in the graph
        	 for(Edge E : edgeSet){
        		 // if the edge E has vertex as destination it is a 
        		 //predecessor of vertex
        		 if ( vertex.equals(E.dest)) {
        			 //adds E to the returnVal set
        			 returnVal.add((V) E.source);
        			 
        		 }
        		 
        		
        		 
        		 
        		 
        	 }
        	
        	
        	
        	
        	
        }
	  
	  return returnVal;
	  
  }
          
// returns true or false based on if the  V vertex is in a cycle or a cycle 
// can be reached from the  V vertex
  public boolean isInCycle(V vertex) throws IllegalArgumentException {
	  // if the vertex is not in the current map throws exception 
	     if(vertices.contains(vertex) == false){
	    	 throw new IllegalArgumentException();
	     }
    // labels the vertex as active since its currently being processed
       active.put(vertex, "active");
  
   
   // goes through all neighbors of the vertex
    for(V Y :adjacencyList.get(vertex)){
    	//if Y is marked active return true
    	if ( active.get(Y).equals("active")) {
    		return true;
    	} else {
    		   // if Y is not active but returns true for isInCycle and is not
    		  // marked done returns true
    		
    		      if (isInCycle(Y) == true && !active.get(Y).equals("done")) {
    		    	  return true;
    		      } 
    		
    		
    	}
    	
    	
    }
    //
   active.put(vertex, "done");
   return false;
  }
 // returns the shortest distance to get from sourceVertex to get to destVertex
 // using Dijkstra's algorithm  also stores all the vertices in that path 
 // in the list shortest path
  public int Dijkstra(V sourceVertex, V destVertex, List<V> shortestPath)
             throws IllegalArgumentException {
    if (vertices.contains(sourceVertex) == false  ||
       vertices.contains(destVertex) == false) {
    	 throw new 	IllegalArgumentException();
    	 
    	 
    	 
    	 
     } else { 

    	    	     shortestPath.removeAll(shortestPath);
    	    	     
    	    	    TreeSet<V> processed  = new TreeSet<V>();
    	    	  
    	    	    TreeMap<V,Integer> pathCost = new TreeMap<V,Integer>();
    	    	    TreeMap<V,List<V>> pred = new TreeMap<V,List<V>>();
    	    	  
    	    	     for(V V : vertices){
    	      	    	 pathCost.put(V, 100);
    	      	    	 pred.put(V, new ArrayList<V>());
    	      	    	 pred.get(V).add(sourceVertex);
    	    	     }
    	    	     pathCost.put(sourceVertex,0);
    	    	      
    	    	     
    	    	     while(processed.containsAll(vertices) == false){
    	    	    	 int MinVal = 101;
    	    	    	 V min = null;
    	    	    	 for(V V : vertices){
    	    	    		 
    	    	    		 if (processed.contains(V) == false) {
    	    	    			 if (pathCost.get(V) < MinVal) {
    	    	    				MinVal= pathCost.get(V);
    	    	    				min = V;
    	    	    			
    	    	    				
    	    	    				
    	    	    				
    	    	    				 
    	    	    			 }
    	    	    			
    	    	    		 }
    	    	    		 
    	    	    		 
    	    	    		 
    	    	    	 } 
    	    	    	 
    	    	    	 
    	    	    	 
    	    	    	 
    	    	    	 
    	    	    	 
    	    	    	 processed.add(min);
    	    	    	 
    	    	    	
    	    	    	
    	    	    		 
    	    	    	 	 for(V N: getNeighbors(min)){
    	    	    	 	
    	    	    	 		
    	        	    		 if (processed.contains(N) == false) {
    	        	    			 String K = min.toString() + N.toString();
    	        	    			 if(pathCost.get(N) > pathCost.get(min) + 
    	        	    			    edges.get(K).value){
    	        	    				 
    	        	    				 pathCost.put(N, pathCost.get(min) + 
    	        	    			    edges.get(K).value);
    	        	    				
    	        	    	            
    	        	    				
    	        	    		      if (pred.get(N).contains(min) == false) {
    	        	    		    	  
    	        	    		    	  
    	        	    		    	 
    	        	    		    	 
    	        	    		    	  for(V V : pred.get(min)){
    	        	    		    	      if(pred.get(N).contains(V) 
    	        	    		    	    		          == false){
    	        	    		    		       pred.get(N).add(V);
    	        	    		    		    
    	        	    		    		    	
    	        	    		    		    }
    	        	    		    		  
    	        	    		    		  
    	        	    		    	  }
    	        	    		    	  
    	        	    		    	   pred.get(N).add(min);
    	        	    		    	  
    	        	    		    	  
    	        	    		      }
    	        	    				 
    	        	    			 }
    	        	    		      	 
    	        	    			  
    	        	    		       } 
    	        	    				 
    	    	    	 	 }
    	        	    			 
    	        	    			 
    	        	    		 }
    	        	    		 
    	        	    		
    	        	    		 shortestPath.addAll(pred.get(destVertex));
    	        	    		 shortestPath.add(destVertex);
    	        	    		return pathCost.get(destVertex);
    	        	    	 } 
    	    	    		 
    	    	    		 
    	    	    		 
    	    	    		
    	    	    		 
    	    	    		 
    	    	    		 
    	    	    	 }
    	    	    	 
    	    	    	 
    	    	  
    	    	 
    	    	 
    	    	 
    	    	 
    	    
    	     
    	 
    	 
    	 
    	 
    	     
    	
    	 
    	 
    	 
    	 
    	 
    
     
	
  // METHODS USED FOR DEBUGGING!
  
  public   Collection  getEdges(){
	  ArrayList<Integer> jade  = new ArrayList<Integer>();
	
	  
	  return edgeSet;
  }
  
  public boolean hasEdge(V start,V end){
	String K = start.toString() + end.toString();
	return edges.containsKey(K);
	  
	

	  
  }
  
  
  
  
  
  }


