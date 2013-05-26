$(document).ready(function () {

  var Socket = window['MozWebSocket'] ? MozWebSocket : WebSocket
  var url = $('body').data('url')
  var connection = new Socket(url)

  window.onmousemove = function (event) {
    var x = event.clientX
    var y = event.clientY
    connection.send(x + "," + y)
  }

});
