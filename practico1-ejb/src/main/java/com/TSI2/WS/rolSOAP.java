package com.TSI2.WS;

import com.TSI2.BLL.BLLRolBeanLocal;
import com.TSI2.Entidades.Rol;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "rolSOAP")
@Stateless()
public class rolSOAP {

    @EJB
    private BLLRolBeanLocal ejbRef;

    @WebMethod(operationName = "addRol")
    public boolean addRol(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion) {
        return ejbRef.addRol(nombre, descripcion);
    }

    @WebMethod(operationName = "updateRol")
    public boolean updateRol(@WebParam(name = "id") int id, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion) {
        return ejbRef.updateRol(id, nombre, descripcion);
    }

    @WebMethod(operationName = "getRol")
    public Rol getRol(@WebParam(name = "id") int id) {
        return ejbRef.getRol(id);
    }

    @WebMethod(operationName = "getRoles")
    public List<Rol> getRoles() {
        return ejbRef.getRoles();
    }

    @WebMethod(operationName = "deleteRol")
    public boolean deleteRol(@WebParam(name = "id") int id) {
        return ejbRef.deleteRol(id);
    }
    
}
