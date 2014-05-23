package controllers

import play.api._
import play.api.libs.concurrent.Akka
import play.api.mvc._
import reactivemongo.api.{MongoDriver, MongoConnection}
import reactivemongo.api.collections.default.BSONCollection
import play.api.Play.current
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.util.{Success, Failure}

object Application extends Controller {
    lazy val mongoDriver = new MongoDriver(Akka.system)

    lazy val mongoDb = {
        val connstr = sys.env getOrElse ("MONGOHQ_URL", sys.error("MONGOHQ_URL not set"))

        MongoConnection.parseURI(connstr) match {
            case Failure(t) ⇒ sys.error(s"$connstr invalid: $t")
            case Success(u) ⇒ mongoDriver connection u db u.db.get
        }
    }

    def index = Action.async {
        mongoDb.collectionNames map (cn ⇒ {
            Ok(views.html.index(s"ReactiveMongo collections: $cn"))
        })
    }

}
