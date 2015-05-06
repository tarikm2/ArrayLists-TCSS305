/**
 * abstract class for array objects.
 */
package mylistpackage;

import java.util.Arrays;

/**
 * @param <E> the object type bound to the arraylist
 * @author tarikm2
 * @version 4/19/2015
 */
public abstract class AbstractArrayMyList<E> implements MyList<E> {

    /**
     * array of list values.
     */
    protected E[] myElements;

    /**
     * current number of elements in the list.
     */
    protected int mySize;

    /**
     * Constructs an empty list of default capacity.
     * @custom.post list of size 10 created
     */
    public AbstractArrayMyList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs an empty list of the given capacity.
     * 
     * @param theCapacity > 0
     * @throws IllegalArgumentException if capacity <= 0
     * @custom.post list of specified size constructed
     */
    @SuppressWarnings("unchecked")
    public AbstractArrayMyList(final int theCapacity) {
        if (theCapacity <= 0) {
            throw new IllegalArgumentException("capacity: " + theCapacity);
        }
        myElements = (E[]) new Comparable[theCapacity];
        mySize = 0;
    }

    /**
     * add will accept another list and add it.
     * @see mylistpackage.MyList#add(java.lang.Object)
     * @param theOtherList list to be added
     */
    
    public void add(final MyList<E> theOtherList) {
        final int size = theOtherList.getSize();
        for (int i = 0; i < size; i++) {
            insert(theOtherList.getElementAt(i));
        }        
    }
    
    /**
     *  @see mylistpackage.MyList#clear()
     */
    
    @Override
    public void clear() {
        final E object = null;
        for (int i = 0; i < mySize; i++) {
            myElements[i] = object;
        }
        mySize = 0;
    }
    
    /**
     * @param theValue the value being searched for.
     * @see mylistpackage.MyList#contains(java.lang.Object)\
     * @return flag 
     */
    @Override
    public boolean contains(final E theValue) {
        final int index = getIndex(theValue);
        boolean flag = false;
        if (index >= 0) {
            flag = true;
        }
        return flag;
    }
    
    /**
     * Returns the value at the given index in the list.
     * 
     * @param theIndex < size and index >= 0
     * @throws IndexOutOfBoundsException if index < 0 or index >= size
     * @return the value at the given index in the list.
     */
    public E getElementAt(final int theIndex) {
        if (theIndex < 0 || theIndex >= mySize) {
            throw new IndexOutOfBoundsException();
        }
        return myElements[theIndex];
    }
   
    
     /**
     * This method returns the size of the array.
     * @return mySize
     * @see mylistpackage.MyList#getSize()
     */
    @Override
    public int getSize() {
        return mySize;
    }   

    /**
     * @return mySize == 0
     * @see mylistpackage.MyList#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return mySize == 0;
    }  
    
    
    
    /**
     * Resizes the array holding list elements.
     * @param theGrowth is not null
     * @custom.post underlying array increases by 100 elements,
     *  if the argument is true; otherwise it shrinks to half its size
     */
    protected void resize(final boolean theGrowth) {
        final int newCapacity;
        if (theGrowth) {
            newCapacity = myElements.length + INCREASE_SIZE;
        } else {
            newCapacity = myElements.length / 2;
        }
        myElements = Arrays.copyOf(myElements, newCapacity);
    }
  
    /**
     * Creates a comma-separated, bracketed version of the list.
     * @return result.toString string representation of this array.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuffer result = new StringBuffer();
        if (mySize == 0) {
            result.append("[]");
        } else {
            result.append("[ " + myElements[0]);
            for (int i = 1; i < mySize; i++) {
                result.append(", ");
                result.append(myElements[i]);
            }
            result.append(" ]");
        }
        return result.toString();
    }    

}
