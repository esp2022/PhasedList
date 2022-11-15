package cs1302.p2;

import cs1302.adt.FancyStringList;
import cs1302.oracle.FancyOracleStringList;

/** Driver class for testing. */
public class Driver {

    public static void main (String [] args) {
        System.out.println("\nOracle STRING LIST TESTS");
        FancyStringList temp_osl = new FancyOracleStringList();
        isEmptyTest(temp_osl);
        sizeTest(temp_osl);
        addTest(temp_osl);
        FancyStringList osl = new FancyOracleStringList(temp_osl);
        appendTest(osl);
        prependTest(osl);
        baseAddTest(osl);
        baseAppendTest(osl);
        basePrependTest(osl);
        containsTest(osl);
        indexOfTest(osl);
        makeStringTest(osl);
        reverseTest(osl);
        removeTest(osl);
        getTest(osl);
        sliceTest(osl);
        clearTest(osl);
        System.out.println("\nARRAY STRING LIST TESTS");
        FancyStringList temp_lsl = new LinkedStringList();
        isEmptyTest(temp_lsl);
        sizeTest(temp_lsl);
        addTest(temp_lsl);
        FancyStringList asl = new ArrayStringList(temp_lsl);
        appendTest(asl);
        prependTest(asl);
        baseAddTest(asl);
        baseAppendTest(asl);
        basePrependTest(asl);
        containsTest(asl);
        indexOfTest(asl);
        makeStringTest(asl);
        reverseTest(asl);
        removeTest(asl);
        getTest(asl);
        sliceTest(asl);
        clearTest(asl);
        System.out.println("\nLINKED STRING LIST TESTS");
        FancyStringList temp_asl = new ArrayStringList();
        isEmptyTest(temp_asl);
        sizeTest(temp_asl);
        addTest(temp_asl);
        FancyStringList lsl = new LinkedStringList(temp_asl);
        appendTest(lsl);
        prependTest(lsl);
        baseAddTest(lsl);
        baseAppendTest(lsl);
        basePrependTest(lsl);
        containsTest(lsl);
        indexOfTest(lsl);
 makeStringTest(lsl);
        reverseTest(lsl);
        removeTest(lsl);
        getTest(lsl);
        sliceTest(lsl);
        clearTest(lsl);
    } // main                                                                                                                                                                                                                                 

    /**                                                                                                                                                                                                                                       
     * isEmptyTest.                                                                                                                                                                                                                           
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void isEmptyTest(FancyStringList sl) {
        if (sl.isEmpty()) {
            System.out.println("isEmpty: Test Passed");
        } else {
            System.out.println("isEmpty: Test Failed");
            System.exit(0);
        }
    }

    /**                                                                                                                                                                                                                                       
     * sizeTest.                                                                                                                                                                                                                              
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void sizeTest(FancyStringList sl) {
        if (sl.size() == 0) {
            System.out.println("isEmpty: Test Passed");
        } else {
            System.out.println("isEmpty: Test Failed");
            System.exit(0);
        }
    }

  /**                                                                                                                                                                                                                                       
     * makeStringTest.                                                                                                                                                                                                                        
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void makeStringTest(FancyStringList sl) {
        System.out.print("MakeString: ");
        System.out.println(sl.makeString("{", " | ", "}"));
        System.out.println("size: " + sl.size());
    }

    /**                                                                                                                                                                                                                                       
     * appendTest.                                                                                                                                                                                                                            
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void appendTest(FancyStringList sl) {
        sl.append("eleven");
        System.out.print("Append: ");
        System.out.println(sl.toString());
        System.out.println("size: " + sl.size());
    }

    /**                                                                                                                                                                                                                                       
     * prependTest.                                                                                                                                                                                                                           
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void prependTest(FancyStringList sl) {
        sl.prepend("zero");
        System.out.print("Prepend: ");
        System.out.println(sl.toString());
	System.out.println("size: " + sl.size());
       }

    /**                                                                                                                                                                                                                                       
     * clearTest.                                                                                                                                                                                                                             
     * @param sl sl FancyStringList object                                                                                                                                                                                                    
     */
    static void clearTest(FancyStringList sl) {
        sl.clear();
        System.out.print("Clear: ");
        System.out.println(sl.toString());
        System.out.println("size: " + sl.size());
    }

