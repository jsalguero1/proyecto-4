package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import model.EquipoReal;
import model.FechaReal;
import model.JugadorReal;
import model.PartidoReal;
import model.TemporadaReal;

public class LectorArchivos {
    
    public LectorArchivos(){}

    /**
     * Carga los equipos que jugaran en la temporada
     * @param _nombreArchivo nombre del archivo donde esta la información
     * @param _temporada temporada a la que se debe agregar la información
     */
    public void cargarEquipos(String _nombreArchivo, TemporadaReal _temporada){
        File rutaEquipos = new File("data/infoTemporada/" + _nombreArchivo);
        try {
            if(rutaEquipos.exists()){
                BufferedReader lector = new BufferedReader(new FileReader(rutaEquipos));
                String linea = lector.readLine();
                linea = lector.readLine();
                while(linea != null){
                     String nombre = linea;
                     EquipoReal equipo = _temporada.crearEquipo(nombre);
                    _temporada.addEquipo(equipo);
                    linea = lector.readLine();
                }
                lector.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga el archivo de los jugadores de la temporada
     * @param _nombreArchivo nombre del archivo donde esta la informacion de los jugadores
     * @param _temporada temporada a la que se debe cargar la información
     */
    public void cargarJugadores(String _nombreArchivo, TemporadaReal _temporada){
        File rutaJugadores = new File("data/infoTemporada/" + _nombreArchivo);
        try {
            if(rutaJugadores.exists()){
                BufferedReader lector = new BufferedReader(new FileReader(rutaJugadores));
                String linea = lector.readLine();
                linea = lector.readLine();
                while(linea != null){
                    String[] datos = linea.split(";");
                    String nombre = datos[0];
                    String equipo = datos[1];
                    String posicion = datos[2];
                    int precio = Integer.parseInt(datos[3]);
                    JugadorReal jugador = _temporada.crearJugador(nombre, equipo, posicion, precio);
                    _temporada.agregarJugadorEquipo(jugador);
                    linea = lector.readLine();
                }
                lector.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarFechas(String _nombreArchivo, TemporadaReal _temporada){
        File rutaFechas = new File("data/infoTemporada/" + _nombreArchivo);
        try {  
            if(rutaFechas.exists()){
                BufferedReader lector = new BufferedReader(new FileReader(rutaFechas));
                String linea = lector.readLine();
                linea = lector.readLine();
                while(linea != null){
                    String[] datos = linea.split(";");
                    int idFecha = Integer.parseInt(datos[0]);
                    String dia = datos[1];
                    String hora = datos[2];
                    String nombreLocal = datos[3];
                    String nombreVisitante = datos[4];
                    EquipoReal visitante = _temporada.buscarEquipoPorNombre(nombreVisitante);
                    EquipoReal local = _temporada.buscarEquipoPorNombre(nombreLocal);

                    FechaReal fecha;

                    if(_temporada.getSizeFechas() == 0 || _temporada.buscarFechaPorId(idFecha) == null){
                        fecha = _temporada.crearFecha(idFecha);
                        _temporada.agregarFecha(fecha);
                    }else{
                        fecha = _temporada.buscarFechaPorId(idFecha);
                    }

                    PartidoReal partido = fecha.crearPartido(local, visitante, dia, hora);
                    fecha.agregarPartido(partido);
                    linea = lector.readLine();
                }
                lector.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
