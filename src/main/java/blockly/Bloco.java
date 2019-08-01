package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Bloco {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// Bloco
public static Var Executar() throws Exception {
 return new Callable<Var>() {

   private Var objetoJson = Var.VAR_NULL;
   private Var url = Var.VAR_NULL;

   public Var call() throws Exception {
    if (cronapi.logic.Operations.isNullOrEmpty(objetoJson).getObjectAsBoolean()) {
        url = Var.valueOf(Var.valueOf("https://my-api-strapi.herokuapp.com/produtos").toString());
        objetoJson = cronapi.json.Operations.toJson(cronapi.util.Operations.getURLFromOthers(Var.valueOf("GET"), Var.valueOf("application/json"), url, Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL));
    }
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("Produto.active.categoria_nome"), cronapi.json.Operations.getJsonOrMapField(objetoJson, Var.valueOf("[0].nome")));
    return Var.VAR_NULL;
   }
 }.call();
}

}

