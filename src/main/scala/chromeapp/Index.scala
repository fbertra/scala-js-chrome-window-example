package chromeapp

import scala.scalajs.js

import org.scalajs.chrome.Chrome._

import org.scalajs.jquery._

object Index {
  def format (din : js.Any) : String = {
    if (din.isInstanceOf [js.Undefined]) {
      "indefinido"
    } else {
      din.toString 
    }
  }
  
  def refresh (mensaje : String): js.Undefined = {
    jQuery ("#_metodo").html ("Scala / FFI")
      
    jQuery ("#_mensaje").html (mensaje)
    
    val window = chrome.app.window.current ()
    
    val bounds = window.getBounds ()
    
    jQuery ("#_windowId").html (format (window.id))
    
    jQuery ("#_isFullscreen").html (format (window.isFullscreen ()))
    jQuery ("#_isMinimized").html (format (window.isMinimized ())) 
    jQuery ("#_isMaximized").html (format (window.isMaximized ()))
    jQuery ("#_isAlwaysOnTop").html (format (window.isAlwaysOnTop ()))
    
    //
    jQuery ("#_left").html (format (bounds.left)) 
    jQuery ("#_top").html (format (bounds.top)) 
    jQuery ("#_width").html (format (bounds.width)) 
    jQuery ("#_height").html (format (bounds.height)) 
    
    //
    
    jQuery ("#_getMinWidth").html (format (window.getMinWidth ())) 
    jQuery ("#_getMinHeight").html (format (window.getMinHeight ())) 
    jQuery ("#_getMaxWidth").html (format (window.getMaxWidth ())) 
    jQuery ("#_getMaxHeight").html (format (window.getMaxHeight ()))
    
    ()
  }
  
  def init () : Unit = {
    refresh ("init") 
    
    val window = chrome.app.window.current ()
    
    window.onBoundsChanged.addListener (() => refresh ("onBoundsChanged"))
    window.onMaximized.addListener (() => refresh ("onMaximized"))
    window.onMinimized.addListener (() => refresh ("onMinimized"))
    window.onRestored.addListener (() => refresh ("onRestored"))
  }
  
  
}
