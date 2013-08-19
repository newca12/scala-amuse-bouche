abstract class Maybe[+T]
case class Just[T](e :T) extends Maybe[T]
case object Nothing extends Maybe

def pickMessage[T](e: Maybe[T]) = e match {
  case _:Nothing.type => "Pick any number you like."
  case Just(n) => s"Pick a number, like ${n}."
}

def findAfterStar(s: String) :Maybe[Char] = s.toList match {
  case c :: d :: r => if (c == '*') Just(d)
  		      else findAfterStar((d :: r).mkString)
  case d :: Nil => Nothing
}

def findAfterChar(m:Char, s: String) :Maybe[Char] = s.toList match {
  case c :: d :: r => if (c == m) Just(d)
		      else findAfterStar((d :: r).mkString)
  case d :: Nil => Nothing
}

def findAfterElement[A <% Comparable[A]](m:A, s:List[A]) :Maybe[A] = s match {
  case c :: d :: r => if (c == m) Just(d)
		      else findAfterElement(m, d :: r)
  case d :: Nil => Nothing
}
