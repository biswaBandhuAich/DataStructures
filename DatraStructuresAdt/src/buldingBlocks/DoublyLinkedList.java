package buldingBlocks;

import buldingBlocks.LinkedList.*;

public class DoublyLinkedList<E> extends LinkedList<E> {
	DoublyLinkedListNode headNode;

	protected static class DoublyLinkedListNode<E> extends Node<E>
	{
		protected DoublyLinkedListNode<E> prev;
		public DoublyLinkedListNode(E value) {
			super(value);
		}
		
	}

	public DoublyLinkedListNode insertElement(DoublyLinkedList<E> list, E value) {	
		
		if(list.headNode==null) {
			list.headNode = new DoublyLinkedListNode<E>(value);
			list.headNode.prev=null;
			System.out.println("List Initiated Succesfully");
			return headNode;
		}
		else {
			DoublyLinkedListNode<E> elementNode=new DoublyLinkedListNode<E>(value);
			elementNode.nextNode=null;
			DoublyLinkedListNode<E> findLastNode=list.headNode;
			while(findLastNode.nextNode!=null) {
				findLastNode=(DoublyLinkedListNode<E>) findLastNode.nextNode;
			}
			findLastNode.nextNode=elementNode;
			elementNode.prev=findLastNode;
			return elementNode;
		}
			}
	public static void printList(DoublyLinkedList list) {
		DoublyLinkedListNode getNode = list.headNode;
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
	
	public static void main(String[] args) {
		DoublyLinkedList<Integer> a = new DoublyLinkedList<Integer>();
		printList(a);
		a.insertElement(a, 5);
		printList(a);
		a.insertElement(a, 6);
		printList(a);
		a.insertElement(a, 10);
		printList(a);
	}

}
