import java.io.*;
import java.util.ArrayList;
import java.util.List;

interface DispositivoElectronico {
    void encender();
    void apagar();
    boolean validarEncendido();
}