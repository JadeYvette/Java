package tests;

import tree.Tree;
import tree.EmptyTree;
import tree.EmptyTreeException;

import java.util.ArrayList;

import org.junit.*;

import static org.junit.Assert.*;

@SuppressWarnings("unchecked")
public class PublicTests {

  // tests calling size() on different-sized trees
  @Test public void testPublic1() {
    Tree<Integer, String> firstTree= EmptyTree.getInstance();
    Tree<Integer, String> secondTree= tree1();
    Tree<Integer, String> fourTree= tree2();
    Tree<Character, Integer> thirdTree= tree3();

    assertEquals(0, firstTree.size());
    assertEquals(1, secondTree.size());
    assertEquals(13, thirdTree.size());
  }

  // tests calling lookup() on an empty tree, and on an element that's not
  // present in a nonempty tree
  @Test public void testPublic2() {
    Tree<Integer, String> firstTree= EmptyTree.getInstance();
    Tree<Integer, String> secondTree= tree2();

    assertNull(firstTree.lookup(100));
    assertNull(secondTree.lookup(100));
  }

  // tests calling lookup() on various elements that are present in a
  // nonempty tree
  @Test public void testPublic3() {
    Tree<Character, Integer> tree= tree3();
    int returnVal = tree.lookup('o');
    assertEquals(1, (int) tree.lookup('h'));
    assertEquals(5, (int) tree.lookup('o'));
    assertEquals(13, (int) tree.lookup('c'));
  }

  // tests creating a tree with no elements and one with one element,
  // calling toString() on them
  @Test public void testPublic4() {
    Tree<Integer, String> firstTree= EmptyTree.getInstance();
    Tree<Integer, String> secondTree= EmptyTree.getInstance();

    secondTree= secondTree.add(10, "ten");

    assertEquals("", firstTree.toString());
    assertEquals("10/ten", secondTree.toString());
  }

  // tests creating a tree with several elements, calling toString() on it
  @Test public void testPublic5() {
    Tree<Integer, String> tree= tree2();
    
    assertEquals("7/seven " +
                 "10/ten " +
                 "12/twelve " +
                 "15/fifteen " +
                 "16/sixteen " +
                 "17/seventeen " +
                 "20/twenty " +
                 "30/thirty", tree.toString());
  }

  // tests that add() modifies its current object tree.
  @Test public void testPublic6() {
    Tree<Character, Integer> tree= tree3();

    Tree<Character, Integer> tree2= tree.add('s', 14);
    assertEquals(14, (int) tree.lookup('s'));
    assertEquals(14, (int) tree2.lookup('s'));
    assertEquals(tree.toString(), tree2.toString());
  }

  // tests that delete() modifies its current object tree.
  @Test public void testPublic7() {
    Tree<Character, Integer> tree= tree3();

    Tree<Character, Integer> tree2= tree.delete('m');
    assertNull(tree.lookup('m'));
    assertEquals(tree.toString(), tree2.toString());
  }

  // tests the copy() method
  @Test public void testPublic8() {
    Tree<Integer, String> tree= tree2();

    assertEquals("7/seven " +
                 "10/ten " +
                 "12/twelve " +
                 "15/fifteen " +
                 "16/sixteen " +
                 "17/seventeen " +
                 "20/twenty " +
                 "30/thirty", tree.copy().toString());
  }

  // tests calling max() on a tree with several elements
  @Test public void testPublic9() throws EmptyTreeException {
    Tree<Character, Integer> tree= tree3();
    
    try {
      assertEquals('y', (char) tree.max());
    } catch (EmptyTreeException ete) {
      // if an exception is thrown the test will fail
    }
  }

  // tests calling min() on a tree with several elements
  @Test public void testPublic10() {
    Tree<Character, Integer> tree= tree3();

    try {
      assertEquals('a', (char) tree.min());
    } catch (EmptyTreeException ete) {
      // if an exception is thrown the test will fail
    }
  }

