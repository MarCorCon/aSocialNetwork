/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import client.AmistadClient;
import entidades.Amistad;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Daniel
 */
public class AmistadDAO implements DAOInterface<Amistad> {

    AmistadClient client = new AmistadClient();

    @Override
    public boolean create(Amistad entidad) {
       try{
        client.create_XML((Object)entidad);
        }catch(ClientErrorException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Amistad entidad) {
    try{
        client.edit_XML((Object)entidad, entidad.getIdAmistad().toString());
        }catch(ClientErrorException e){
            return false;
        }
        return true; 
    }

    @Override
    public List<Amistad> list() {
        GenericType<List<Amistad>> generic = new GenericType<List<Amistad>>(){};
        List<Amistad> data = (List<Amistad>) client.findAll_XML(generic);
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
    public Amistad read(String id) {
     GenericType<Amistad> generic = new GenericType<Amistad>(){};
       Amistad amistad = (Amistad) client.find_XML(generic, id);
        
        return amistad;   
    }

}
