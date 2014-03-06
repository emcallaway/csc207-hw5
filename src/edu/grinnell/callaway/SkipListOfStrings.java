package edu.grinnell.callaway;

/**
 * Skip lists of strings, stored alphabetically.
 */
public class SkipListOfStrings
    implements
      SetOfStrings
{
  /**
   * Nodes of the skip list
   */
  private class Node
  {
    public final String val;
    public final Node[] pointer;

    public Node(String str, int lvl)
    {
      this.val = str;
      pointer = new Node[lvl + 1];
    }// Node(String str, int lvl)
  }// private class Node

  /*
   * Constants and Fields
   */
  int MAX_LEVEL = 20;
  int level = 0;
  double p = 0.5;

  Node HEAD = new Node(null, MAX_LEVEL);

  /**
   * generates a random level from 1 to MAX_LEVEL-1, inclusive
   * 
   * @pre MAX_LEVEL is predefined
   *      p is predefined
   * 
   * @post 0 < lvl < MAX_LEVEL
   * 
   * @return int lvl
   */
  public int level()
  {
    int lvl = 1;
    while (Math.random() < p && lvl < MAX_LEVEL)
      {
        lvl++;
      }// while
    return lvl;
  }// level()

  /**
   * determines whether 'str' is contained within this skip list
   * 
   * @param String
   *          str String to search for in this skip list
   * 
   * @pre str must be a valid string 
   *      this skip list must be predefined
   * 
   * @return boolean
   */

  public boolean contains(String str)
  {
    Node current = this.HEAD;
    for (int i = level; i >= 0; i--)
      {
        while (current.pointer[i] != null
               && current.pointer[i].val.compareTo(str) < 0)
          {
            current = current.pointer[i];
          }// while
      }// for

    current = current.pointer[0];
    return (current != null && current.val.equals(str));
  }// contains(String str)

  /**
   * adds a string 'str' to this list in alphabetical order
   * 
   * @param String
   *          str
   * 
   * @pre str must be a valid string 
   *      this skip list must be predefined
   *      MAX_LEVEL is predefined
   * 
   * @post str is in this skip list in the correct alphabetical position
   *       all pointers of all elements of this skip list have been
   *       adjusted accordingly
   *       if necessary, the level of this skip list has been increased
   *       accordingly
   */
  public void add(String str)
  {
    Node current = this.HEAD;
    Node[] update = new Node[MAX_LEVEL + 1];

    for (int i = this.level; i >= 0; i--)
      {
        while (current.pointer[i] != null
               && current.pointer[i].val.compareTo(str) < 0)
          {
            current = current.pointer[i];
          }// while
        update[i] = current;
      } // for

    current = current.pointer[0];

    if (current == null || !current.val.equals(str))
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
        for (int i = 0; i <= lvl; i++)
          {
            current.pointer[i] = update[i].pointer[i];
            update[i].pointer[i] = current;
          }// for
      } // if
  }// add(String str)

  /**
   * removes a string 'str' from this skip list
   * 
   * @param String
   *          str
   * 
   * @pre str must be a valid string 
   *      this skip list must be predefined
   *      MAX_LEVEL is predefined
   * 
   * @post str is removed from this skip list 
   *       all pointers of all remaining elements of this skip list 
   *       have been reassigned accordingly.
   * 
   */

  public void remove(String str)
  {
    Node current = this.HEAD;
    Node[] update = new Node[MAX_LEVEL + 1];

    for (int i = this.level; i >= 0; i--)
      {
        // System.out.println("i = " + i);
        while (current.pointer[i] != null
               && str.compareTo(current.pointer[i].val) > 0)
          {
            current = current.pointer[i];
          }// while
        update[i] = current;
      } // for
    current = current.pointer[0];
    if (str.equals(current.val))
      {
        for (int i = 0; i < this.level; i++)
          {
            if (update[i].pointer[i] != current)
              break;
            update[i].pointer[i] = current.pointer[i];
            while (this.level > 0 && this.HEAD.pointer[this.level] == null)
              this.level--;
          }// for
      }// if
  }// remove(String str)
  
  /**
   * converts this skip list to printable format for output
   * 
   * @pre this skip list is predefined
   * 
   * credit: inspired by toString method on michaelnaper.com
   *    (took cue from code, significantly modfied for our use)
   * 
   */

  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    Node current = HEAD.pointer[0];
    while (current != null)
      {
        sb.append(current.val);
        current = current.pointer[0];
        if (current != null)
          sb.append(",");
      }// while
    sb.append("}");
    return sb.toString();
  }// toString()
} // class SkipListOfStrings