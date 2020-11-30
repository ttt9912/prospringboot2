function connect() {
    sockJS = new SockJS('http://localhost:8080/chat');
    stomp = Stomp.over(sockJS);

    stomp.connect({}, function (frame) {
        refreshStatus();

        // subscribe to /topic/chat
        stomp.subscribe("/topic/msg", function (message) {
            console.log("Message");
            console.log(message);
            showMessage(JSON.parse(message.body))
        });

        // SockJS auto heartbeat
        sockJS.onheartbeat = function (hearbeat) {
            console.log('SockJS Heartbeat');
            console.log(hearbeat);
        };
    });
}

function disconnect() {
    console.log('closing sockJS');
    sockJS.close();
    refreshStatus();
}

function refreshStatus() {
    console.log('sockJS connection');
    console.log(sockJS);
    $('#status').html(sockJS.readyState);
}

function sendMessage() {
    const chatmessage = JSON.stringify({
        'from': $('#from').val(),
        'text': $('#text').val()
    });

    stomp.send("/app/msg", {}, chatmessage);
}

function showMessage(messageBody) {
    const message = '<div>' + messageBody.from + ': ' + messageBody.text + '</div>';
    $('#response').append(message);
}