import java.io.Serializable;

public class Vehiculo implements Serializable {
    private static final long serialVersionUID=7695874286508524707L;
    //atributos
    private String matricula;
    private String marca;
   //tamaño del depósito del vehículo no se transfiere a la serialización
    transient private double tamanoDeposito;
    private String modelo;

    public String getMatricula(){
        return matricula;
    }
    public String getMarca(){
        return marca;
    }
    public double getTamanoDeposito(){
        return tamanoDeposito;
    }
    public String getModelo(){
        return modelo;
    }
    //Constructor
    public Vehiculo (String matricula, String marca, double tamanoDeposito, String modelo){
        this.matricula=matricula;
        this.tamanoDeposito=tamanoDeposito;
        this.marca=marca;
        this.modelo=modelo;
    }
}
