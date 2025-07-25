package PROYECTO_121;

import java.io.*;
import java.util.*;
import java.util.ArrayList;
public class ArchReservas {
    private String nomArch = "reservas.dat";

    public void crear() throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomArch));
        out.close();
    }

    public void adicionar(Reserva r) throws IOException {
        ArrayList<Reserva> lista = listar();
        lista.add(r);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomArch));
        for (Reserva x : lista) {
            oos.writeObject(x);
        }
        oos.close();
    }

    public ArrayList<Reserva> listar() {
        ArrayList<Reserva> lista = new ArrayList<>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomArch));
            while (true) {
                Reserva r = (Reserva) ois.readObject();
                lista.add(r);
            }
        } catch (EOFException e) {
        } catch (FileNotFoundException e) {
        } catch (Exception e) {
            System.out.println("Error al leer reservas: " + e.getMessage());
        }
        return lista;
    }
}
