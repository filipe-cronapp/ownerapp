package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.Iterator;
import java.util.concurrent.Callable;


@CronapiMetaData(type = "blockly")
@CronappSecurity
public class Apiget {

public static final int TIMEOUT = 300;

/**
 *
 * @return Var
 */
// apiget
public static Var apiget() throws Exception {
 return new Callable<Var>() {

   private Var lista = Var.VAR_NULL;
   private Var i = Var.VAR_NULL;
   private Var id_prod = Var.VAR_NULL;
   private Var nome = Var.VAR_NULL;
   private Var tipo = Var.VAR_NULL;

   public Var call() throws Exception {
    lista = cronapi.json.Operations.toList(cronapi.util.Operations.getURLFromOthers(Var.valueOf("GET"), Var.valueOf("application/json"), Var.valueOf("https://my-api-strapi.herokuapp.com/produtos"), Var.VAR_NULL, Var.VAR_NULL, Var.VAR_NULL));
    for (Iterator it_i = lista.iterator(); it_i.hasNext();) {
        i = Var.valueOf(it_i.next());
        id_prod = cronapi.object.Operations.getObjectField(i, Var.valueOf("id"));
        nome = cronapi.object.Operations.getObjectField(i, Var.valueOf("nome"));
        tipo = cronapi.object.Operations.getObjectField(i, Var.valueOf("tipo"));
        cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.Nome"), nome);
        System.out.println(nome.getObjectAsString());
        System.out.println(tipo.getObjectAsString());
    } // end for
    return lista;
   }
 }.call();
}

}

