package fileStuff

//import collection.mutable

object MapUtil {
  def mapUserToFunctions
  (userToRole: Map[String, String], roleToFunctions: Map[String, List[String]]): Map[String, List[String]] = {
    val user2func = (for (userRolePair <- userToRole)
    yield (userRolePair._1, roleToFunctions(userRolePair._2))
      ).toMap

    user2func
  }

}
