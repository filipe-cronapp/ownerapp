window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.AuthAPI = window.blockly.js.blockly.AuthAPI || {};

/**
 * authAPI
 */
window.blockly.js.blockly.AuthAPI.Executar = function() {
 var item, url_api, auth_user;
  this.cronapi.screen.showLoading();
  auth_user = String('https://my-api-strapi.herokuapp.com/auth/local');
  this.cronapi.util.getURLFromOthers('POST', 'application/x-www-form-urlencoded', auth_user, this.cronapi.object.createObjectFromString(['{ \"identifier\": \"',this.cronapi.screen.getValueOfField("User.active.login"),'\" , \"password\": \"',this.cronapi.screen.getValueOfField("User.active.password"),'\" } '].join('')), null, function(sender_item) {
      item = sender_item;
  }.bind(this), function(sender_item) {
      item = sender_item;
  }.bind(this));
  console.log(auth_user);
}
