/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nelson Matsinhe
 */
import com.sun.istack.NotNull;
import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull
    @Column(name = "nuit", nullable = false, unique = true)
    private String nuit;

    @Column(name = "morada")
    private String morada;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "licenca_comercial", unique = true)
    private String licencaComercial;

    @Column(name = "banco")
    private String banco;

    @Column(name = "iban")
    private String iban;

    @Column(name = "data_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistro;

    // Getters e Setters
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

    public String getNuit() {
        return nuit;
    }

    public void setNuit(String nuit) {
        this.nuit = nuit;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicencaComercial() {
        return licencaComercial;
    }

    public void setLicencaComercial(String licencaComercial) {
        this.licencaComercial = licencaComercial;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
