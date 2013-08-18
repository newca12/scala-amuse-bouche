import java.util.GregorianCalendar
import java.util.Calendar._

def firstOne[T](l: List[T]) = l match {
  case a :: _ => a
  case Nil => sys.error("O Noes!")
} //normally called head

def firstOne_[T](l: List[T]) = l match {
  case a :: _ => Some(a)
  case Nil => None
}

def addWeek(date: GregorianCalendar) = {
  val trick = new GregorianCalendar
  trick.setTime(date.getTime)
  trick.add(DAY_OF_YEAR, 7)
  trick.getTime
}

val interestingDates = new GregorianCalendar(1966, 9, 8) :: new GregorianCalendar(1969, 6, 21) :: new GregorianCalendar(1969, 10, 29) :: Nil

def anInterestingDate = firstOne_( interestingDates)

//def aWeekLater =  anInterestingDate.flatMap(addWeek(_)) //Short syntax won't compile
def aWeekLater = anInterestingDate match {
  case Some(x) => addWeek(x)
  case None => None
}

//def maybeAddWeek_(date: Option[GregorianCalendar]) = date.flatMap(addWeek(_)) //Short syntax won't compile
def maybeAddWeek(date: Option[GregorianCalendar]) = date match {
  case Some(x) => addWeek(x)
  case None => None
}

def aWeekLater_  = maybeAddWeek(anInterestingDate)
