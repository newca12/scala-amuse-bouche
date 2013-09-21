abstract class List[+T]
case object EndOfList extends List
case class Link[T](first: T, rest: List[T]) extends List[T]

val empty = EndOfList
val oneWord = Link("apple", EndOfList)
val twoWords = Link("banana", (Link("cantaloupe", EndOfList)))

val mystery1 = Link("pear", empty)
val mystery2 = Link("peach", oneWord)
lazy val mystery3: List[String] = Link("pineapple", mystery3)
val mystery4 = Link(42, (Link("apple", EndOfList))) //this is OK with Scala :-)

def dropOne[T](l: List[T]) = l match {
  case _: EndOfList.type ⇒ l
  case Link(_, rest)     ⇒ rest
}

def justOne[T](l: List[T]) = l match {
  case _: EndOfList.type ⇒ l
  case Link(first, _)    ⇒ Link(first, EndOfList)
}
