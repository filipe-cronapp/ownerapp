window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ObterProdutos = window.blockly.js.blockly.ObterProdutos || {};

/**
 * obterPessoas
 */
window.blockly.js.blockly.ObterProdutos.obter = function() {
 var item;
  this.cronapi.util.callServerBlocklyAsynchronous('blockly.Apiget:apiget', function(sender_item) {
      item = sender_item;
    this.cronapi.screen.changeValueOfField("listadeprodutos", item);
  }.bind(this));
  console.log('obtendo produtos da API');
}
