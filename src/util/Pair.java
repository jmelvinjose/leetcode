package util;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 1/1/15
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Pair<F, S> {

  private F first;
  private S second;

  public F getFirst() {
    return first;
  }

  public S getSecond() {
    return second;
  }

  public Pair(F first, S second) {
    this.first = first;
    this.second = second;
  }
}
