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
public class PilhaFloat {
    private float elementos[];
    private int topo;

    public PilhaFloat(int N) {
        this.elementos = new float[N];
        this.topo = -1;//pilha
    }
    void push(float e){
        
        //topo++;
        this.elementos[++this.topo]=e;
    }
    float pop(){
        return elementos[topo--];
    }
    boolean isEmpty(){
        return this.topo == -1;
    }
    float pegaTopo(){
            return elementos[topo];
    }

    
}
