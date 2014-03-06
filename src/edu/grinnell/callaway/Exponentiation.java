package edu.grinnell.callaway;

public class Exponentiation
{
  /**
   * Compute x^n.
   *
   * @pre n >= 1.
   */
  public static double expt(double x, int n)
  {
    double val = x;
    double k=1;
    
    while (n>0)
      {
        if(n%2 == 1)
          k *= val;
        n =n/2;
        if (n>0)
          val *= val;
      } // while (n>0)
    
    return k;
  } // expt(double, int)
  
  public static void main(String[]args)
  {
    System.out.println(expt(3.6, 5));
  }
}
