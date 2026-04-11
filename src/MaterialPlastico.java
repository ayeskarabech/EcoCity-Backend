package src;

public class MaterialPlastico extends Material {

    public MaterialPlastico(double peso) {
        super("Plástico", peso, false);
    }
    
    @Override
    public double calcularPontos() {
        double pontosBase = this.getPeso() * 10; 
        return pontosBase; // materiais plásticos valem os pontos base, sem bônus
    }
    
}
