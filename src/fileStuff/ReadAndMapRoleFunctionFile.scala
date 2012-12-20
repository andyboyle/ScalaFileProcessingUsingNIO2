package fileStuff

object ReadAndMapRoleFunctionFile {

  def retrieveMapOfRolesToFunction(filepathAsString: String): Map[String, List[String]] = {
    val fileLines = FileUtils.convertFileToList(filepathAsString)
    buildRolesToFunctionMap(fileLines)
  }

  private def buildRolesToFunctionMap(fileLines: List[String]): Map[String, List[String]] = {
    (fileLines map {
      line =>
        val key = line.split("=")(0)
        val value = (line.split("=")(1)).split(" ,").toList
        (key, value)
    }).toMap
  }

}
