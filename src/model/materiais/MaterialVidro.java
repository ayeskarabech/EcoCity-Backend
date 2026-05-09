package src.model.materiais;

import src.model.Material;

public class MaterialVidro extends Material {

    public MaterialVidro(double peso, boolean toxico) {
        super("Vidro", peso, toxico);
    }
    
    @Override
    public double calcularPontos() {
        double pontosBase = this.getPeso() * 10; 
        return pontosBase; // materiais de vidro valem os pontos base, sem bônus
    }
    
}
