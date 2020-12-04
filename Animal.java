/**
 * @author Neilan Post
 * @version 1.0 (jan 7th 2020)
 * @see AnimalClient
*/

import java.util.*;//for random
public class Animal//Animal object class used for AnimalClient
{
   public String name;//given name of animal
   private int x;//keeps track of horizontal location between -10 and 10
   private int y;//keeps track of vertical location between -10 and 10
   private int speed;//how much (minimum of 2) in one move() animal can move
   
   /**
   * default constructor for Animal object, no parameters. Creates Animal with name "unknown" at (0,0) with base speed of 2
   */
   public Animal()
   {
      this.name = "unknown";
      this.x = 0;
      this.y = 0;
      this.speed = 2;
   }
   
   /**
    * Full parameterized constructor for Animal object
    * @param name String of Animal object's name
    * @param x integer that keeps track of animal's position hoizontaly
    * @param y integer that keeps track of animal's position verticaly
    * @param speed integer that multiplies on animals move()
    */
   public Animal(String name, int x, int y, int speed)
   {
      this.name = name;
      if (x>-11&&x<11){this.x = x;} else this.x = 0;
      if (y>-11&&y<11){this.y = y;} else this.y = 0;
      if (speed>1&&speed<6){this.speed = speed;} else this.speed = 2;
   }
   
   /**
    * Method that takes 3 of 4 data feilds of Animal object into one String to use for printing
    * @return String with infomation of Animal object
    */
   public String toString()
   {
      return (""+name+" at ("+x+", "+y+")");
   }
   
   /**
    * sees if two Animal objects are in the same spot
    * @param z explicit Animal object that will be compared with the implicit Animal object
    * @return Boolean true/false that says wheather animals are in same location (same x and same y) 
    */
   public boolean touching(Animal z)
   {
      return ((z.x==this.x)&&(z.y==this.y));
   }
   
   /**
    * gets private variable x to other classes by calling this method
    * @return integer x of implicit Animal Object
    */
   public int getX(){return x;}
   
   /**
    * gets private variable y to other classes by calling this method
    * @return integer y of implicit Animal Object
    */
   public int getY(){return y;}
   
   /**
    * (No paramters or return) moves Animal object in a random dirrection (up or down along y range. left and right along x range) in a random amount between 2 and speed.
    */
   public void move()
   {
      Random roll = new Random();
      int moveAmount = roll.nextInt(speed-1)+2; //amount of spaces to move, goes between 2 and animal's speed
      
      boolean canMove = true;
      while(canMove)//while on an edge, keep looping random roll till direction not towards barrier
      {
         int moveDirection = roll.nextInt(4); //0-3 each will correspond with 4 directions
         //if number lands on dirrection but is at the end (-10 or 10), don't enter statement and redo random moveDirection
         
         if (moveDirection == 0 && (y!=10))//up
         {
            if(y+moveAmount<=10){y += moveAmount;}//normal move
            else{y=10;}//if moveAmount is too large, move remaining spaces
            canMove=false;//leave loop
         }
            
         else if (moveDirection == 1 && (y!=-10))//down
         {
            if(y-moveAmount>=-10){y -= moveAmount;}//normal move
            else{y=-10;}//move remaining spaces
            canMove=false;//leave loop
         }
         
         else if (moveDirection == 2 && (x!=10))//right
         {
            if(x+moveAmount<=10){x += moveAmount;}//normal move
            else{x=10;}//move remaining spaces
            canMove=false;//leave loop
         }
           
         else if (moveDirection == 3 && (x!=-10)) //left
         {
            if(x-moveAmount>=-10){x -= moveAmount;}//normal move
            else{x=-10;}//move remaining spaces
            canMove=false;//leave loop
         }
      }
   }
}