    /**                                                                                                                                                                                                                                       
     * getTest.                                                                                                                                                                                                                               
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void getTest(FancyStringList sl) {
        System.out.println("Get: ");
        System.out.println("Index (2): " + sl.get(2));
        System.out.println("Index (5): " + sl.get(5));
        System.out.println("Index (4): " + sl.get(4));
        System.out.println("size: " + sl.size());
    }

    /**                                                                                                                                                                                                                                       
     * addTest.                                                                                                                                                                                                                               
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void addTest(FancyStringList sl) {
        sl.add(0, "one");
        sl.add(1, "two");
	      sl.add(2, "four");
        sl.add(2, "three");
        sl.add(4, "six");
        sl.add(4, "five");
        sl.add(6, "seven");
        sl.add(7, "ten");
        sl.add(7, "nine");
        sl.add(7, "eight");
        System.out.print("Add: ");
        System.out.println(sl.toString());
        System.out.println("size: " + sl.size());
    }

    /**                                                                                                                                                                                                                                       
     * baseAddTest.                                                                                                                                                                                                                           
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void baseAddTest(FancyStringList sl) {
        FancyStringList slAdd = new LinkedStringList();
        slAdd.add(0, "pizza");
        slAdd.add(1, "cake");
        slAdd.add(2, "taco");
        sl.add(5, slAdd);
        System.out.print("Base Add: ");
        System.out.println(sl.toString());
        System.out.println("size: " + sl.size());
    }

    /**                                                                                                                                                                                                                                       
     * baseAppendTest.                                                                                                                                                                                                                        
     * @param sl FancyStringList object    
      */
    static void baseAppendTest(FancyStringList sl) {
        FancyStringList slAppend = new LinkedStringList();
        slAppend.append("burrito");
        sl.append(slAppend);
        System.out.print("Base Append: ");
        System.out.println(sl.toString());
        System.out.println("size: " + sl.size());
    }

    /**                                                                                                                                                                                                                                       
     * basePrependTest.                                                                                                                                                                                                                       
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void basePrependTest(FancyStringList sl) {
        FancyStringList slPrepend = new LinkedStringList();
        slPrepend.add(0, "strawberry");
        sl.prepend(slPrepend);
        System.out.print("Base Prepend: ");
        System.out.println(sl.toString());
        System.out.println("size: " + sl.size());
    }

    /**                                                                                                                                                                                                                                       
     * containsTest.                                                                                                                                                                                                                          
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void containsTest(FancyStringList sl) {
        System.out.print("Contains \"taco\": " + sl.contains(3, "taco"));
        System.out.print("\nContains \"pasta\": " + sl.contains(6, "pasta"));
       System.out.println("\nsize: " + sl.size());
    }

    /**                                                                                                                                                                                                                                       
     * indexOfTest.                                                                                                                                                                                                                           
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void indexOfTest(FancyStringList sl) {
        System.out.print("indexOf \"taco\": " + sl.indexOf(0, "taco"));
        System.out.print("\nindexOf \"eight\": " + sl.indexOf(9, "eight"));
        System.out.println("\nsize: " + sl.size());
    }

    /**                                                                                                                                                                                                                                       
     * removeTest.                                                                                                                                                                                                                            
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void removeTest(FancyStringList sl) {
        sl.remove(5);
        System.out.print("Remove: ");
        System.out.println(sl.toString());
        System.out.println("size: " + sl.size());
    }

    /**                                                                                                                                                                                                                                       
     * sliceTest.                                                                                                                                                                                                                             
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void sliceTest(FancyStringList sl) {
        FancyStringList slicedList = sl.slice(2,5,1);
       System.out.print("Slice: ");
        System.out.println(slicedList.toString());
        System.out.println("size: " + slicedList.size());
    }

    /**                                                                                                                                                                                                                                       
     * reverseTest.                                                                                                                                                                                                                           
     * @param sl FancyStringList object                                                                                                                                                                                                       
     */
    static void reverseTest(FancyStringList sl) {
        FancyStringList reversedList = sl.reverse();
        System.out.print("Reverse: ");
        System.out.println(reversedList.toString());
        System.out.println("size: " + reversedList.size());
    }

} //Driver               
