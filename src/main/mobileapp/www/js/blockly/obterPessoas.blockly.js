window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ObterPessoas = window.blockly.js.blockly.ObterPessoas || {};

/**
 * obterPessoas
 */
window.blockly.js.blockly.ObterPessoas.obter = function() {
 var item;
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Apiget:apiget', function(sender_item) {
      item = sender_item;
    this.cronapi.screen.changeValueOfField("listapessoas", item);
  }.bind(this));
}
