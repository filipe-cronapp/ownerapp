window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ObterPessoas = window.blockly.js.blockly.ObterPessoas || {};

/**
 * obterPessoas
 */
window.blockly.js.blockly.ObterPessoas.obter = function() {
 var item, listaPessoas;
  listaPessoas = this.cronapi.object.createObjectFromString('{}');
  this.cronapi.util.callServerBlocklyAsynchronous('', function(sender_item) {
      item = sender_item;
    this.cronapi.object.setProperty(listaPessoas, 'listapessoas', item);
  }.bind(this));
}
