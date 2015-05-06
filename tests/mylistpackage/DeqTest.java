/**
 * 
 */
package mylistpackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Tarik
 * @version 5/5/2015
 */
public class DeqTest {
    /**
     * test deq.
     */
    private Deq<Integer> myOne;
    
    /**
     * test deq.
     */
    private Deq<Integer> myTwo;
    
    /**
     * test deq.
     */
    private Deq<Integer> myThree;
    /**
     * @throws java.lang.Exception the exception.
     */
    @Before
    public void setUp() throws Exception {
        myOne = new Deq<Integer>();
        myTwo = new Deq<Integer>();
        myThree = new Deq<Integer>();
        
        for (int i = 1; i < 6; i++) {
            myTwo.insert(i);
        }
        for (int i = 1; i < 2500; i++) {
            myThree.insert(i);
        }
    }

    /**
     * Test method for {@link mylistpackage.Deq#Deq()}.
     */
    @Test
    public final void testDeq() {
        assertEquals(0, myOne.getSize());
        assertEquals("[]", myOne.toString());
    }

    /**
     * Test method for {@link mylistpackage.Deq#Deq(int)}.
     */
    @Test
    public final void testDeqInt() {
        myOne = new Deq<Integer>(50);
        assertEquals(0, myOne.getSize());
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#Deq(int)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public final void testDeqIntZero() {
        myOne = new Deq<Integer>(0);
    }

    /**
     * Test method for {@link mylistpackage.Deq#getIndex(java.lang.Object)}.
     */
    @Test
    public final void testGetIndexFalse() {
        assertEquals(-1, myTwo.getIndex(10));
    }

    /**
     * Test method for {@link mylistpackage.Deq#getIndex(java.lang.Object)}.
     */
    @Test
    public final void testGetIndexFirst() {
        assertEquals(0, myThree.getIndex(1));
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#getIndex(java.lang.Object)}.
     */
    @Test
    public final void testGetIndexLast() {
        assertEquals(myThree.getSize() - 1, myThree.getIndex(2499));
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#getIndex(java.lang.Object)}.
     */
    @Test
    public final void testGetIndexMiddle() {
        assertEquals(599, myThree.getIndex(600));
    }

    /**
     * Test method for {@link mylistpackage.Deq#insert(java.lang.Object)}.
     */
    @Test
    public final void testInsert() {
        myThree.insert(5);
        final int test = myThree.removeBack();
        assertEquals(5, test);
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#insert(java.lang.Object)}.
     */
    @Test
    public final void testInsertMany() {
        
        for (int i = 0; i < 600; i++) {
            myOne.insert(i);
        }
        assertEquals(600, myOne.getSize());
        assertEquals(599, (int) myOne.removeBack());
    }

    /**
     * Test method for {@link mylistpackage.Deq#insertFront(java.lang.Object)}.
     */
    @Test
    public final void testInsertFrontOne() {
        myOne.insertFront(5);
        assertEquals(5, (int) myOne.getElementAt(0));
        assertEquals(1, myOne.getSize());
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#insertFront(java.lang.Object)}.
     */
    @Test
    public final void testInsertFrontSeveral() {
        for (int i = 1; i <= 10000; i++) {
            myOne.insertFront(i);
        }
        assertEquals(10000, (int) myOne.getElementAt(0));
        assertEquals(1, (int) myOne.getElementAt(9999));
        assertEquals(10000, myOne.getSize());
    }

    /**
     * Test method for {@link mylistpackage.Deq#removeFront()}.
     */
    @Test
    public final void testRemoveFront() {
        for (int i = 1; i < 2499; i++) {
            myThree.removeFront();
        }
        assertEquals(1, myThree.getSize());
        assertEquals(2499, (int) myThree.removeFront());
        
    }

    /**
     * Test method for {@link mylistpackage.Deq#removeBack()}.
     */
    @Test
    public final void testRemoveBack() {
        for (int i = 1; i < 2499; i++) {
            myThree.removeBack();
        }
        assertEquals(1, myThree.getSize());
        assertEquals(1, (int) myThree.removeFront());
    }

}
