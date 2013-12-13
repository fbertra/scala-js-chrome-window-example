function mainJS () {
  var params = new Object () ;
  params.id = "main" 
  
  chrome.app.window.create ("index-dev.html", params) ;
}

function mainScala () {
  ScalaJS.modules.chromeapp_Main().main();
}

mainScala () ;
// mainJS () ;


