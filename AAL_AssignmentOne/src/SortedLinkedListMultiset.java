import java.io.PrintStream;
import java.util.*;

public class SortedLinkedListMultiset<T> extends Multiset<T> {

	protected Node mHead;
	protected Node mTail;
	protected int mLength;

	public SortedLinkedListMultiset() {
		// Implement me!
		mHead = null;
		mTail = null;
		mLength = 0;
	} // end of SortedLinkedListMultiset()

	public void add(T item) {
		// Implement me!
		Node newNode = new Node(item);

		if (mHead == null) {
			// If head is empty, then the list is empty
			mHead = newNode;
			mTail = newNode;
			mLength++;
		} else if (search(item) != 0) {
			// Item already exists in the list - increase count
			Node currNode = getNode(item);
			currNode.increaseCount();
		} else {
			Node currNode = mHead;
			while(currNode != null && ((String) item).compareTo((String) currNode.getItem()) > 0){
				currNode = currNode.getNext();
			}
			
			if(currNode != null){
				if(currNode.equals(mHead)){
					//The new node is the smallest value, add to head
					currNode.mPrev = newNode;
					newNode.mNext = currNode;
					mHead = newNode;
					mLength++;
				}else{
					//The new node should be added to somewhere in the middle.
					currNode.mPrev.mNext = newNode;
					newNode.mPrev = currNode.mPrev;
					newNode.mNext = currNode;
					currNode.mPrev = newNode;
					mLength++;
				}
				
			}else{
				//The new node is the biggest value, add to tail
				newNode.mPrev = mTail;
				newNode.mNext = null;
				mTail.mNext = newNode;
				mTail = newNode;
				mLength++;
			}
		}
	} // end of add()

	public int search(T item) {
		// Implement me!

		Node currNode = mHead;
		int instances = 0;

		for (int i = 0; i < mLength; ++i) {
			if (((String) item).compareTo((String) currNode.getValue()) == 0) {
				instances = currNode.getCount();
			}
			currNode = currNode.getNext();
		}
		return instances;
	} // end of add()

	public void removeOne(T item) {
		// Implement me!
		Node currNode = getNode(item);
		if (currNode != null) {
			if (currNode.getCount() > 1) {
				// If there is more than one item.
				currNode.decreaseCount();
			} else {
				deleteNode(currNode);
			}
		}
	} // end of removeOne()

	public void removeAll(T item) {
		// Implement me!
		Node currNode = getNode(item);
		if (currNode != null) {
			deleteNode(currNode);
		}
	} // end of removeAll()

	public void print(PrintStream out) {
		if (mHead != null) {
			Node currNode = mHead;
			while (currNode != null) {
				out.println(currNode.getString() + printDelim + currNode.getCount());
				currNode = currNode.getNext();
			}
		}
	} // end of print()

	public Node getNode(T item) {
		// Finds and returns node that has the exact item
		Node currNode = mHead;
		Node tempNode = null;
		while (currNode != null) {
			if (((String) item).compareTo((String) currNode.getValue()) == 0) {
				tempNode = currNode;
				currNode = null;
			} else {
				currNode = currNode.getNext();
			}
		}
		return tempNode;

	}

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

		public T getValue() {
			return mItem;
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

		public void increaseCount() {
			mCount++;
		}

		public void decreaseCount() {
			mCount--;
		}

		public int getCount() {
			return mCount;
		}

		public String getString() {
			return mItem.toString();
		}

	} // end of inner class Node

	protected void deleteNode(Node currNode) {
		// If there is only one item left.
		if (currNode.equals(mHead) && mHead.getNext() != null) {
			// If Current is at head and there are other nodes
			mHead = mHead.getNext();
			mLength--;
			currNode = mHead;
		} else if (currNode.equals(mHead) && mHead.getNext() == null) {
			// If Current is at head and there are no other nodes
			mHead = null;
			mLength--;
		} else if (currNode.equals(mTail)) {
			// Current node is at tail
			mTail = mTail.getPrev();
			mTail.setNext(null);
			mLength--;
		} else if (currNode != null) {
			// Current node is not null and is in the middle
			Node prvNode = currNode.getPrev();
			Node nxtNode = currNode.getNext();
			currNode.mPrev.setNext(nxtNode);
			currNode.mNext.setPrev(prvNode);
			currNode = nxtNode;
			mLength--;
		}
	}

} // end of class SortedLinkedListMultiset