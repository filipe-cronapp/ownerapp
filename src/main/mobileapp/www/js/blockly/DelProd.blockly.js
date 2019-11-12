window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.DelProd = window.blockly.js.blockly.DelProd || {};

/**
 * DelProd
 */
window.blockly.js.blockly.DelProd.delete2 = function() {
 var item;
  this.cronapi.util.getURLFromOthers('GET', 'application/x-www-form-urlencoded', 'https://my-api-strapi.herokuapp.com/produtos', null, null, function(sender_item) {
      item = sender_item;
  }.bind(this), function(sender_item) {
      item = sender_item;
  }.bind(this));
}
