package fileStuff

import java.nio.file.{Files, Path}
import java.io.File
import java.nio.charset.Charset
import scala.collection.JavaConversions._

object FileUtils {

  def printToFile(stringToBePrinted: String, outputFile: String) {
    val outputFilePath = convertStringToPath(outputFile)
    val writer = Files.newBufferedWriter(outputFilePath, Charset.defaultCharset())
    writer.write(stringToBePrinted)
    writer.flush()
  }

  def convertFileToList(file: String): List[String] = {
    convertFileToList(convertStringToPath(file))
  }

  def convertFileToList(path: Path): List[String] = {
    val javaListOfLines = Files.readAllLines(path, Charset.defaultCharset())
    javaListOfLines.toList
  }

  private def convertStringToPath(file: String): Path = {
    (new File(file)).toPath
  }


}
