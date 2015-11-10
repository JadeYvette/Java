package tests;

import graph.Graph;
import java.util.List;
import java.util.ArrayList;
import org.junit.*;
import static org.junit.Assert.*;

public class PublicTests {

  // checks for the presence of an edge in a small graph that contains only
  // two vertices, with that as the only edge
  @Test public void testPublic1() {
    Graph<Character> graph= TestGraphs.testGraph1();

    assertEquals(3, graph.getEdge('A', 'B'));
  }

  // tests adding a vertex to a graph twice (adding one that's already
  // present), which should throw an IllegalArgumentException.
  @Test(expected=IllegalArgumentException.class) public void testPublic2() {
    Graph<Character> graph= TestGraphs.testGraph3();

    graph.addVertex('A');
  }

  // tests adding an edge to a graph twice, which should replace the edge's
  // previous cost
  @Test public void testPublic3() {
    Graph<String> graph= TestGraphs.testGraph2();

    graph.addEdge("apple", "banana", 2);
    graph.addEdge("cherry", "date", 3);
    graph.addEdge("elderberry", "fig", 4);

    assertEquals(graph.getEdge("apple", "banana"), 2);
    assertEquals(graph.getEdge("cherry", "date"), 3);
    assertEquals(graph.getEdge("elderberry", "fig"), 4);
  }

  // calls getNeighbors() on the only vertex in a small graph that has an
  // edge (the only edge), to the only other vertex, and ensures that the
  // adjacent vertex is in the set returned
  @Test public void testPublic4() {
    Graph<Character> graph= TestGraphs.testGraph1();

    assertEquals("B", TestGraphs.collToString(graph.getNeighbors('A')));
  }

  // ensures that only the vertices connected to outgoing edges from a
  // vertex are in the set returned by getNeighbors(), when called on a
  // small graph that has only two vertices and one edge
  @Test public void testPublic5() {
    Graph<Character> graph= TestGraphs.testGraph1();

    assertEquals("", TestGraphs.collToString(graph.getNeighbors('B')));
  }

  // checks the effects of using removeEdge() to remove some edges from a
  // graph by checking the neighbors of all of the vertices afterward
  @Test public void testPublic6() {
    Graph<Character> graph= TestGraphs.testGraph3();
    String[] results= {"O", "", "", "E F", "", "", "", "", "", "", "",
                       "B K", "A N", "C G", "H K", "D"};
    Character ch;
    int i;

    graph.removeEdge('A', 'I');
    graph.removeEdge('K', 'J');
    graph.removeEdge('M', 'L');
    graph.removeEdge('N', 'P');

    for (ch= 'A', i= 0; ch <= 'P'; ch++, i++)
      assertEquals(results[i],
                   TestGraphs.collToString(graph.getNeighbors(ch)));
  }

  // tests getVertices(); is basically the same as the previous test except
  // for use of getVertices() (note that "ch - 'A'" is the index of an
  // element of the array; its value is 0 if ch is 'A', 1 if ch is 'B',
  // etc.)
  @Test public void testPublic7() {
    Graph<Character> graph= TestGraphs.testGraph3();
    String[] results= {"O", "", "", "E F", "", "", "", "", "", "", "",
                       "B K", "A N", "C G", "H K", "D"};

    graph.removeEdge('A', 'I');
    graph.removeEdge('K', 'J');
    graph.removeEdge('M', 'L');
    graph.removeEdge('N', 'P');

    for (Character ch : graph.getVertices())
      assertEquals(results[ch - 'A'],
                   TestGraphs.collToString(graph.getNeighbors(ch)));
  }

  // tests getNeighbors() on a graph that has a cycle
  @Test public void testPublic8() {
    Graph<Integer> graph= TestGraphs.testGraph4();
    String[] results= {"1 4", "2 4", "3 4", "0 4", ""};
    Integer i;

    for (i= 0; i <= 4; i++)
      assertEquals(results[i],
                   TestGraphs.collToString(graph.getNeighbors(i)));
  }

  // tests the effect of removeVertex() in removing some vertices from a graph
  @Test public void testPublic9() {
    Graph<Character> graph= TestGraphs.testGraph3();
    char[] toRemove= {'I', 'H', 'B', 'J', 'C', 'G', 'E', 'F'};
    int i;

    for (i= 0; i < toRemove.length; i++) {
      graph.removeVertex(toRemove[i]);
      assertFalse(graph.hasVertex(toRemove[i]));
    }
  }

