// Scala script to load CEX data, and define a function
// creating a simple facsimile view of a manuscript's pages.
//
// Usage:  facsimile(URN) where URN is a CITE2 URN identifying a manuscript.
val facsimileMap =  Map("msA" -> "data/release/vapages.cex")
val defaultImageIndex = "data/release/tbsToImage.cex"

import edu.holycross.shot.cite._
import edu.holycross.shot.cex._
import scala.io.Source
import java.io.PrintWriter
import java.io.File

case class LabelledPage(u: Cite2Urn, label: String)
case class IllustratedPage(page: Cite2Urn, defaultImage: Cite2Urn)

println("\n\nLoading data:  please be patient...")
val idxLines = Source.fromFile(defaultImageIndex).getLines.toVector.drop(1)
val defaultImages = idxLines.map(s => {val cols = s.split("#"); IllustratedPage( Cite2Urn(cols(0)), Cite2Urn(cols(2))  )  })
println("\n\nDone loading data.\n\n")



def imgLinkForPage(u: Cite2Urn, defaultImageIndex: Vector[IllustratedPage] =  defaultImages) : String = {
  val imgs = defaultImageIndex.filter(_.page ~~ u)
  "Found " + imgs.size + " imgs for " + u


  val base = "http://www.homermultitext.org/iipsrv?OBJ=IIP,1.0&FIF=/project/homer/pyramidal/deepzoom/"
  val width = 600
  val ict2 = "http://www.homermultitext.org/ict2?urn="

  imgs.size  match {
    case 1 => {
      val img = imgs(0).defaultImage
      val binary = s"${base}${img.namespace}/${img.collection}/${img.version}/${img.dropExtensions.objectOption.get}.tif&" + s"WID=${width}&CVT=JPEG"


      s"![${img}](${binary})"
      //s"<${binary}>"
    }
    case _ => s"Found ${imgs.size} images for ${u}"
  }

}

// Create simple facsimile view for a codex identified by URN
def writeFacsimile(u: Cite2Urn): Unit = {
  println("Writing facsimile for " + u + "...")

//  val modelText = Source.fromFile(facsimileMap(u.collection)).getLines.mkString("\n")

  val modelCex = CexParserSource.fromFile(facsimileMap(u.collection))
  val stringValues = modelCex.blockString("citedata").split("\n").drop(1).map(_.split("#").toVector)
  val pages = stringValues.map(ar => LabelledPage( Cite2Urn(ar(1)), ar(3) ))


  val tableBody = for  (i <- 0 until pages.size) yield {
    val columnWidth = 5

    val pg = pages(i)
    (i % columnWidth) match {
      case 4 =>  s"| ${imgLinkForPage(pg.u)}<br/>" + pg.label + " |\n"
      case _ => s"| ${imgLinkForPage(pg.u )}<br/>" + pg.label
    }
  }


  val tableHeader = "| 1     | 2     | 3 | 4 | 5|\n| :------------- | :------------- | :------------- |:------------- |:------------- |\n"

  val label = "# Codex " + u + "\n\n"
  val content = s"${label}${tableHeader}${tableBody.mkString("")}"
  val fileName =  "views/facsimile-" + u.collection + ".md"
  new PrintWriter(new File(fileName)) {write (content); close}
  println("Facsimile view written to " + fileName)
}

def facsimile(codex: String): Unit = {
  try {
    val urn = Cite2Urn(codex)
    writeFacsimile(urn)


  } catch {
    case badurn: java.lang.IllegalArgumentException => println("Failed to make URN from string " + codex + ".\n" + badurn)
    case t: Throwable => println("Failed... " + t)
  }
}

println("\n\nGive one of the following URNs for a codex to the `facsimile` function to create an illustrated view of the facsimile:\n")
for (siglum <- facsimileMap.keySet) {
  println("\turn:cite2:hmt:" + siglum + ":")
}
println("\nExample:")
println("\tfacsimile" + """("urn:cite2:hmt:msA:")""" + "\n\n")
