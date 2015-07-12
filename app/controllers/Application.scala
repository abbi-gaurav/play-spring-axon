package controllers

import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype
import play.api.mvc._

@stereotype.Controller
class Application @Autowired()(commandGateway:CommandGateway) extends Controller {


  def index = Action {
    println(commandGateway.getClass.getName)
    Ok(views.html.index("Your new application is ready."))
  }

  def createItem: Action[AnyContent] = Action{ implicit request:Request[AnyContent] =>
    ???
  }

}