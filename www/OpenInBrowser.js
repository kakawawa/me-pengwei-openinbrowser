
function OpenInBrowser() {
	
}

OpenInBrowser.prototype.showWithOptions = function (options, successCallback, errorCallback) {
  options.url = options.url.toString();
  options.show = options.show.toString();
  cordova.exec(successCallback, errorCallback, "OpenInBrowser", options.show, [options]);
};

OpenInBrowser.install = function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.openinbrowser = new OpenInBrowser();
  return window.plugins.openinbrowser;
};

cordova.addConstructor(OpenInBrowser.install);
