package PROYECTO_121;

import java.io.*;
import java.util.ArrayList;

public class ArchUsuario {
    private String nomArch = "usuarios.dat";

    public void crear() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomArch));
        out.close();
    }

    public void adicionar(Usuario u) throws IOException {
        ArrayList<Usuario> lista = listar();
        lista.add(u);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomArch));
        for (Usuario x : lista) {
            oos.writeObject(x);
        }
        oos.close();
    }

    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomArch));
            while (true) {
                Usuario u = (Usuario) ois.readObject();
                lista.add(u);
            }
        } catch (EOFException e) {
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            System.out.println("Error al leer usuarios: " + e.getMessage());
        }
        return lista;
    }
}