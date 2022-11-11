package cs1302.p2;

import cs1302.adt.FancyStringList;
import cs1302.adt.StringList;

/**                                                                             
* Abstract class that implements some methods of the                            
* {@code StringList} interface. Class defines                                   
* general characteristics of its child classes                                  
* {@code ArrayStringList} and {@code LinkedStringList}                          
*/
public abstract class BaseStringList implements FancyStringList {

    /** Number of elements in {@code StringList} object. */
    protected int size;

    /**                                                                         
     * Constructor of {@code BaseStringList}                                    
     * initializes a {@code BaseStringList} object.                             
     */
    public BaseStringList() {
 size = 0;
    } // Constructor                                                            

    /**                                                                         
     * Adds an item to this string list as index size().                        
     *                                                                          
     * <p>                                                                      
     * {@inheritdoc}                                                            
     *                                                                          
     * <p>                                                                      
     * @param item to be inserted
     * @throws NullPointerException                                             
     * @throws IllegalArgumentException if the item is empty                    
     */
    @Override
    public boolean append (String item) {
        if (item == null) {
            throw new NullPointerException ("The item was null.");
        } else if (item.isEmpty()) {
            throw new IllegalArgumentException("Item is empty");
        } else {
            add(size(), item);
             return true;
        }
    }

    /**                                                                         
     * Checks if string list has no elements.                                   
     *                                                                          
     * <p>                                                                      
     * {@inheritdoc}                                                            
     */
    @Override
    public boolean isEmpty() {
        if (size() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**                                                                         
     * Retuns true if this string list has no items.                            
     *           
      * <p>                                                                      
     * {@inheritdoc}                                                            
     *                                                                          
     * <p>                                                                      
     * @param start specified start string                                      
     * @param sep specified separator string                                    
     * @param end specified ending                                              
     */
    @Override
public String makeString (String start, String sep, String end) {
        String result = start;
     for (int i = 0; i < size; i++) {
            result += get(i);
            if (i != size - 1) {
                result += sep;
            }
        }
        result += end;
        return result;
    }

    /**       
      /**                                                                         
     * Adds item at beginning of string list.                                   
     *                                                                          
     * <p>                                                                      
     * {@inheritdoc}                                                            
     *                                                                          
     * <p>                                                                      
     * @throws NullPointerException if item is null                             
     * @throws IllegalArgumentException if item is empty                        
    */
    @Override
    public boolean prepend (String item) {
         if (item == null) {
            throw new NullPointerException ("The item was null.");
        } else if (item.isEmpty()) {
            throw new IllegalArgumentException ("Item is empty.");
        } else {
            add(0, item);
            return true;
        }
    }

    /**       
     * Returns number of elements in the string list.                           
     *                                                                          
     * <p>                                                                      
     * {@inheritdoc}                                                            
     */
    @Override
     public int size() {
        return size;
    }

     /**    
     * Returns a call to the {@code makeString} method.                        
      *                                                                         
      * <p>                                                                     
      * {@inheritdoc}                                                           
      */
    @Override
    public String toString () {
        return makeString ("[", ", ", "]");
    }

    /**     
     * Inserts a stringlist object at the specified index position.             
     *                                                                          
     * <p>                                                                      
     * {@inheritdoc}                                                            
     *                                                                          
     * <p>                                                                      
     * @param index where items is inserted                                     
     * @param items string list of items                                        
     * @throws NullPointerException if item is null                             
     * @throws IndexOutOfBoundsException if index is out of range               
     */
 @Override
    public boolean add (int index, StringList items) {
        if (items == null) {
            throw new NullPointerException("items is null");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException ("The index was out of bounds")\
;
        } else {
            for (int i = index, indexCnt = 0; indexCnt < items.size(); i++, ind\
exCnt++) {
                this.add(i, items.get(indexCnt));
                 }
            return !items.isEmpty();
        }
    }

    /**                                                                         
     * Adds a StringList object at the desired index.                           
     *                                                                          
     * <p>                                                                      
     * {@inheritdoc}                                                            
     *              
      * <p>                                                                      
     * @param items string list of items                                        
     * @throws NullPointerException                                             
     */
    @Override
    public boolean append(StringList items) {
        if (items == null) {
            throw new NullPointerException("items is null");
        } else {
            this.add(this.size(), items);
            return !items.isEmpty();
             }
    }

    /**                                                                         
     * Checks if the string list contains the target value at or after start.   
     *                                                                          
     * <p>                                                                      
     * {@inheritdoc}                                                            
     *                                                                          
     * <p>                                                                      
     * @param start starting index  
     * @param target item to search for                                         
     */
    @Override
    public boolean contains (int start, String target) {
        if (start >= 0) {
            for (int i = start; i < this.size(); i++) {
                if (this.get(i).equals(target)) {
                    return true;
                }
            }
        }
 return false;
    }

    /**                                                                         
     * Gets the index of the target value at or after the start index.          
     *                                                                          
     * <p>                                                                      
     * {@inheritdoc}                                                            
     *                                                                          
     * <p>                                                                      
     * @param start starting index 
     * @param target item to search for                                         
     */
    @Override
    public int indexOf (int start, String target) {
        for (int i = start; i < this.size(); i++) {
            if (i >= start && start >= 0 && this.get(i).equals(target)) {
                return i;
            }
        }
        return -1;
    }
 /**                                                                         
     * Adds string list object end of list.                                     
     *                                                                          
     * <p>                                                                      
     * {@inheritdoc}                                                            
     *                                                                          
     * <p>                                                                      
     * @param items string list of items                                        
     * @throws NullPointerException items are null                              
     */
 @Override
    public boolean prepend (StringList items) {
        if (items == null) {
            throw new NullPointerException ("The item was null.");
        } else {
            this.add(0, items);
            return !items.isEmpty();
        }
    }

}
