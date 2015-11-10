//Jade Wilkins Directory ID:jwilkin1  UID:112450816 Section:201 
//I pledge on my honor that I have not given or received any unauthorized 
//assistance on this assignment.




package tests;

import java.util.ArrayList;

import org.junit.*;

import tree.EmptyTree;
import tree.EmptyTreeException;
import tree.Tree;
import static org.junit.Assert.*;

@SuppressWarnings("unchecked")
public class StudentTests {

	  private static final Tree<Integer, String> thirdTree = null;

	@Test public void testAdd() {
		Tree<Integer, String> firstTree= tree1();
		firstTree.add(21, "twenty1");
		 assertEquals("10/ten 21/twenty1",firstTree.toString());
		  }
	
	
	
	  @Test public void testSize() {
            Tree<Integer, String> emptyTree= EmptyTree.getInstance();
		    Tree<Integer, String> firstTree= tree1();
		    Tree<Integer, String> secondTree= tree2();
		    Tree<Integer, String> thirdTree= tree3();
		    Tree<Integer, String> fourTree= tree4();
		    
		    
		    assertEquals(4, secondTree.size());
		    assertEquals(1, firstTree.size());
		    assertEquals(7, thirdTree.size());
		    assertEquals(4, fourTree.size());
		  }
	
	
	
	  @Test public void lookup() {
		  Tree<Integer, String> emptyTree= EmptyTree.getInstance();
		    Tree<Integer, String> firstTree= tree1();
		    Tree<Integer, String> secondTree= tree2();
		    Tree<Integer, String> thirdTree= tree3();


		    assertNull(firstTree.lookup(777));
		    assertNull(secondTree.lookup(777));
		    assertNull(firstTree.lookup(13));
		    assertNull(secondTree.lookup(14));
		    
		    
		    assertEquals("five",  thirdTree.lookup(5));
		    assertEquals("six",  thirdTree.lookup(6));
		    assertEquals("twelve", thirdTree.lookup(12));
		    
		    
		    
		    
		    
		    
		    
		    
		  }
	  
	  
	  
	  
	
	
	
	
	  @Test public void testMin() {
		  Tree<Integer, String> emptyTree= EmptyTree.getInstance();
		    Tree<Integer, String> firstTree= tree1();
		    Tree<Integer, String> secondTree= tree2();
		    Tree<Integer, String> thirdTree= tree3();

		    try {
				assertEquals(10,  (int)firstTree.min());
			} catch (EmptyTreeException e) {
				
			}
		    try {
				assertEquals(1, (int) secondTree.min());
			} catch (EmptyTreeException e) {
				
			}
		    try {
				assertEquals(5,  (int)thirdTree.min());
			} catch (EmptyTreeException e) {
				
			}
		  }
	
	
	  @Test public void testMax() {
		  Tree<Integer, String> emptyTree= EmptyTree.getInstance();
		    Tree<Integer, String> firstTree= tree1();
		    Tree<Integer, String> secondTree= tree2();
		    Tree<Integer, String> thirdTree= tree3();

		    try {
				assertEquals(10, (int)firstTree.max());
			} catch (EmptyTreeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				assertEquals(4, (int)secondTree.max());
			} catch (EmptyTreeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try {
				assertEquals(21,(int) thirdTree.max());
			} catch (EmptyTreeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	
	  @Test public void testDelete() {
		  Tree<Integer, String> emptyTree= EmptyTree.getInstance();
		    Tree<Integer, String> firstTree= tree1();
		    Tree<Integer, String> secondTree= tree2();
		    Tree<Integer, String> thirdTree= tree3();
		    
		    thirdTree.delete(5);
		    thirdTree.delete(11);
		    thirdTree.delete(6);
		    
		    assertEquals("8/eight " +
	                 "10/ten " +
	                 "12/twelve " +
	                 "21/twenty-one",
	                 thirdTree.toString());
		   
		    
		    
		  
		  }
	  
	  @Test public void testHaveSameKeys() {
		  Tree<Integer, String> emptyTree= EmptyTree.getInstance();
		    Tree<Integer, String> firstTree= tree1();
		    Tree<Integer, String> secondTree= tree2();
		    Tree<Integer, String> thirdTree= tree3();
		    Tree<Integer, String> fourTree= tree4();
		  
		  
		  assertEquals(true,
	                 secondTree.haveSameKeys(fourTree));
		  
	  
	      assertEquals(false,
              secondTree.haveSameKeys(thirdTree));
	  
	  }
	  
	  @Test public void testPathFromRoot() {
		  Tree<Integer, String> emptyTree= EmptyTree.getInstance();
		    Tree<Integer, String> firstTree= tree1();
		    Tree<Integer, String> secondTree= tree2();
		    Tree<Integer, String> thirdTree= tree3();
		    Tree<Integer, String> fourTree= tree4();
		  
		    ArrayList<Integer> list= new ArrayList<Integer>();
		    ArrayList<Integer> list2= new ArrayList<Integer>();
		  
		  
		  
		    firstTree.pathFromRoot(10, list);
		    assertEquals("10", ListToString.listToString(list));
		    
		    
		    
		    secondTree.pathFromRoot(10, list2);
		    assertEquals("", ListToString.listToString(list2));
		    
		    
		  }
	  
	 	  
	  
	  
	  
	  
	  
	  @Test public void testLevel() {
		  Tree<Integer, String> emptyTree= EmptyTree.getInstance();
		    Tree<Integer, String> firstTree= tree1();
		    Tree<Integer, String> secondTree= tree2();
		    Tree<Integer, String> thirdTree= tree3();
		    Tree<Integer, String> fourTree= tree4();
		  
		    assertEquals(0, emptyTree.level(0));
		    assertEquals(1, firstTree.level(10));
		    assertEquals(0, secondTree.level(10));
	  }
	  
	  
	  
	  
	  private static Tree<Integer, String> tree1() {
		    Tree<Integer, String> tree= EmptyTree.getInstance();

		    tree= tree.add(10, "ten");

		    return tree;
		  }
	  
	

	  private static Tree<Integer, String> tree2() {
		    Tree<Integer, String> tree= EmptyTree.getInstance();

		    tree= tree.add(1, "one");
		    tree= tree.add(2, "two");
		    tree= tree.add(3, "three");    
		    tree= tree.add(4, "four");	    
		    
		    
		    return tree;
		  }
	  
	  
	  

	  private static Tree<Integer, String> tree3() {
		    Tree<Integer, String> tree= EmptyTree.getInstance();


		    tree= tree.add(5, "five");
		    tree= tree.add(6, "six");
		    tree= tree.add(12, "twelve");    
		    tree= tree.add(8, "eight");
		    tree= tree.add(21, "twenty-one");
		    tree= tree.add(10, "ten");
		    tree= tree.add(11, "eleven"); 
		    return tree;
		  }
	
	  private static Tree<Integer, String> tree4() {
		    Tree<Integer, String> tree= EmptyTree.getInstance();

		    tree= tree.add(1, "one");
		    tree= tree.add(2, "two");
		    tree= tree.add(3, "three");    
		    tree= tree.add(4, "four");	   

		    return tree;
		  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
}
