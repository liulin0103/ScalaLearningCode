package pers.liulin.scala._3_functional_data_structure

/**
  * Created by liulin on 17-4-5.
  */
sealed trait List[+A] {

  // List 是一个泛型的数据类型.类型参数用A表示.
  // trait 是一种可以包含一些具体方法(可选)的抽象接口.这里我们定义了一个没有任何方法的List特质.
  // sealed 关键字意味着这个特质的所有实现都必须定义在这个文件里.

  case object Nil extends List[Nothing]   // List有两种实现,或者说构造器(由case关键字引入),表示List有两种可能的形式.

  // 用于表现空 List 的 List 数据构造器.

  case class Cons[+A](head: A, tail: List[A]) extends List[A]  // 一个非空List由初始元素head和后续紧跟的也是List的结构(可能为空)的tail组成.

  // 另一个数据构造器,呈现非空List.注意尾部是另一个List[A],当然这个尾部也可能为Nil或另一个Cons.

  object List {
    // List伴生对象.包含创建List和对List操作的一些函数.
    def sum(ints: List[Int]): Int = ints match {
      // 利用模式匹配对一个整形数List进行合计.
      case Nil => 0 // 空列表的累加值为0
      case Cons(x, xs) => x + sum(xs) // 对一个头部是x的列表进行累加,这个过程是用x加上该列表剩余部分的累加值.
    }

    def product(ds: List[Double]): Double = ds match {
      case Nil => 1.0
      case Cons(0.0, _) => 0.0
      case Cons(x, xs) => x * product(xs)
    }

    def apply[A](as: A*) : List[A] = {    // 可变参数(可以是一个或多个该类型的参数)语法.
      if (as.isEmpty) Nil
      else Cons(as.head,apply(as.tail:_*))
    }
  }
}
