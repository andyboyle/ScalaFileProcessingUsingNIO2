package fileStuff

object Bootstrap {
  val ROLE_TO_FUNCTION_FILE = "c:/programming/programScratch/roleFunctionsMapping.txt"
  val USER_TO_ROLE_FILE = "c:/programming/programScratch/userRoleMapping.txt"
  val OUTPUT_FILE = "c:/programming/programScratch/userFunctionMapping_Output.txt"

  def main ( args: Array[String]) {
    val rolesToFunction = ReadAndMapRoleFunctionFile.retrieveMapOfRolesToFunction(ROLE_TO_FUNCTION_FILE)
    val userToRole = ReadAndMapUserRoleFile.retrieveMapOfUserToRole(USER_TO_ROLE_FILE)

    val userToFunctions = MapUtil.mapUserToFunctions(userToRole, rolesToFunction)

    val printableRoleToFunctions = createPrintableFormatOfUserToFunctions(userToFunctions)
    FileUtils.printToFile(printableRoleToFunctions,OUTPUT_FILE)
  }

  private def createPrintableFormatOfUserToFunctions(rolesToFunctions: Map[String, List[String]]): String = {
    val header = "\n\n" + """|The Mapping of Roles To Functions
                  |=================================""".stripMargin + "\n"

    val body = ( for (pair <- rolesToFunctions )
      yield ( "Role: " + pair._1 + "\t\tFunctions: " + pair._2.mkString + "\n")
    ).mkString

    header + body
  }
}
