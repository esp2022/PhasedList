package cs1302.p2;

import cs1302.adt.StringList;
import cs1302.adt.FancyStringList;

/**                                                                                                                                                                                                                                           
* Array list implementation of {@code StringList} interface                                                                                                                                                                                   
* and defines different operations.                                                                                                                                                                                                           
*/

public class ArrayStringList extends BaseStringList {

    /** String array of the items in the string.*/
    private String [] items;

    /**                                                                                                                                                                                                                                       
     * This is the main constructor for {@code ArrayStringList}.                                                                                                                                                                              
     * It initializes a {@code ArrayStringList} object.                                                                                                                                                                                       
     */
    public ArrayStringList() {
        super();
        this.items = new String [5];
    } // Constructor                                                                                                                                                                                                                          

    /**                                                                                                                                                                                                                                       
     * Places an item in the specified index.                                                                                                                                                                                                 
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritdoc}                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * @param index where item is inserted                                                                                                                                                                                                    
     * @param item soon to be inserted                                                                                                                                                                                                        
     * @throws NullPointerExcpetion if the item is null                                                                                                                                                                                       
     * @throws IllegalArgumentException if the item is empty                                                                                                                                                                                  
     * @throws IndexOutOfBoundsException if index is out of range                                                                                                                                                                             
     */
    @Override
    public boolean add (int index, String item) {
        if (item == null) {
            throw new NullPointerException ("The item is Null");
        } else if (item.isEmpty()) {
            throw new IllegalArgumentException ("The item is empty");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException ("Index is out of bounds.");
        } else {
            increaseArrayLength(); // dynamically changes array size                                                                                                                                                                          
            if (checkForItem(index)) {
                shiftItemsRight(index);
                items[index] = item;
            } else {
                items[index] = item;
            }
            this.size++;
            return true;
        }
    }

    /**                                                                                                                                                                                                                                       
     * Checks if an item is at the specified index. 
      *                                                                                                                                                                                                                                        
     * @param index where item is checked                                                                                                                                                                                                     
     * @return index where item is checked                                                                                                                                                                                                    
     */
    private boolean checkForItem(int index) {
        if (items[index] != null) {
            return true;
        } else {
            return false;
        }
    }

    /**                                                                                                                                                                                                                                       
     * Shifts elements of array from the index                                                                                                                                                                                                
     * to the right.                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * @param index where items are shifted                                                                                                                                                                                                   
     */
    private void shiftItemsRight(int index) {
        for (int i = items.length - 1; i > index; i--) {
            items [i] = items[i - 1];
        }
    }

    /**                                                                                                                                                                                                                                       
     * Shifts elements of array from the index                                                                                                                                                                                                
     * to the left.                                                                                                                                                                                                                           
     *                                                                                                                                                                                                                                        
     * @param index where items are shifted                                                                                                                                                                                                   
     */
    private void shiftItemsLeft(int index) {
        for (int i = index; i < items.length - 1; i++) {
            items[i] = items[i + 1];
        }
 }

    /**                                                                                                                                                                                                                                       
     * Increases the length of the array {@code items}                                                                                                                                                                                        
     * if number of elements in array exceed length                                                                                                                                                                                           
     * of the array.                                                                                                                                                                                                                          
     */
    private void increaseArrayLength() {
        if (size == items.length) {
            String [] tempItems = new String[items.length];
            for (int i = 0; i < tempItems.length; i++) {
                tempItems [i] = items [i];
            }
            items = new String[(int) (size * 1.5)];
            for (int i = 0; i < tempItems.length; i++) {
                items[i] = tempItems[i];
            }
        }
    }

    /**                                                                                                                                                                                                                                       
     * Removes all elements of the string list.                                                                                                                                                                                               
     *                                                                                                                                                                                                                                        
     *  <p>                                                                                                                                                                                                                                   
     * {@iinheritdoc}                                                                                                                                                                                                                         
     */
    @Override
    public void clear() {
        size = 0;
        for (String item: items) {
           item = null;
        }
    }

