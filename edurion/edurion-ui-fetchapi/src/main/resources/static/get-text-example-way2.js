// The Endpoint URL
let url = 'https://jsonplaceholder.typicode.com/posts/1';
function doGetJSON()  {
    fetch(url).then(function(response) {
      // Parse the body as JSON
      console.log('response:  ' + response);
      return response.json();
    }).then(function(json) {
      console.log('json: ' + json);
    })
}
