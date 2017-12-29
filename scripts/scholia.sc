// Scala script to load CEX data, and define a function
// creating views of scholia for a given Iliad passage.
//
// Usage:  scholia(URN) where URN is a CTS URN identifying a line
// of the Iliad.

val texts = "data/sample/va1-texts.cex"
val commentsIndex = "data/sample/scholiaToIliad-1.cex"


import edu.holycross.shot.dse._
import edu.holycross.shot.ohco2._
import edu.holycross.shot.citerelation._
import edu.holycross.shot.citeobj._


import scala.io.Source

println("\n\nLoading data:  please be patient...")
val commentsCex = Source.fromFile(commentsIndex).getLines.mkString("\n")
val relationSet = CiteRelationSet(commentsCex)

println("\n\nDone loading data.\n\n")
