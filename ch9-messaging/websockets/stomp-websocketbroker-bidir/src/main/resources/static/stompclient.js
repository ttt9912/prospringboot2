var stompClient = null;

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility
        = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}

function connect() {
    var socket = new SockJS('http://localhost:8080/stomp');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/messages', function (websocketMessage) {
            showMessage(JSON.parse(websocketMessage.body));
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    var from = $('#from').val();
    var text = $('#text').val();

    stompClient.send("/app/new-message", {},
        JSON.stringify({'from': from, 'content': text}));
}

function showMessage(messageBody) {
    const node = document.createTextNode(
        messageBody.from + ": " + messageBody.content
        + " (" + messageBody.createdAt + ")");

    $('#response').append(node);
}