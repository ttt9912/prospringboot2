$(function () {
    sockJS = new SockJS('http://localhost:8080/greetings');
    stomp = Stomp.over(sockJS);

    stomp.connect({}, function (frame) {
        console.log('Connected: ' + frame);
    });
});