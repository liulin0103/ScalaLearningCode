package pers.liulin.scala_2

/**
  * Created by LiuLin on 2017/3/26 0026.
  * LiuLin's first  scala program. ╮(╯3╰)╭
  */

/** object 关键字
  *  object 关键字创建一个新的单例类型，就像一个class只有一个被命名的实例。
  *  就像Java中创建了一个匿名类的实例。
  */

object MyModule { // 声明一个单例对象，即同时声明一个类，和它的唯一实例。
  def abs(n: Int): Int = { // abs方法接受一个integer并返回一个integer。
    if (n < 0) -n //如果小于0，返回-n
    else n
  }

  private def formatAbs(x: Int) = { //一个私有方法只能被MyModule里的其他成员调用。
    val msg = "The absolute value of %d is %d"  //字符串里有两个占位符，%d代表数字。
    msg.format(x,abs(x))  //在字符串里将2个%d 占位符分别替换为x和abs(x)。
  }

  def main(args: Array[String]): Unit = {   //Unit类似于Java或C语言里的void
    println(formatAbs(-42))
  }
}

/**
  * Unit 类型
  * Unit 与C或Java中的void类似.在scala中只要没有引起程序奔溃或挂住,每个方法都会有返回值.
  * 但是main方法的返回值没有任何意义.它是一个特殊的类型Unit,该类型只有唯一的值,写作().
  * 通常返回Unit类型的方法暗示它包含副作用。
  */
