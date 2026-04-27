package src.model.materiais;

import src.model.Material;

public class MaterialToxico extends Material {

    public MaterialToxico(double peso) {
        super("Tóxico", peso, true);
    }
    
    @Override
    public double calcularPontos() { 
        return (getPeso() * 10) * 3; // materiais tóxicos valem o triplo dos pontos base, para incentivar a reciclagem correta e evitar descarte inadequado
    }
    
}
