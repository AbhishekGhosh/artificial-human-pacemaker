package pacemaker.PulseGenerator.BradycardiaOperationModes.logic;

import pacemaker.PulseGenerator.PacingPulse;
import pacemaker.PulseGenerator.SensingPulse;

public class VVTlogic implements Runnable{

	private double amplitude; 
	private double pulseWidth;
	private double vRP;
	
	public VVTlogic(double amplitude, double pulseWidth, double vRP){
		this.amplitude = amplitude; 
		this.pulseWidth = pulseWidth;
		this.vRP = vRP;
	}
	
	@Override
	public void run() {
		//falta definir os periodos refratarios
		if (SensingPulse.ventricularSensing()){
			//trigger the action
			PacingPulse.ventricularPacing(amplitude, pulseWidth);
		}
		
	}

}
