import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 11/2/14
 * Time: 10:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class WordLadder {

  static class Pair<A, B> {
    private A first;
    private B second;

    public Pair(A first, B second) {
      super();
      this.first = first;
      this.second = second;
    }

    public int hashCode() {
      int hashFirst = first != null ? first.hashCode() : 0;
      int hashSecond = second != null ? second.hashCode() : 0;

      return (hashFirst + hashSecond) * hashSecond + hashFirst;
    }

    public boolean equals(Object other) {
      if (other instanceof Pair) {
        Pair otherPair = (Pair) other;
        return
                ((  this.first == otherPair.first ||
                        ( this.first != null && otherPair.first != null &&
                                this.first.equals(otherPair.first))) &&
                        (	this.second == otherPair.second ||
                                ( this.second != null && otherPair.second != null &&
                                        this.second.equals(otherPair.second))) );
      }

      return false;
    }

    public String toString()
    {
      return "(" + first + ", " + second + ")";
    }

    public A getFirst() {
      return first;
    }

    public void setFirst(A first) {
      this.first = first;
    }

    public B getSecond() {
      return second;
    }

    public void setSecond(B second) {
      this.second = second;
    }
  }

  public static Set<String> dict;
  public static int ladderLength(String start, String end, Set<String> d) {
    dict = d;
    return bfs(start, end);
  }

  static int bfs(String start, String end) {
    LinkedList<Pair<String, Integer>> q = new LinkedList<Pair<String, Integer>>();
    Set<String> visited = new HashSet<String>();

    q.add(new Pair<String, Integer>(start, 0));
    while (!q.isEmpty()) {
      Pair<String, Integer> front = q.getFirst();
      q.removeFirst();
      if (visited.contains(front.getFirst())) {
        continue;
      }
      if (front.getFirst().equals(end)) {
        return front.getSecond() + 1;
      }
      visited.add(front.getFirst());
      for (String word : getAdj(front.getFirst())) {
        if (!visited.contains(word)) {
          q.add(new Pair<String, Integer>(word, front.getSecond()+1));
        }
      }
    }
    return -1;
  }

  public static Iterable<String> getAdj(String node) {
    List<String> res = new ArrayList<String>();
    char[] arr = node.toCharArray();
    for (int i=0; i< arr.length; i++) {
      char[] temp = (char[]) arr.clone();
      for (int j=0; j<26; j++) {
        temp[i] = (char)('a' + j);
        String t = new String(temp);
        if (dict.contains(t)) {
          res.add(t);
        }
      }
    }
    return res;
  }

  public static void main(String args[]) {
    Set<String> d = new HashSet<String>();
    d.add("a"); d.add("b"); d.add("c");
    System.out.println(ladderLength("a", "c", d));
  }
}
