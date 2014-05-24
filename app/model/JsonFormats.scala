package model

import model.session.Session

/**
 * @author progoth
 *
 */
object JsonFormats {
    import play.api.libs.json.Json
    import play.modules.reactivemongo.json.BSONFormats._

    implicit val sessionFormat = Json.format[Session]
}
