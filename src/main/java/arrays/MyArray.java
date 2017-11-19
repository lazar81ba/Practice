package arrays;

import java.util.Arrays;

public class MyArray<T extends Comparable> {
   private T[] array ;
   private int currentElement = 0;
   private int currentCapacity =4;

   public MyArray(){
       array = (T[]) new Comparable[currentCapacity];
   }

    public MyArray(int capacity){
       currentCapacity=capacity;
        array = (T[]) new Comparable[capacity];
    }

    private boolean isThereNeedToExpandArray(){
        return currentCapacity==currentElement;
    }

    private void expandArray(){
        T[] tmp = array;
        currentCapacity*=2;
        array = (T[]) new Comparable[currentCapacity];
        System.arraycopy(tmp,0,array,0,tmp.length);
    }

    public void insert(T element){
        if(isThereNeedToExpandArray())
            expandArray();
        array[currentElement++]=element;
    }

    @Override
    public String toString() {
        return Arrays.toString(array) ;
    }

    public void insertionSort(){
        for(int k=1; k<currentCapacity;k++){ // begin with second
            T curr = array[k];
            int j = k;   // find index j for curr
            while(j>0&&array[j-1].compareTo(curr)>0){
                array[j] = array[j-1];
                j--;
            }
            array[j]=curr;
        }
    }
}
