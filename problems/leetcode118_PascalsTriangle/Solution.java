package leetcode118_PascalsTriangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>();
    if (numRows == 0) return res;
    if (numRows == 1) {
      List<Integer> ele = new ArrayList<>();
      ele.add(1);
      res.add(ele);
      return res;
    }

    // numRows >=2;
    for (int i = 0; i < numRows; i++) {
      List<Integer> ele = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          ele.add(1);
        } else {
          ele.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
        }
      }
      res.add(ele);
    }

    return res;
  }
}
