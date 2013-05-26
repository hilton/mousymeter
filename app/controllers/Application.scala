package controllers

import play.api._
import play.api.mvc._
import play.api.libs.iteratee.{Enumerator, Iteratee}

object Application extends Controller {

  def index = Action { implicit request =>
    Ok(views.html.index())
  }

  /**
   * Minimal web socket action that uses an iteratee to log input, and empty output.
   */
  def log = WebSocket.using[String] { implicit request =>
    val input = Iteratee.foreach[String] { data =>
      Logger.debug(data)
    }
    val output = Enumerator("")
    (input, output)
  }

}