package PROYECTO_121;

import java.io.*;
import java.util.ArrayList;

public class ArchEspacioPublico {
    private String nomArch = "espacios.dat";

    public void crear() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomArch));
        out.close();
    }
    public void adicionar(EspacioPublico e) throws IOException {
        ArrayList<EspacioPublico> lista = listar();
        lista.add(e);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomArch));
        for (EspacioPublico x : lista) {
            oos.writeObject(x);
        }
        oos.close();
    }

    public ArrayList<EspacioPublico> listar() {
        ArrayList<EspacioPublico> lista = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomArch));
            while (true) {
                EspacioPublico e = (EspacioPublico) ois.readObject();
                lista.add(e);
            }
        } catch (EOFException e) {
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            System.out.println("Error al leer espacios: " + e.getMessage());
        }
        return lista;
    }
}