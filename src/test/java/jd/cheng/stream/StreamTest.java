package jd.cheng.stream;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class StreamTest {

  @Test
  public void test() throws Exception {
    List<Integer> l1 = new ArrayList<>();
    l1.add(1);
    l1.add(2);

    List<Integer> l2 = new ArrayList<>();
    l2.add(3);
    l2.add(4);
    l2.add(5);

    List<List<Integer>> list = new ArrayList<>();
    list.add(l1);
    list.add(l2);

    List<Integer> result = list.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
    assertThat(result).containsExactly(1,2,3,4,5);
  }
}
