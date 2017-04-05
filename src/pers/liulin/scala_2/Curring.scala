package pers.liulin.scala_2

/**
  * Created by liulin on 17-3-29.
  */
object Curring {
  def curry[A,B,C](f:(A,B) => C) : A => (B => C) = {
    (a: A) => (b: B) => f(a,b)
  }
}
