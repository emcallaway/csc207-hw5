package edu.grinnell.callaway;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearchTest
{

  @Test
  public void test()
    throws Exception
  {
    for (int size = 1; size < 32; size++)
      {
        int[] array = new int[size];
        for (int fill = 0; fill < size; fill++)
          {
            array[fill] = fill * 2;
          } // for (fill)
        for (int i = 0; i < size; i++)
          {
            assert (BinarySearch.binarySearch(2 * i, array) == i);
            try
              {
                BinarySearch.binarySearch((2 * i) + 1, array);
                fail("That actually worked. It wasn't supposed to...");
              } // try
            catch (Exception e)
              {
                assert (e.getMessage().contains("Val not in array"));
              } // catch
          } // for (i)
        
        try
          {
            BinarySearch.binarySearch(-1, array);
            fail("That actually worked. It wasn't supposed to...");
          } // try
        catch (Exception e)
          {
            assert (e.getMessage().contains("Val not in array"));
          }
      } // for (size)
  } // test
} // class BinarySearchTest
