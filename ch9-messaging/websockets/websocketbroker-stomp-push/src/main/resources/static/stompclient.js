// var stomp = null;

function connect() {
    sockJS = new SockJS('http://localhost:8080/chat');
    stomp = Stomp.over(sockJS);

    stomp.connect({}, function (frame) {
        console.log('frame');
        console.log(frame);
        stomp.subscribe("/topic", function (message) {
            console.log("Message");
            console.log(message);
            showMessage(message.body)
        })
    });


    /*
    refreshStatus();

    sockJS.onerror = function (error) {
        console.log('WebSocket Error ' + error);
    };

    sockJS.onheartbeat = function (hearbeat) {
        console.log('Heartbeat');
        console.log(hearbeat);
    };

    sockJS.onmessage = function (messageEvent) {
        console.log('Websocket MessageEvent');
        console.log(messageEvent);
        showMessage(messageEvent.data);
    };
     */
}

function disconnect() {
    console.log('closing sockJS');
    // sockJS.close();
    // refreshStatus();
}

function refreshStatus() {
    console.log('sockJS connection');
    // console.log(sockJS);
    // $('#status').html(sockJS.readyState);
}

function sendMessage() {
    var text = $('#text').val();
    // sockJS.send(text);
}

function showMessage(messageBody) {
    const message = '<div>' + messageBody + '</div>';
    $('#response').append(message);
}