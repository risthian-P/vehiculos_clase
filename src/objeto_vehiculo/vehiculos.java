package objeto_vehiculo;

import java.io.Serializable;

public class vehiculos implements Serializable {

    private static final long serialVersionUID =1L;
    private String marca, modelo, color, motor;
    private double year;
    
    //constructor

    public vehiculos(String marca, String modelo, String color, String motor, float year) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.motor = motor;
        this.year = year;
    }
    
    //setter y getter
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Float getYear() {
        return year;
    }

    public void setYear(Float year) {
        this.year = year;
    }

    public String toString() {
        return "Marca: " + marca + "; modelo: " + modelo+"; color: "+ color+"; motor: "+ motor + "; año: "+year;
    }
}
