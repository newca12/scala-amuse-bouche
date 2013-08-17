abstract class List[+T]
case object EndOfList extends List
case class Link[T](val first :T, val rest: List[T] ) extends List[T]

val empty = EndOfList
val oneWord = Link("apple",EndOfList)
val twoWords = Link("banana",(Link("cantaloupe",EndOfList)))

val mystery1 = Link("pear",empty)
val mystery2 = Link("peach",oneWord)
val mystery4 = Link( 42, (Link("apple", EndOfList))) //this is OK with Scala :-)

def dropOne[T](l :List[T]) = l match {
	case _:EndOfList.type => l
	case _ => l.asInstanceOf[Link[T]].rest
}

def justOne[T](l :List[T]) = l match {
	case _:EndOfList.type => l
	case _ => Link(l.asInstanceOf[Link[T]].first, EndOfList)
}
