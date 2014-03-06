package edu.grinnell.callaway;

/**
 * Skip lists of strings, stored alphabetically.
 */
public class SkipListOfStrings
    implements
      SetOfStrings
{

  /*
   * Fields and Constants
   */

  int MAX_LEVEL = 20;
  int level=1;
  double p = 0.5;

  Node HEAD = new Node("HEAD", MAX_LEVEL);
  Node NIL = new Node("NIL", MAX_LEVEL);
//  Node TEST = new Node("TEST", 20);

  private class Node
  {
    /*
     * Fields
     */

    String val;
    int level;
    Node[] pointer;

    /*
     * Constructors
     */
    private Node(String str, int lvl)
    {
      val = str;
      level = lvl;
      pointer = new Node[level];
    }// Node(String str, int lvl)
  }// private class Node

  /*
   * Constructors
   */
 /* public SkipListOfStrings()
  {
    this.level = 1;
    for (int i = 0; i < MAX_LEVEL; i++)
      {
        this.HEAD.pointer[i] = NIL;
  //      this.TEST.pointer[i] = NIL;
      }// for
  }// SkipListOfStrings()*/

  /*
   * Methods
   */

  public int level()
  {
   int lvl = 1;
    while (Math.random() < p && lvl < MAX_LEVEL)
      {
        lvl++;
      }

    System.out.println("level: " + level);
    return lvl;
    
  }// level()

  public boolean contains(String str)
  {
    Node current = this.HEAD;
    for (int i = this.level; i > 0; i--)
      {
        while (current.pointer[i] != null && str.compareTo(current.pointer[i].val) > 0)
          {
            current = current.pointer[i];
          } // while
      } // for
    current = current.pointer[1];
   
      return (current.val != null && str.equals(current.val));
    
    

  }// contains(String str)

  public void add(String str)
  {
    Node current = this.HEAD;
    Node[] update = new Node[MAX_LEVEL + 1];
    for (int i = this.level; i >= 0; i--)
      {
       // System.out.println("i = " + i);
        while (current.pointer[i] != null && str.compareTo(current.pointer[i].val) > 0)
          {
            current = current.pointer[i];
          }// while
        update[i] = current;
      } // for
    current = current.pointer[1];
    if (current == null || !str.equals(current.val))
      {
        int lvl = level();
        if (lvl > this.level)
          {
            for (int i = this.level + 1; i <= lvl; i++)
              {
                update[i] = this.HEAD;
              }// for
            this.level = lvl;
          }// if
        current = new Node(str, lvl);
        for (int i = 0; i<lvl; i++)
          {
            current.pointer[i] = update[i].pointer[i];
            update[i].pointer[i] = current;
          }// for
      } // if 

  }// add(String str)

  public void remove(String str)
  {

    Node current = this.HEAD;
    Node[] update = new Node[MAX_LEVEL + 1];
    for (int i = this.level; i >= 0; i--)
      {
       // System.out.println("i = " + i);
        while (current.pointer[i] != null && str.compareTo(current.pointer[i].val) > 0)
          {
            current = current.pointer[i];
          }// while
        update[i] = current;
      } // for
    current = current.pointer[0];
    if (str.equals(current.val))
      {
        for (int i=0; i<this.level; i++)
          {
            if (update[i].pointer[i] != current)
                break;
            update[i].pointer[i] = current.pointer[i];
            current = null;
            while (this.level >1 && this.HEAD.pointer[this.level] ==NIL)
                this.level = this.level-1;
          }
      }
    

  }// remove(String str)

  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    Node x = HEAD.pointer[0];
    while (x != null)
      {
        sb.append(x.val);
        x = x.pointer[0];
        if (x != null)
          sb.append(",");
      }
    sb.append("}");
    return sb.toString();
  }
} // class SkipListOfStrings