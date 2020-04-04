var connection;

function connect() {
    connection = new WebSocket('ws://localhost:8080/echo');

    refreshStatus();

    connection.onerror = function (error) {
        console.log('WebSocket Error ' + error);
    };

    connection.onmessage = function (messageEvent) {
        console.log('Websocket MessageEvent');
        console.log(messageEvent);
        showMessage(messageEvent.data);
    };
}

function disconnect() {
    console.log('closing connection');
    connection.close();
    refreshStatus();
}

function refreshStatus() {
    console.log(connection);
    $('#status').html(connection.readyState);
}

function sendMessage() {
    var text = $('#text').val();
    connection.send(text);
}

function showMessage(messageBody) {
    const message = '<div>' + messageBody + '</div>';
    $('#response').append(message);
}