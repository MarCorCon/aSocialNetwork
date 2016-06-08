/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import DAO.UsuarioDAO;
import entidades.Usuario;
import java.util.List;

/**
 *
 * @author marco
 */
public class LoginDAO {

    public static Usuario validate(String username, String userpass) {
       
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarioList;
        usuarioList = usuarioDAO.list();
        
        for(Usuario u : usuarioList){
            System.out.println(u.toString());
            if(u.getEmail().equals(username)&&u.getPassword().equals(userpass)){
                return u;
            }
        }
        

        return null;
    }
}
