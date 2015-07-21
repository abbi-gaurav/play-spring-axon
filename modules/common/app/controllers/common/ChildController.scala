package controllers.common

import play.api.mvc._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.beans.factory.annotation.Autowired

@stereotype.Controller
class ChildController @Autowired()(commandGateway:CommandGateway)extends Controller{
      def testCommon = Action{
      	  println(commandGateway.toString)
      	  Ok("hi from test")
      }
}