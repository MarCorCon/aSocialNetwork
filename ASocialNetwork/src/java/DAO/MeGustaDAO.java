/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import client.MeGustaClient;
import entidades.MeGusta;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Daniel
 */
public class MeGustaDAO implements DAOInterface<MeGusta> {

    MeGustaClient client = new MeGustaClient();

    @Override
    public boolean create(MeGusta entidad) {
       try{
        client.create_XML((Object)entidad);
        }catch(ClientErrorException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(MeGusta entidad) {
    try{
        client.edit_XML((Object)entidad, entidad.getIdLike().toString());
        }catch(ClientErrorException e){
            return false;
        }
        return true; 
    }

    @Override
    public List<MeGusta> list() {
        GenericType<List<MeGusta>> generic = new GenericType<List<MeGusta>>(){};
        List<MeGusta> data = (List<MeGusta>) client.findAll_XML(generic);
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
    public MeGusta read(String id) {
     GenericType<MeGusta> generic = new GenericType<MeGusta>(){};
       MeGusta meGusta = (MeGusta) client.find_XML(generic, id);
        
        return meGusta;   
    }

}

