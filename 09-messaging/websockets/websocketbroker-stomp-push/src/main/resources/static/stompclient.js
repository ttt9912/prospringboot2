$(function () {
    sockJS = new SockJS('http://localhost:8080/greetings');
    stomp = Stomp.over(sockJS);

    stomp.connect({}, function (frame) {
        console.log('Connected: ' + frame);

        stomp.subscribe('/topic/greeting', function (data) {
            console.log('>>>>> ' + data);
            var result = "<span>" + data.body + "</span><br/>";
            $("#output").append(result);
        });

        sockJS.onheartbeat = function (hearbeat) {
            console.log('SockJS Heartbeat');
            console.log(hearbeat);
        };
    });
});