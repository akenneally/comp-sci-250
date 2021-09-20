/**
 *
 * @param <E>
 */

public class SinglyLinkedList <E> {
	
	private Node<E> head = null;	// head node of the list
	private Node<E> tail = null;	// last node of the list
	private int size = 0;
	
	/**
	 * returns the number of elements in the list
	 * @return
	 */
	public int size() {
       return size;
	}
	/**
	 * returns true if the list is empty, and false otherwise
	 * @return
	 */
	public boolean isEmpty() {
        return (size == 0);
	}
	/**
	 * returns (but does not remove) the first element in the list
	 * @return
	 */
	public E first(){
		if (isEmpty()) return null;
		return head.element;
	}
	/**
	 * returns (but does not remove) the last element in the list
	 * @return
	 */
	public E last(){
		if (isEmpty()) return null;
		return tail.element;
	}
	/**
	 * adds a new element to the front of the list
	 * @param e
	 */
	public void addFirst (E e){
		Node<E> newest = new Node<>(e);
		newest.next = head;
		head = newest;
		if (isEmpty()){
			tail = head;
		}
		size ++;

	}
	/**
	 * adds a new element to the end of the list
	 * @param e
	 */
	public void addLast(E e) {
		Node<E> newest = new Node<>(e);
		newest.next = null;
		if (isEmpty()) {
			head = newest;
		}else{
			tail.next = newest;
			}

		tail = newest;
		size++;
	}
	/**
	 * removes the first element of the list
	 */
	public void removeFirst(){
		if (isEmpty()){
		}
		head = head.next;
		size--;
		if (isEmpty()){
			tail = null;
		}
            
	}
	
	/**
	 * Inner class (or nested class) for encapsulation.
	 * Shielding users of our class from the underlying details about nodes and links
	 * @param <E>
	 */
	private static class Node<E> //E can be type anything
	{
		private E element;
		private Node<E> next = null;

		public Node (E e) {
			element = e;
		}
	}
}
