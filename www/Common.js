var exec = require('cordova/exec');

exports.getVersionNumber = function(arg0, success, error) {
    exec(success, error, "Common", "getVersionNumber", [arg0]);
};
