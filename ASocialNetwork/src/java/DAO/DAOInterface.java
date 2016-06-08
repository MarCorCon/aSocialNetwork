/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author Daniel
 */
public interface DAOInterface <E>{
   public boolean create(E entidad);
   public boolean update(E entidad);
   public boolean delete(String id);
   public List<E> list();
   public E read(String id);
}
