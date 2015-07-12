package controllers

import commands.{CreateTodoItemCommand, MarkCompletedCommand}
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, AnyContent, Controller, Request}

/**
 * Created by gabbi on 12/07/15.
 */
@stereotype.Controller
class TodoItemController @Autowired()(commandGateway: CommandGateway) extends Controller {

  val todoItemForm: Form[CreateTodoItemCommand] = Form {
    mapping(
      "id" -> text,
      "desc" -> text
    )(CreateTodoItemCommand.apply)(CreateTodoItemCommand.unapply)
  }

  def addTodoItem: Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val createTodoItemCommand: CreateTodoItemCommand = todoItemForm.bindFromRequest.get
    println(commandGateway.toString)
    commandGateway.send(createTodoItemCommand)
    Ok("created new")
  }

  def markComplete(id: String): Action[AnyContent] = Action {
    println(commandGateway.toString)
    val markCompletedCommand: MarkCompletedCommand = MarkCompletedCommand(id)
    println(s"complete item $markCompletedCommand")
    commandGateway.send(markCompletedCommand)
    Ok("marked completed")
  }
}
