import java.util.*;
/**
 * A PrimeDivisorList is a list that only takes integers that are prime.
 * Integers can be added and / or removed from the PrimeDivisorList. 
 *
 * If an Integer that is null is attempted to be added to the PrimeDivisorList,
 * a NullPointerException is thrown. If a non-prime Integer is added to the
 * PrimeDivisorList, then an IllegalArgumentException is thrown. 
 *
 * This class overrides the toString() method to print the calculation and result of
 * multiplying each element in the list. This enables the result to be represented
 * as a product of its prime numbers.
 */

public interface PrimeDivisorList {
	
	/**
	 * Adds an Integer to the PrimeDivisorList.
	 *
	 * @param integer the Integer to be added to the PrimeDivisorList.
	 *
	 * @throws NullPointerException if the Integer provided is null
	 * @throws IllegalArgumentException if the Integer provided is not prime
	 */
	void add(Integer integer);
	
	/**
	 * Removes an Integer from the PrimeDivisorList.
	 *
	 * @param index the position in the list to remove the Integer.
	 *
	 * @throws IndexOutOfBoundsException if index provided is greater or 
	 *         smaller than the range of indices currently present in 
	 *         the PrimeDivisorList
	 */
	void remove(int index);
	
	/**
	 * Prints on the screen the product of all Integers within the list. 
     * Prints the result as a product of its prime numbers. If the list
     * is empty or null, a [] is printed to the screen.	 
	 *
	 * @return a string which contains the result as a product of its 
	 *         prime numbers
	 */
	String toString();
	
	/**
	 * Returns true if the Integer provided is a prime number, otherwise
     * this method returns false.
     *
     * @param integer the Integer to be tested as to whether it is prime
     *        or not	 
	 *
	 * @return returns true if the Integer is prime, false otherwise
	 */
	boolean isPrime(Integer integer);
	
	List<Integer> getList();
}