class TelefonoInteligente implements DispositivoElectronico {
    private String modelo;
    private boolean encendido;

    public TelefonoInteligente(String modelo) {
        this.modelo = modelo;
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

    public String getModelo() {
        return modelo;
    }

    public String getInfo() {
        return "Teléfono: Modelo - " + modelo + ", Encendido - " + encendido;
    }
}