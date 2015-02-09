import java.util.*;

/**
 * Created by melvinj on 2/8/15.
 */
public class WordLadderII {

  Set<String> dict;
  String start;
  String end;
  List<List<String>> paths;

  public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    this.dict = dict;
    this.start = start;
    this.end = end;
    paths = new ArrayList<List<String>>();

    bfs(start, end);
    return paths;
  }

  private void bfs(String start, String end) {
    LinkedList<String> queue = new LinkedList<String>();
    Set<String> visited = new HashSet<String>();
    Map<String, String> edgeTo = new HashMap<String, String>();

    visited.add(start);
    queue.add(start);

    while (!queue.isEmpty()) {
      String v = queue.removeFirst();

      for (String w : getAdj(v)) {
        if (!visited.contains(w)) {
          if (w.equals(end)) {
            edgeTo.put(w, v);
            List<String> path = new ArrayList<String>();
            for (String x = w; !x.equals(start); x = edgeTo.get(x)) {
              path.add(x);
            }
            path.add(start);
            Collections.reverse(path);
            if (paths.isEmpty()) {
              paths.add(path);
            } else if (paths.get(0).size() == path.size()) {
              paths.add(path);
            }
          } else {
            visited.add(w);
            queue.add(w);
            edgeTo.put(w, v);
          }
       }
      }
    }

  }

  private Set<String> getAdj(String word) {
    Set<String> result = new HashSet<String>();
    char[] charArray = word.toCharArray();

    for (int i = 0; i < charArray.length; i++) {
      char[] temp = (char[]) charArray.clone();
      for (int j = 0; j < 26; j++) {
        temp[i] = (char) ('a' + j);
        String t = new String(temp);
        if (dict.contains(t) && !t.equals(word)) {
          result.add(t);
        }
      }
    }
    return result;
  }

  public static void main(String args[]) {
    Set<String> dict = new HashSet<String>(Arrays.asList("a", "b", "c"));
    WordLadderII w = new WordLadderII();
    System.out.println(w.findLadders("a", "c", dict));
  }
}
