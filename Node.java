  enum Era {
      SHOWA {
          @Override
          public String toString() {
            return "Showa rider";
          }
        },
      HEISEI {
          @Override
          public String toString() {
            return "Heisei rider";
          }
        },
      REIWA {
          @Override
          public String toString() {
            return "Reiwa rider";
          }
        }
  }

  public class Node {
      public int heroId;
      public String name;
      public double power;
      public Era era;

      Node next;
      Node previous;
      
      // Constructor 1
      public Node(int id, String name, double power, Era era){
          //START FIX HERE
          this.heroId = id;
          this.name = name;
          this.power = power;
          this.era = era;
          //END FIX HERE
      }
      // Constructor 2
      public Node(String name){
          //START FIX HERE
          this.name = name;
          //END FIX HERE
      }
      // Constructor 3 (dummy)
      public Node(){
          // You can leave this function blank
      }
      
      public void printHero(){
          System.out.printf("HeroID: %s , Name: %s , Power: %.1f, Era: %s\n", heroId, name, power, era);
      }

  }
