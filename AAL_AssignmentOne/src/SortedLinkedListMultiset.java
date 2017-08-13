import java.io.PrintStream;
import java.util.*;

public class SortedLinkedListMultiset<T> extends Multiset<T> {
	
	protected Node mHead;
	protected Node mTail;
	protected Node mCurrent;
	
	public SortedLinkedListMultiset() {
		// Implement me!
		mHead = null;
		mTail = null;
		mCurrent = null;
	} // end of SortedLinkedListMultiset()

	public void add(T item) {
		// Implement me!
		Node mNode = new Node(item);
		
		if(mHead == null){
			//If head is empty then list is empty
			mHead = mNode;
			mTail = mNode;
		}else if(search(item) != 0){
			//If head is not empty and there is a duplicate item already in the list
			
		}
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

	private class Node {
		/** Stored item of node. */
		private T mItem;
		/** Reference to next node. */
		private Node mNext;
		/** Reference to previous node. */
		private Node mPrev;
		/** Stored count of items in node */
		private int mCount;
		
		public Node(T item) {
			mItem = item;
			mPrev = null;
			mNext = null;
			mCount = 1;
			
		}

		public void setNext(Node next) {
			mNext = next;
		}

		public void setPrev(Node prev) {
			mPrev = prev;
		}

		public Node getNext() {
			return mNext;
		}

		public Node getPrev() {
			return mPrev;
		}

		public T getItem() {
			return mItem;
		}

		public void setItem(T item) {
			mItem = item;
		}
		
		public void increaseCount(){
			mCount++;
		}
		
		public int getCount(){
			return mCount;
		}

	} // end of inner class Node

} // end of class SortedLinkedListMultiset