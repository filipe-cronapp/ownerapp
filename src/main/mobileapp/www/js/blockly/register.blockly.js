window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Register = window.blockly.js.blockly.Register || {};

/**
 * register
 */
window.blockly.js.blockly.Register.Executar = function() {
 var item, identifier;
  identifier = this.cronapi.screen.getScopeVariable('identifier');
  this.cronapi.util.getURLFromOthers('POST', 'application/x-www-form-urlencoded', 'https://my-api-strapi.herokuapp.com/auth/local', null, this.cronapi.json.createObjectFromString(identifier), function(sender_item) {
      item = sender_item;
  }.bind(this), function(sender_item) {
      item = sender_item;
  }.bind(this));
  console.log('abc');
}
