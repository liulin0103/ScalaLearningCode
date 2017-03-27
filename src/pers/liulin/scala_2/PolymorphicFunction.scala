package pers.liulin.scala_2

/**
  * Created by LiuLin on 2017/3/26 0026.
  */
object PolymorphicFunction {
  def findFirst_1(ss: Array[String], key: String): Int = {
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= ss.length) -1 //如果到了数组的结尾，返回-1，表示这个key在数组里不存在。
      else if (ss(n) == key) n //ss(n) 抽取数组里的第n个元素。如果第n个元素等于 key 返回 n
      else loop(n + 1) // 否则，传入n+1，继续查找
    }
    loop(0) //从数组的第一个元素开始启动loop
  }

  /**
    * 这段代码的细节不是关注的重点，重要的是不管是从Array[String]中查找一个String，还是从Array[Int]中查找一个Int，
    * 他们看起来几乎都是相同的。我们可以写一个更加泛化的适用任何类型的findFirst函数，它接收一个函数参数，用来对A进行判定。
    */

  def findFirst_2[A](ss: Array[A], p: A => Boolean): Int = {  // 用类型A做参数替换掉String类型的硬编码，
                                                              // 并且用一个对数组里每个元素进行测试的函数替换掉之前用于判断元素
                                                              // 是否与给定key相等的硬编码。
    @annotation.tailrec
    def loop(n: Int): Int = {
      if (n >= ss.length) -1
      else if (p(ss(n))) n    // 如果函数p匹配当前元素，就找到了相匹配的元素，返回数组当前索引值。
      else loop(n + 1)
    }
    loop(0)
  }

  def isSorted[A](as: Array[A], orderd: (A, A) => Boolean): Boolean = {
    def go(n: Int): Boolean = {
      if (n >= as.length - 1) true
      else if (orderd(as(n), as(n + 1))) false
      else go(n + 1)
    }

    go(0)
  }

  def orderInt(prev: Int, next: Int): Boolean = {
    if (prev >= next) true
    else false
  }

  def orderString(prev: String, next: String): Boolean = {
    if (prev >= next) true
    else false
  }

  def main(args: Array[String]): Unit = {
    val a1 = Array(1, 2, 3, 4, 5, 6, 7)
    val a2 = Array(1, 2, 3, 5, 4, 6, 7)
    val a3 = Array("A", "B", "C", "D", "E")
    val a4 = Array("A", "B", "D", "C", "E")

    println(isSorted[Int](a1, orderInt))
    println(isSorted[Int](a2, orderInt))
    println(isSorted[String](a3, orderString))
    println(isSorted[String](a4, orderString))
  }
}