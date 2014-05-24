import akka.actor.{Actor, Props, ActorRef}
import play.api._
import play.api.libs.concurrent.Akka

/**
 * @author progoth
 *
 */
object Global extends GlobalSettings {

    var sessionActor: ActorRef = _

    override def onStart(app: Application): Unit = {
        super.onStart(app)

        sessionActor = Akka.system(app).actorOf(Props[Actor](new Actor {
            def receive = {
                case _ ⇒
            }
        }))
    }
}
