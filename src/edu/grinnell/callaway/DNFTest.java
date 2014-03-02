package edu.grinnell.callaway;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class DNFTest
{
  @Test
  public void test()
  {
    String[] str = new String[]{"12345", "666666", "456", "123", "55555", "2", "1", "345", "67890"};
    String[] ring = new String[]{"12345", "123456", "123"};
    String[] ing = new String[]{"This", "34", "this", "IT"};
    DNF.dnf(str, new SimpleStringSizeClassifier());
    DNF.dnf(ring, new SimpleStringSizeClassifier());
    DNF.dnf(ing, new ClassifyStringsByFirstCharacter());
    assertArrayEquals(new String[]{"456", "123", "2", "1", "345", "12345", "55555", "67890", "666666"},
                      str);
    assertArrayEquals(new String[]{"123", "12345", "123456"},
                      ring);
    assertArrayEquals(new String[]{"this", "This", "IT", "34"},
                      ing);
  } // test()
} // DNFTest
