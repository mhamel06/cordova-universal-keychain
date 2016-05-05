var exec = require("cordova/exec"),
    channel = require("cordova/channel");



channel.onCordovaReady.subscribe(function(){
    exec(win, null, 'Plugin', 'method', []);
    function win(message){
        console.log(message);
    }
});
var UniversalKeychain = function(){

};

module.exports = new UniversalKeychain();