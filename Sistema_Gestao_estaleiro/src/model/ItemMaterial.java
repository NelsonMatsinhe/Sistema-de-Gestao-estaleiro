/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author Nelson Matsinhe
 */
public class ItemMaterial {

    int Codigo;
    private Material material;
    private double quantidade;

    public ItemMaterial() {
    }

    public ItemMaterial(Material material, double quantidade) {
        this.material = material;
        this.quantidade = quantidade;
    }

    // Getters e setters

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.material);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.quantidade) ^ (Double.doubleToLongBits(this.quantidade) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ItemMaterial) {
            ItemMaterial iv = (ItemMaterial) o;
            if (iv.getCodigo() == this.getCodigo()) {
                return true;
            }
        }
        return false;
    }


}
