package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Bloco09 {

public static final int TIMEOUT = 300;

/**
 *
 * @param Dados
 * @return Var
 */
// Bloco09
public static Var Executar(Var Dados) throws Exception {
 return new Callable<Var>() {

   private Var item = Var.VAR_NULL;

   public Var call() throws Exception {
    item = cronapi.util.Operations.getURLFromOthers(Var.valueOf("GET"), Var.valueOf("application/json"), Var.valueOf("https://my-api-strapi.herokuapp.com/produtos"), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL);
    return item;
   }
 }.call();
}

}

