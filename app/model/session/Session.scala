package model.session

import reactivemongo.bson.BSONObjectID

/**
 * @author progoth
 *
 */
case class Session(googleId: String, id: BSONObjectID = BSONObjectID.generate)
