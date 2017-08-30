import java.io.PrintStream;
import java.util.*;

public class BstMultiset<T> extends Multiset<T>
{
	
	public static final int EMPTY_TREE = -1;

    /** Root node of the tree. */
	protected Node mRoot;


	public BstMultiset() {
		// Implement me!
		mRoot = null;
	} // end of BstMultiset()

	public void add(T item) {
		// Implement me!
		Node newNode = new Node(item);
		
		if(mRoot == null) {
			mRoot = newNode;
			return;
		} 
		
		Node current = mRoot;
		Node parent = null;
		
		while(true) {
			
			parent = current;
								
			if(((String) item).compareTo((String)current.getValue()) > 0) {
				
				current = current.mRightChild;
				
				if(current==null){
					parent.mLeftChild = newNode;
					return;
				}
				
			}
		}
			
	} // end of add()


	public int search(T item) {
		// Implement me!
		Node current = mRoot;
		while(current!=null){
			if(current.mItem==item){
				// found the node
			}else if(current.mItem>item){
				current = current.mLeftChild;
			}else{
				current = current.mRightChild;
			}
		}
			
		return 0; // return count
	} // end of add()


	public void removeOne(T item) {
		// Implement me!
	} // end of removeOne()
	
	
	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()


	public void print(PrintStream out) {
		// Implement me!
	} // end of print()
	
	
	
	class Node
	{
		  	private T mItem;
	        /** Reference to left child. */
	        public Node mLeftChild;
	        /** Reference to right child. */
	        public Node mRightChild;


	        /**
	         * Constructor.
	         * @param <T>
	         *
	         * @param key Key to store in node.
	         */
	        public Node(T item) {
	                mItem = item;
	                mLeftChild = null;
	                mRightChild = null;
	        }


	        /**
	         *
	         * @return Key stored in node.
	         */
	        public T getValue() {
	            return mItem;
	        } // end of getKey()


	        /**
	         *
	         * @return Reference to left child of node.
	         */
	        public Node leftChild() {
	            return mLeftChild;
	        } // end of leftChild()


	        /**
	         *
	         * @return Reference to right child of node.
	         */
	        public Node rightChild() {
	            return mRightChild;
	        } // end of rightChild()

	} // end of class Node


} // end of class BstMultiset


