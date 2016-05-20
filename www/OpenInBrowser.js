function OpenInBrowser() {

}

OpenInBrowser.prototype.showQQBrowser = function (options, successCallback, errorCallback) {
  options.url = options.url.toString();
  cordova.exec(successCallback, errorCallback, "OpenInBrowser", "showQQBrowser", [options]);
};

OpenInBrowser.prototype.showUCBrowser = function (options, successCallback, errorCallback) {
  options.url = options.url.toString();
  cordova.exec(successCallback, errorCallback, "OpenInBrowser", "showUCBrowser", [options]);
};

OpenInBrowser.install = function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.openinbrowser = new OpenInBrowser();
  return window.plugins.openinbrowser;
};

cordova.addConstructor(OpenInBrowser.install);