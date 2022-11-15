package cs1302.p2;

import cs1302.adt.Node;
import cs1302.adt.FancyStringList;
import cs1302.adt.StringList;

/**                                                                                                                                                                                                                                           
 * A node implementation of a {@code StringList} interface                                                                                                                                                                                    
 * and defines different operations.                                                                                                                                                                                                          
*/

public class LinkedStringList extends BaseStringList {


    private Node head; //first node element                                                                                                                                                                                                   

    /**                                                                                                                                                                                                                                       
     * This is constructor of {@code LinkedStringList} class                                                                                                                                                                                  
     * that initializes a {@code LinkedStringList} object.                                                                                                                                                                                    
     */
    public LinkedStringList () {
        super();
        head = new Node("head");
    } // constructor                                                                                                                                                                                                                          

    /**                                                                                                                                                                                                                                       
     * Inserts an item in string list at specified index.                                                                                                                                                                                     
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritdoc}                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * @param index where item is inserted                                                                                                                                                                                                    
     * @param item to be inserted                                                                                                                                                                                                             
     * @throws NullPointerException if items are null                                                                                                                                                                                         
     * @throws IllegalArgumentException if item is empty                                                                                                                                                                                      
     * @throws IndexOutOfBoundsException                                                                                                                                                                                                      
     */
    @Override
    public boolean add(int index, String item) {
        if (item == null) {
            throw new NullPointerException ("The item is Null");
        } else if (item.isEmpty()) {
            throw new IllegalArgumentException ("The item is empty");
        } else if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException ("Index is out of bounds.");
        } else {
            Node newNode = new Node (item);
            Node temp = head;
            int cnt = 0;
            while (temp.hasNext() && cnt < index) {
                temp = temp.getNext();
                cnt++;
            }
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);
            this.size++;
            return true;
        }
    }
 /**                                                                                                                                                                                                                                       
     * Removes all items from this string list.                                                                                                                                                                                               
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritdoc}                                                                                                                                                                                                                          
     */
    @Override
    public void clear () {
        size = 0;
        head = null;
    } // clear                                                                                                                                                                                                                                

    /**                                                                                                                                                                                                                                       
     * Returns the item at the specific index of this string list.                                                                                                                                                                            
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritdoc}                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * @param index where item is returned                                                                                                                                                                                                    
     * @throws IndexOutOfBounds if index is out of range                                                                                                                                                                                      
     */
    @Override
    public String get (int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            Node temp = head;
            int cnt = 0;
            while (temp.hasNext() && cnt <= index) {
                temp = temp.getNext();
               cnt++;
            }
            return temp.getItem();
        }
    }

    /**                                                                                                                                                                                                                                       
     * Removes the item at the specified index position.                                                                                                                                                                                      
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritdoc}                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * @param index where item is removed                                                                                                                                                                                                     
     * @throws IndexOutOfBoundsException is out of range                                                                                                                                                                                      
     */
    @Override
    public String remove (int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException ("Index out of bounds");
        } else {
            Node temp = head;
            int cnt = 0;
            while (temp.hasNext() && cnt < index) {
                temp = temp.getNext();
                cnt++;
            }
            String removedItem = (temp.getNext()).getItem();
            temp.setNext(temp.getNext().getNext());
            size--;
  return removedItem;
        }
    }

    /**                                                                                                                                                                                                                                       
     * Return a new string list containing all items from                                                                                                                                                                                     
     * specified start and end indices.                                                                                                                                                                                                       
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritdoc}                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * @param start left endpoint inclusive of slice                                                                                                                                                                                          
     * @param stop right endpoint inclusive of slice                                                                                                                                                                                          
     * @throws IndexOutOfBoundsException if index is out of bounds                                                                                                                                                                            
     */
    @Override
    public StringList slice (int start, int stop) {
        if (start < 0 || stop > size() || start > stop) {
            throw new IndexOutOfBoundsException("Index was out of bounds.");
        } else {
            StringList sliceList = new LinkedStringList();
            for (int indexCnt = 0, i = start; i < stop; i++) {
                sliceList.add(indexCnt, get(i));
            }
            return sliceList;
        }
    }

    /**          
     * Contrusts a new LinkedStringList which is a copy of {@code other}.                                                                                                                                                                     
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritDoc}                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * @param other an object of type String List                                                                                                                                                                                             
     * @throws NullPointerExcepption if other is null                                                                                                                                                                                         
     */
    public LinkedStringList (StringList other) {
        super();
        if (other == null) {
            throw new NullPointerException("The given StringList object is null");
        } else {
            head = new Node("head");
            for (int i = 0; i < other.size(); i++) {
                this.add(i, other.get(i));
            }
            size = other.size();
        }
    }

    /**                                                                                                                                                                                                                                       
     * Returns a new string list that contains items only                                                                                                                                                                                     
     * from specified start and end indices. It increments by step.                                                                                                                                                                           
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritdoc}                                                                                                                                                                                                                          
     *                                                                                                                                                                                                                                        
     * <p>           
        * @param start left endpoint inclusive of slice                                                                                                                                                                                          
     * @param stop right endpoint exclusive of slice                                                                                                                                                                                          
     * @param step increment amount                                                                                                                                                                                                           
     * @throws IndexOutOfBoundsException if out of range                                                                                                                                                                                      
     */
    @Override
    public FancyStringList slice (int start, int stop, int step) {
        if (start < 0 || stop > size() || start > stop || step < 1) {
            throw new IndexOutOfBoundsException ("Start, stop, or step are out of bounds.");
        } else {
            FancyStringList sliceList = new LinkedStringList();
            for (int indexCnt = 0, i = start; i < stop; i += step, indexCnt++) {
                sliceList.add(indexCnt, get(i));
            }
            return sliceList;
        } // slice                                                                                                                                                                                                                            
    }

    /**                                                                                                                                                                                                                                       
     * Returns a reversed version of the list.                                                                                                                                                                                                
     *                                                                                                                                                                                                                                        
     * <p>                                                                                                                                                                                                                                    
     * {@inheritdoc}                                                                                                                                                                                                                          
     */
    @Override
    public FancyStringList reverse () {
        Node temp = head;
        FancyStringList reverseList = new LinkedStringList();
        while (temp.hasNext()) {
            temp = temp.getNext();
            reverseList.prepend(temp.getItem());
           }
        return reverseList;
    }

}
