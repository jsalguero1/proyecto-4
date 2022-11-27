package model;

public class Participante extends Usuario {
    
    /**
     * Constructor de un partiicipante
     * @param _nombre
     * @param _clave
     */
    public Participante(String _nombre, String _clave){
        super(_nombre, _clave);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public String getClave() {
        return super.getClave();
    }
}
