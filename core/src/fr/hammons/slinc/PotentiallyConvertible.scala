package fr.hammons.slinc

trait PotentiallyConvertible[A, B]:
  def to(a: A): Option[B]

object PotentiallyConvertible:
  extension [A](a: A)
    def maybeAs[B](using pc: PotentiallyConvertible[A,B]) = pc.to(a)
  given PotentiallyConvertible[Long, Int] with 
    def to(a: Long): Option[Int] =
      if a <= Int.MaxValue && a >= Int.MinValue then 
        Some(a.toInt)
      else 
        None

  given PotentiallyConvertible[Long, Long] with 
    def to(a: Long): Option[Long] = Some(a)

  given PotentiallyConvertible[Int, Int] with 
    def to(a: Int): Option[Int] = Some(a)