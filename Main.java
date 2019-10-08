package Shapes;

public class Main {
  public static void main(String[] args) {
    Knapsack k = new Knapsack(8);
    try {
      k.Put(new Cube(1));
      k.Put(new Prism(new Circle(1), 2));
      k.Put(new Cuboid(1, 2, 3));
    } catch (KnapsackFullException e) {
      System.out.println(e.getMessage());
    }
  }
}
