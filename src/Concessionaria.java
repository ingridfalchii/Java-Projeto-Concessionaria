import java.util.ArrayList;
import java.util.Iterator;

public class Concessionaria {

    //Atributos
    private String nome;
    private ArrayList<Carro> carros;

    //Construtor
    public Concessionaria(String nome){
        this.nome = nome;
        carros = new ArrayList<>();
    }

    //metodo que retorna o nome da concessionaria
    public String getNome(){
        return nome;
    }

    //metodo que imprimi todos os itens ta lista
    public void imprimirCarrosCadastrados() {
        if (carros.isEmpty()) {
            System.out.println("Nenhum carro cadastrado.");
        } else {
            System.out.println("Carros cadastrados:");
            for (Carro carro : carros) {
                System.out.println("Marca: " + carro.getMarca() + ", Ano: " + carro.getAno());
            }
        }
    }
    
    //metodo que verifica se um carro ja esta cadastrado
    public boolean carroEstaCadastrado(String marca){
        for(Carro c : carros){
            if(c.getMarca().equals(marca)){
                return true;
            }
        }
        return false;
    }

    //metodo para add carro na lista
    public boolean cadastraCarro(Carro carro){
        if(!carroEstaCadastrado(carro.getMarca())){
            carros.add(carro);
            return true;
        }
        return false;
    }

    //metodo para buscar carro na lista atraves da marca
    public boolean buscarCarroMarca(String marca){
        for(Carro c : carros){
            if(c.getMarca().equals(marca)){
                return true;
            }
        }
        return false;
    }

    //metodo para buscar carro na lista atraves do ano
    public boolean buscarCarroAno(int ano){
        for(Carro c : carros){
            if(c.getAno() == ano){
                return true;
            }
        }
        return false;
    }

    //metodo de remoçao usando o Iterator
    public boolean removeCarro(String marca){
        Iterator<Carro> iterator = carros.iterator();
        while (iterator.hasNext()) {
            Carro c = iterator.next();
            if (c.getMarca().equals(marca)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}