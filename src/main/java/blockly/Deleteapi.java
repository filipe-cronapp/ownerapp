package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Deleteapi {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// deleteapi
public static Var del() throws Exception {
 return new Callable<Var>() {

   private Var urlAuthAPI = Var.VAR_NULL;
   private Var delprod = Var.VAR_NULL;

   public Var call() throws Exception {
    urlAuthAPI = Var.valueOf(Var.valueOf("https://my-api-strapi.herokuapp.com/produtos/").toString());
    delprod = cronapi.util.Operations.getHeadersFromExternalURL(Var.valueOf("DELETE"), Var.valueOf("application/x-www-form-urlencoded"), urlAuthAPI, Var.VAR_NULL, cronapi.map.Operations.createObjectMapWith(Var.valueOf("nome",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.testeEntra")))));
    return Var.VAR_NULL;
   }
 }.call();
}

}

