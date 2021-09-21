package Activities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)

public class Activity1 {

	// declaring Arraylist
	static ArrayList<String> list;

	// initializing Arraylist
	@BeforeAll
	void setUp() throws Exception {
		list = new ArrayList<String>();
		list.add("S1");
		list.add("S2");
	}


	@Test
	public void insertTest() {
		// size assertion correct
		assertEquals(2, list.size(), "Wrong size");
		// adding value in arraylist
		list.add("S3");
		// size assertion incorrect
		assertEquals(3, list.size(), "Wrong size");

		// assert individual elements
		assertEquals("S1", list.get(0), "Wrong element");
		assertEquals("S2", list.get(1), "Wrong element");
		assertEquals("S3", list.get(2), "Wrong element");
	}

	@Test
	public void replaceTest() {
		list.set(1, "S3");

		// size assertion
		assertEquals(2, list.size(), "Wrong size");

		// Assert individual Elements
		assertEquals("S1", list.get(0), "Wrong element");
		assertEquals("S2", list.get(1), "Wrong element");

	}
}
