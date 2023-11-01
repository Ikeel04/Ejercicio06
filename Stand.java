import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Stand {
    private List<DispositivoElectronico> dispositivos = new ArrayList<>();

    public void agregarDispositivo(DispositivoElectronico dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void desplegarInformacion() {
        for (DispositivoElectronico dispositivo : dispositivos) {
            System.out.println(dispositivo.getClass().getSimpleName() + ": " + dispositivo.validarEncendido());
        }
    }

    public void validarEncendidos() {
        for (DispositivoElectronico dispositivo : dispositivos) {
            if (dispositivo.validarEncendido()) {
                System.out.println(dispositivo.getClass().getSimpleName() + " está encendido.");
            }
        }
    }

    public void validarApagados() {
        for (DispositivoElectronico dispositivo : dispositivos) {
            if (!dispositivo.validarEncendido()) {
                System.out.println(dispositivo.getClass().getSimpleName() + " está apagado.");
            }
        }
    }

    public void guardarEnArchivoCSV(String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new File(nombreArchivo))) {
            for (DispositivoElectronico dispositivo : dispositivos) {
                if (dispositivo instanceof TelefonoInteligente) {
                    writer.println("Telefono," + ((TelefonoInteligente) dispositivo).getModelo());
                } else if (dispositivo instanceof ComputadoraPortatil) {
                    writer.println("Computadora," + ((ComputadoraPortatil) dispositivo).getMarca());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cargarDesdeArchivoCSV(String nombreArchivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    if (parts[0].equals("Telefono")) {
                        agregarDispositivo(new TelefonoInteligente(parts[1]));
                    } else if (parts[0].equals("Computadora")) {
                        agregarDispositivo(new ComputadoraPortatil(parts[1]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Stand stand = new Stand();

        TelefonoInteligente telefono1 = new TelefonoInteligente("Modelo1");
        ComputadoraPortatil computadora1 = new ComputadoraPortatil("Marca1");

        stand.agregarDispositivo(telefono1);
        stand.agregarDispositivo(computadora1);

        stand.desplegarInformacion();
        stand.validarEncendidos();
        stand.validarApagados();

        stand.guardarEnArchivoCSV("dispositivos.csv");
        stand.cargarDesdeArchivoCSV("dispositivos.csv");
    }
}
