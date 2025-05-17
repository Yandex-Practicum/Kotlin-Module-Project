package dataBase.repository

import dataBase.DataBaseSingleton
import model.Archive

class ArchiveRepositoryImpl: AbstractCRUDRepository<Archive>(DataBaseSingleton.archives), ArchiveRepository