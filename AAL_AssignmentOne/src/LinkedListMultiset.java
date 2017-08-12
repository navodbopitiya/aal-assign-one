import java.io.PrintStream;
import java.util.*;

public class LinkedListMultiset<T> extends Multiset<T>
{
	
	protected Node mHead;
	protected Node mTail;
	protected int mLength;
	
	
	public LinkedListMultiset() {
		// Implement me!
		
		 mHead = null; 
	     mTail = null;
	     mLength = 0;
			
	
	} // end of LinkedListMultiset()
	
	
	public void add(T item) {
		// Implement me!
		
		 Node newNode = new Node(item);
		 
	     // If head is empty, then the list is empty
	        if (mHead == null) {
	            mHead = newNode;
	            mTail = newNode;
	        }
	        // otherwise, add node to the head of list.
	        else {
	            newNode.setNext(mHead);
	            mHead.setPrev(newNode);
	            mHead = newNode;
	        }
	        
	        mLength++;
	} // end of add()
	
	
	public int search(T item) {
		// Implement me!		
		
		// default return, please override when you implement this method
		return 0;
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
	
	/* Creating Node class */
	
	class Node {
		
		private T mItem;
		private Node mNext, mPrev;
		
		public Node(T item) {
			
			mItem = item;
			mNext = null;
			mPrev = null;
					
		}
		
		/* Get the values */
				
		 public T getValue() {
	            return mItem;
	        }

	        public Node getNext() {
	            return mNext;
	        }
	        
	        
	        public Node getPrev() {
	            return mPrev;
	        }


	        public void setValue(T item) {
	            mItem = item;
	        }


	        public void setNext(Node next) {
	            mNext = next;
	        }
	        
	        public void setPrev(Node prev) {
	            mPrev = prev;
	        }
		
	
		
		
	}
	
} // end of class LinkedListMultiset