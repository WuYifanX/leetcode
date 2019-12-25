# Leetcode

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

# Solution

1. 使用set集合来做.
2. 使用找规律来做 如果是非happy的数字, 那么一定会出现如果不是快乐数 最终会出现4 16 37 58 89 145 42 20循环
3. 判断有没有环的方式: 快慢指针.

