//Jade Wilkins Directory ID:jwilkin1  UID:112450816 Section:201 
//I pledge on my honor that I have not given or received any unauthorized 
//assistance on this assignment.




package tree;

import java.util.List;

@SuppressWarnings("unchecked")
public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {
//Creates the fields of the leftTree and the RighTree which will be
// branches of the tree;
	private Tree leftTree;
	private Tree rightTree;
	
//creates the fields to hold the data of the tree and the  key used to locate 
// the data
	private K key;
	private V data;


	
	
// Constructor for the NonEmptyTree that instantiates the key & data field
// with the key and value being passed through
 public NonEmptyTree(K key,V value){
	 
	this.key = key;
	data = value;
 // sets the branches equal to an EmptyTree;
	leftTree = EmptyTree.getInstance();
	rightTree = EmptyTree.getInstance();
	 
 }
	
	
	//creates a new tree with the corresponding value and key,to the appropriate 
   // spot
  public NonEmptyTree<K, V> add(K key, V value) {
	  NonEmptyTree treeIn = new NonEmptyTree(key,value);
		
	  if (key.compareTo(this.key) < 0) {
		  if(leftTree == EmptyTree.getInstance()){
			leftTree = treeIn;
		
			  
		  } else {
			 leftTree =  leftTree.add(key, value);
		  }
    	   
    
    	
    }
    
	if ( key.compareTo(this.key) > 0)  {
		if(rightTree == EmptyTree.getInstance()){
			
		   rightTree = treeIn;
			
		} else {
			rightTree = rightTree.add(key, value);
		}
	}
	  
    if (this.key.compareTo(key) == 0) {
    	
    }
    
    
    
	return this;
  } 
  
  
  
  
  // returns the size of the current tree
  public int size(int sizeIn) {
	  
	   // checks to see that both the left tree and right tree aren't empty
	  //since their not empty you can add two more to size
	  // then calls size on those two branches
	    if (leftTree != EmptyTree.getInstance() && rightTree != EmptyTree.getInstance()) 
	    {
	         sizeIn = sizeIn +2;
	    	 sizeIn = leftTree.size(sizeIn);
	    	 sizeIn = rightTree.size(sizeIn);
	    }
	    
	    // checks if the right branch is empty and the left is not if so it adds
	    //one to the size and then checks the size of the left branch;
	   if (leftTree != EmptyTree.getInstance() && rightTree == EmptyTree.getInstance() )
	   {
		   sizeIn = sizeIn +1;
		   sizeIn =  leftTree.size(sizeIn);
	   }
	    
	   // checks if the right tree isnt empty and that the left tree is
	   // if so it adds one to the size and checks the size of the right tree;
	   if (rightTree!= EmptyTree.getInstance() && leftTree == EmptyTree.getInstance()) 
	   {
		   sizeIn = sizeIn +1;
		   sizeIn =  rightTree.size(sizeIn);
	   }
	   
	   // returns the size;
	    return sizeIn;
	  } 
  
  // calls the size method above to return the current size;
  public int size() {
	  // passes through the value one because a NonEmpty has to have at least
	  //one tree;
	return size(1);
  }
  
  


  
  // returns the data associated with the key being pass through
  public V lookup(K key) {

 // if the key of the tree is the key were looking for return the data of that 
// key 
   if (this.key.compareTo(key) == 0) {
	   return data;
   } else {
	       
	   // if not  check if the key is in the rightTree
	   // if the rightTree isnt empty it checks the leftTree;
	      if (key.compareTo(this.key) > 0  ) {
	    	   if(rightTree != EmptyTree.getInstance())
	    	  return (V) rightTree.lookup(key);
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	    	  
	      } else {
	    	  // checks if the key is in the left tree
	    	  // if the left tree isnt empty it checks the left tree
	    	  if (leftTree!=EmptyTree.getInstance())
	    	 return  (V)leftTree.lookup(key);
	    	  
	      }
	   
	   
	   
	   
   }
return null;
  }
  //makes a copy of the current object
  public Tree<K, V> copy() {
	// creates an copy of the root of the current tree
    NonEmptyTree root = new NonEmptyTree(key,data);
	   // returns the new tree  by  calling the helper method
        return copy(root);
	
      
  }
  
  // helper method for the copy method
  public Tree<K, V> copy(Tree TreeIn) {
	  //creates a copy of the current object
	   NonEmptyTree treeCopy = new NonEmptyTree(key,data) ;
	   
	   
	   //checks if the tree has any empty branches if true it makes 
	   //a copy of both sides
		
	    if (leftTree != EmptyTree.getInstance() && rightTree != EmptyTree.getInstance()) 
	    {
	    	//sets the copies left tree to a copy of the current objects left tree
	        treeCopy.leftTree = leftTree.copy(treeCopy);
	        
	        //sets the copies right tree to a copy of the current objects left tree
	    	treeCopy.rightTree = rightTree.copy(treeCopy);
	    	
	    
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    }
	    // checks if the tree has a  empty right tree and non empty left tree
	    // if so it only copies the left tree
	    if (leftTree != EmptyTree.getInstance() && rightTree == EmptyTree.getInstance()) 
	    {
	    	
	    	//sets the copies left tree to a copy of the current objects left tree
	    	treeCopy.leftTree = this.leftTree;
		}
		// checks if the tree has a empty leftTree and a non empty right tree
	    // if so it makes a copy of the rightTree;
		if (rightTree != EmptyTree.getInstance() && leftTree == EmptyTree.getInstance()) 
		{
			//sets the copies right tree to a copy of the current objects left tree
			 treeCopy.rightTree = this.rightTree;
		}
		// returns the copied tree;
		return treeCopy;
		

	  } 
  
  
  int returnVal = 1;
  public int level(K key) {
	  
	  
	  if (this.lookup(key) == null) {
		  return 0;
	  }
	
    if (this.key.compareTo(key) == 0) {
    	return returnVal;
    }else{
    	   returnVal++;
    	if (this.key.compareTo(key) > 0) {
    		leftTree.level(key);
    	} else {
    		rightTree.level(key);
    	}
    	
    	
    }
	return returnVal;
  }
  //returns the max Value 
  public K max() throws EmptyTreeException {
	  K maxVal = key;
      if ( rightTree == EmptyTree.getInstance()) {
    	  return key;
      } else {
    	  return (K) rightTree.max(maxVal);
    	  
    	  
    	  
      }
  }
//helper method of max
  public K max(K keyIn) throws EmptyTreeException {
	  K maxVal = keyIn;
	  if (key.compareTo(keyIn) > 0) {
		  maxVal = key;
		 
		 
	  }
	  
	  if (rightTree != EmptyTree.getInstance()) {
		  return (K) rightTree.max(maxVal);
	  }
	  
	  
	  
	  
	  
	  
     
	return maxVal;
  }
  
  
  
  
  
  //return the min val
  public K min() throws EmptyTreeException {
	  K minVal = key;
      if (leftTree == EmptyTree.getInstance()) {
    	  return key;
      } else {
    	  return (K) leftTree.min(minVal);
    	  
    	  
    	  
      }
  }
  
  
// helper method for the min method
  public K min(K keyIn) throws EmptyTreeException {
	  K minVal = keyIn;
	  if (key.compareTo(keyIn) < 0) {
		  minVal = key;
		 
		 
	  } else {
		  return minVal;
	  }
	  
	  if (leftTree != EmptyTree.getInstance()) {
		 return  (K) leftTree.min(minVal);
	  }
	  
	  
	  
	  
	  
	  
     
	return minVal;
  } 
  
  
  
  
  
  
  
  
  

  
  
  
  // deletes the object associated with the key being passed through 
  public Tree<K, V> delete(K key)  {
	 
	  if (key.compareTo(this.key) == 0) {
		  
		  if (leftTree == EmptyTree.getInstance() && rightTree 
				  == EmptyTree.getInstance())
		  {
			   return EmptyTree.getInstance();
			   
			    
		  } else {
			  
			  if (rightTree != EmptyTree.getInstance()) {
				   Tree<K,V> rightTreeIn = rightTree.copy();
				  try { 
					
				   K valueIn = (K) rightTreeIn.min();
				   delete(valueIn);
				   setData(rightTreeIn.lookup(valueIn));
				   setKey(valueIn);
				  
			       return this;
		        
				} catch (EmptyTreeException e) {
					
				}
			  } else {
				   
				   try {
					setKey((K) leftTree.max());
					setData(lookup((K) leftTree.max())) ;
				} catch (EmptyTreeException e) {
					
				}
				  
				  
				  
				  
				  
				  
				  
				  
			  }
			  
			  
	        	
				 
				  
	        	 
			  
			  
			  
			  
			  
			  
			  
		  }
		  
		  
         
	  } else{
		  
		  
		  
		  
		    if (key.compareTo(this.key) > 0 ) {
		      rightTree = rightTree.delete(key);
		    
		   
		   
	   } else {
		   
		   leftTree = leftTree.delete(key);
		   
		   
	   }
		  }
	  
	  
	  
	  
	  
	  
	  
	  
	 
	  
	  
	  
	   return this;
	  
	  }
  
  
  
  
  
  
  
  
  
//tells if the tree has all the same keys as the key being passed through
  public boolean haveSameKeys(Tree<K, V> otherTree) {
	 Tree<K, V> treeIn = (NonEmptyTree<K, V>) this.copy();
	  Tree <K,V> otherTreeIn= (NonEmptyTree<K, V>) otherTree.copy();
	 if (size() == otherTree.size()) {
		  return treeIn.haveSameKeysHelper(otherTreeIn);
	 } else {
		 return false;
	 }
	
	
	
  }
  
  //helps the haveSameKeys method
  public boolean haveSameKeysHelper(Tree<K, V> otherTree) {
	  
		  if (otherTree.lookup(key) !=null) {
			  if (size() ==  1) {
					 if (otherTree.lookup(key) !=null){
						  return true;
						  
					  }
			
			  }
			   delete(key);
			  
			   return haveSameKeysHelper(otherTree);
			  
		  }
		  
		  
		return false;
	
		  
	  } 

  // returns a list containing the path from the root
  public void pathFromRoot(K key, List<K> list) {
    //checks if the key is actually inside of the current tree
   // if its true it calls the helper method to fill the list 
   //with the path from the root
	  
	  if (lookup(key) != null) {
      
    		this.pathFromRootHelp(key, list);
    		
    		
    	}
  
    	
    }
     
    // helps the pathFromRoot method
	  public void pathFromRootHelp(K key, List<K> list) {
		   //adds the key of the current object to the list
	      	list.add(this.key);
	    	 //if key is greater than the current objects key its calls the 
	      	//method on the rightTree in order to keep searching for the key
	    	if (this.key.compareTo(key) < 0) {
	    	 
	    	 rightTree.pathFromRootHelp(key, list);
	    		
	    		
	    	}
	    	//if key is greater than the current objects key its calls the 
	      	//method on the leftTree in order to keep searching for the key
	    	if (this.key.compareTo(key) > 0) {
	    	   leftTree.pathFromRootHelp(key, list);
	    	}
	    		
	    	//once the key is found the method stops running	
	    	if (this.key.compareTo(key) == 0 ) {
	    		
	    		
	    	}
	   
	    	
	    
	     
	    
	  }

	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
// returns a string representing the current object	  
  public String toString()  {
		//Concatenates the string represent the left tree of the current object
	   // with the current key and data then the right tree of 
	  //the current object
	 
	    String stringIn = leftTree.toString() + " " + toStringHelp() 
	    		+ rightTree.toString();
	    
	    // used to remove the last space from the string
		String returnVal = stringIn.trim();
		
		//returns the string representing the current object
		return returnVal;
		 
		   
	   
	  
  }
  
  
 //forms a string to represent just the root of the current tree 
  public String toStringHelp() {
	  return  key + "/" + data +" ";
   
	   
   }
  
 //helper 
 
  
  
  // sets the data of the current object to the argumenent
  private void setData(V dataIn){
	  this.data = dataIn;
  }
  //sets the key of the current object to the argument 
  private void setKey(K keyIn){
	  this.key = keyIn;
  }
  
  
  
  
  
  

}
