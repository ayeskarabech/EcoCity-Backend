package src;

public class MaterialPapel extends Material {

    public MaterialPapel(double peso) {
        super("Papel", peso, false);
    }
    
    @Override
    public double calcularPontos() {
        double pontosBase = this.getPeso() * 10; 
        return pontosBase; // materiais de papel valem os pontos base, sem bônus
    }
    
}
