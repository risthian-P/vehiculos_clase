import objeto_vehiculo.vehiculos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class panel_vehiculos {
    private JPanel rootP;
    private JTextField marca_text;
    private JTextField modelo_text;
    private JTextField color_text;
    private JTextField motor_text;
    private JTextField year_text;
    private JButton cargarButton;
    private JButton navegarButton;
    private JButton guardarButton;
    private JLabel marcaLabel;
    private JLabel modeloLabel;
    private JLabel colorLabel;
    private JLabel motorLabel;
    private JLabel year_creacion;
    private JLabel buscar;
    private JTextField textField1;
    private JButton buscarButton;
    private JLabel resultado;
    private int narreglo = 100;

    //variables para agregar al arreglo
    String dmarca,dmodelo,dcolor,dmotor,cambio;
    double dyear;

    String filePath = "objeto_vehiculo.vehiculos.dat";  //nombre del archivo

    public panel_vehiculos(){
        vehiculos objeto = new vehiculos(dmarca,dmodelo,dcolor,dmotor,dyear);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (//try permite tratar de hacer algo, y nos ayuda a capturar el mensaje de error
                     FileOutputStream fileOut = new FileOutputStream(filePath);
                     ObjectOutputStream obOut = new ObjectOutputStream(fileOut) )
                {
                    obOut.writeObject(objeto);
                    System.out.println("archivo escrito correctamente");
                }catch (Exception m){
                    throw new RuntimeException(m);
                }
            }
        });

        cargarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try(
                        FileInputStream fileIn = new FileInputStream(filePath);
                        ObjectInputStream objIn = new ObjectInputStream(fileIn)
                )
                {
                    vehiculos readObject = (vehiculos) objIn.readObject();
                    System.out.println("El objeto en disco es: " + readObject);
                }catch (IOException m){
                    throw new RuntimeException(m);
                }catch (ClassNotFoundException m){
                    throw new RuntimeException(m);
                }
            }
        });

        year_text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dyear = Double.parseDouble(year_text.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("panel_vehiculos");
        frame.setContentPane(new panel_vehiculos().rootP);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
