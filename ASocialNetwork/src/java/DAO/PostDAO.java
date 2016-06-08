/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import client.PostClient;
import entidades.Post;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author marco
 */
public class PostDAO implements DAOInterface<Post> {
    PostClient cliente = new PostClient();
    @Override
    public boolean create(Post entidad) {
 try{
        cliente.create_XML((Object)entidad);
        }catch(ClientErrorException e){
            return false;
        }
        return true;    }

    @Override
    public boolean update(Post entidad) {
try{
        cliente.edit_XML((Object)entidad, entidad.getIdPost().toString());
        }catch(ClientErrorException e){
            return false;
        }
        return true;      }

   

    @Override
    public List<Post> list() {
GenericType<List<Post>> generic = new GenericType<List<Post>>(){};
        List<Post> data = (List<Post>) cliente.findAll_XML(generic);
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
    public Post read(String id) {
GenericType<Post> generic = new GenericType<Post>(){};
       Post usuario = (Post) cliente.find_XML(generic, id);
        
        return usuario;     }
    
}
