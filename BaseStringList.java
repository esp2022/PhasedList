package cs1302.p2;

import cs1302.adt.StringList;
abstract class BaseStringList implements StringList {
    int size = 0;

    boolean append (String item) {
        checkItem (item);
        return  add (size(), item);


    }

    int size () {

        return this.size;

    }

    private void checkItem (String item) {
        if (item == null) {
            throw new NullPointerException ("checkItem: item is null");
        }
        if (item.isEmpty) {
            throw new IllegalArgumentException ("checkItem: item is illegal");
        }
    }

    private void checkIndex (int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException ("checkIndex: index is out of bounds");
        }
    }

    String  get (int index) {
        checkIndex(index);
        return getStringAtIndex (index);

    }

    abstract String getStringAtIndex (int index);
}