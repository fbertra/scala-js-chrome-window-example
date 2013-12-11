function format (obj) {
  if (typeof obj === 'undefined') {
    return ('indefinido') ;
  }
  else if (obj == null) {
    return ('mulo') ;
  }	  
  else {
    return (' ' + obj) ;
  }
}

function refresh (mensaje) { 
  jQuery ("#_metodo").html ("javascript / jquery") ;
  
  jQuery ("#_mensaje").html (mensaje) ;
  
  var window = chrome.app.window.current () ;
  var bounds = window.getBounds () ;
  
  jQuery ("#_isFullscreen").html (format (window.isFullscreen ())) ;
  jQuery ("#_isMinimized").html (format (window.isMinimized ())) ;
  jQuery ("#_isMaximized").html (format (window.isMaximized ())) ;
  jQuery ("#_isAlwaysOnTop").html (format (window.isAlwaysOnTop ())) ;
    
  //
  jQuery ("#_left").html (format (bounds.left)) ; 
  jQuery ("#_top").html (format (bounds.top)) ;
  jQuery ("#_width").html (format (bounds.width)) ;
  jQuery ("#_height").html (format (bounds.height)) ;
    
  //
    
  jQuery ("#_getMinWidth").html (format (window.getMinWidth ())) ;
  jQuery ("#_getMinHeight").html (format (window.getMinHeight ())) ; 
  jQuery ("#_getMaxWidth").html (format (window.getMaxWidth ())) ;
  jQuery ("#_getMaxHeight").html (format (window.getMaxHeight ())) ; 
}

function initJS () {
  refresh ("init") ;
  
  var window = chrome.app.window.current () ;
  window.onBoundsChanged.addListener (function () {refresh ("onBoundsChanged")}) ;
  window.onMaximized.addListener (function () {refresh ("onMaximized")}) ;
  window.onMinimized.addListener (function () {refresh ("onMinimized")}) ;
  window.onRestored.addListener (function () {refresh ("onRestored")}) ;
}

function initScala () {
  ScalaJS.modules.chromeapp_Index().init();
}

jQuery (document).ready (initScala) ;
