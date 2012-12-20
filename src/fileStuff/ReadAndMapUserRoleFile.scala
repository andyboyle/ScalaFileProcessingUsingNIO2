package fileStuff

object ReadAndMapUserRoleFile {

  def retrieveMapOfUserToRole(filepathAsString: String) : Map[String,String] = {
    val fileLines = FileUtils.convertFileToList(filepathAsString)
    buildUserToRoleMap(fileLines)
  }

  private def buildUserToRoleMap(fileLines: List[String]): Map[String,String] = {
    (fileLines map {
      line =>
        (line.split("=")(0) ,  line.split("=")(1) )
    }).toMap
  }
}
