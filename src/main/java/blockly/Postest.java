package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Postest {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// postest
public static Var postesteeer() throws Exception {
 return new Callable<Var>() {

   private Var url = Var.VAR_NULL;
   private Var produto = Var.VAR_NULL;

   public Var call() throws Exception {
    url = Var.valueOf(Var.valueOf("https://my-api-strapi.herokuapp.com/produtos/").toString());
    produto = cronapi.util.Operations.getURLFromOthers(Var.valueOf("POST"), Var.valueOf("application/x-www-form-urlencoded"), url, Var.VAR_NULL, Var.VAR_NULL, cronapi.map.Operations.createObjectMapWith(Var.valueOf("nome",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.testeEntra")))));
    cronapi.util.Operations.callClientFunction( Var.valueOf("cronapi.screen.notify"), Var.valueOf("success"), produto);
    return Var.VAR_NULL;
   }
 }.call();
}

}

