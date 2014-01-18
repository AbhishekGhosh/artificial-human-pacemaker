package pacemaker.PulseGenerator.BradycardiaOperationModes.logic;

import pacemaker.PulseGenerator.PacingPulse;
import pacemaker.PulseGenerator.SensingPulse;

public class AATlogic implements Runnable{

	private double amplitude; 
	private double pulseWidth;
	private double aRP;
	
	public AATlogic(double amplitude, double pulseWidth, double aRP){
		this.amplitude = amplitude; 
		this.pulseWidth = pulseWidth;
		this.aRP = aRP;
	}
	
	@Override
	public void run() {
		//falta definir os periodos refratarios
		if (SensingPulse.atrialSensing()){
			//trigger the action
			PacingPulse.atrialPacing(amplitude, pulseWidth);
		}
		
	}

}
