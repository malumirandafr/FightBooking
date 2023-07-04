import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        final int TAM1 = 50;
        final int TAM2 = 30;
        int op = 0;
        int x = 0;
        Random gerador = new Random();
        ArrayList<Passageiro> passageiros1797 = new ArrayList<Passageiro>();
        ArrayList<Passageiro> passageiros4163 = new ArrayList<Passageiro>();
        ArrayList<Passageiro> passageiros1865 = new ArrayList<Passageiro>();
        ArrayList<Passageiro> passageiros4164 = new ArrayList<Passageiro>();
        Scanner entrada = new Scanner(System.in);
        Voo v1797 = new Voo(1797, "07:45", TAM1);
        Voo v4163 = new Voo(4163, "11:10", TAM2);
        Voo v1865 = new Voo(1865, "06:05", TAM1);
        Voo v4164 = new Voo(4164, "16:45", TAM2);
        Arquivo arquivo = new Arquivo();

        do{
            System.out.println("******************* MENU *******************");
            System.out.println("1 - Consultar disponibilidade de assento");
            System.out.println("2 - Reservar assento");
            System.out.println("3 - Cancelar reserva");
            System.out.println("4 - Consultar assentos disponiveis");
            System.out.println("5 - Consultar taxa de ocupacao");
            System.out.println("6 - Consultar Passageiros de determinado voo");
            System.out.println("7 - Encerrar operacao");
            System.out.println("********************************************");
            System.out.print("Informe Codigo Operacao (1-7): ");
            op = entrada.nextInt();
            System.out.println();

            switch(op){

                case 1:
                    System.out.println("Informe o destino e o horario do voo: ");
                    System.out.println("1 - Destino: Local A / Saida as 06:05, chegada as 07:20");
                    System.out.println("2 - Destino: Local A / Saida as 16:45, chegada as 17:40");
                    System.out.println("3 - Destino: Local B / Saidas as 07:45, chegada as 08:55");
                    System.out.println("4 - Destino: Local B / Saida as 11:10, chegada as 12:05");
                    x = entrada.nextInt();
                    System.out.println();

                    switch(x){
                        case 1:
                            System.out.println("Informe o assento (1 - " + TAM1 + "):");
                            int n = entrada.nextInt();

                            try{
                                if(v1865.isAssentoLivre(n)){
                                    System.out.println("Assento livre");
                                    System.out.println();
                                }
                                else{
                                    System.out.println("Assento ocupado");
                                    System.out.println();
                                }
                            }
                            catch(Exception e){
                                System.out.println("" + e.getMessage() + "");
                            }
                            break;

                        case 2:
                            System.out.println("Informe o assento (1 - " + TAM2 + "):");
                            n = entrada.nextInt();

                            try{
                                if(v4164.isAssentoLivre(n)){
                                    System.out.println("Assento livre");
                                }
                                else{
                                    System.out.println("Assento ocupado");
                                }
                            }
                            catch(Exception e){
                                System.out.println("" + e.getMessage() + "");
                            }
                            break;

                        case 3:
                            System.out.println("Informe o assento (1 - " + TAM1 + "):");
                            n = entrada.nextInt();

                            try{
                                if(v1797.isAssentoLivre(n)){
                                    System.out.println("Assento livre");
                                    System.out.println();
                                }
                                else{
                                    System.out.println("Assento ocupado");
                                    System.out.println();
                                }
                            }
                            catch(Exception e){
                                System.out.println("" + e.getMessage() + "");
                            }
                            break;

                        case 4:
                            System.out.println("Informe o assento (1 - " + TAM2 + "):");
                            n = entrada.nextInt();

                            try{
                                if(v4163.isAssentoLivre(n)){
                                    System.out.println("Assento livre");
                                }
                                else{
                                    System.out.println("Assento ocupado");
                                }
                            }
                            catch(Exception e){
                                System.out.println("" + e.getMessage() + "");
                            }
                            break;
                    }
                    break;

                case 2:
                    System.out.println("Informe o destino e o horario do voo: ");
                    System.out.println("1 - Destino: Local A / Saida as 06:05, chegada as 07:20");
                    System.out.println("2 - Destino: Local A / Saida as 16:45, chegada as 17:40");
                    System.out.println("3 - Destino: Local B / Saidas as 07:45, chegada as 08:55");
                    System.out.println("4 - Destino: Local B / Saida as 11:10, chegada as 12:05");
                    x = entrada.nextInt();
                    System.out.println();

                    switch(x){
                        case 1:
                            System.out.println("Informe o assento (1 - " + TAM1 + "):");
                            int n = entrada.nextInt();

                            try{
                                if(v1865.ocuparAssento(n)){
                                    System.out.println("Informe o primeiro nome do Passageiro:");
                                    String nome = entrada.next();
                                    System.out.println("Informe o sobrenome do Passageiro:");
                                    String sobrenome = entrada.next();
                                    System.out.println("Informe o cpf do Passageiro (apenas numeros):");
                                    String cpf = entrada.next();

                                    if(passageiros1865 != null && !passageiros1865.isEmpty()) {
                                        passageiros1865.forEach(passageiro -> {
                                            if(passageiro.cpf.equals(cpf)) {
                                                throw new RuntimeException("CPF JA CADASTRADO! Você será redirecionado para o menu principal.");
                                            }
                                        });
                                    }

                                    System.out.println("Informe a idade do Passageiro:");
                                    int idade = entrada.nextInt();
                                    System.out.println("Informe o sexo do Passageiro:");
                                    System.out.println("1 - Masculino:");
                                    System.out.println("2 - Feminino:");
                                    int sexo = entrada.nextInt();
                                    System.out.println();
                                    int numeroReserva = gerador.nextInt(899) + 100;

                                    Passageiro p = new Passageiro(nome, sobrenome, cpf, idade, sexo, numeroReserva);
                                    passageiros1865.add(p);

                                    System.out.println("Assento ocupado pelo passgeiro:");
                                    System.out.println(p.toString() + " / assento: " + n + " / numero de voo" + v1865.getNumero());
                                    System.out.println();
                                }
                                else{
                                    System.out.println("Assento já ocupado");
                                    System.out.println();

                                }
                            }
                            catch(Exception e){
                                System.out.println("" + e.getMessage() + "");
                            }
                            break;

                        case 2:
                            System.out.println("Informe o assento (1 - " + TAM2 + "):");
                            n = entrada.nextInt();

                            try{
                                if(v4164.isAssentoLivre(n)){
                                    System.out.println("Informe o primeiro nome do Passageiro:");
                                    String nome = entrada.next();
                                    System.out.println("Informe o sobrenome do Passageiro:");
                                    String sobrenome = entrada.next();
                                    System.out.println("Informe o cpf do Passageiro (apenas numeros):");
                                    String cpf = entrada.next();
                                    System.out.println("Informe a idade do Passageiro:");
                                    int idade = entrada.nextInt();
                                    System.out.println("Informe o sexo do Passageiro:");
                                    System.out.println("1 - Masculino");
                                    System.out.println("2 - Feminino");
                                    int sexo = entrada.nextInt();
                                    System.out.println();
                                    int numeroReserva = gerador.nextInt(899) + 100;

                                    Passageiro a = new Passageiro(nome, sobrenome, cpf, idade, sexo, numeroReserva);
                                    passageiros4164.add(a);

                                    System.out.println("Assento ocupado pelo passgeiro:");
                                    System.out.println(a.toString() + " / assento: " + n + " / numero de voo" + v4164.getNumero());
                                    System.out.println();
                                }
                                else{
                                    System.out.println("Assento já ocupado");
                                    System.out.println();
                                }
                            }
                            catch(Exception e){
                                System.out.println("" + e.getMessage() + "");
                            }
                            break;

                        case 3:
                            System.out.println("Informe o assento (1 - " + TAM1 + "):");
                            n = entrada.nextInt();

                            try{
                                if(v1797.ocuparAssento(n)){
                                    System.out.println("Informe o primeiro nome do Passageiro:");
                                    String nome = entrada.next();
                                    System.out.println("Informe o sobrenome do Passageiro:");
                                    String sobrenome = entrada.next();
                                    System.out.println("Informe o cpf do Passageiro (apenas numeros):");
                                    String cpf = entrada.next();
                                    System.out.println("Informe a idade do Passageiro:");
                                    int idade = entrada.nextInt();
                                    System.out.println("Informe o sexo do Passageiro:");
                                    System.out.println("1 - Masculino:");
                                    System.out.println("2 - Feminino:");
                                    int sexo = entrada.nextInt();
                                    System.out.println();
                                    int numeroReserva = gerador.nextInt(899) + 100;

                                    Passageiro a = new Passageiro(nome, sobrenome, cpf, idade, sexo, numeroReserva);
                                    passageiros1797.add(a);

                                    System.out.println("Assento ocupado pelo passgeiro:");
                                    System.out.println(a.toString() + " / assento: " + n + " / numero de voo" + v1797.getNumero());
                                    System.out.println();
                                }
                                else{
                                    System.out.println("Assento já ocupado");
                                    System.out.println();
                                }
                            }
                            catch(Exception e){
                                System.out.println("" + e.getMessage() + "");
                            }
                            break;

                        case 4:
                            System.out.println("Informe o assento (1 - " + TAM2 + "):");
                            n = entrada.nextInt();

                            try{
                                if(v4163.isAssentoLivre(n)){
                                    System.out.println("Informe o primeiro nome do Passageiro:");
                                    String nome = entrada.next();
                                    System.out.println("Informe o sobrenome do Passageiro:");
                                    String sobrenome = entrada.next();
                                    System.out.println("Informe o cpf do Passageiro (apenas numeros):");
                                    String cpf = entrada.next();
                                    System.out.println("Informe a idade do Passageiro:");
                                    int idade = entrada.nextInt();
                                    System.out.println("Informe o sexo do Passageiro:");
                                    System.out.println("Informe o sexo do Passageiro (1 - Masculino):");
                                    System.out.println("Informe o sexo do Passageiro (2 - Feminino):");
                                    int sexo = entrada.nextInt();
                                    System.out.println();
                                    int numeroReserva = gerador.nextInt(899) + 100;

                                    Passageiro a = new Passageiro(nome, sobrenome, cpf, idade, sexo, numeroReserva);
                                    passageiros4163.add(a);

                                    System.out.println("Assento reservado para o Passageiro:");
                                    System.out.println(a.toString()  + " / assento: " + n + " / numero de voo" + v4163.getNumero());
                                    System.out.println();
                                }
                                else{
                                    System.out.println("Assento já ocupado");
                                    System.out.println();
                                }
                            }
                            catch(Exception e){
                                System.out.println("" + e.getMessage() + "");
                            }
                            break;
                    }
                    break;

                case 3:
                    System.out.println("Informe o numero do voo cujo cadastro será cancelado:");
                    System.out.println("1 - 1797");
                    System.out.println("2 - 4163");
                    System.out.println("3 - 1865");
                    System.out.println("4 - 4164");
                    x = entrada.nextInt();

                    switch(x){
                        case 1:
                            System.out.println("Informe o cpf do Passageiro:");
                            String cpfTemp = entrada.next();

                            try{
                                for(int i = 0; i < passageiros1797.size() ; i++){
                                    if(cpfTemp.equals(passageiros1797.get(i).getCpf())){
                                        System.out.println("Reserva do Passageiro: " + passageiros4164.get(i).toString() + " cancelada com sucesso");
                                        passageiros1797.remove(i);
                                        v1797.desocuparAssento(i);
                                    }
                                    else{
                                        System.out.println("Passageiro informado não se encontra neste voo");
                                    }
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            break;

                        case 2:
                            System.out.println("Informe o cpf do Passageiro:");
                            cpfTemp = entrada.next();

                            try{
                                for(int i = 0; i < passageiros4163.size() ; i++){
                                    if(cpfTemp.equals(passageiros4163.get(i).getCpf())){
                                        System.out.println("Reserva do Passageiro: " + passageiros4163.get(i).toString() + " cancelada com sucesso");
                                        passageiros4163.remove(i);
                                        v4163.desocuparAssento(i);
                                    }
                                    else{
                                        System.out.println("Passageiro informado não se encontra neste voo");
                                    }
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            break;

                        case 3:
                            System.out.println("Informe o cpf do Passageiro:");
                            cpfTemp = entrada.next();

                            try{
                                for(int i = 0; i < passageiros1865.size() ; i++){
                                    if(cpfTemp.equals(passageiros1865.get(i).getCpf())){
                                        System.out.println("Reserva do Passageiro: " + passageiros1865.get(i).toString() + " cancelada com sucesso");
                                        passageiros1865.remove(i);
                                        v1865.desocuparAssento(i);
                                    }
                                    else{
                                        System.out.println("Passageiro informado não se encontra neste voo");
                                    }
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            break;

                        case 4:
                            System.out.println("Informe o cpf do Passageiro:");
                            cpfTemp = entrada.next();

                            try{
                                for(int i = 0; i < passageiros4164.size() ; i++){
                                    if(cpfTemp.equals(passageiros4164.get(i).getCpf())){
                                        System.out.println("Reserva do Passageiro: " + passageiros4164.get(i).toString() + " cancelada com sucesso");
                                        passageiros4164.remove(i);
                                        v4164.desocuparAssento(i);
                                    }
                                    else{
                                        System.out.println("Passageiro informado não se encontra neste voo");
                                    }
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                            break;
                    }
                    break;

                case 4:
                    System.out.println("Informe o voo para consulta de assentos:");
                    System.out.println("1 - Destino: Local A / Saida as 06:05, chegada as 07:20 / numero do voo: 1865");
                    System.out.println("2 - Destino: Local A / Saida as 16:45, chegada as 17:40 / numero do voo: 4164");
                    System.out.println("3 - Destino: Local B / Saidas as 07:45, chegada as 08:55 / numero do voo: 1797");
                    System.out.println("4 - Destino: Local B / Saida as 11:10, chegada as 12:05 / numero do voo: 4163");
                    x = entrada.nextInt();
                    System.out.println();

                    switch(x){
                        case 1:
                            System.out.println(v1865.getTotalAssentosLivres());
                            break;

                        case 2:
                            System.out.println(v4164.getTotalAssentosLivres());
                            break;

                        case 3:
                            System.out.println(v1797.getTotalAssentosLivres());
                            break;

                        case 4:
                            System.out.println(v4163.getTotalAssentosLivres());
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Informe o voo para consulta da taxa de ocupacao:");
                    System.out.println("1 - Destino: Local A / Saida as 06:05, chegada as 07:20 / numero do voo: 1865");
                    System.out.println("2 - Destino: Local A / Saida as 16:45, chegada as 17:40 / numero do voo: 4164");
                    System.out.println("3 - Destino: Local B / Saidas as 07:45, chegada as 08:55 / numero do voo: 1797");
                    System.out.println("4 - Destino: Local B / Saida as 11:10, chegada as 12:05 / numero do voo: 4163");
                    x = entrada.nextInt();
                    System.out.println();

                    switch(x){
                        case 1:
                            System.out.println(v1865.getTaxaOcupacao() + "%. Destes: ");

                            for(int i = 0; i < passageiros1865.size(); i++){
                                if(passageiros1865.get(i).getSexo() == 1){
                                    int contM = 0;
                                    contM++;

                                    System.out.println("pessoas do sexo masculino: " + contM);
                                    System.out.println();
                                }
                                else if(passageiros1865.get(i).getSexo() == 2){
                                    int contF = 0;
                                    contF++;

                                    System.out.println("pessoas do sexo feminino: " + contF);
                                    System.out.println();
                                }
                            }

                            for(int i = 0; i < passageiros1865.size(); i++){
                                if(passageiros1865.get(i).getFaixaEtaria() == "criança"){
                                    int contCrianca = 0;
                                    contCrianca++;

                                    System.out.println("crianças: " + contCrianca);
                                    System.out.println();
                                }
                                else if(passageiros1865.get(i).getFaixaEtaria() == "adolescente"){
                                    int contAdolescente = 0;
                                    contAdolescente++;

                                    System.out.println("adolescentes: " + contAdolescente);
                                    System.out.println();
                                }
                                else if(passageiros1865.get(i).getFaixaEtaria() == "adulto"){
                                    int contAdulto = 0;
                                    contAdulto++;

                                    System.out.println("adultos: " + contAdulto);
                                    System.out.println();
                                }
                                else if(passageiros1865.get(i).getFaixaEtaria() == "idoso"){
                                    int contIdoso = 0;
                                    contIdoso++;

                                    System.out.println("idosos: " + contIdoso);
                                    System.out.println();
                                }
                            }
                            break;

                        case 2:
                            System.out.println(v4164.getTaxaOcupacao() + "%. Destes: ");

                            for(int i = 0; i < passageiros4164.size(); i++){
                                if(passageiros4164.get(i).getSexo() == 1){
                                    int contM = 0;
                                    contM++;

                                    System.out.println("pessoas do sexo masculino: " + contM);
                                    System.out.println();
                                }
                                else if(passageiros4164.get(i).getSexo() == 2){
                                    int contF = 0;
                                    contF++;

                                    System.out.println("pessoas do sexo feminino: " + contF);
                                    System.out.println();
                                }
                            }

                            for(int i = 0; i < passageiros4164.size(); i++){
                                if(passageiros4164.get(i).getFaixaEtaria() == "criança"){
                                    int contCrianca = 0;
                                    contCrianca++;

                                    System.out.println("crianças: " + contCrianca);
                                    System.out.println();
                                }
                                else if(passageiros4164.get(i).getFaixaEtaria() == "adolescente"){
                                    int contAdolescente = 0;
                                    contAdolescente++;

                                    System.out.println("adolescentes: " + contAdolescente);
                                    System.out.println();
                                }
                                else if(passageiros4164.get(i).getFaixaEtaria() == "adulto"){
                                    int contAdulto = 0;
                                    contAdulto++;

                                    System.out.println("adultos: " + contAdulto);
                                    System.out.println();
                                }
                                else if(passageiros4164.get(i).getFaixaEtaria() == "idoso"){
                                    int contIdoso = 0;
                                    contIdoso++;

                                    System.out.println("idosos: " + contIdoso);
                                    System.out.println();
                                }
                            }
                            break;

                        case 3:
                            System.out.println(v1797.getTaxaOcupacao() + "%. Destes: ");

                            for(int i = 0; i < passageiros1797.size(); i++){
                                if(passageiros1797.get(i).getSexo() == 1){
                                    int contM = 0;
                                    contM++;

                                    System.out.println("pessoas do sexo masculino: " + contM);
                                    System.out.println();
                                }
                                else if(passageiros1797.get(i).getSexo() == 2){
                                    int contF = 0;
                                    contF++;

                                    System.out.println("pessoas do sexo feminino: " + contF);
                                    System.out.println();
                                }
                            }

                            for(int i = 0; i < passageiros1797.size(); i++){
                                if(passageiros1797.get(i).getFaixaEtaria() == "criança"){
                                    int contCrianca = 0;
                                    contCrianca++;

                                    System.out.println("crianças: " + contCrianca);
                                    System.out.println();
                                }
                                else if(passageiros1797.get(i).getFaixaEtaria() == "adolescente"){
                                    int contAdolescente = 0;
                                    contAdolescente++;

                                    System.out.println("adolescentes: " + contAdolescente);
                                    System.out.println();
                                }
                                else if(passageiros1797.get(i).getFaixaEtaria() == "adulto"){
                                    int contAdulto = 0;
                                    contAdulto++;

                                    System.out.println("adultos: " + contAdulto);
                                    System.out.println();
                                }
                                else if(passageiros1797.get(i).getFaixaEtaria() == "idoso"){
                                    int contIdoso = 0;
                                    contIdoso++;

                                    System.out.println("idosos: " + contIdoso);
                                    System.out.println();
                                }
                            }
                            break;

                        case 4:
                            System.out.println(v4163.getTaxaOcupacao() + "%. Destes: ");

                            for(int i = 0; i < passageiros4163.size(); i++){
                                if(passageiros4163.get(i).getSexo() == 1){
                                    int contM = 0;
                                    contM++;

                                    System.out.println("pessoas do sexo masculino: " + contM);
                                    System.out.println();
                                }
                                else if(passageiros4163.get(i).getSexo() == 2){
                                    int contF = 0;
                                    contF++;

                                    System.out.println("pessoas do sexo feminino: " + contF);
                                    System.out.println();
                                }
                            }

                            for(int i = 0; i < passageiros4163.size(); i++){
                                if(passageiros4163.get(i).getFaixaEtaria() == "criança"){
                                    int contCrianca = 0;
                                    contCrianca++;

                                    System.out.println("crianças: " + contCrianca);
                                    System.out.println();
                                }
                                else if(passageiros4163.get(i).getFaixaEtaria() == "adolescente"){
                                    int contAdolescente = 0;
                                    contAdolescente++;

                                    System.out.println("adolescentes: " + contAdolescente);
                                    System.out.println();
                                }
                                else if(passageiros4163.get(i).getFaixaEtaria() == "adulto"){
                                    int contAdulto = 0;
                                    contAdulto++;

                                    System.out.println("adultos: " + contAdulto);
                                    System.out.println();
                                }
                                else if(passageiros4163.get(i).getFaixaEtaria() == "idoso"){
                                    int contIdoso = 0;
                                    contIdoso++;

                                    System.out.println("idosos: " + contIdoso);
                                    System.out.println();
                                }
                            }
                            break;
                    }
                    break;

                case 6:
                    System.out.println("Informe o voo para consulta de Passageiros:");
                    System.out.println("1 - Destino: Local A / Saida as 06:05, chegada as 07:20 / numero do võo: 1865");
                    System.out.println("2 - Destino: Local A / Saida as 16:45, chegada as 17:40 / numero do voo: 4164");
                    System.out.println("3 - Destino: Local B / Saidas as 07:45, chegada as 08:55 / numero do voo: 1797");
                    System.out.println("4 - Destino: Local B / Saida as 11:10, chegada as 12:05 / numero do voo: 4163");
                    x = entrada.nextInt();
                    System.out.println();

                    switch(x){
                        case 1:
                            for(int i = 0; i < passageiros1865.size(); i++){
                                System.out.println(passageiros1865.get(i).toString());
                                System.out.println();
                            }
                            break;

                        case 2:
                            for(int i = 0; i < passageiros4164.size(); i++){
                                System.out.println(passageiros4164.get(i).toString());
                                System.out.println();
                            }
                            break;

                        case 3:
                            for(int i = 0; i < passageiros1797.size(); i++){
                                System.out.println(passageiros1797.get(i).toString());
                                System.out.println();
                            }
                            break;

                        case 4:
                            for(int i = 0; i < passageiros4163.size(); i++){
                                System.out.println(passageiros4163.get(i).toString());
                                System.out.println();
                            }
                            break;
                    }
                    break;

            }

            arquivo.salvarPassageiros(passageiros1865);
        }
        while (op != 7);
        entrada.close();
    }
}