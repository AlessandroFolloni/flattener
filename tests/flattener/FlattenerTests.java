package flattener;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlattenerTests {
	
	@Test
	public void test0() {
		//test null input
		boolean i = false;
		try {
			Flattener.flatten(null) ;
		} catch ( NullException e ) {
			i=true;
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		assertTrue( i );
	}
	
	@Test
	public void test1() {
		//test invalid input
		boolean i = false;
		try {
			Flattener.flatten( new Object[]{ 'a', 'b'} ) ;
		} catch ( NullException e ) {
			e.printStackTrace();
		} catch (InvalidInputException e) {
			i=true;
		}
		assertTrue( i );
	}
	
	
	
	@Test
	public void test2() {
		// test empty input
		Integer[] in  = {};
		Integer[] out = {};
		try {
			assertArrayEquals( out , Flattener.flatten( in ) );
		} catch (InvalidInputException | NullException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		//test a flat array
		Integer[] in = { 0,1,2,3,4,5 };
		Integer[] out = new Integer[6];
		for(int i= 0; i<= 5; i++ ) out[i] = i;
		try {
			assertArrayEquals( out, Flattener.flatten(in) );
		} catch (InvalidInputException | NullException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test4() {
		//test a depth 2 nested array
		Object[] inside = {3,4,5};
		Object[] in = { 0,1,2,inside };
		Integer[] out = new Integer[6];
		for(int i= 0; i<= 5; i++ ) out [i] = i;
		try {
			assertArrayEquals( out, Flattener.flatten(in) );
		} catch (InvalidInputException | NullException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test5() {
		//test a depth 3 array
		Object[] insideD2 = {3,4,5};
		Object[] insideD1 = {insideD2,6,7};
		Object[] in = { 0,1,2,insideD1 };
		Integer[] out = new Integer[8];
		for(int i= 0; i<= 7; i++ ) out[ i ] = i;
		try {
			assertArrayEquals( out, Flattener.flatten(in) );
		} catch (InvalidInputException | NullException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test6() {
		//test  [[1,2,[3]],4] 
		Object[] in = {new Object[]{1,2,		new Object[]{3}		}, 4};
		Integer[] out = new Integer[4];
		for(int i= 0; i< 4; ) out[ i ] = ++i;
		try {
			assertArrayEquals( out, Flattener.flatten(in) );
		} catch (InvalidInputException | NullException e) {
			e.printStackTrace();
		}
	}
	
}
