# Leetcode

Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:

```
^
|
|        o
|     o
|  o  
+------------->

```
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:

```
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->

```
0  1  2  3  4  5  6
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.




# Solution

1. 遍历每一个节点, 然后把每个节点的斜率放到map里面, hash算法是可以用"y,x"
2. 但是如果考虑斜率就需要考虑几种特殊情况.
  a. 水平
  b. 垂直
  c. 重叠
3. 对于斜率的计算, 因为是小数, 那么需要考虑精度的问题. 或者说, 使用约分的思想, 比如说 1/2 == 10/20. 
只要我们把两个都化简成为不可约分的小数, 那么也就是可以写成1/2, 也就是斜率变成"1/2"这种形式.然后就可以比较和存在hash表了.
也就是说, 我们需要找到分子和分母的公约数, 除以他们的最大公约数, 然后化简即可.


```java


```
