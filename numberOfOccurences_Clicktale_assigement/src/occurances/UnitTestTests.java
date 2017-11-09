package occurances;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;
//The program won't accept by definition any integer variables thus this will not be checked.
public class UnitTestTests {
	HashMap<Character, Integer> expected = new HashMap<Character, Integer>();

	@Test
	//simple string with known characters
	public void test_simple() {
		
		expected.put('A', 2);
		expected.put('B', 2);
		expected.put('C', 2);
		expected.put('D', 1);
		assertEquals(expected,new HashMapOccur().countOccur("AABBCCD"));
	}
	@Test
	//diffrent count of 'C' character will fail the program
	public void test_diffrent_count_of_charcater() {
		
		expected.put('A', 3);
		expected.put('C', 3);
		expected.put('B', 2);
		expected.put('W', 2);

		assertEquals(expected,new HashMapOccur().countOccur("AABBCCCCWWA"));
	}

	@Test
	//test for special characters 
	public void test_special_characters(){
		
		expected.put('&', 2);
		expected.put('#', 8);
		expected.put('%', 2);
		expected.put('^',3);
		expected.put(')', 1);
		expected.put('-', 1);
		assertEquals(expected,new HashMapOccur().countOccur("&&########%%)^^^-"));
	}
	@Test
	//we mix big and small letters we expect to get A:3,C:10,B:2
	public void test_mixed_big_and_small_letters(){
		
		expected.put('a', 2);
		expected.put('C', 8);
		expected.put('B', 2);
		expected.put('c', 2);
		expected.put('A', 1);
		assertEquals(expected,new HashMapOccur().countOccur("AACCCCCCCCBBccA"));

	}
	@Test
	//check if the program can count numbers which are characters
	public void test_mixed_numbers_and_letters(){
		
		expected.put('5', 2);
		expected.put('C', 2);
		expected.put('B', 2);
		expected.put('c', 2);
		expected.put('A', 1);
		assertEquals(expected,new HashMapOccur().countOccur("55CCBBccA"));
	}
	@Test
	//check casting that will fail the program
	public void test_casting(){
		
		expected.put((char)5, 2);
		expected.put('C', 2);
		expected.put('B', 2);
		expected.put('^',3);
		expected.put('A', 1);
		assertEquals(expected,new HashMapOccur().countOccur("55CCBB^^^A"));
	}
	@Test
	//check for empty string
	public void test_isempty_string(){
		
		expected.put('c', 8);
		assertTrue(expected.isEmpty());
	}
	@Test
	//Test string length
	public void test_length() {
		
		expected.put('C', 2);
		expected.put('B', 2);
		expected.put('^',3);
		expected.put('A', 10);
		
		StringBuilder str = new StringBuilder();
		
	    for (Character c : expected.keySet()) {
	        for (int count=0;count<expected.get(c);count++){
	            str.append(c);
	        }
	    }
	    System.out.println(str);
		
		assertTrue(str.length()<1000);
	}
}
