package src.model.exceptions;

// Exceção personalizada para lidar com tipos de materiais inválidos, garantindo que o sistema seja robusto e forneça feedback claro ao usuário em caso de erros de entrada.

public class TipoMaterialInvalidoException extends Exception {
    public TipoMaterialInvalidoException(String mensagem) {
        super(mensagem);
    }
}