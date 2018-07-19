package com.sino.pattern.adapter;


import com.sino.beans.ChinaesePower;
import com.sino.beans.CommonPower;
import com.sino.beans.IphonePower;
import com.sino.beans.JapanesePower;

/**
 * 适配器设计模式
 *
 */
public class PowerAdapter extends  IphonePower{

	public static void main(String[] args) {
		
		/**
		 * 适配中国电源
		 */
		ChinaesePower chinaesePower = new ChinaesePower(220, 220);
		
		IphonePower transToIphonePower = transToIphonePower(chinaesePower);
		System.out.println(transToIphonePower);
		
		
		/**
		 * 适配日本电源
		 */
		JapanesePower japanesePower = new JapanesePower(110,110);
		IphonePower transToIphonePower2 = transToIphonePower(japanesePower);
		System.out.println(transToIphonePower2);
		
		
	}
	
	
	
	

//    private  JapanesePower japanesePower;
//    private  ChinaesePower chinaesePower;

    public static IphonePower transToIphonePower( CommonPower power){

        IphonePower iphonePower = new IphonePower();

        if(power instanceof  JapanesePower){

            iphonePower.setVoltage(((JapanesePower) power).getVoltage()/22);
            iphonePower.setCurrent(((JapanesePower) power).getCurrent()/22);
            return iphonePower;
        }else if(power instanceof ChinaesePower){
        	  iphonePower.setVoltage(((ChinaesePower) power).getVoltage()/44);
              iphonePower.setCurrent(((ChinaesePower) power).getCurrent()/44);
            return iphonePower;
        }
        
        return null;


    }




}
