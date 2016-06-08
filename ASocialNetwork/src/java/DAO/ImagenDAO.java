/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import client.ImagenClient;
import entidades.Imagen;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Daniel
 */
public class ImagenDAO implements DAOInterface<Imagen> {

    ImagenClient client = new ImagenClient();

    @Override
    public boolean create(Imagen entidad) {
       try{
        client.create_XML((Object)entidad);
        }catch(ClientErrorException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Imagen entidad) {
    try{
        client.edit_XML((Object)entidad, entidad.getIdImagen().toString());
        }catch(ClientErrorException e){
            return false;
        }
        return true; 
    }

    @Override
    public List<Imagen> list() {
        GenericType<List<Imagen>> generic = new GenericType<List<Imagen>>(){};
        List<Imagen> data = (List<Imagen>) client.findAll_XML(generic);
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
    public Imagen read(String id) {
     GenericType<Imagen> generic = new GenericType<Imagen>(){};
       Imagen imagen = (Imagen) client.find_XML(generic, id);
        
        return imagen;   
    }

}
