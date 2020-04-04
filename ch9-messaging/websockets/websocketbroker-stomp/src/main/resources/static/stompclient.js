$(function(){
    var stompClient = null;
    var socket = new SockJS('http://localhost:8080/stomp');
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function (frame) { console.log('Connected: ' + frame);
        stompClient.subscribe('/todo/new', function (data) { console.log('>>>>> ' + data);
            var json = JSON.parse(data.body);
            var result = "<span><strong>[" + json.created + "]</ strong>&nbsp" + json.description + "</span><br/>";
            $("#output").append(result);
        });
    });
});