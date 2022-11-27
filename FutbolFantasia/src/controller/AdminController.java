package controller;

import BaseDatos.GuardaDatos;
import view.InterfazAdmin;

public class AdminController {
    private InterfazAdmin view;
    private GuardaDatos baseDatos;
    private LectorArchivos lector = new LectorArchivos();
    
    public AdminController(InterfazAdmin _view, GuardaDatos _baseDatos){
        this.view = _view;
        this.baseDatos = _baseDatos;        
    }
}
