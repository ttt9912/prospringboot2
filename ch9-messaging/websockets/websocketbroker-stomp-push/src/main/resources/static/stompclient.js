$(function () {
    var stompClient = null;
    var socket = new SockJS('http://localhost:8080/greetings');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greeting', function (data) {
            console.log('>>>>> ' + data);
            var result = "<span>" + data.body + "</span><br/>";
            $("#output").append(result);
        });
    });
});