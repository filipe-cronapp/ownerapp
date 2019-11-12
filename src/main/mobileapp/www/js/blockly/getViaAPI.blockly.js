window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.GetViaAPI = window.blockly.js.blockly.GetViaAPI || {};

/**
 * getViaAPI
 */
window.blockly.js.blockly.GetViaAPI.Executar = function() {
 var item, lista, api_nome, price_prod, id_prod, i;
  this.cronapi.util.getURLFromOthers('GET', 'application/json', 'https://my-api-strapi.herokuapp.com/produtos', null, null, function(sender_lista) {
      lista = sender_lista;
    this.cronapi.screen.changeValueOfField("cardClient", lista);
  }.bind(this), function(sender_item) {
      item = sender_item;
  }.bind(this));
}
