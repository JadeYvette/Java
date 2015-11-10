//Jade Wilkins Directory ID:jwilkin1  UID:112450816 Section:201 
//I pledge on my honor that I have not given or received any unauthorized 
//assistance on this assignment.





package tree;

import java.util.List;

@SuppressWarnings({"unchecked", "rawtypes"})
public class EmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {

private static EmptyTree jadesEmpty = new EmptyTree();
	
  private EmptyTree(){
	
	}
	
	
	
	
  public static EmptyTree getInstance() {
    return  jadesEmpty;
  }

  public NonEmptyTree<K, V> add(K key, V value) {
    return new NonEmptyTree(key,value);
  }

  public int size() {
   return 0;
  }

  public V lookup(K key) {
    return null;
  }

  public Tree<K, V> copy() {
    return new EmptyTree();
  }

  public int level(K key) {
    return 0;
  }

  public K max() throws EmptyTreeException {
     throw new EmptyTreeException();
  }

  public K min() throws EmptyTreeException {
    throw new EmptyTreeException();
  }

  public Tree<K, V> delete(K key) {
   return getInstance();
  }

  public boolean haveSameKeys(Tree<K, V> otherTree) {
   if(otherTree == EmptyTree.getInstance()){
	   return true;
   }else{
	   return false;
   }
  }

  public void pathFromRoot(K key, List<K> list) {
    
  }

  public String toString() {
   return "";
  }




@Override
public int size(int sizeIn) {
	
	return 0;
}




@Override
public Tree copy(Tree leftTree2) {
	// TODO Auto-generated method stub
	return leftTree2;
}




@Override
public K max(K kIn) throws EmptyTreeException {
	// TODO Auto-generated method stub
	return kIn;
}




@Override
public K min(K kIn) throws EmptyTreeException {
	
	return kIn;
}









@Override
public void pathFromRootHelp(K key, List<K> list) {
	// TODO Auto-generated method stub
	
}




@Override
public boolean haveSameKeysHelper(Tree<K, V> otherTree) {
	// TODO Auto-generated method stub
	return false;
}

}

