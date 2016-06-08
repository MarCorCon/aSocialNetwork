/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades.actions;

import DAO.UsuarioDAO;
import static com.opensymphony.xwork2.Action.SUCCESS;
import entidades.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Daniel
 */
public class UsuarioAction {

    String nombre;
    String apellidos;
    String email;
    String password;
    String fechaNacimiento;
    String fotoPerfil;
    UsuarioDAO dao = new UsuarioDAO();

    public UsuarioAction() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public UsuarioDAO getDao() {
        return dao;
    }

    public void setDao(UsuarioDAO dao) {
        this.dao = dao;
    }

    public String create() throws Exception {
        if(dao.create(new Usuario(nombre, apellidos, email, stringToDate(fechaNacimiento), password, fotoPerfil))){
           return SUCCESS; 
        }
        else{
            return "error";
        }
        
    }

    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Date stringToDate(String fecha) throws ParseException {
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        if (!fecha.equals("")) {
            date = formatter.parse(fecha);
        }

        return date;
    }
}
