package Shapes;

public class Main {
  public static void main(String[] args) {
    Knapsack k = new Knapsack(9);
    try {
    k.Put(new Cube(1));
    k.Put(new Cube(2));
    k.Put(new Ball(1));
    } catch (KnapsackFullException e) {
      System.out.println(e.getMessage());
    }
  }
}
