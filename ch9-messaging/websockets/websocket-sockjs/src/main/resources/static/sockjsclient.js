var sockJS;

function connect() {
    sockJS = new SockJS('http://localhost:8080/echo');

    refreshStatus();

    sockJS.onerror = function (error) {
        console.log('WebSocket Error ' + error);
    };

    sockJS.onmessage = function (messageEvent) {
        console.log('Websocket MessageEvent');
        console.log(messageEvent);
        showMessage(messageEvent.data);
    };
}

function disconnect() {
    console.log('closing sockJS');
    sockJS.close();
    refreshStatus();
}

function refreshStatus() {
    console.log(sockJS);
    $('#status').html(sockJS.readyState);
}

function sendMessage() {
    var text = $('#text').val();
    sockJS.send(text);
}

function showMessage(messageBody) {
    const message = '<div>' + messageBody + '</div>';
    $('#response').append(message);
}