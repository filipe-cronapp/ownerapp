window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.AuthAPI = window.blockly.js.blockly.AuthAPI || {};

/**
 * authAPI
 */
window.blockly.js.blockly.AuthAPI.Executar = function() {
 var item, auth_user, url_api;
  url_api = String('https://my-api-strapi.herokuapp.com/users');
  auth_user = null;
  this.cronapi.util.getURLFromOthers('POST', 'application/x-www-form-urlencoded', url_api, null, [String('username') + String(this.cronapi.screen.getValueOfField("User.active.login")), String('Password') + String(this.cronapi.screen.getValueOfField("User.active.password"))], function(sender_item) {
      item = sender_item;
    console.log(item);
  }.bind(this), function(sender_item) {
      item = sender_item;
  }.bind(this));
}
