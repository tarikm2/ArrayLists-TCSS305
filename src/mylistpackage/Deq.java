/**
 * This class represents a Deque object.
 */
package mylistpackage;

/**
 * @author Tarik Merzouk
 * @version 5/5/2015
 * @param <E> the Deques data type.
 */
public class Deq<E> extends AbstractArrayMyList<E> {
    
    
    /**
     * default constructror for Deque.
     * @custom.post a default Deque is constructed.
     */
    public Deq() {
        super();
    }
    
    /**
     * Constructor with specified capacity.
     * @param theCapacity the capacity of the Deque
     * @custom.post a Deque is constructed with theCapacity.
     */
    public Deq(final int theCapacity) {
        super(theCapacity);
    }

    /**
     * getIndex returns the index of theValue, -1 if not found.
     * @param theValue the value to be searched for.
     * @return index the index of theValue. -1 if not found.
     */
    @Override
    public int getIndex(final E theValue) {
        int index = -1;
        for (int i = 0; i < mySize; i++) {
            if (myElements[i].equals(theValue)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * insert inserts theValue to at the back of the Deque.
     * @param theValue the value to be inserted.
     * @custom.post theValue is inserted into the Deque, the size is incremented.
     * @custom.post the Deques capacity is adjusted if necesary.
     */
    @Override
    public void insert(final E theValue) {
        if (mySize >= myElements.length) {
            resize(true);
        }
        myElements[mySize] = theValue;
        mySize++;
    }
    
    /**
     * insertFront inserts theValue at the front of the Deque.
     * @param theValue the value being inserted in the front.
     * @custom.post The Value is inserted in the front of the Deque, the size is incremented.
     * @custom.post The Deques capacity is adjusted if necesary.
     */
    public void insertFront(final E theValue) {
        //adjust capacity
        if (mySize >= myElements.length) {
            resize(true);
        }
        //move all elemnts right one
        for (int i = mySize - 1; i >= 0; i--) {
            myElements[i + 1] = myElements[i];
        }
        //insert theValue
        myElements[0] = theValue;
        mySize++;
    }
    
    /**
     * removeFront removes the value at the front of the Deque.
     * @return theValue which is being removed.
     * @custom.post the value at the front is removed.
     * @custom.post the Size of the Deque is decremented
     * @custom.post the capacity of the Deque is adjusted if necesary.
     */
    public E removeFront() {
        final E toReturn = getElementAt(0);
        final E object = null;
     
       //move objects forward
        for (int i = 1; i < mySize; i++) {
            myElements[i - 1] = myElements[i];
        }
        //delete final element
        myElements[mySize - 1] = object;
        mySize--;
        
        final double test = 0.3;
        if (myElements.length > DEFAULT_CAPACITY 
            && ((double) mySize / myElements.length) < test) {
            resize(false);
        }
        return toReturn;
    }
    
    /**
     * removeBack removes an element at the back of the Deque.
     * @return the element at the back of the Deque,
     * @custom.post the value at the back is removed.
     * @custom.post the Size of the Deque is decremented.
     * @custom.post the capacity of the Deque is adjusted if necesary.
     */
    public E removeBack() {
        //remove item
        final E toReturn = getElementAt(mySize - 1);
        final E object = null;
        myElements[mySize - 1] = object;
        mySize--;
        
        //adjust capacity
        final double test = 0.3;
        if (myElements.length > DEFAULT_CAPACITY 
            && ((double) mySize / myElements.length) < test) {
            resize(false);
        }
        return toReturn;
        
    }
    
    

}
