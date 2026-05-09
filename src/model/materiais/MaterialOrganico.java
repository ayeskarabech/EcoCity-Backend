package src.model.materiais;

import src.model.Material;

public class MaterialOrganico extends Material {

    public MaterialOrganico(double peso, boolean toxico) {
        super("Orgânico", peso, toxico);
    }
    
    @Override
    public double calcularPontos() {
        return (getPeso() * 10) * 2; // materiais orgânicos valem o dobro dos pontos base
    }
}
