package model;

import java.util.ArrayList;

public class EquipoReal extends Equipo {
    
    ArrayList<JugadorReal> jugadoresEquipo = new ArrayList<>();

    public EquipoReal(String _nombre){
        super(_nombre);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    public void agregarJugador(JugadorReal _jugador){
        jugadoresEquipo.add(_jugador);
    }
}
