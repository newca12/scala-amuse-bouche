val tvShows = Map((1966, "Star Trek"), (1969, "Monty Python's Flying Circus"), (1989, "The Simpsons"))

def showForYear(y: Int) = tvShows.get(y)

def showWithName(n: String) = tvShows collectFirst { case (a, b) if (b.contains(n)) ⇒ b }

def favoriteShow(s: String) = s match {
  case "Amy" ⇒ Some("Batman")
  case "Bob" ⇒ Some("Iron Chef")
  case _     ⇒ None
}

case class Person(name: String, year: Int)

val amy = Person(name = "Amy", year = 1971)
val cam = Person(name = "Cam", year = 1989)
val deb = Person(name = "Deb", year = 1967)
val monty = Person(name = "Monty", year = 1973)

def picShow(p: Person) = favoriteShow(p.name).orElse(showWithName(p.name).orElse(showForYear(p.year)))
