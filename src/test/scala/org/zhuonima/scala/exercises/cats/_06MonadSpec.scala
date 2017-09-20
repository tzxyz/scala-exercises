package org.zhuonima.scala.exercises.cats

import org.scalatest._

class _06MonadSpec extends FlatSpec with Matchers {

  import cats._
  import cats.implicits._

  "Monad Flatten Specs" should "have some tests" in {
    Option(Option(1)).flatten should be(Option(1))
    Option(None).flatten should be(None)
    List(List(1), List(2, 3)).flatten should be(List(1, 2, 3))
  }

  "Monad FlatMap Specs" should "have some tests" in {
    Monad[List].flatMap(List(1, 2, 3))(x => List(x, x)) should be(List(1, 1, 2, 2, 3, 3))
  }

  "Monad IfM Specs" should "have some tests" in {
    Monad[Option].ifM(Option(true))(Option("true"), Option("false")) should be(Some("true"))
    Monad[List].ifM(List(true, false, true))(List(1, 2), List(3, 4)) should be(List(1, 2, 3, 4, 1, 2))
  }

  "Monad Composition Specs" should "have some tests" in {
    import language.higherKinds
    case class OptionT[F[_], A](value: F[Option[A]])

    // TODO
//    implicit def optionTMonad[F[_]](implicit F: Monad[F]) = {
//      new Monad[OptionT[F, ?]] {
//        def pure[A](a: A): OptionT[F, A] = OptionT(F.pure(Some(a)))
//        def flatMap[A, B](fa: OptionT[F, A])(f: A => OptionT[F, B]): OptionT[F, B] = OptionT {
//          F.flatMap(fa.value) {
//            case None => F.pure(None)
//            case Some(a) => f(a).value
//          }
//        }
//        def tailRecM[A, B](a: A)(f: A => OptionT[F, Either[A, B]]): OptionT[F, B] =
//          tailRecM(a)(f)
//      }
//    }
//    optionTMonad[List].pure(42) should be(OptionT(List(Some(42))))

  }
}
