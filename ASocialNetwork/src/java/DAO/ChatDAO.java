/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import client.ChatClient;
import entidades.Chat;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Daniel
 */
public class ChatDAO implements DAOInterface<Chat> {

    ChatClient client = new ChatClient();

    @Override
    public boolean create(Chat entidad) {
       try{
        client.create_XML((Object)entidad);
        }catch(ClientErrorException e){
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Chat entidad) {
    try{
        client.edit_XML((Object)entidad, entidad.getIdChat().toString());
        }catch(ClientErrorException e){
            return false;
        }
        return true; 
    }

    @Override
    public List<Chat> list() {
        GenericType<List<Chat>> generic = new GenericType<List<Chat>>(){};
        List<Chat> data = (List<Chat>) client.findAll_XML(generic);
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
    public Chat read(String id) {
     GenericType<Chat> generic = new GenericType<Chat>(){};
       Chat chat = (Chat) client.find_XML(generic, id);
        
        return chat;   
    }

}
