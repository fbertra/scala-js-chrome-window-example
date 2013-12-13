package chromeapp

import scala.scalajs.js
import scala.scalajs.js.JSON

import js.Dynamic.global

import org.scalajs.chrome._
import org.scalajs.chrome.Chrome._
import org.scalajs.chrome.app.runtime._
import org.scalajs.chrome.app.window._

object Main {
  def launch (data : LaunchData) : js.Undefined = {
    val params = js.Object ().asInstanceOf [CreateParams]
    params.id = "main2" 
    params.minWidth = 1000
    params.minHeight = 400    
    params.bounds = js.Object ().asInstanceOf  [Bounds]
    params.bounds.left = 10
    params.bounds.top = 20
    
    global.console.log(JSON.stringify(params))

    chrome.app.window.create ("index-dev.html", params)
    
    ()
  }
  
  def main(): Unit = {
    chrome.app.runtime.onLaunched.addListener (launch _)
    
    ()
  }
}
