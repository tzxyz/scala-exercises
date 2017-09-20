package org.zhuonima.scala.exercises.cats

import org.scalatest._

class _05ApplicativeSpec extends FlatSpec with Matchers {

  import cats._
  import cats.implicits._

  "Applicative Pure Specs" should "have some tests" in {
    Applicative[Option].pure(1) should be(Some(1))
    Applicative[List].pure(1) should be(List(1))
    Applicative[List].pure(None) should be(List(None))
  }

  "Applicative Compose Specs" should "have some tests" in {
    (Applicative[List] compose Applicative[Option]).pure(1) should be(List(Some(1)))
  }

  "Applicative & Monad Specs" should "have some tests" in {
    Monad[Option].pure(1) should be(Some(1))
    Applicative[Option].pure(1) should be(Some(1))
  }

}
