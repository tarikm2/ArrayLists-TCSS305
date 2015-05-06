/**
 *  This class represents a sorted arraylist using binary search.
 */
package mylistpackage;

/**
 * @param <E> the type of object to be held in ArrayList
 * @author Tarik
 * @version 4/19/2015
 */
public class ArrayListSorted<E extends Comparable<? super E>> extends AbstractArrayMyList<E> {
    
    /**
     * default constructor.
     * @custom.post an arraylist is constructed with default values.
     */
    public ArrayListSorted() {
        super();
    }
    
    /**
     * Constructor with array  capacity.
     * @param theCapacity the arrays capacity
     * @custom.post a sorted array list is constructed of size theCapacity.
     */
    public ArrayListSorted(final int theCapacity) {
        super(theCapacity);
    }
   
    /**
     * getIndex returns the index of a key element or where it should be.
     * @param theKey the key to search for
     * @return the value of the keys index or where it should be found.
     * @custom.post the index is returned.
     */
    public int getIndex(final E theKey) {

        int low = 0;
        int high = mySize - 1;
        int notFound = -1;
        int toReturn = 0;
        if (mySize == 0) {
            toReturn = 0;
        } else if (theKey.compareTo(myElements[0]) < 0) {
            toReturn = -1;
        } else {
            while (low <= high) {
                final  int mid = low + (high - low) / 2;
                if  (theKey.compareTo(myElements[mid]) < 0) {
                    high = mid - 1;
                } else if (theKey.compareTo(myElements[mid]) > 0) {
                    low = mid + 1;
                } else if (theKey.compareTo(myElements[mid]) == 0) {
                    return  mid;
                }      
                if (low > high) {
                    notFound = -(mid + 2);
                }
            }
            return notFound;
        }
        return toReturn;
    }
    
    /**
     *  insert inserts a value in sorted order.
     *  @param theValue what will be inserted.
     *  @custom.post theValue is inserted into the sorted list.
     */
    public void insert(final E theValue) {
        int index = getIndex(theValue);
        
        if (mySize >= myElements.length) {
            resize(true);
        }
        if (index < 0) {
            index = -(index + 1);
        }
        if (!(index > mySize - 1)) {
            for (int i = mySize - 1; i >= index; i--) {
               
                myElements[i + 1] = myElements[i];
            }
        }
        myElements[index ] = theValue;
        mySize++;
    }
    
    /**
     * This method removes a value from the sorted arraylist.
     * @param theValue the value to be removed
     * @custom.post theValue is removed from the sorted array list.
     * @see mylistpackage.MyList#remove(java.lang.Object)
     */
    public void remove(final E theValue) {
        final E object = null;
        final int index = getIndex(theValue);
        for (int i = index + 1; i < mySize; i++) {
            myElements[i - 1] = myElements[i];
        }
         
        myElements[mySize - 1] = object;
        mySize--;
        final double test = 0.3;
        if (myElements.length > DEFAULT_CAPACITY 
            && ((double) mySize / myElements.length) < test) {
            resize(false);
        }
    }
    
}
