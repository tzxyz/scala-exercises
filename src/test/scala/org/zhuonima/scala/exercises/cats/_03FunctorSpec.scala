package org.zhuonima.scala.exercises.cats

import org.scalatest.{FlatSpec, Matchers}

class _03FunctorSpec extends FlatSpec with Matchers {

  import cats._
  import cats.implicits._

  "Functor fproduct" should "have somes tests" in {

    val source = List("Cats", "is", "awesome")

    val product = Functor[List].fproduct(source)(_.length).toMap

    product.getOrElse("Cats", 0)    should be (4)
    product.getOrElse("is", 0)      should be (2)
    product.getOrElse("awesome", 0) should be (7)
  }

  "Functor compose" should "have some tests" in {

    val lstOps = Functor[List] compose Functor[Option]

    lstOps.map(List(Some(1), None, Some(3)))(_ + 1) should be (List(Some(2), None, Some(4)))

  }
}
