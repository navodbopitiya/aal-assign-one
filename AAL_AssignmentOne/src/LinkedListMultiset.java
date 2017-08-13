import java.io.PrintStream;

public class LinkedListMultiset<T> extends Multiset<T> {

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
			// item doesn't exist, add node to the tail of list.
			newNode.mPrev = mTail;
			newNode.mNext = null;
			mTail.mNext = newNode;
			mTail = newNode;
			mLength++;
		}

	} // end of add()

	@Override
	public int search(T item) {
		// Implement me!

		Node currNode = mHead;
	
		for (int i = 0; i < mLength; ++i) {
			if (currNode.getValue() == item) {
				return currNode.getCount();
			}
			currNode = currNode.getNext();
		}

		return 0;
		

	} // end of search()

	public void removeOne(T item) {
		// Implement me!

		Node currNode = mHead;

		// check if value is head node
		if (currNode.getValue() == item) {
			// check if length of 1
			if (mLength == 1) {
				mHead = mTail = null;
			} else {
				mHead = currNode.getNext();
				mHead.setPrev(null);
				currNode = null;
			}

			mLength--;
		}
		// search for value in rest of list
		else {
			currNode = currNode.getNext();

			while (currNode != null) {
				if (currNode.getValue() == item) {
					Node prevNode = currNode.getPrev();
					prevNode.setNext(currNode.getNext());
					// check if tail
					if (currNode.getNext() != null) {
						currNode.getNext().setPrev(prevNode);
					} else {
						mTail = prevNode;
					}
					currNode = null;
					mLength--;
				}

				currNode = currNode.getNext();
			}
		}

		// couldn't find a node with value

	} // end of removeOne()

	public void removeAll(T item) {
		// Implement me!
	} // end of removeAll()

	public void print(PrintStream out) {
		// Implement me!
		// entry.getKey() + printDelim + entry.getValue()
		if (mHead != null) {
			Node currNode = mHead;
			while (currNode != null) {
				out.println(currNode.getString() + printDelim + currNode.getCount());
				currNode = currNode.getNext();
			}
		}
	} // end of print()

	public Node getNode(T item) {
		Node currNode = mHead;
		Node tempNode = null;
		while (currNode != null) {
			if (currNode.getValue() == item) {
				tempNode = currNode;
				currNode = null;
			} else {
				currNode = currNode.getNext();
			}
		}
		return tempNode;

	}
	/* Creating Node class */

	class Node {

		private T mItem;
		private Node mNext, mPrev;
		/** Stored count of items in node */
		private int mCount;

		public Node(T item) {

			mItem = item;
			mNext = null;
			mPrev = null;
			mCount = 1;
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

		public void increaseCount() {
			mCount++;
		}

		public int getCount() {
			return mCount;
		}
		
		public String getString(){
			return mItem.toString();
		}

	}

} // end of class LinkedListMultiset