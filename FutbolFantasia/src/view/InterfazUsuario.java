//CLASE COMPLETA
package view;
import controller.UserController;

public class InterfazUsuario {
    
    public void iniciarVista(UserController _controller){
        FirstFrame ventana = new FirstFrame(_controller);
        ventana.setVisible(true);
    }
}
