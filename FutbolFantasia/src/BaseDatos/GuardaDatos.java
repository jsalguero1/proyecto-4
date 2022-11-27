package BaseDatos;

import java.io.*;
import model.Participante;


public class GuardaDatos {
    String tipoDato = ".obj";

    public GuardaDatos(){

    }

    /**
     * Guarda un participante en la base de datos de la aplicacion
     * @param _participante el participante que se va a guardar
     */
    public boolean guardarParticipante(Participante _participante, String _nombreAdmin){
        try {
            if(_participante.getNombre().equals(_nombreAdmin)){
                return false;
            }
            if(!verificarExistenciaUsuario(_participante.getNombre())){
                ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream("dataBase/participantes/" + _participante.getNombre() + tipoDato));
                escritor.writeObject(_participante);
                escritor.close();
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            
        }
        return false;
    }

    /**
     * 
     * @param _nombre
     * @return true si existe un participante con ese nombre, false de lo contrario
     */
    public boolean verificarExistenciaUsuario(String _nombre){
        try {
            File rutaParticipante = new File("dataBase/participantes/" + _nombre + tipoDato);
            if(rutaParticipante.exists()){
                return true;
            }else{
                return false;
            }
            
        } catch (Exception e) {
            
        }
        return false;
    }

    /**
     * Recupera un participante de la base de datos de la aplicacion
     * @param _nombre nombre de usuario buscado
     * @param _clave clave asociada al nombre de usuario
     * @return participante cuyo nombre y clave coincidan con los ingresados por parametro, null si no existe
     */
    public Participante recuperarparticipante(String _nombre, String _clave){
        try {
            File rutaParticipante = new File("dataBase/participantes/" + _nombre + tipoDato);
            if(rutaParticipante.exists()){
                ObjectInputStream lector = new ObjectInputStream(new FileInputStream(rutaParticipante));
                Participante participante = (Participante)lector.readObject();
                lector.close();
                if(_clave.equals(participante.getClave())){
                    return participante;
                }
            }
        } catch (Exception e) {
            
        }
        return null;
    }
}
