package edu.grinnell.callaway;

public class SkipListExpt
{
  public static void main(String[] args)
  {

    SkipListOfStrings list = new SkipListOfStrings();
    System.out.println(list);

    list.add("m");
    list.add("i");
    list.add("a");
    list.add("dancing");
    list.add("i am electric");
    list.add("banana");
    list.add("breakfast at tiffany's");
    list.add("1");
    list.add("0");
    list.add(" ");
    list.add("xylophone");
    list.add("xylophones");

    System.out.println("contains 'i': " + list.contains("i"));
    System.out.println("contains '0': " + list.contains("0"));
    System.out.println("contains 'breakfast at johns': "
                       + list.contains("breakfast at johns"));
    System.out.println("contains 'zebra': " + list.contains("zebra") + "\n");

    System.out.println(list + "\n");
    list.remove("a");
    list.remove("dancing");
    System.out.println("contains 'a': " + list.contains("a"));
    System.out.println("contains 'dancing': " + list.contains("dancing") + "\n");

    System.out.println(list);
  } // main
} // SkipListExpt
