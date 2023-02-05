interface InterfaceArchive {

   fun create(titleArchive: String, strNote:String)
   fun removeArchive(titleArchive: String)
   fun replaceArchive(archiveKey: String, newNote: String)
   fun clearArchive()
   fun printAllArchive()

}
