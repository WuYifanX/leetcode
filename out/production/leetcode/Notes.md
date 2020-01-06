# Notes


### 如何给string设计hash.

需要考虑这个问题是因为, 在做字符串匹配的过程做, 经常会需要把字符串映射到一个独一无二的数上.

思路:

1. 给字符串排序, 因为排序之后, 必定是独一无二的. "abc", "bca"排序之后都是"abc". 
2. 如果字符的范围不大, 比如说只有小写字母, 可以考虑首先用一个int[26]来计算每个字符出现的次数. 然后再通过一定形式的编码.
比如说 "aabbbcz" 可以编码成为"#2#3#1#0....#1".然后在把这个26位的字符串存入hashmap. 因为hashmap已经做了很好的冲突处理机制, 不太需要独立去处理冲突.
3. 还可以通过质数的方式来编码:int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103}.
可以通过代码生成质数. 然后通过累乘的方式得到hash. 但是需要考虑的问题有int越界的问题和hash碰撞的问题. 所以其实最好还是使用方法2.

```
  int key = 1;
  //累乘得到 key
  for (int j = 0; j < strs[i].length(); j++) {
      key *= prime[strs[i].charAt(j) - 'a'];
  } 
```

```java

class FindPrime{
  
  public List<Integer> FindPrimeBetween(int range){
    List<Integer> list = new ArrayList<>();
    if(range < 2) return false;
    list.add(2);
    for (int i = 3; i < range ; i++) {
      if(isPrime(i)) list.add(i);
    }
  }
  public boolean isPrime(int n)
  
  {
  
  if(n < 2) return false;
  
  if(n == 2) return true;
  
  if(n%2==0) return false;
  
  for(int i = 3; i < n; i += 2)
  
  if(n%i == 0) return false;
  
  return true;
  
  }
}

```                  
