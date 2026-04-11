package src;

public class MaterialOrganico extends Material {

    public MaterialOrganico(double peso) {
        super("Orgânico", peso, false);
    }
    
    @Override
    public double calcularPontos() {
        double pontosBase = this.getPeso() * 10; 
        return (getPeso() * 10) * 2; // materiais orgânicos valem o dobro dos pontos base
    }
}
