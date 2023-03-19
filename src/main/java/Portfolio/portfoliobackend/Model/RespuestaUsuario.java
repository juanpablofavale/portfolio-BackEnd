package Portfolio.portfoliobackend.Model;

public class RespuestaUsuario {
    String mensaje;
    Integer codigo;

    public RespuestaUsuario(String mensaje, Integer codigo) {
        this.mensaje = mensaje;
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Respuesta dobre Usuario{" + "mensaje=" + mensaje + ", codigo=" + codigo + '}';
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}