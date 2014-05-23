package model

import reactivemongo.bson.{BSONDocumentWriter, BSONDocument, BSONDocumentReader, BSONObjectID}

/**
 * @author steven
 *
 */
case class Settings(id: BSONObjectID, appName: String)

object Settings {
    implicit object SettingsReader extends BSONDocumentReader[Settings] {
        def read(doc: BSONDocument): Settings = {
            val id = doc.getAs[BSONObjectID]("_id").get
            val appName = doc.getAs[String]("appName").get
            Settings(id, appName)
        }
    }

    implicit object SettingsWriter extends BSONDocumentWriter[Settings] {
        override def write(t: Settings): BSONDocument = {
            BSONDocument("_id" → t.id, "appName" → t.appName)
        }
    }
}
