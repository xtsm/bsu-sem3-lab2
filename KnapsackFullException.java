package lab2.knapsack;

public class KnapsackFullException extends Exception {
  public KnapsackFullException(double volume, double shapeVolume) {
    super(String.format("tried to fit %f vol. into knapsack with %f vol. left", shapeVolume, volume));
  }
}
