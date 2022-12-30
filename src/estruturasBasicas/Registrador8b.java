package estruturasBasicas;

public class Registrador8b {

    private Flip_Flop_d f0 = new Flip_Flop_d();
    private Flip_Flop_d f1 = new Flip_Flop_d();
    private Flip_Flop_d f2 = new Flip_Flop_d();
    private Flip_Flop_d f3 = new Flip_Flop_d();
    private Flip_Flop_d f4 = new Flip_Flop_d();
    private Flip_Flop_d f5 = new Flip_Flop_d();
    private Flip_Flop_d f6 = new Flip_Flop_d();
    private Flip_Flop_d f7 = new Flip_Flop_d();

    

    public boolean[] executar(boolean[] vetEntrada, boolean clk){
        
        boolean[] vetValArmazenado = new boolean[8];
        

            vetValArmazenado[0] = f0.executar(vetEntrada[0], clk);
            vetValArmazenado[1] = f1.executar(vetEntrada[1], clk);
            vetValArmazenado[2] = f2.executar(vetEntrada[2], clk);
            vetValArmazenado[3] = f3.executar(vetEntrada[3], clk);
            vetValArmazenado[4] = f4.executar(vetEntrada[4], clk);
            vetValArmazenado[5] = f5.executar(vetEntrada[5], clk);
            vetValArmazenado[6] = f6.executar(vetEntrada[6], clk);
            vetValArmazenado[7] = f7.executar(vetEntrada[7], clk);


    return vetValArmazenado;
    }

    
}
