/**
 * CS 145 Java
 * @author Neilan Post
 * @version 1.0 (jan 8th 2020)
 * @see Animal
*/

public class AnimalClient
{
   public static void main(String[] args)
   {
      int fightCounter = 0, roundCounter = 0;

      int numAnimals = 5;
      Animal[] animalList = new Animal[numAnimals];
      //5 elements of array can be edited
      animalList[0] = new Animal("Pig",7,10,3);
      animalList[1] = new Animal("Cow",9,4,2);
      animalList[2] = new Animal("Dog",-4,0,4);
      animalList[3] = new Animal("Cat",2,-5,3);
      animalList[4] = new Animal("Horse",-7,-7,5);
      
      System.out.println("The animals start in these positions...");
      printAllAnimals(animalList,numAnimals);//print out all animals for begining
      System.out.println();
            
      while(fightCounter<5)//repeat moving animals and checking if animals are in same spot
      {
         moveAllAnimals(animalList,numAnimals);//move animals
         for(int i=0;i<numAnimals;i++)//double loop checks each animal with all other animals
         {
            for(int j=i+1;j<numAnimals-1;j++)
            {
               if (animalList[i].touching(animalList[j]))
               {
                  //when animals in same x and y cordinates, print and add to counter 
                  System.out.println("Fight! "+animalList[i].toString()+" and "+ animalList[j].toString()+"\n");
                  fightCounter++;
               }
            }
         }
         roundCounter++;//add to counter after moving and checking
         printAllAnimals(animalList,numAnimals);//print out locations once per round
         System.out.println("+-+-+-+-+-+-+-+-+-+-+-+");//seperates rounds
      }
      //when 5 fights have occured
      System.out.println("There were "+fightCounter+" fights\nIt took "+roundCounter+" rounds\nThe final locations were...");
      printAllAnimals(animalList,numAnimals);
   }
   
   public static void printAllAnimals(Animal[] list, int numAnimals)
   {
      for(int i=0;i<numAnimals;i++) //for each animal, print toString()
      {
         System.out.println(list[i].toString());
      }
   }
   
   public static void moveAllAnimals(Animal[] list, int numAnimals)
   {
      for(int i=0;i<numAnimals;i++)//for each animal, do move()
      {
         list[i].move();
      }
   }
}