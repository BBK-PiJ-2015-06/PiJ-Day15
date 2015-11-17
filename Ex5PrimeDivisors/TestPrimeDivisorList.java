import org.junit.*;
import static org.junit.Assert.*;

public class TestPrimeDivisorList {
	
	private PrimeDivisorList myList;
	
	@Before
	public void init() {
		myList = new PrimeDivisorListImpl();
	}
	
	@Test
	public void testsAddingNullIntegerToList() {
		myList.add(null);
		assertEquals(0, myList.getList().size());
		myList.add(3);
		myList.add(5);
		assertEquals(2, myList.getList().size());
		assertEquals("[ 3 * 5 = 15 ]", myList.toString());
	}
	
	@Test
	public void testsAddingNonPrimeIntegerToList() {
		myList.add(3);
		myList.add(20);
		assertEquals(1, myList.getList().size());
		assertEquals("[ 3 ]", myList.toString());
	}
	
	@Test
	public void testsIsPrime() {
		assertFalse(myList.isPrime(0));
		assertFalse(myList.isPrime(1));
		assertTrue(myList.isPrime(2));
		assertTrue(myList.isPrime(3));
		assertFalse(myList.isPrime(4));
		assertTrue(myList.isPrime(5));
		assertFalse(myList.isPrime(6));
		assertTrue(myList.isPrime(7));
	}
	
	@Test
	public void testsRemove() {
		myList.add(3);
		myList.add(5);
		myList.add(12);
		myList.remove(2);
		assertEquals(2, myList.getList().size());
		myList.remove(1);
		assertEquals(1, myList.getList().size());
		myList.remove(0);
		assertEquals("[  ]", myList.toString());
	}
	
	@Test
	public void testsToString() {
		myList.add(3);
		myList.add(3);
		myList.add(7);
		myList.add(2);
		myList.add(2);
		myList.add(2);
		assertEquals("[ 2^3 * 3^2 * 7 = 504 ]", myList.toString());
	}
}