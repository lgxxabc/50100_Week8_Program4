package Week8_Program4;

public class Set {
	LinkedNode front; // Reference to the first LinkedNode in the list

	// Constructor - initializes the front variables
	public Set() {
		front = null;
	}

	// Implements the add operation.
	public void add(int x) {
		LinkedNode newNode = new LinkedNode(x);
		if (exists(x)) {
			return;
		} else {
			newNode.next = front;
			front = newNode;
		}
	}

	// Implements the delete operation.
	public void delete(int x) {
		if (front == null) {
			return;
		}

		if (!exists(x)) {
			return;
		}
		
		// Use a dummy node to make sure we can delete at the front.
		LinkedNode dummyHead = new LinkedNode();
		// Connect the dummy node to the front.
		dummyHead.next = front;
		
		// The cur node is the next node of the prev node
		LinkedNode cur = front;
		LinkedNode prev = dummyHead;

		while (cur != null) {
			if (cur.x == x) {
				// Delete the cur node
				prev.next = cur.next;
			} else {
				// Keep scanning
				prev = cur;
			}
			cur = cur.next;
		}

		front = dummyHead.next;

	}

	// Implements the exist operation.
	public boolean exists(int x) {
		LinkedNode cur = front;
		while (cur != null) {
			if (cur.x == x) {
				return true;
			} else {
				cur = cur.next;
			}
		}
		return false;
	}

	// This method returns a String containing
	// a space separated representation of the underlying linked list
	public String toString() {
		String str = " ";

		LinkedNode cur = front;

		while (cur != null) {
			str += cur.x + " ";
			cur = cur.next;
		}

		return str;
	}
}
