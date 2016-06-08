/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import client.UsuarioClient;
import entidades.Usuario;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author marco
 */
public class UsuarioDAO implements DAOInterface<Usuario>{
UsuarioClient cliente = new UsuarioClient();
    @Override
    public boolean create(Usuario entidad) {
       try{
        cliente.create_XML((Object)entidad);
        }catch(ClientErrorException e){
            return false;
        }
        return true;
   }

    @Override
    public boolean update(Usuario entidad) {
 try{
        cliente.edit_XML((Object)entidad, entidad.getIdUsuario().toString());
        }catch(ClientErrorException e){
            return false;
        }
        return true;  
    }

    

    @Override
    public List<Usuario> list() {
GenericType<List<Usuario>> generic = new GenericType<List<Usuario>>(){};
        List<Usuario> data = (List<Usuario>) cliente.findAll_XML(generic);
        return data; 
    }

    @Override
    public boolean delete(String id) {
        try{
        cliente.remove( id);
        }catch(ClientErrorException e){
            return false;
        }
        return true;
    }

    @Override
    public Usuario read(String id) {
     GenericType<Usuario> generic = new GenericType<Usuario>(){};
       Usuario usuario = (Usuario) cliente.find_XML(generic, id);
        
        return usuario;    }
    
}
