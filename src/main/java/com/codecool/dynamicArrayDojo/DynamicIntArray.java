package com.codecool.dynamicArrayDojo;


// put your code here!
public class DynamicIntArray {
    private int pointer;
    private Integer[] array;
    private static int DEFAULT_SIZE = 10;

    public DynamicIntArray() {
        this(DEFAULT_SIZE);
    }

    public DynamicIntArray(int size) {
        this.array = new Integer[size];
    }


    public void add(Integer elem) {
        adjust();
        array[pointer++] = elem;
    }

//    public void remove(Integer elem) {
//        Integer index = search(elem);
//        if(index != null) remove(index);
//    }

    public void remove(Integer index) {
        if((index >= 0) && (index < pointer )) {

            for(int i= index; i < pointer-1; i++) {
                array[i] = array[i+1];
            }
            array[--pointer] = null;
            adjust();
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    public void insert(int index, int value) {
        if (index > pointer) index = pointer;

        for(int i = pointer ; i >= index; i--) {
            array[i] = array[i-1];
        }
        array[index] = value;
        adjust();
        pointer++;
    }


    private void adjust() {
        if(pointer == array.length) {
            increaseSize();
        }
        else if (pointer == (array.length/4 - 1)) {
            decreaseSize();
        }
    }

    private void increaseSize() {

        Integer[] temp = new Integer[array.length * 2];
        for (int i=0; i < pointer; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    private void decreaseSize() {
        Integer[] temp = new Integer[array.length/4];

        for (int i=0; i < pointer; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public Integer size() {
        return pointer;
    }

    @Override
    public String  toString() {
        StringBuilder temp = new StringBuilder();

        for (Integer elem : array) {
            if(elem != null) temp.append(" ").append(elem);
        }
        return temp.toString();
    }
}
