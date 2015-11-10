package tests;

// helper methods used in tests

import graph.Graph;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class TestGraphs {

  /* Converts a Collection to a string (with the elements in order) so it
   * can be compared in tests.  Since Collections of different types can be
   * passed in, depending on the type a graph is instantiated with, a
   * wildcard is used.  The elements of the string will be put in sorted
   * order, to allow testing the contents of Collections that have no
   * ordering.
   */
  public static String collToString(Collection<?> collection) {
    ArrayList<String> list= new ArrayList<String>();
    Iterator<?> iter= collection.iterator();
    String elementNames= "";

    while (iter.hasNext())
      list.add(iter.next().toString());

    // we sort the elements of the collection in order to be able to get
    // definite expected results.
    Collections.sort(list);

    for (Object o : list) {
      if (!elementNames.equals(""))
        elementNames += " ";
      elementNames += o.toString();
    }

    return elementNames;
  }

  // Converts a path (returned by the method Dijkstra()) to a string so it
  // can be compared in tests.  Since lists of different types can be passed
  // in, depending on the type a graph is instantiated with, a wildcard is
  // used.
  public static <T> String listToString(List<T> list) {
    Iterator<T> iter= list.iterator();
    String s= "";

    while (iter.hasNext()) {
      s += iter.next();  // calls toString()
      if (iter.hasNext())
        s += " ";
    }

    return s + "";
  }

  // This method creates a very simple graph, instantiated with Characters,
  // with only two vertices and one edge
  public static Graph<Character> testGraph1() {
    Graph<Character> graph= new Graph<Character>();

    // add an edge to the graph (which should also add the adjacent vertices)
    graph.addEdge('A', 'B', 3);

    return graph;
  }

  // This method creates a simple graph (which is actually linear),
  // instantiated with Strings, with all edge weights of 1
  public static Graph<String> testGraph2() {
    Graph<String> graph= new Graph<String>();

    // add edges to the graph (which in this case also adds the necessary
    // vertices)
    graph.addEdge("apple", "banana", 1);
    graph.addEdge("banana", "cherry", 1);
    graph.addEdge("cherry", "date", 1);
    graph.addEdge("date", "elderberry", 1);
    graph.addEdge("elderberry", "fig", 1);
    graph.addEdge("fig", "guava", 1);

    return graph;
  }

  // This method creates a simple graph, instantiated with Characters, with
  // all edge weights of 1
  public static Graph<Character> testGraph3() {
    Graph<Character> graph= new Graph<Character>();

    // add edges to the graph (which in this case also adds the necessary
    // vertices)
    graph.addEdge('A', 'I', 1);
    graph.addEdge('A', 'O', 1);
    graph.addEdge('D', 'E', 1);
    graph.addEdge('D', 'F', 1);
    graph.addEdge('K', 'J', 1);
    graph.addEdge('L', 'B', 1);
    graph.addEdge('L', 'K', 1);
    graph.addEdge('M', 'A', 1);
    graph.addEdge('M', 'L', 1);
    graph.addEdge('M', 'N', 1);
    graph.addEdge('N', 'C', 1);
    graph.addEdge('N', 'G', 1);
    graph.addEdge('N', 'P', 1);
    graph.addEdge('O', 'H', 1);
    graph.addEdge('O', 'K', 1);
    graph.addEdge('P', 'D', 1);

    return graph;
  }

  // This method creates a more complex graph, instantiated with Integers,
  // with all edge weights of 1, that has a cycle.
  public static Graph<Integer> testGraph4() {
    Graph<Integer> graph= new Graph<Integer>();

    // add edges to the graph (which in this case also adds the necessary
    // vertices)
    graph.addEdge(0, 1, 1);
    graph.addEdge(0, 4, 1);
    graph.addEdge(1, 2, 1);
    graph.addEdge(1, 4, 1);
    graph.addEdge(2, 3, 1);
    graph.addEdge(2, 4, 1);
    graph.addEdge(3, 0, 1);
    graph.addEdge(3, 4, 1);

    return graph;
  }

  // This method creates a more complex graph, instantiated with Integers.
  // Note that some vertices have no incoming edges, and one has neither
  // incoming nor outgoing edges.
  public static Graph<Integer> testGraph5() {
    Graph<Integer> graph= new Graph<Integer>();
    int[] vertices= {131, 132, 140, 141, 250, 330, 351, 412, 420, 430, 452,
                     456};
    int i;

    // add vertices to the graph
    for (i= 0; i < vertices.length; i++)
      graph.addVertex(vertices[i]);

    // add edges to the graph
    graph.addEdge(131, 330, 4);
    graph.addEdge(132, 131, 1);
    graph.addEdge(132, 141, 2);
    graph.addEdge(132, 250, 4);
    graph.addEdge(140, 131, 1);
    graph.addEdge(141, 330, 3);
    graph.addEdge(250, 140, 6);
    graph.addEdge(250, 351, 5);
    graph.addEdge(330, 132, 2);
    graph.addEdge(330, 250, 5);
    graph.addEdge(330, 351, 1);
    graph.addEdge(351, 132, 6);
    graph.addEdge(351, 140, 3);
    graph.addEdge(412, 420, 3);
    graph.addEdge(430, 420, 7);
    graph.addEdge(452, 420, 1);

    return graph;
  }

}
