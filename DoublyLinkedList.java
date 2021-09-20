/**
 * Basic doubly linked list implementation
 * @param <E>
 */
public class DoublyLinkedList <E> {
	private Node<E> header;
	private Node<E> footer;
	private int size = 0;
	/**
	 * Create header and footer nodes, linked
	 */
	public DoublyLinkedList() {
		header = new Node<E>(null,null,null);
		footer = new Node<E>(null,header,null);
		header.setNext(footer);
	}
	/**
	 * Returns the number of elements in the list
	 * @return
	 */
	public int size() {
       return size;
    }
	/**
	 * Returns true if the list is empty and false otherwise
	 * @return
	 */
	public boolean isEmpty() {
       return size == 0;
	}
	
	/**
	 * Returns (but does not remove) the first element in the list
	 * @return
	 */
	public E first(){
        return header.element;
	}
	
	/**
	 * Returns (but does not remove) the last element in the list
	 * @return
	 */
	public E last(){
		return footer.element;
	}

	/**
	 * Adds a new element to the front of the list
	 * @param e
	 */
	public void addFirst (E e){
		addBetween(e, header.getNext(), header);
    }
	
	/**
	 * Adds a new element to the end of the list
	 * @param e
	 */
	public void addLast(E e) {
       addBetween(e, footer.getPrev(), footer);
    }
    
    /**
     * Add element e to the linked list in between the given nodes
     * @param e
     * @param predecessor
     * @param successor
     */
    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
    	Node newest = new Node(e, predecessor, successor);
    	newest.element = e;
    	newest.prev = header;
    	newest.next = successor;
    	predecessor.next = newest;
    	successor.prev = newest;
    	size++;
    }
	
	/**
	 * Removes and returns the first element of the list
	 * @return
	 */
	public E removeFirst(){
		if (isEmpty()){
			return null;
		}
		return remove(header.getNext());
	}
	
	/**
	 * Removes and returns the last element of the list
	 * @return
	 */
	public E removeLast(){
		if (isEmpty()){
			return null;
		}
		return remove(footer.getPrev());
	}

	/**
	 * Removes the given node from the list and returns its element
	 * @param node
	 * @return
	 */
	private E remove (Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
	}
	
	/**
	 * Inner class
	 * @param <E>
	 */
	private static class Node <E> {
		private E element;
		private Node<E> prev;  // predecessor
		private Node<E> next;  //successor
        
        
		public Node (E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}
		public E getElement() {
			return element;
		}
		public Node<E> getPrev() {
			return prev;
		}
		public Node<E> getNext() {
			return next;
		}
		public void setPrev(Node<E> p) {
			prev = p;
		}
		public void setNext(Node<E> n) {
			next = n;
		}
	}

}
