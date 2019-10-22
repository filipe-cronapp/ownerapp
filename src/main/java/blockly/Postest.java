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

   private Var getProd = Var.VAR_NULL;
   private Var urlAuthAPI = Var.VAR_NULL;
   private Var authAPI = Var.VAR_NULL;
   private Var item = Var.VAR_NULL;
   private Var header_token = Var.VAR_NULL;
   private Var newprod = Var.VAR_NULL;

   public Var call() throws Exception {
    getProd = Var.valueOf(Var.valueOf("https://my-api-strapi.herokuapp.com/produtos").toString());
    urlAuthAPI = Var.valueOf(Var.valueOf("https://my-api-strapi.herokuapp.com/auth/local").toString());
    authAPI = cronapi.util.Operations.getURLFromOthers(Var.valueOf("POST"), Var.valueOf("application/x-www-form-urlencoded"), urlAuthAPI, Var.VAR_NULL, Var.VAR_NULL, cronapi.map.Operations.createObjectMapWith(Var.valueOf("identifier",Var.valueOf("admin")) , Var.valueOf("password",Var.valueOf("adminadmin"))));
    item = cronapi.json.Operations.toJson(authAPI);
    header_token = cronapi.map.Operations.createObjectMapWith(Var.valueOf("authorization",Var.valueOf(Var.valueOf("Bearer ").toString() + cronapi.json.Operations.getJsonOrMapField(item, Var.valueOf("jwt")).toString())));
    newprod = cronapi.util.Operations.getURLFromOthers(Var.valueOf("POST"), Var.valueOf("application/x-www-form-urlencoded"), getProd, Var.VAR_NULL, header_token, Var.valueOf(cronapi.map.Operations.createObjectMapWith(Var.valueOf("nome",Var.valueOf("adminadmin")) , Var.valueOf("sabor",null) , Var.valueOf("preco",null) , Var.valueOf("quantidade",null)).toString()));
    System.out.println(header_token.getObjectAsString());
    System.out.println(newprod.getObjectAsString());
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

