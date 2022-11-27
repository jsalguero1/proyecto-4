package model;

import java.util.ArrayList;

public class TemporadaReal extends Temporada{

    ArrayList<EquipoReal> equiposTemporada = new ArrayList<>();
    ArrayList<FechaReal> fechasTemporada = new ArrayList<>();
    
    public TemporadaReal(){
    }

    @Override
    public int getIdTemporada() {
        return super.getIdTemporada();
    }

    @Override
    public void setIdTemporada(int _idTemporada) {
        super.setIdTemporada(_idTemporada);
    }

    /**
     * Agrega un equipo real a la lista de equipos
     * @param _equipo equipos a ser agregado
     */
    public void addEquipo(EquipoReal _equipo){
        equiposTemporada.add(_equipo);
    }

    /**
     * Retorna el tamaño de la lista de equipos
     * @return tamaño lista de equipos
     */
    public int getSizeEquipos(){
        return equiposTemporada.size();
    }

    /**
     * Crea un equipo real
     * @param _nombre nombre del equipo
     * @return equipo real creado
     */
    public EquipoReal crearEquipo(String _nombre){
        return new EquipoReal(_nombre);
    }

    public int getSizeFechas(){
        return fechasTemporada.size();
    }


    public FechaReal buscarFechaPorId(int _id){
        int i = 0;
        while(i < fechasTemporada.size()){
            FechaReal fecha = fechasTemporada.get(i);
            if(fecha.getIdFecha() == _id){
                return fecha;
            }
            i += 1;
        }  
        return null;
    }

    public FechaReal crearFecha(int _id){
        return new FechaReal(_id);
    }

    public void agregarFecha(FechaReal _fecha){
        this.fechasTemporada.add(_fecha);
    }

    /**
     * Crea un jugador real
     * @param _nombre nombre del jugador
     * @param _equipo nombre del equipo al que pertence el jugador
     * @param _posicion posicion de juego del jugador
     * @param _precio precio de compra del jugador
     * @return jugador creado
     */
    public JugadorReal crearJugador(String _nombre, String _equipo, String _posicion, int _precio){
        EquipoReal equipo = buscarEquipoPorNombre(_equipo);
        JugadorReal jugador = new JugadorReal(_nombre, equipo, _precio);
        jugador.setPosicion(_posicion);
        return jugador;
    }

    /**
     * Busca un equipo en la lista de equipos por su nombre
     * @param _nombreEquipo nombre del equipo a ser buscado
     * @return equipo encontrado
     */
    public EquipoReal buscarEquipoPorNombre(String _nombreEquipo){
        for (EquipoReal equipoReal : equiposTemporada) {
            if(equipoReal.getNombre().equals(_nombreEquipo)){
                return equipoReal;
            }
        }
        return null;
    }

    /**
     * Agrega un jugador a un equipo
     * @param _jugador jugador a ser agregado
     */
    public void agregarJugadorEquipo(JugadorReal _jugador){
        int i = 0;
        while(i < getSizeEquipos()){
            EquipoReal equipo = equiposTemporada.get(i);
            String NombreEquipo = equipo.getNombre();
            String nombreEquipoJugador = _jugador.getEquipo().getNombre();
            if(NombreEquipo.equals(nombreEquipoJugador)){
                equipo.agregarJugador(_jugador);
                break;
            }
            i += 1;
        }
    }

}
