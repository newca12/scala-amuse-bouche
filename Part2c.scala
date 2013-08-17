val empty = Nil
val oneWord = "apple" :: Nil
val twoWords = "banana" :: "cantaloupe" :: Nil

val mystery1 = "pear" :: empty
val mystery2 = "peach" :: oneWord
lazy val mystery3 :List[String] = "pineapple" :: mystery3
val mystery4 = 42 :: "apple" :: Nil //This is OK with Scala :-)

def dropOne[T](l: List[T]) = l match {
  case Nil => Nil
  case _ :: rest => rest
}   

def justOne[T](l: List[T]) = l match {
  case Nil => Nil
  case first :: _ => first :: Nil
}
