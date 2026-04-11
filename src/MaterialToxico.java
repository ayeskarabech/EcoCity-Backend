package src;

public class MaterialToxico extends Material {

    public MaterialToxico(double peso) {
        super("Tóxico", peso, true);
    }
    
    @Override
    public double calcularPontos() {
        double pontosBase = this.getPeso() * 10; 
        return (getPeso() * 10) * 3; // materiais tóxicos valem o triplo dos pontos base, para incentivar a reciclagem correta e evitar descarte inadequado
    }
    
}
