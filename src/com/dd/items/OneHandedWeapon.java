package com.dd.items;

public class OneHandedWeapon extends Physical {
	
	protected int attackGain;
	
    public OneHandedWeapon(String name, int attackGain) {
        super(name, attackGain, 0);
        this.attackGain = attackGain;
        
    }
    
    public void setStatForWizard() {
    	attackGain -= 2;
    	if(attackGain < 1){
    		attackGain = 1;
    	}
    	super.setStatChange(0, 0, attackGain, 0);
    }
    
    @Override
    public String getType() {
		return "One Handed Weapon";
	}
}