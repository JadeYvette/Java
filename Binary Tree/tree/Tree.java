//Jade Wilkins Directory ID:jwilkin1  UID:112450816 Section:201 
//I pledge on my honor that I have not given or received any unauthorized 
//assistance on this assignment.





package tree;

import java.util.List;

public interface Tree<K extends Comparable<K>, V> {
  Tree leftTree = null;
  Tree rightTree = null;

  public NonEmptyTree<K, V> add(K key, V value);
  public int size();
  public V lookup(K key);
  public Tree<K, V> copy();
  public int level(K key);
  public K max() throws EmptyTreeException;
  public K max(K kIn) throws EmptyTreeException;
  public K min() throws EmptyTreeException;
  public K min(K kIn) throws EmptyTreeException;
  public Tree<K, V> delete(K key) ;
  public boolean haveSameKeys(Tree<K, V> otherTree);
  public void pathFromRootHelp(K key, List<K> list);
  public void pathFromRoot(K key, List<K> list);
  public int size(int sizeIn);
  public Tree copy(Tree leftTree2);
  public boolean haveSameKeysHelper(Tree<K, V> otherTree);



}