  // tests calling delete() on an empty tree and on an element that's not
  // present in a nonempty tree
  @Test public void testPublic11() {
    Tree<Integer, String> firstTree= EmptyTree.getInstance();
    Tree<Integer, String> secondTree= tree2();

    firstTree= firstTree.delete(100);
    assertEquals("", firstTree.toString());

    assertEquals("7/seven " +
                 "10/ten " +
                 "12/twelve " +
                 "15/fifteen " +
                 "16/sixteen " +
                 "17/seventeen " +
                 "20/twenty " +
                 "30/thirty",
                 secondTree.toString());
  }

  // tests calling delete() on various elements of a nonempty tree
  @Test public void testPublic12() {
    Tree<Integer, String> tree= tree2();

    tree= tree.delete(15);
    assertEquals("7/seven " +
                 "10/ten " +
                 "12/twelve " +
                 "16/sixteen " +
                 "17/seventeen " +
                 "20/twenty " +
                 "30/thirty",
                 tree.toString());

    tree= tree.delete(16);
    assertEquals("7/seven " +
                 "10/ten " +
                 "12/twelve " +
                 "17/seventeen " +
                 "20/twenty " +
                 "30/thirty",
                 tree.toString());

    tree= tree.delete(17);
    assertEquals("7/seven " +
                 "10/ten " +
                 "12/twelve " +
                 "20/twenty " +
                 "30/thirty",
                 tree.toString());
  }

  // tests pathFromRoot() on a tree with only one element
  @Test public void testPublic13() {
    Tree<Integer, String> tree= tree1();
    ArrayList<Integer> list= new ArrayList<Integer>();

    tree.pathFromRoot(15, list);
    assertEquals("15", ListToString.listToString(list));
  }

  // tests pathFromRoot() on a tree with multiple elements
  @Test public void testPublic14() {
    Tree<Integer, String> tree= tree2();
    ArrayList<Integer> list1= new ArrayList<Integer>();
    ArrayList<Integer> list2= new ArrayList<Integer>();
    ArrayList<Integer> list3= new ArrayList<Integer>();

    tree.pathFromRoot(10, list1);
    assertEquals("15 10", ListToString.listToString(list1));

    tree.pathFromRoot(12, list2);
    assertEquals("15 10 12", ListToString.listToString(list2));

    tree.pathFromRoot(17, list3);
    assertEquals("15 20 16 17", ListToString.listToString(list3));
  }

  // private utility methods ////////////////////////////////////////////

  // returns a tree with one element, with Integer keys and String values
  private static Tree<Integer, String> tree1() {
    Tree<Integer, String> tree= EmptyTree.getInstance();

    tree= tree.add(15, "fifteen");

    return tree;
  }

  // returns a tree with several elements, with Integer keys and String values
  private static Tree<Integer, String> tree2() {
    Tree<Integer, String> tree= EmptyTree.getInstance();

    tree= tree.add(15, "fifteen");
    tree= tree.add(10, "ten");
    tree= tree.add(20, "twenty");
    tree= tree.add(7, "seven");
    tree= tree.add(12, "twelve");
    tree= tree.add(16, "sixteen");
    tree= tree.add(30, "thirty");
    tree= tree.add(17, "seventeen");

    return tree;
  }

  // returns a tree with several elements, with Character keys and Integer
  // values
  private static Tree<Character, Integer> tree3() {
    Tree<Character, Integer> tree= EmptyTree.getInstance();

    tree= tree.add('h', 1);
    tree= tree.add('y', 2);
    tree= tree.add('d', 3);
    tree= tree.add('r', 4);
    tree= tree.add('o', 5);
    tree= tree.add('m', 6);
    tree= tree.add('a', 7);
    tree= tree.add('g', 8);
    tree= tree.add('n', 9);
    tree= tree.add('e', 10);
    tree= tree.add('t', 11);
    tree= tree.add('i', 12);
    tree= tree.add('c', 13);

    return tree;
  }

}
