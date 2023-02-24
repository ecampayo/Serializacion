import javax.swing.*;
import java.io.*;
public class Serializacion {
    public static void main(String[] args) {
        File fichero=new File(vehiculos.txt);
        String matricula= JOptionPane.showInputDialog("Introduce la matricula");
        String marca=JOptionPane.showInputDialog("Introduce la marca");
        String texto=JOptionPane.showInputDialog("Introduce el tamaño del depósito");
        double tamanoDeposito=Double.parseDouble(texto);
        String modelo=JOptionPane.showInputDialog("Introduce el modelo");

        try {
            Vehiculo vehiculo = new Vehiculo(matricula, marca, tamanoDeposito, modelo);
            //Si el fichero existe, usaremos la clase Object nuestra sino la propia de Java
            if (fichero.exists()) {
                MiObjectOutputStream moos = new MiObjectOutputStream(new FileOutputStream(fichero, true));
                moos.writeObject(vehiculo);
                moos.close();
            } else {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
                oos.writeObject(vehiculo);
                oos.close();
            }
            //Creamos el objeto para evitar errores
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));
            muestraDatos(ois);
        }catch (ClassNotFoundException e){

        }catch (EOFException e){
            System.out.println("fin");
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void muestraDatos (ObjectInputStream ois) throws IOException, ClassNotFoundException{
        //cuando acabe el fichero saltará la IOException
        while (true){
            Vehiculo ref=(Vehiculo)ois.readObject();
            JOptionPane.showMessageDialog(null, "El vehiculo tiene una matricula " +ref.getMatricula()+ "su marca es " + ref.getMarca() + "su modelo es " + ref.getModelo());
        }
    }
}
