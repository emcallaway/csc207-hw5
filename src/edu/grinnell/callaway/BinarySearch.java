package edu.grinnell.callaway;
public class BinarySearch
{
  /**
   * Search for val in values, return the index of an instance of val.
   *
   * @param val
   *   An integer we're searching for
   * @param values
   *   A sorted array of integers
   * @result
   *   index, an integer
   * @throws Exception
   *   If there is no i s.t. values[i] == val
   * @pre
   *   values is sorted in increasing order.  That is, values[i] <
   *   values[i+1] for all reasonable i.
   * @post
   *   values[index] == val
   */
  public static int binarySearch (int i, int[] vals) 
    throws Exception 
  {
    int lower = 0;
    int upper = vals.length-1;
    
    while (lower <= upper)
      {
        int mid = lower + (upper-lower)/2;
        
        if (vals[mid]<i)
          {
            lower = mid +1;
          }
        else if (vals[mid]>i)
          {
            upper = mid -1;
          }
        else
          {
            return mid;
          }
      }
    throw new Exception("Val not in array");    
  } // binarySearch
}
