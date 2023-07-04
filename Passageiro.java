import java.util.ArrayList;

public class Passageiro{
    protected String nome, sobrenome, cpf;
    protected int idade, sexo;
    protected String faixaEtaria, sexoTemp;
    protected int numeroReserva;

    public Passageiro(String nome, String sobrenome, String cpf, int idade, int sexo, int numeroReserva){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.numeroReserva = numeroReserva;

        if(idade < 12){
            faixaEtaria = "criança";
        }
        else if(idade >= 12 && idade < 18){
            faixaEtaria = "adolescente";
        }
        else if(idade >= 18 && idade < 59){
            faixaEtaria = "adulto";
        }
        else{
            faixaEtaria = "idoso";
        }

        if(sexo == 1){
            sexoTemp = "masculino";
        }
        else if(sexo == 2){
            sexoTemp = "feminino";
        }
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getSobrenome(){
        return sobrenome;
    }

    public void setSobrenome(String sobrenome){
        this.sobrenome = sobrenome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getSexo(){
        return sexo;
    }

    public void setSexo(int sexo){
        this.sexo = sexo;
    }

    public int getnumeroReserva(){
        return numeroReserva;
    }

    public void setnumeroReserva(int numeroReserva){
        this.numeroReserva = numeroReserva;
    }

    public String getFaixaEtaria(){
        return faixaEtaria;
    }

    public String toString(){
        return ("nome: " + nome + " " + sobrenome + " / idade: " + idade + " / cpf: " + cpf + " / faixa etaria: " + faixaEtaria + " / sexo: " + sexoTemp + " / codigo pessoal de reserva: " + numeroReserva);
    }

}