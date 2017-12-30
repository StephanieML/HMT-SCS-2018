// Scala script to load CEX data, and define a function
// creating views of scholia for a given Iliad passage.
//
// Usage: at the sbt console, after loading this script,
//
//      scholia(URN)
//
//  where URN is a CTS URN identifying a line of the Iliad.

val texts = "data/sample/va1-iliad-mains.cex"
val commentsIndex = "data/sample/scholiaToIliad-1.cex"
val dseCex =  "data/sample/va1-dse.cex"

import edu.holycross.shot.ohco2._
import edu.holycross.shot.citerelation._
import edu.holycross.shot.cite._
import edu.holycross.shot.cex._
import scala.io.Source


case class IllustratedPassage(psg: CtsUrn, img: Cite2Urn)
println("\n\nLoading data:  please be patient...")
val commentsCex = Source.fromFile(commentsIndex).getLines.mkString("\n")
val relationSet = CiteRelationSet(commentsCex)
val textRepo = TextRepositorySource.fromCexFile(texts)
val dse = CexParserSource.fromFile("data/sample/va1-dse.cex")

val stringValues = dse.blockString("citedata").split("\n").drop(1).map(_.split("#"))
val illustratedPassages = stringValues.map(a => IllustratedPassage(  CtsUrn(a(1)), Cite2Urn(a(3)) )).toVector

println("\n\nDone loading data.\n\n")


/** Find set of Urns commenting on a particular passage
*
* @param u The Iliad passage to look for.
* @param relationSet Relations of scholia commenting on Iliad passages.
*/
def scholiaForPassage(u: CtsUrn, relationSet: CiteRelationSet = relationSet ) : Vector[CtsUrn] = {
  val triples = relationSet.relations.filter(_.urn2 ~~ u)
  println(s"${triples.size} matching scholia.")
  val urnVector = triples.map(_.urn1).toVector
  val optVector = urnVector.map( u => {
    u match {
      case cts: CtsUrn => Some(cts)
      case _ => None
    }
  })
  optVector.flatten
}


// Get text contents of a CtsUrn
def citedText(u: CtsUrn, texts : TextRepository = textRepo): String = {
  val citedNodes = texts.corpus.nodes.filter(_.urn ~~ u)
  citedNodes.size match {
    case 0 => "(text not on line)"
    case _ =>  citedNodes.map(_.text).mkString(" ")
  }
}


def documentaryImage(u: CtsUrn, imgMap : Vector[IllustratedPassage]  = illustratedPassages): Option[Cite2Urn] = {
  val imgs = illustratedPassages.filter(_.psg ~~ u)
  imgs.size match {
    case 1 => Some(imgs(0).img)
    case _ => None
  }
}



/**  Write a markdown report on scholia commenting on a given line.
*
* @param psg Passage of Iliad to report on.
*/
def scholia(psg: String): Unit = {
  try {
    val psgUrn = CtsUrn(psg)
    val label = "Iliad " + psgUrn.passageComponent
    val fileName =  "views/iliad-" + psgUrn.passageComponent + "-scholia.md"

    val scholiaVector = scholiaForPassage(psgUrn)
    for (s <- scholiaVector) {
      //println("scholia: " + scholiaVector.map(s => citedText(s)))
      println("On Iliad " + psgUrn.passageComponent + ", scholion " + s.passageComponent + ": "+ citedText(s))
      println("Image: " + documentaryImage(s))
    }


    println("Report on " + label + " written in " + fileName)
  } catch {
    case badurn: java.lang.IllegalArgumentException => println("Failed to make URN from string " + psg + ".\n" + badurn)
    case t: Throwable => println("Failed... " + t)
  }

}

println("\n\nGive an Iliad URN to the `scholia` function to view scholia on that passage.")
println("Example:")
println("\tscholia" + """("urn:cts:greekLit:tlg0012.tlg001:1.1")""" + "\n\n")
