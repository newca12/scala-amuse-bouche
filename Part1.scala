/* To explore this file :

Run scala from the shell:
	Welcome to Scala version 2.10.2 (Java HotSpot(TM) 64-Bit Server VM, Java 1.7.0_25).
	Type in expressions to have them evaluated.
	Type :help for more information.

	scala>

Load up this file:
	scala> :load Part1.scala
	Loading Part1.scala...
	import scala.io.Source
	...
	...
	scala>

Try stuff:
	scala> 2 + 2
	res1: Int = 4

	scala> println(poem)
	occasional clouds
	one gets a rest
	from moon-viewing

	scala> main
	from moon-viewing
	occasional clouds
	one gets a rest
*/
import scala.io.Source

val poem = Source.fromFile("poem").mkString

def lines(s: String) = Source.fromString(s).getLines.toList
val unlines: List[String] ⇒ String = _.mkString("\n")
def sort(l: List[String]) = l.sorted

def process(s: String) = (unlines compose sort compose lines)(s)

def main = println(process(poem))

// show the poem in REPL with:
//	scala> print(poem)

def reverse(l: List[String]) = l.reverse
def firstTwo(l: List[String]) = l.take(2)
def sortLines(s: String) = (unlines compose sort compose lines)(s)
def reverseLines(s: String) = (unlines compose reverse compose lines)(s)
def firstTwoLines(s: String) = (unlines compose firstTwo compose lines)(s)

//try applying to the poem in REPL:
//	scala> println(sortLines(poem))
//	scala> println(reverseLines(poem))

def byLines(f: (List[String]) ⇒ List[String]) = unlines compose f compose lines

def sortLines_ = byLines(sort)
def reverseLines_ = byLines(reverse)
def firstTwoLines_ = byLines(firstTwo)

def indent(s: String) = "    " + s

// This is commented out, because it won't compile:
//	def indentLines = byLines(indent)

def map(f: String ⇒ String)(l: List[String]) = l map f

def indentEachLine(s: String) = byLines(map(indent))(s)

def eachLine(f: String ⇒ String) = unlines compose map(f) compose lines

def indentEachLine_ = eachLine(indent)

def yell(s: String) = s.toUpperCase() + "!!!"

def yellEachLine = eachLine(yell)

def words(s: String) = s.split(" ").toList
val unwords: List[String] ⇒ String = _.mkString(" ")

def eachWord(f: String ⇒ String) = unwords compose map(f) compose words

def yellEachWord = eachWord(yell)

def eachWordOnEachLine(f: String ⇒ String) = eachLine(eachWord(f))

def yellEachWordOnEachLine = eachWordOnEachLine(yell)
