package model;

public abstract class Jugador {
    String nombre;
    Double precio;
    Double venta;
    Posicion posicion;

    public Jugador(String _nombre, int _precio){
        this.nombre = _nombre;
        this.precio = (double)_precio;
        this.venta = precio * 0.97;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }
    
    public Double getVenta() {
        return venta;
    }

    public void setPosicion(String _posicion) {
        if(_posicion.equals("arquero")){
            posicion = Posicion.ARQUERO;
        }else if(_posicion.equals("delantero")){
            posicion = Posicion.DELANTERO;
        }else if(_posicion.equals("medio")){
            posicion = Posicion.MEDIOCAMPISTA;
        }else if(_posicion.equals("defensa")){
            posicion = Posicion.DEFENSA;
        }
    }

}
