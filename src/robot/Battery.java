/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

/**
 *
 * @author hbonne03
 */
public class Battery {
    private BatteryType type;
    private int capacity;
    public static final int DEFAULT_CAPACITY = 10;
    
    public Battery(BatteryType t, int c) throws InvalidBatteryCapacityException{
        if(c<=0){
            throw new InvalidBatteryCapacityException();
        }else{
            this.capacity=c;
            this.type=t;
        }
    }
    
    public Battery(BatteryType t) throws InvalidBatteryCapacityException {
        this(t, DEFAULT_CAPACITY);
    }
    
    public boolean isEmpty(){
        return (this.capacity == 0);
    }
    
    public BatteryType getType(){
        return this.type;
    }
    
    public void use(){
        if (this.capacity>0){
            this.capacity--;
        }
    }
            
}
