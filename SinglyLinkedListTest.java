import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SinglyLinkedListTest {

	@Test
	void test() {
		SinglyLinkedList<String> list = new SinglyLinkedList<String>();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		assertNull(list.first());
		assertNull(list.last());
		
		list.addFirst("BOS");
		assertEquals(1, list.size());
		assertFalse(list.isEmpty());
		assertEquals("BOS",list.first());
		assertEquals("BOS",list.last());
		
		list.removeFirst();
		assertEquals(0, list.size());
		assertTrue(list.isEmpty());
		assertNull(list.first());
		assertNull(list.last());

		list.addFirst("BOS");
		list.addFirst("ATL");
		list.addFirst("MSP");
		assertEquals(3, list.size());
		assertFalse(list.isEmpty());
		assertFalse(list.first() == list.last());
		
		list.addLast("LAX");
		assertEquals(4, list.size());
		assertEquals("LAX",list.last());
	
	}

}
