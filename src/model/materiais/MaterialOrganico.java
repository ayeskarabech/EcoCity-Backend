package src.model.materiais;

import src.model.Material;

public class MaterialOrganico extends Material {

    public MaterialOrganico(double peso) {
        super("Orgânico", peso, false);
    }
    
    @Override
    public double calcularPontos() {
        return (getPeso() * 10) * 2; // materiais orgânicos valem o dobro dos pontos base
    }
}
