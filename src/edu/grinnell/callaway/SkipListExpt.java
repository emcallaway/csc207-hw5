package edu.grinnell.callaway;

public class SkipListExpt
{
  public static void main(String[] args)
  {

    SkipListOfStrings ss = new SkipListOfStrings();
    System.out.println(ss);

    ss.add("m");
    ss.add("i");
    ss.add("a");

    System.out.println(ss.contains("c"));
    System.out.println(ss);
    ss.remove("a");

    System.out.println(ss);
  }
}
