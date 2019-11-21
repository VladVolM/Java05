/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author alumno
 */
public class CTabla {
    int codB;
    int codD;
    int contador;
    float valorCalculado;
    
    public CTabla(int codB, int codD, int contador, float valorCalculado) {
        this.codB = codB;
        this.codD = codD;
        this.contador = contador;
        this.valorCalculado = valorCalculado;
    }
    
    public int getCodB() {
        return codB;
    }

    public int getCodD() {
        return codD;
    }

    public int getContador() {
        return contador;
    }

    public float getValorCalculado() {
        return valorCalculado;
    }
}
