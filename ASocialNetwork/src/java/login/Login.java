/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;



import entidades.Usuario;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;


/**
 *
 * @author marco
 */
public class Login implements SessionAware{  
private String username,userpass;  
SessionMap<String,Object> sessionmap;  
  Usuario u;
public String getUsername() {  
    return username;  
}  
  
public void setUsername(String username) {  
    this.username = username;  
}  

    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }
  
public String getUserpass() {  
    return userpass;  
}  
  
public void setUserpass(String userpass) {  
    this.userpass = userpass;  
}  
  
public String execute(){  
    System.out.println("LOGIN");
    u = LoginDAO.validate(username, userpass);
    if(u!= null){  
         sessionmap.put("usuario",u); 
               return "success";  
    }  
    else{  
        return "error";  
    }  
}  
  
@Override
public void setSession(Map map) {  
    sessionmap=(SessionMap)map;  
    sessionmap.put("login","true");  
   
    
}  
  
public String logout(){  
    sessionmap.invalidate();  
    return "success";  
}  
  
}  
