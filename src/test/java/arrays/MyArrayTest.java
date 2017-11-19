package arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayTest {


    @Test
    public void testInsert(){
        MyArray<String> array= new MyArray<String>(1);
        array.insert("test");
        assertEquals("[test]",array.toString());
    }
    @Test
    public void testArrayExpanding(){
        MyArray<Integer> array= new MyArray<Integer>(1);
        array.insert(1);
        array.insert(2);
        assertEquals("[1, 2]",array.toString());
    }

    @Test
    public void testInsertionSort(){
        MyArray<Integer> array= new MyArray<Integer>(3);
        array.insert(new Integer(1));
        array.insert(new Integer(-1));
        array.insert(new Integer(0));
        array.insert(new Integer(4));
        array.insert(new Integer(-1));
        array.insert(new Integer(6));


        array.insertionSort();
        assertEquals("[-1, -1, 0, 1, 4, 6]",array.toString());

    }

}