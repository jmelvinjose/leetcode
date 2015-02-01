import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by melvinj on 1/31/15.
 */
public class NumberToRomanNumeral {

  static Map<Integer, String> map;
  static List<Integer> numbers;

  public static String numberToRomanNumeral(int num) {
    map = new HashMap<Integer, String>();
    numbers = new ArrayList<Integer>();
    map.put(1, "I");
    map.put(4, "IV");
    map.put(5, "V");
    map.put(9, "IX");
    map.put(10, "X");
    map.put(40, "XL");
    map.put(50, "L");
    map.put(90, "XC");
    map.put(100, "C");
    map.put(400, "CD");
    map.put(500, "D");
    map.put(900, "CM");
    map.put(1000, "M");
    numbers.add(1000);
    numbers.add(900);
    numbers.add(500);
    numbers.add(400);
    numbers.add(100);
    numbers.add(90);
    numbers.add(50);
    numbers.add(40);
    numbers.add(10);
    numbers.add(9);
    numbers.add(5);
    numbers.add(4);
    numbers.add(1);
    String res = "";
    int remainder = 0;
    while (num > 0) {
      int smallest = 0;
      for (Integer number : numbers) {
        if (number <= num) {
          smallest = number;
          break;
        }
      }
      res += map.get(smallest);
      num = num - smallest;
    }
    return res;
  }

  public static void main(String args[]) {
    String res = numberToRomanNumeral(3);
    System.out.println(res);
    System.out.println(numberToRomanNumeral(3));
    System.out.println(numberToRomanNumeral(8));
    System.out.println(numberToRomanNumeral(3999));
  }
}
