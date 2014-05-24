package controllers

import play.api._
import play.api.libs.concurrent.Akka
import play.api.mvc._
import reactivemongo.api.{MongoDriver, MongoConnection}
import reactivemongo.api.collections.default.BSONCollection
import play.api.Play.current
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.util.{Success, Failure}
import play.modules.reactivemongo.MongoController
import scala.concurrent.Future
import java.util.UUID

object Application extends Controller with MongoController {
    lazy val googClientId = sys.env getOrElse ("GOOGLE_CLIENT_ID", sys.error("GOOGLE_CLIENT_ID not set"))

    def index = Action.async { request ⇒

        db.collectionNames map (cn ⇒ {
            Ok(views.html.index(s"ReactiveMongo collections: $cn"))
        })
    }

    def login = Action.async (implicit request ⇒ {
        val csrfToken = UUID.randomUUID().toString

        Future successful (Ok(views.html.login(googClientId, csrfToken)) withSession ("csrfToken" → csrfToken))
    })
}
