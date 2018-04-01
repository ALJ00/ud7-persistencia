package jose.armas;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class VentanaPrincipal {
    private JList listTexto;
    private JButton buttonCompletar;
    private JTextField textFieldTexto;
    private JButton buttonAnadir;
    private JPanel panelTareas;
    private JLabel mensaje;
    private JScrollPane scrollLista;

    private List<Tarea> tareas = new ArrayList<>();
    
    public VentanaPrincipal() throws IOException {

        buttonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textFieldTexto.getText();
                if(texto.equals("")){
                    JOptionPane.showMessageDialog(panelTareas,"tarea no válida");
                }else{

                    Tarea nuevaTarea = new Tarea(texto);

                    tareas.add(nuevaTarea);

                    actualizarLista();

                    textFieldTexto.setText("");

                }
            }
        });
        buttonCompletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((listTexto.getMinSelectionIndex())<0){
                    JOptionPane.showMessageDialog(panelTareas,"Seleccione una tarea");
                }else{
                    int[] seleccionadas = listTexto.getSelectedIndices();

                    List<Tarea> sinCompletar = new ArrayList<>();

                    for (Tarea t : tareas) {
                        if (!t.isCompletada()) {
                            sinCompletar.add(t);
                        }
                    }

                    for (int posicion : seleccionadas) {
                        sinCompletar.get(posicion).setCompletada(true);
                    }

                    actualizarLista();
                }
            }
        });
    }

    private void actualizarLista() {
        DefaultListModel<Tarea> modelo = new DefaultListModel<>();

        for (Tarea t : tareas) {
            if (!t.isCompletada())
                modelo.addElement(t);
        }

        listTexto.setModel(modelo);
    }


    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().panelTareas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
