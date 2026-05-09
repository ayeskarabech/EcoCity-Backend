package src.model.materiais;

import src.model.Material;

public class MaterialPlastico extends Material {

    public MaterialPlastico(double peso, boolean toxico) {
        super("Plástico", peso, toxico);
    }
    
    @Override
    public double calcularPontos() {
        double pontosBase = this.getPeso() * 10; 
        return pontosBase; // materiais plásticos valem os pontos base, sem bônus
    }
    
}
