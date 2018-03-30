package jose.armas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VentanaTareas {
    private JPanel tareas;
    private JButton buttonAñadir;
    private JList list1;
    private JTextField textoTarea;


    //Conexión.
    private Tarea tarea;
    private EscribirJason escribirJason;

    //Almacenamiento.
    private List<Tarea> tareaListVentanaTareas = new ArrayList<>();


    public VentanaTareas() {
        list1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);


            }
        });
        buttonAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String texto = textoTarea.getText();

                Tarea nuevaTarea = new Tarea(texto);
                tareaListVentanaTareas.add(nuevaTarea);

                textoTarea.setText("");

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaTareas");
        frame.setContentPane(new VentanaTareas().tareas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
