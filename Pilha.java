package avaliadorexpressao;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author fabio.aglubacheski
 */
public class Pilha {
    private char elementos[];
    private int topo;

    public Pilha(int N) {
        this.elementos = new char[N];
        this.topo = -1;//pilha
    }
    void push(char e){
        
        //topo++;
        this.elementos[++this.topo]=e;
    }
    char pop(){
        return elementos[topo--];
    }
    boolean isEmpty(){
        return this.topo == -1;
    }
    char pegaTopo(){
            return elementos[topo];
    }

    
}