    /**                                                                                                                                                                                                                                       
     * Retrieves the item at the specified index position.                                                                                                                                                                                    
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritDoc}                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * @param index where item is retrieved                                                                                                                                                                                                   
     * @throws IndexOutOfBoundsException is index is out of range                                                                                                                                                                             
     */
    @Override
    public String get(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        } else {
            return items[index];
        }
    }

    /**                                                                                                                                                                                                                                       
     * Removes the item at specified index position.                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritdoc}                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>                   
      * @param index where item is removed                                                                                                                                                                                                     
     * @throws IndexOutOfBoundsException                                                                                                                                                                                                      
     */
    @Override
    public String remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        } else {
            size --;
            String item = items[index];
            shiftItemsLeft(index);
            return item;
        }
    }

    /**                                                                                                                                                                                                                                       
     * Returns a new string list that only contains                                                                                                                                                                                           
     * items from specified start and end indices.                                                                                                                                                                                            
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritdoc}                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * @param start left endpoint inclusive of slice                                                                                                                                                                                          
     * @param stop right endpoint inclusive of slice                                                                                                                                                                                          
     * @throws IndexOutOfBoundsException if index is out of range                                                                                                                                                                             
     */
    @Override
    public StringList slice( int start, int stop) {
        if (start < 0 || stop > size() || start > stop) {
           throw new IndexOutOfBoundsException("Start or stop indeces are out of bounds");
        } else {
            StringList sliceList = new ArrayStringList();
            for (int indexCnt = 0, i = start; i < stop; i++, indexCnt++) {
                sliceList.add(indexCnt, get(i)); // only adds between start and stop                                                                                                                                                          
            }
            return sliceList;
        }
    }

    /**                                                                                                                                                                                                                                       
     * Creates a deep copy of the {@code other} StringList.                                                                                                                                                                                   
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritDoc}                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * @param other an object of type StringList                                                                                                                                                                                              
     * @throws NullPointerException                                                                                                                                                                                                           
     */
    public ArrayStringList(StringList other) {
        super();
        if (other == null) {
            throw new NullPointerException("StringList object is null");
        } else {
            items = new String[other.size()];
            for (int i = 0; i < other.size(); i++) {
                this.add(i, other.get(i));
            }
            size = other.size();
           }
    }

    /**                                                                                                                                                                                                                                       
     * Returns a new string list that only contains items from                                                                                                                                                                                
     * the specified start and end indices. It increments by step.                                                                                                                                                                            
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritDoc}                                                                                                                                                                                                                          
                                                                                                                                                                                                                                              
     * <p>                                                                                                                                                                                                                                    
     * @param start left endpoint inclusive of slice                                                                                                                                                                                          
     * @param stop right endpoint exclusive of slice                                                                                                                                                                                          
     * @param step increment amount                                                                                                                                                                                                           
     * @throws IndexOutOfBoundsException if indices are out of range                                                                                                                                                                          
     */
    @Override
    public FancyStringList slice(int start, int stop, int step) {
        if (start < 0 || stop > size () || start > stop || step < 1) {
            throw new IndexOutOfBoundsException("Start,stop,stop or step indices are out ofbounds");
        } else {
            FancyStringList sliceList = new ArrayStringList();
            for (int indexCnt = 0, i = start; i < stop; i += step, indexCnt++) {
                sliceList.add(indexCnt, get(i));
            }
            return sliceList;
        }
    }

    /**                                                                                                                                                                                                                                       
     * Returns reversed version of list.   
      *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritDoc}                                                                                                                                                                                                                          
     */
    @Override
    public FancyStringList reverse() {
        FancyStringList reverseList = new ArrayStringList();
        for (int i = 0; i < this.size(); i++) {
            reverseList.prepend(items[i]);
        }
        return reverseList;
    }

}
