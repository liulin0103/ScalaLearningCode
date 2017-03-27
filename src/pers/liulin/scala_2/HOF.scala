package pers.liulin.scala_2

/**
  * Created by LiuLin on 2017/3/26 0026.
  */
object HOF {
  def factorial(n: Int): Int = {
    /**
      * 一个内部函数，或局部定义函数，在Scala中把一个函数定义在另一个函数体内很常见。
      * 在函数式编程中，我们不应该认为它跟一个局部整数或局部字符串有什么不同。
      */
    @annotation.tailrec
    def go(n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n - 1, n * acc)
    }

    go(n, 1)
  }

  def fib(n: Int): Int = {
    @annotation.tailrec
    def fib_1(n: Int, acc1: Int, acc2: Int): Int = {
      if (n == 0) acc1
      else fib_1(n - 1, acc2, acc1 + acc2)
    }

    fib_1(n, 0, 1)
  }

  def abs(n: Int): Int = {
    if (n < 0) -n
    else n
  }

  private def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def formatFactorial(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  private def formatFib(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

  def formatResult(name: String, n: Int, f: Int => Int) = { //f必须是一个接收Int，返回Int的函数
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }

  def main(args: Array[String]): Unit = {
    println(formatResult("abs",-42,abs))
    println(formatResult("factorial",5,factorial))
    println(formatResult("fib",5,fib))
  }
}
