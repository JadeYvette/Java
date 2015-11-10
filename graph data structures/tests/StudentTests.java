//Jade Wilkins Directory ID:jwilkin1  UID:112450816 Section:201 
//I pledge on my honor that I have not given or received any unauthorized assistance on this 
//assignment.
package tests;

import graph.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.*;

@SuppressWarnings("unchecked")
public class StudentTests {

	  @Test public void addVertex() {
		    Graph<Character> graph1= new Graph();
		    graph1.addVertex('A');
		    graph1.addVertex('B');
		    graph1.addVertex('C');
		    graph1.addVertex('D');
		    
		    assertEquals(true, graph1.hasVertex('A') );
		    assertEquals(true,graph1.hasVertex('B') );
		    assertEquals(true,graph1.hasVertex('C') );
		    assertEquals(true,graph1.hasVertex('D') );
		    assertEquals(false,graph1.hasVertex('E') );
		  }
	  
	  
	  @Test public void hasVertex() {
		   
		    Graph<Character> graph1= new Graph();
		    graph1.addVertex('E');
		    graph1.addVertex('F');
		    graph1.addVertex('D');
		    graph1.addVertex('J');
		    
		    assertEquals(false, graph1.hasVertex('A') );
		    assertEquals(false,graph1.hasVertex('B') );
		    assertEquals(false,graph1.hasVertex('C') );
		    assertEquals(true,graph1.hasVertex('E') );
		  
		  
		  
		  
		  
		  
		  
		  }
	  
	  @Test public void getVertex() {
		  Graph<Character> graph1= new Graph();
		    graph1.addVertex('A');
		    graph1.addVertex('B');
		    graph1.addVertex('C');
		    graph1.addVertex('D');
		    
		    HashSet<Character>vert = new HashSet<Character>();
		    vert.add('A');
		    vert.add('B');
		    vert.add('C');
		    vert.add('D');
		    
		    assertEquals(true, graph1.getVertices().containsAll(vert));
		    
		  }
	  
	  
	  @Test public void removeVertex() {
		  Graph<Character> graph1= new Graph();
		    graph1.addVertex('A');
		    graph1.addVertex('B');
		    graph1.addVertex('C');
		    graph1.removeVertex('A');
		    
		    HashSet<Character>vert = new HashSet<Character>();
		   
		    vert.add('B');
		    vert.add('C');
		    
		    
		    assertEquals(true, graph1.getVertices().containsAll(vert));
		    
		    
		  }
	  
	  
	  
	  @Test public void addEdge() {
		  Graph<Character> graph1= new Graph();
		  
		  graph1.addEdge('A','B', 10);
		  graph1.addEdge('C','D', 10);
		  
		  assertEquals(true, graph1.hasVertex('A') );
		  assertEquals(true,graph1.hasVertex('B') );
		  assertEquals(true, graph1.hasVertex('D') );
		  assertEquals(true,graph1.hasVertex('C') );
		  
		  
		  }
	  
	  
	  
	  @Test public void removeEdge() {
		  Graph<Character> graph1= new Graph();
		  graph1.addEdge('A','B', 10);
		  graph1.addEdge('C','D', 10);
		  graph1.removeEdge('A','B');
		  assertEquals(false, graph1.hasEdge('A','B'));
		  assertEquals(true,graph1.hasEdge('C','D'));
		  
		  
		  
		  
		  }
	  
	  
	  @Test public void getPredecessors() {
		  Graph<Character> graph1= new Graph();
		  graph1.addEdge('A','B', 10);
		  graph1.addEdge('D','B', 10);
		  graph1.addEdge('C','B', 10);
		  graph1.addEdge('E','B', 10);
		  
		  HashSet<Character>vert = new HashSet<Character>();
		   
		    vert.add('A');
		    vert.add('D');
		    vert.add('C');
		    vert.add('E');
		    
		   assertEquals(true, graph1.getPredecessors('B').containsAll(vert));
		  
		  
		  }
	  
	  

	  
	  @Test public void getNeighbors() {
		  Graph<Character> graph1= new Graph();
		  graph1.addEdge('A','B', 10);
		  graph1.addEdge('A','D', 10);
		  graph1.addEdge('A','E', 10);
		  graph1.addEdge('A','F', 10);
		 
		  
		  HashSet<Character>vert = new HashSet<Character>();
		   
		    vert.add('B');
		    vert.add('D');
		    vert.add('E');
		    vert.add('F');
		  
		    assertEquals(true, graph1.getNeighbors('A').containsAll(vert));
		  
		  
		  
		  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
