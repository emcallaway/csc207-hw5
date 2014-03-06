package edu.grinnell.callaway;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExponentiationTest
{

  @Test
  public void testInt()
  {
    for (int x = 0; x < 20; x++)
      {
        for (int n = 1; n < 5; n++)
          {
            assertEquals(Math.pow(x, n), Exponentiation.expt(x, n), 0.001);
          }// for n
      }// for x
  }// testInt

  @Test
  public void testHalf()
  {
    for (double x = 1; x < 10; x += .5)
      {
        for (int n = 1; n < 5; n++)
          {
            assertEquals(Math.pow(x, n), Exponentiation.expt(x, n), 0.001);
          }// for n
      }// for x
  }// testHalf

  @Test
  public void testLarge()
  {
    for (double x = 0; x < 200; x++)
      {
        for (int n = 1; n < 8; n++)
          {
            assertEquals(Math.pow(x, n), Exponentiation.expt(x, n), 0.001);
          }// for n
      }// for x
  }// testLarge

  @Test
  public void testLargeN()
  {
    for (double x = 0; x < 5; x++)
      {
        for (int n = 1; n < 40; n++)
          {
            assertEquals(Math.pow(x, n), Exponentiation.expt(x, n), 0.001);
          }// for n
      }// for x
  }// testLargeN

  @Test
  public void testLargeDec()
  {
    for (double x = 0; x < 100; x += .1)
      {
        for (int n = 1; n < 8; n++)
          {
            assertEquals(Math.pow(x, n), Exponentiation.expt(x, n), .1);
          }// for n
      }// for x
  }// testLargeDec
  
  

}
