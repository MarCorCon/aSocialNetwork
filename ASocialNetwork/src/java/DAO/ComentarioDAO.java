/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import client.ComentarioClient;
import entidades.Comentario;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Daniel
 */
public class ComentarioDAO implements DAOInterface<Comentario> {

    ComentarioClient client = new ComentarioClient();

    @Override
    public boolean create(Comentario entidad) {
       try{
        client.create_XML((Object)entidad);
        }catch(ClientErrorException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Comentario entidad) {
    try{
        client.edit_XML((Object)entidad, entidad.getIdComentario().toString());
        }catch(ClientErrorException e){
            return false;
        }
        return true; 
    }

    @Override
    public List<Comentario> list() {
        GenericType<List<Comentario>> generic = new GenericType<List<Comentario>>(){};
        List<Comentario> data = (List<Comentario>) client.findAll_XML(generic);
        return data;}

    @Override
    public boolean delete(String id) {
    try{
        client.remove( id);
        }catch(ClientErrorException e){
            return false;
        }
        return true;    
    }

    @Override
    public Comentario read(String id) {
     GenericType<Comentario> generic = new GenericType<Comentario>(){};
       Comentario comentario = (Comentario) client.find_XML(generic, id);
        
        return comentario;   
    }

}