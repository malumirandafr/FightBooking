public class Voo {
    protected boolean[] assentos;
    protected int numero;
    protected String dataHorario;

    public Voo(int numero, String dataHorario, int qtdAssentos){

        this.assentos = new boolean[qtdAssentos];
        this.numero = numero;
        this.dataHorario = dataHorario;
    }

    public int getNumero(){
        return numero;
    }

    public String getDataHorario(){
        return dataHorario;
    }

    public int getProximoAssentoLivre(){
        for(int i = 0; i < assentos.length; i++){
            if(!assentos[i]){
                return i + 1;
            }
        }
        return -1;
    }

    public int getTotalAssentosLivres(){
        int qtd = 0;

        for(int i = 0; i < assentos.length; i++){
            if(!assentos[i]){
                qtd++;
            }
        }
        return qtd;
    }

    public double getTaxaOcupacao(){
        double assentosOcupados = assentos.length - getTotalAssentosLivres();
        return assentosOcupados * 100.0 / assentos.length;
    }

    public boolean isAssentoLivre(int n) throws Exception{
        if(n < 0 || n > assentos.length){
            throw new Exception(n + " não é um numero de assento valido!");
        }
        else{
            return !assentos[n - 1];
        }
    }

    public boolean ocuparAssento(int n) throws Exception{
        if(!isAssentoLivre(n)){
            return false;
        }
        else{
            assentos[n - 1] = true;
            return true;
        }
    }

    public boolean desocuparAssento(int n) throws Exception{
        return assentos[n] = false;
    }

}