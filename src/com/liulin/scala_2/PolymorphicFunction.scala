package com.liulin.scala_2

/**
  * Created by liulin on 17-3-27.
  */
object PolymorphicFunction {
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
