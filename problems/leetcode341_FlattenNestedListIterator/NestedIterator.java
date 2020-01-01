package leetcode341_FlattenNestedListIterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 * // This is the interface that allows for creating nested lists. // You should not implement it,
 * or speculate about its implementation
 *
 * <p>public interface NestedInteger {
 *
 * <p>// @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 *
 * <p>// @return the single integer that this NestedInteger holds, if it holds a single integer,
 * Return null if this NestedInteger holds a nested list public Integer getInteger();
 *
 * <p>// @return the nested list that this NestedInteger holds, if it holds a nested list // Return
 * null if this NestedInteger holds a single integer public List<NestedInteger> getList(); }
 */
public class NestedIterator implements Iterator<Integer> {

  Queue<Integer> queue = new ArrayDeque<>();

  public NestedIterator(List<NestedInteger> nestedList) {
    dfs(nestedList);
  }

  private void dfs(List<NestedInteger> nestedList) {
    for (NestedInteger iterator : nestedList) {
      if (iterator.isInteger()) {
        queue.add(iterator.getInteger());
      } else {
        dfs(iterator.getList());
      }
    }
  }

  @Override
  public Integer next() {
    return queue.poll();
  }

  @Override
  public boolean hasNext() {
    return !queue.isEmpty();
  }
}

/**
 * Your NestedIterator object will be instantiated and called as such: NestedIterator i = new
 * NestedIterator(nestedList); while (i.hasNext()) v[f()] = i.next();
 */
