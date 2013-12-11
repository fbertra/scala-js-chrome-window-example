package chromeapp

import scala.scalajs.js

import org.scalajs.chrome._
import org.scalajs.chrome.Chrome._
import org.scalajs.chrome.app.runtime._
import org.scalajs.chrome.app.window._

object Main {
  def launch (data : LaunchData) : js.Undefined = {
    /*
    val bound = new Bounds 
    
    bound.top = 10
    bound.left = 20
    bound.width = 1000
    bound.height = 400
    */
      
    val params = new CreateParams ("main")
    // params.id = 

    /*    
    val params = js.Dynamic.newInstance (js.Dynamic.global.js.Object) () 
    
    params.updateDynamic ("id") ("main")
    params.updateDynamic ("minWidth") (200.0)
    params.updateDynamic ("minHeight") (100.0)
    */
      
    chrome.app.window.create ("index-dev.html", params)
    
    ()
  }
  
  def main(): Unit = {
    chrome.app.runtime.onLaunched.addListener (launch _)
    
    ()
  }
}
