var xhr = function (url) {
    return new Promise(function (resolve, reject) {
        var xmhr = new XMLHttpRequest();

        //Listen for API Response
        xmhr.onreadystatechange = function () {
            if (xmhr.readyState === XMLHttpRequest.DONE && xmhr.status === 200)
                return resolve(xmhr.responseText);
        };

        xmhr.open("GET", url, true);
        xmhr.send();
    });
};