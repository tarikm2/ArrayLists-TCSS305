/**
 * 
 */
package mylistpackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Tarik
 * @version 4/19/2015
 */
public class ArrayListSortedTest {
    
/**
 * List #1.
 */
    private ArrayListSorted<Integer> myList1;
    
    /**
     * List #2.
     */
    private ArrayListSorted<Integer> myList2; 
    
    /**
     * List #3.
     */
    private ArrayListSorted<Integer> myList3;
    
    /**
     * @throws java.lang.Exception if object not constructed.
     */
    @Before
    public void setUp() throws Exception {
        myList1 = new ArrayListSorted<Integer>();
        myList2 = new ArrayListSorted<Integer>();
        myList3 = new ArrayListSorted<Integer>();
        
        for (int i = 1; i <= 6; i++) {
            myList2.insert(i);
        }
        
        for (int i = 1; i <= 25000; i++) {
            myList3.insert(i);
        }
        
        System.out.print(myList1);
    }

    /**
     * Test method for {@link mylistpackage.ArrayListSorted#ArrayListSorted()}.
     */
    @Test
    public void testArrayListSorted() {
        assertEquals(0, myList1.getSize());
        assertEquals("[]", myList1.toString());
        assertEquals(6, myList2.getSize());
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList2.toString());
        
        
    }

    /**
     * Test method for {@link mylistpackage.ArrayListSorted#ArrayListSorted(int)}.
     */
    @Test
    public void testArrayListSortedInt() {
        myList1 = new ArrayListSorted<Integer>(50);
        assertEquals(0, myList1.getSize());
    }

    /**
     * Test method for {@link mylistpackage.ArrayListSorted#getIndex(java.lang.Comparable)}.
     */
    @Test
    public void testGetIndex() {
        final  int index = myList2.getIndex(3);
        assertEquals(2, index);
    }
 
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#getIndex(java.lang.Comparable)}.
     */
    @Test
    public void testGetIndexNotFoundAbove() {
        final int index = myList2.getIndex(8);
        assertEquals(-7, index);
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#getIndex(java.lang.Comparable)}.
     */
    @Test
    public void testGetIndexNotFoundBelow() {
        final int index = myList2.getIndex(0);
        assertEquals(-1, index);
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#getIndex(java.lang.Comparable)}.
     */
    @Test
    public void testGetIndexNotFoundCenter() {
        myList2.remove(3);
        assertEquals(5, myList2.getSize());
        final  int index = myList2.getIndex(3);
        assertEquals(-3, index);
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#insert(java.lang.Comparable)}.
     */
    @Test
    public void testInsert1() {
        myList2.remove(3);
        assertEquals("[ 1, 2, 4, 5, 6 ]", myList2.toString()); 
        myList2.insert(3);
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList2.toString()); 
        
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#insert(java.lang.Comparable)}.
     */
    @Test
    public void testInsert2() {
        myList2.remove(1);
        assertEquals("[ 2, 3, 4, 5, 6 ]", myList2.toString()); 
        myList2.insert(1);
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList2.toString()); 
        
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#insert(java.lang.Comparable)}.
     */
    @Test
    public void testInsert3() {
        
        myList2.insert(7);
        assertEquals("[ 1, 2, 3, 4, 5, 6, 7 ]", myList2.toString()); 
        
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#insert(java.lang.Comparable)}.
     */
    @Test
    public void testRemove1() {
        
        for (int i = 0; i < myList2.getSize(); i++) {
            myList2.remove(myList2.getElementAt(i));
            i--;
        }
        assertEquals("[]", myList2.toString());
        assertEquals(0, myList2.getSize());
        
    }
 
   
}
