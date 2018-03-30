package jose.armas;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class EscribirJason {

    private List<Tarea>tareas = new ArrayList<>();

    public EscribirJason(Tarea a) {
        tareas.add(a);

        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream("tareas.json");
            Writer w = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8));

            // REF: https://www.mkyong.com/java/how-to-enable-pretty-print-json-output-gson/
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(tareas);

            //String json = new Gson().toJson(corredores);
            w.write(json);

            w.flush();
            w.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
