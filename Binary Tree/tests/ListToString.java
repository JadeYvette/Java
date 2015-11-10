package tests;

import java.util.List;
import java.util.Iterator;

public class ListToString {

  // converts a list to a string
  public static <T> String listToString(List<T> list) {
    Iterator<T> iter= list.iterator();
    String s= "";

    while (iter.hasNext()) {
      s += iter.next();
      if (iter.hasNext())
        s += " ";
    }

    return s;
  }

}
