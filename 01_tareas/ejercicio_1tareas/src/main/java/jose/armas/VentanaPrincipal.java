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
    private JScrollBar scrollBar1;

    private List<Tarea> tareas = new ArrayList<>();
    private DefaultListModel<String> model  = new DefaultListModel<>();

    public VentanaPrincipal() throws IOException {

        leerJson();


        buttonAnadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String texto = textFieldTexto.getText();

                if(texto.equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(panelTareas,"Tarea no válida");
                }else{
                    try {
                        escribirJson(texto);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                    textFieldTexto.setText("");
                }
            }
        });
    }

    private void leerJson() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader
                    (new FileInputStream("tareas.json"), StandardCharsets.UTF_8));

            String json = br.lines().collect(Collectors.joining());

            Gson gson = new Gson();


        }catch(IOException e){
            e.printStackTrace();
         }
    }

    private void rellenarLista(String texto) {
        Tarea tarea = new Tarea(texto);
        tareas.add(tarea);
        model.addElement(texto);
        listTexto.setModel(model);

    }

    private void escribirJson(String texto) throws IOException {
        FileOutputStream fos=null;
        try{
            fos = new FileOutputStream("tareas.json");
            Writer w = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(texto);

          


            w.write(json);



            w.flush();
            w.close();

        }catch  (FileNotFoundException e) {
            e.printStackTrace();
        }
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
