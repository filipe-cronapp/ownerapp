package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
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
   private Var listas = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;

   public Var call() throws Exception {
    objetoJson = cronapi.util.Operations.getURLFromOthers(Var.valueOf("GET"), Var.valueOf("application/json"), Var.valueOf("https://my-api-strapi.herokuapp.com/produtos"), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL);
    listas = cronapi.json.Operations.toList(objetoJson);
    for (Iterator it_i = listas.iterator(); it_i.hasNext();) {
        i = Var.valueOf(it_i.next());
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.Nome"), cronapi.object.Operations.getObjectField(i, Var.valueOf("nome")));
    } // end for
    return Var.VAR_NULL;
   }
 }.call();
}

}