  // tests that removeVertex() removes the necessary edges also
  @Test public void testPublic10() {
    Graph<Character> graph= TestGraphs.testGraph3();
    char[] toRemove= {'I', 'H', 'B', 'J', 'C', 'G', 'E', 'F'};
    String[] results= {"O", "", "", "", "", "", "", "", "", "", "", "K",
                       "A L N", "P", "K", "D"};
    int i;

    for (i= 0; i < toRemove.length; i++)
      graph.removeVertex(toRemove[i]);

    for (Character ch : graph.getVertices())
      assertEquals(results[ch - 'A'],
                   TestGraphs.collToString(graph.getNeighbors(ch)));
  }

  // ensures that isInCycle() returns false for every vertex in an acyclic
  // graph
  @Test public void testPublic11() {
    Graph<Character> graph= TestGraphs.testGraph3();

    for (Character ch : graph.getVertices())
      assertFalse(graph.isInCycle(ch));
  }

  // ensures that isInCycle() returns true for every vertex in a graph in
  // which all vertices are in a cycle
  @Test public void testPublic12() {
    Graph<Integer> graph= new Graph<Integer>();
    int i;

    // note this adds the adjacent vertices in the process
    for (i= 0; i < 10; i++)
      graph.addEdge(i, i + 1, 1);
    graph.addEdge(10, 0, 1);

    for (Integer vertex : graph.getVertices())
      assertTrue(graph.isInCycle(vertex));
  }

  // checks the result of isInCycle() on a graph in which some vertices are
  // in a cycle, but one is not
  @Test public void testPublic13() {
    Graph<Integer> graph= TestGraphs.testGraph4();
    int i;

    for (i= 0; i < 4; i++)
      assertTrue(graph.isInCycle(i));

    assertFalse(graph.isInCycle(4));
  }

  // calls Dijkstra's algorithm on vertices in a linear graph and checks its
  // results
  @Test public void testPublic14() {
    Graph<String> graph= TestGraphs.testGraph2();
    List<String> shortestPath= new ArrayList<String>();

    assertEquals(1, graph.Dijkstra("apple", "banana", shortestPath));
    assertEquals("apple banana", TestGraphs.listToString(shortestPath));

    assertEquals(2, graph.Dijkstra("apple", "cherry", shortestPath));
    assertEquals("apple banana cherry",
                 TestGraphs.listToString(shortestPath));

    assertEquals(3, graph.Dijkstra("apple", "date", shortestPath));
    assertEquals("apple banana cherry date",
                 TestGraphs.listToString(shortestPath));

    assertEquals(4, graph.Dijkstra("apple", "elderberry", shortestPath));
    assertEquals("apple banana cherry date elderberry",
                 TestGraphs.listToString(shortestPath));

    assertEquals(5, graph.Dijkstra("apple", "fig", shortestPath));
    assertEquals("apple banana cherry date elderberry fig",
                 TestGraphs.listToString(shortestPath));

    assertEquals(6, graph.Dijkstra("apple", "guava", shortestPath));
    assertEquals("apple banana cherry date elderberry fig guava",
                 TestGraphs.listToString(shortestPath));
  }

  // calls Dijkstra's algorithm on two pairs of vertices in a simple graph
  // and checks its results
  @Test public void testPublic15() {
    Graph<Character> graph= TestGraphs.testGraph3();
    List<Character> shortestPath= new ArrayList<Character>();

    assertEquals(1, graph.Dijkstra('A', 'O', shortestPath));
    assertEquals("A O", TestGraphs.listToString(shortestPath));

    assertEquals(4, graph.Dijkstra('M', 'F', shortestPath));
    assertEquals("M N P D F", TestGraphs.listToString(shortestPath));
  }

  // calls Dijkstra's algorithm on a pair of vertices in a more complex
  // graph and checks its results
  @Test public void testPublic16() {
    Graph<Integer> graph= TestGraphs.testGraph5();
    List<Integer> shortestPath= new ArrayList<Integer>();

    assertEquals(5, graph.Dijkstra(131, 351, shortestPath));
    assertEquals("131 330 351", TestGraphs.listToString(shortestPath));
  }

  // calls Dijkstra's algorithm on another pair of vertices in a more
  // complex graph and checks its results
  @Test public void testPublic17() {
    Graph<Integer> graph= TestGraphs.testGraph5();
    List<Integer> shortestPath= new ArrayList<Integer>();

    assertEquals(8, graph.Dijkstra(131, 141, shortestPath));
    assertEquals("131 330 132 141", TestGraphs.listToString(shortestPath));
  }

  // calls Dijkstra's algorithm on another pair of vertices in a more
  // complex graph and checks its results
  @Test public void testPublic18() {
    Graph<Integer> graph= TestGraphs.testGraph5();
    List<Integer> shortestPath= new ArrayList<Integer>();

    assertEquals(13, graph.Dijkstra(250, 141, shortestPath));
    assertEquals("250 351 132 141", TestGraphs.listToString(shortestPath));
  }

}
