package edu.grinnell.callaway;

public class SkipNode
{
  int level;
  int MAX_LEVEL = 20;
   String elements;
   SkipNode[] next;
   int count;

   
   public SkipNode(int newHeight)
   {
     this.level = randLevel(); 
     this.next = new SkipNode[this.level];
   }
   
  public SkipNode(int newHeight, String str)
  {
    this.level = newHeight;
    this.elements = str;
    this.next = new SkipNode[this.level];

  }
  
  public int randLevel() 
  {
    for(int i = 1; i < MAX_LEVEL; i++)
      {
        if(Math.random() > count)//p)
          {
            return i;
          }//if
      }//if
    return MAX_LEVEL;
  }
  

}


/*
function level
  for (int i = 1; i < MAX_LEVEL; i++)
    if (random() < (1-p)) // you could also use (random() > p)
      return i
    end if
  end for
  // At this point, we seem to have run out of possible levels
  return MAX_LEVEL
*/