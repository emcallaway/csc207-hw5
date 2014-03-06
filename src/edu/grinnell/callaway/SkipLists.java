package edu.grinnell.callaway;

class Nodes
{
    public final String element;
    public final Nodes[] next; // array of pointers

    public Nodes(int level, String element) 
    {
       next = new Nodes[level + 1];
       this.element = element;
    }
}
 
  public class SkipLists
  {
      public static final double P = 0.5;
      public static final int MAX_LEVEL = 6;
      public static int randomLevel() {
          int lvl = (int)(Math.log(1.-Math.random())/Math.log(1.-P));
          return Math.min(lvl, MAX_LEVEL);
      } 
  
      public final Nodes header = new Nodes(MAX_LEVEL, null);
      public int level = 0;
  
      public String toString()
      {
          StringBuilder sb = new StringBuilder();
          sb.append("{");
          Nodes x = header.next[0];
          while (x != null) {
              sb.append(x.element);
              x = x.next[0];
              if (x != null)
                  sb.append(",");
          }    
          sb.append("}");
          return sb.toString();
      }
      public boolean contains(String str)
      {
          Nodes x = header;
          for (int i = level; i >= 0; i--) {
          while (x.next[i] != null && x.next[i].element.compareTo(str) < 0) {
              x = x.next[i];
          }
      }
      x = x.next[0];
          return x != null && x.element.equals(str);
      }

      public void insert(String str)
      {
          Nodes x = header;     
          Nodes[] update = new Nodes[MAX_LEVEL + 1];
  
          for (int i = level; i >= 0; i--) {
          while (x.next[i] != null && x.next[i].element.compareTo(str) < 0) {
              x = x.next[i];
          }
          update[i] = x; 
      }
      x = x.next[0];
  
          if (x == null || !x.element.equals(str)) {        
              int lvl = randomLevel();
        
              if (lvl > level) {
              for (int i = level + 1; i <= lvl; i++) {
                  update[i] = header;
              }
              level = lvl;
          }
              x = new Nodes(lvl, str);
          for (int i = 0; i <= lvl; i++) {
              x.next[i] = update[i].next[i];
              update[i].next[i] = x;
          }
          }
      }
      @SuppressWarnings("unchecked")
      public void delete(String str)
      {
          Nodes x = header;     
          Nodes[] update = new Nodes[MAX_LEVEL + 1];
  
          for (int i = level; i >= 0; i--) {
          while (x.next[i] != null && x.next[i].element.compareTo(str) < 0) {
              x = x.next[i];
          }
          update[i] = x; 
      }
      x = x.next[0];
  
          if (x.element.equals(str)) {
              for (int i = 0; i <= level; i++) {
              if (update[i].next[i] != x)
                  break;
              update[i].next[i] = x.next[i];
          }
              while (level > 0 && header.next[level] == null) {
              level--;
          }
          }
      }
  
      public static void main(String[] args) {
  
          SkipLists ss = new SkipLists();
          System.out.println(ss);
  
          ss.insert("a");
          ss.insert("b");
          ss.insert("r");
          ss.insert("c");
          ss.insert("x");
          
          if (ss.contains("a")) {
              System.out.println("'a' is in the list");
          }
  
          System.out.println(ss);
  
          ss.delete("a");
          System.out.println(ss);
          
          if (!ss.contains("a")) {
              System.out.println("a has been deleted");
          }
      }
  }

