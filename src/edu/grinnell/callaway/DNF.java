package edu.grinnell.callaway;

import java.util.Arrays;

public class DNF
{
  
  /**
   * Rearrange vals so that red values precede white values and white values
   * precede blue values.
   *
   * @post
   *   Exist P and Q, 0 <= P <= Q <= vals.length, s.t.
   *     For all i, 0 <= i < P, classifier.classify(vals[i]) < 0
   *     For all i, P <= w < Q, classifier.classify(vals[i]) == 0
   *     For all i, Q <= i < vals.length, classifier.classify(vals[i]) > 0
   *   Values have neither been added to nor removed from vals; the new
   *     vals is a permutation of the original.
   */
  public static void dnf(String[] vals, StringClassifier classifier)
  {
    int begin =0, r=0, i=0, b=vals.length, end=vals.length;
   
    while(i < b)
      {
        String move = vals[i];
        if (classifier.classify(vals[i])<0)
          {
            
            for (int j=i; j>r; j--)
              {
                vals[j]= vals[j-1];
              }
            vals[r]=move;
            r++;
          }
        else if (classifier.classify(vals[i])>0)
          {
            for (int j=i; j<end-1; j++)
              {
                vals[j] = vals[j+1];
              }
            vals[end-1]= move;
            b--;
            i--;
          }
        i++;
      }//   int x = classifier.classify(vals[0]);
  } // dnf(String[], StringClassifier) 
  
  public static void main(String[] args)
  {
    String[] str = new String[]{"12345", "666666", "456", "123", "55555", "2", "1", "345", "67890"};
    String[] th = new String[]{"This", "34", "this", "IT",};
    dnf(str, new SimpleStringSizeClassifier());
    dnf(th, new ClassifyStringsByFirstCharacter());
    System.out.println(Arrays.toString(str));
    System.out.println(Arrays.toString(th));
  }
} // class DNF
