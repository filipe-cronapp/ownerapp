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
    produto = cronapi.util.Operations.getURLFromOthers(Var.valueOf("POST"), Var.valueOf("application/x-www-form-urlencoded"), url, Var.VAR_NULL, Var.VAR_NULL, cronapi.map.Operations.createObjectMapWith(Var.valueOf("nome",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.nome_prdo"))) , Var.valueOf("sabor",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.sabor_prod"))) , Var.valueOf("preco",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.preco_prod"))) , Var.valueOf("quantidade",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.quant_prod")))));
    cronapi.util.Operations.sleep(Var.valueOf(2));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.nome_prdo"), Var.VAR_NULL);
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.sabor_prod"), Var.VAR_NULL);
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.preco_prod"), Var.valueOf("0"));
    cronapi.util.Operations.callClientFunction(Var.valueOf("cronapi.screen.changeValueOfField"), Var.valueOf("vars.quant_prod"), Var.VAR_NULL);
    return Var.VAR_NULL;
   }
 }.call();
}

/**
 *
 * @return Var
 */
// Descreva esta função...
public static Var del() throws Exception {
 return new Callable<Var>() {

   private Var url = Var.VAR_NULL;
   private Var delprod = Var.VAR_NULL;

   public Var call() throws Exception {
    url = Var.valueOf(Var.valueOf("https://my-api-strapi.herokuapp.com/produtos/").toString());
    delprod = cronapi.util.Operations.getHeadersFromExternalURL(Var.valueOf("DELETE"), Var.valueOf("application/x-www-form-urlencoded"), url, Var.VAR_NULL, cronapi.map.Operations.createObjectMapWith(Var.valueOf("nome",cronapi.screen.Operations.getValueOfField(Var.valueOf("vars.testeEntra")))));
    return Var.VAR_NULL;
   }
 }.call();
}

}

