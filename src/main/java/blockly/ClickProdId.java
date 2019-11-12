package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity
public class ClickProdId {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// clickProd_ID
public static Var prod_id() throws Exception {
 return new Callable<Var>() {

   private Var url = Var.VAR_NULL;
   private Var id_pro_del = Var.VAR_NULL;
   private Var url_id = Var.VAR_NULL;
   private Var clicked_prod = Var.VAR_NULL;

   public Var call() throws Exception {
    url = Var.valueOf("https://my-api-strapi.herokuapp.com/produtos");
    id_pro_del = Var.valueOf("2");
    url_id = Var.valueOf(url.toString() + id_pro_del.toString());
    clicked_prod = cronapi.util.Operations.getHeadersFromExternalURL(Var.valueOf("GET"), Var.valueOf("application/x-www-form-urlencoded"), url_id, Var.VAR_NULL, Var.VAR_NULL);
    System.out.println(clicked_prod.getObjectAsString());
    return Var.VAR_NULL;
   }
 }.call();
}

}

