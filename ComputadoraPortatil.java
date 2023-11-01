class ComputadoraPortatil implements DispositivoElectronico {
    private String marca;
    private boolean encendido;

    public ComputadoraPortatil(String marca) {
        this.marca = marca;
        this.encendido = false;
    }

    @Override
    public void encender() {
        encendido = true;
    }

    @Override
    public void apagar() {
        encendido = false;
    }

    @Override
    public boolean validarEncendido() {
        return encendido;
    }

    public String getMarca() {
        return marca;
    }

    public String getInfo() {
        return "Computadora: Marca - " + marca + ", Encendida - " + encendido;
    }
}