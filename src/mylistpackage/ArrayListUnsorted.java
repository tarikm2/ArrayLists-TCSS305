package mylistpackage;

/**
 * Dynamic representation of a basic unsorted array-based list.
 * 
 * @author modified from Building Java Programs 3rd ed.
 * @version Apr. 12, 2015
 * @param <E> is of any object type
 * @custom.inv 0 <= mySize <= array length
 */
public class ArrayListUnsorted<E> extends AbstractArrayMyList<E> {

    /**
     * Default constructor.
     * @custom.post a default arraylist is constructed.
     */
    public ArrayListUnsorted() {
        super();
    }
    
    /**
     *  this constructor creates a list of capacity theCapacity.
     * @param theCapacity the capacity
     * @custom.post an arralist of size theCapacity is constructed.
     */
    public ArrayListUnsorted(final int theCapacity) {
        super(theCapacity);
    }
    /**
     * finds the index of theValue.
     * @see mylistpackage.MyList#getIndex()
     * @param theValue the value to be searched for.
     * @return index the idex of the value. -1 if not found
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
     * inserts theValue into this arraylist.
     * @param theValue the value to be inserted.
     * @see mylistpackage.MyList#insert(java.lang.Object)
     * @custom.post the Value is inserted to back of the list and size is incrimeted.
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
     * remove removes theValue from this arraylist.
     * @param theValue the first occurance of theValue.
     * @see mylistpackage.MyList#remove(java.lang.Object)
     * @custom.post first occurance of  theValue is removed from the Arraylist.
     */
    public void remove(final E theValue) {
        final E object = null;
        final int index = getIndex(theValue);
        if (index >= 0) {
            myElements[index] = myElements[mySize - 1];
            myElements[mySize - 1] = object;
            mySize--;
        }
        final double test = 0.3;
        if (myElements.length > DEFAULT_CAPACITY 
            && ((double) mySize / myElements.length) < test) {
            resize(false);
        }
    }

}
    