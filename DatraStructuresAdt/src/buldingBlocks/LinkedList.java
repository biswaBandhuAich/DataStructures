package buldingBlocks;

public class LinkedList<E> {
	Node headNode;
	Node lastNode;

	static class Node<E> {
		Node nextNode;
		E value;

		public Node(E value) {
			this.value = value;
			this.nextNode = null;
		}

	}

	public Node<E> insertElement(LinkedList list, E value) {
		if (list.headNode != null) {
			Node elementNode = new Node(value);
			elementNode.nextNode = null;
			Node lastNode = list.headNode;
			while (lastNode.nextNode != null) {
				lastNode = lastNode.nextNode;
			}
			lastNode.nextNode = elementNode;
			list.lastNode=elementNode;
			System.out.println("Inserted Succesfully");
			return elementNode;
		} else {
			list.headNode = new Node(value);
			list.lastNode=headNode;
			System.out.println("List Initiated Succesfully");
			return headNode;
		}
	}

	public void insertElementAfter(LinkedList list, E value, E insertAfter) {
		Node currNode = list.headNode;
		Node tempNode;
		if (currNode != null) {
			while (currNode != null) {
				if (currNode.value.toString().equals(insertAfter.toString())) {
					tempNode = currNode.nextNode;
					currNode.nextNode = new Node(value);
					currNode.nextNode.nextNode = tempNode;
					break;
				} else {
					currNode = currNode.nextNode;
				}
			}

		} else {
			System.out.println("List is Empty. Initiating new List");
			insertElement(list, value);
		}

	}

	public void insertElementBefore(LinkedList list, E value, E insertBefore) {
		Node currNode = list.headNode;
		Node tempNode;
		int i = 0;
		if (currNode != null) {
			while (currNode.nextNode != null) {
				if (currNode.nextNode.value.toString().equals(insertBefore.toString())) {
					E insertElem = (E) currNode.value;
					insertElementAfter(list, value, insertElem);
					i++;
					break;
				} else {
					currNode = currNode.nextNode;
				}
			}

		} else {
			System.out.println("List is Empty. Initiating new List");
			insertElement(list, value);
		}
		if (i == 0) {
			System.out.println("Elemnet Not Found");
		}

	}

	public static void printList(LinkedList list) {
		Node getNode = list.headNode;
		if (getNode == null) {
			System.out.print("List is empty!!!");
		} else {
			Node goUptoLastNode = list.headNode;
			do {
				System.out.print(goUptoLastNode.value.toString() + " ");
				goUptoLastNode = goUptoLastNode.nextNode;
			} while (goUptoLastNode != null);

		}
		System.out.println(" ");
	}

	public void deleteElement(LinkedList list, E value) {
		Node currNode = list.headNode;
		int i=0;
		while (currNode != null) {
			if ((currNode.nextNode != null) && currNode.nextNode.value.equals(value)) {
				if (currNode.nextNode.nextNode != null) {
					currNode.nextNode = currNode.nextNode.nextNode;
					i++;
					break;
				} else {
					// For last element
					currNode.nextNode = null;
					i++;
				}
			}

			else {
				currNode = currNode.nextNode;
			}
		}
		if(i==0) {
			System.out.println("Element not found!!!");
		}

	}

	public static void main(String[] args) {
		LinkedList<Integer> a = new LinkedList<Integer>();
		printList(a);
		a.insertElement(a, 5);
		printList(a);
		a.insertElement(a, 4);
		a.insertElement(a, 3);
		a.insertElement(a, 4);
		printList(a);
		a.insertElement(a, 100);
		printList(a);
		a.insertElementAfter(a, 25, 3);
		printList(a);
		a.insertElementBefore(a, 7, 25);
		printList(a);
		a.deleteElement(a, 100);
		printList(a);
		a.deleteElement(a, 200);


	}

}