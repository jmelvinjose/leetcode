import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: melvinj
 * Date: 8/26/14
 * Time: 7:14 AM
 * http://community.topcoder.com/stat?c=problem_statement&pm=10774&rd=14146
 */
public class TheCitiesAndRoadsDivTwo {

  int count;
  boolean[] marked;
  int[] id;
  int[] size;

  public int find(String[] map) {
    int numCities = map.length;
    marked = new boolean[numCities];
    id = new int[numCities];
    size = new int[numCities];
    count = 0;
    for (int v = 0; v < numCities; v++) {
      if (!marked[v]) {
        dfs(map, v);
        count++;
      }
    }

    int result = 1;
    System.out.println("Number of connected components " + count);

    if (count == 1) {
      return 1;
    }

    for (int i = 0; i < count; i++) {
      result *= size[i];
    }
    return result;
  }

  void dfs(String[] map, int v) {

    marked[v] = true;
    id[v] = count;
    size[count]++;

    for (int w : getAdj(map, v)) {
      if (!marked[w]) {
        dfs(map, w);
      }
    }
  }

  Iterable<Integer> getAdj(String map[], int v) {
    Set<Integer> result = new HashSet<Integer>();
    String cities = map[v];

    for (int i = 0; i < cities.length(); i++ ) {
      if (cities.charAt(i) == 'Y') {
        result.add(i);
      }
    }
    return result;
  }

  public static void main(String args[]) {
    TheCitiesAndRoadsDivTwo citiesObject = new TheCitiesAndRoadsDivTwo();
    String[] map = {"NYNN",
            "YNNN",
            "NNNY",
            "NNYN"};

    System.out.println(citiesObject.find(map));

    String[] map2 = {"NNY",
            "NNN",
            "YNN"};

    System.out.println(citiesObject.find(map2));

    String[] map3 = {"NY",
            "YN"};

    System.out.println(citiesObject.find(map3));

    String[] map4 = {"NN",
            "NN"};

    System.out.println(citiesObject.find(map4));
  }
}
