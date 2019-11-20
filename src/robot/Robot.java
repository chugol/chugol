/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hbonne03
 */
public class Robot {

    private String name;
    private boolean on;
    private int nbPiles;
    private List<Battery> piles;
    private BatteryType bt;
    
    public Robot(String s,int nb,BatteryType t) throws InvalidBatteryCapacityException, InvalidNbBatteryException{
        if(nb<=0){
            throw new InvalidNbBatteryException();
        }else{
            this.name=s;
            this.on=false;
            piles = new ArrayList();
            Battery b = new Battery(t);
            nbPiles=nb;
            bt=t;
            for(int i=0; i<nbPiles; i++){
                piles.add(b);
            }
        }
    }
    
    public void allumer(){
        this.on = true;
    }
    
    public void eteindre(){
        this.on=false;
    }
    
    public void showName(){
        if(this.on==true){
            System.out.println(this.name);
            for(Battery b : piles){
                b.use();
            }
        }
    }
    
    public boolean remplacerPile(int k, Battery b) throws InvalidBatteryTypeException{
        if(b.getType()!=bt){
            throw new InvalidBatteryTypeException();
        }else{
            if(k<nbPiles){
                piles.set(k, b);
                return true;
            }
            return false;
        }
    }
    
    public int[] showListHS(){
        int[] posPilesHS=new int[this.nbPiles];
        int i = 0;
        for(Battery b : piles){
            if(b.isEmpty()){
                posPilesHS[i]=piles.indexOf(b);
                i++;
            }
        }
        return posPilesHS;
    }
}
