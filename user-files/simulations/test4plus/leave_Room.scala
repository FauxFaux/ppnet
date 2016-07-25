package test4plus
import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import Trait._

object Leave_Room2 extends Trait{
	val feeder=csv("login.csv").random
		val leave_room2=exec(feed(feeder))
		.exec(http("Rooms infos")
			.options("/_matrix/client/r0/rooms/${table}%3Amatrix.allmende.io/leave?access_token=${token}")
			.headers(headers_11)
			.resources(http("Acces room")
			.post("/_matrix/client/r0/rooms/${table}%3Amatrix.allmende.io/leave?access_token=${token}")
			.headers(headers_12)
			.body(RawFileBody("leaveRoomVector_0048_request.txt"))
			.check(status.is(200)),
            http("upload image")
			.get("http://" + uri1 + ":8081/img/upload.svg")
			.headers(headers_40)
			.check(status.is(304)),
            http("call image")
			.get("http://" + uri1 + ":8081/img/call.svg")
			.headers(headers_42)
			.check(status.is(304)),
            http("search image")
			.get("http://" + uri1 + ":8081/img/search.svg")
			.headers(headers_29)
			.check(status.is(304)),
            http("voice image")
			.get("http://" + uri1 + ":8081/img/voice.svg")
			.headers(headers_43)
			.check(status.is(304)),
            http("setting image")
			.get("http://" + uri1 + ":8081/img/settings.svg")
			.headers(headers_27)
			.check(status.is(304)),
            http("leave image")
			.get("http://" + uri1 + ":8081/img/leave.svg")
			.headers(headers_41)
			.check(status.is(304)),
            http("Rooms access")
			.get("/_matrix/client/r0/rooms/${table}%3Amatrix.allmende.io/messages?from=s9146_3412_0_77_1_2&limit=20&dir=b&access_token=${token}")
			.headers(headers_14)
			.check(status.is(200)),
            http("Room access")
			.get("/_matrix/client/r0/rooms/${table}%3Amatrix.allmende.io/messages?from=t1-3102_3412_0_77_1_2&limit=20&dir=b&access_token=${token}")
			.headers(headers_14)
			.check(status.is(200)))
			.check(status.is(200)))
			.exec(session =>{
				println("session :"+session)
				session
			})
	
}
