package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.NamedQuery;

@Entity
@NamedQuery(name = "Funcionario.pesquisarPorNome", query="SELECT f FROM Funcionario f WHERE f.nome like CONCAT('%', :nome, '%')")
public class Funcionario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String salario;

    public Funcionario() {
    }

    public Funcionario(String nome, String email, String telefone, String salario) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.salario = salario;
    }

    public String getSalario() {
        return salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setSalario(String salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return id + " | " + nome + " | " +  email + " | " + telefone + " | " + salario;
    }   

}

