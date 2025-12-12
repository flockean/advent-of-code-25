
package helpers

object ReadUtil {

  def readLines(sourceFile: String): List[String] = {
    scala.io.Source.fromFile(sourceFile).getLines().toList
  }

  def readLine(sourceFile: String): List[String] = {
    scala.io.Source.fromFile(sourceFile).getLines().toList
  }

}

