package edu.grinnell.callaway;

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
    int r=0, i=0, b=vals.length, end=vals.length;
   
    while(i < b)
      {
        String move = vals[i];
        if (classifier.classify(vals[i])<0)
          {          
            for (int j=i; j>r; j--)
              {
                vals[j]= vals[j-1];
              } // for (j)
            vals[r]=move;
            r++;
          } // if (classifier.classify(vals[i])<0)
        else if (classifier.classify(vals[i])>0)
          {
            for (int k=i; k<end-1; k++)
              {
                vals[k] = vals[k+1];
              } // for (k)
            vals[end-1]= move;
            b--;
            i--;
          } // else if (classifier.classify(vals[i])>0)
        i++;
      }// while (i<b)
  } // dnf(String[], StringClassifier) 
} // class DNF
