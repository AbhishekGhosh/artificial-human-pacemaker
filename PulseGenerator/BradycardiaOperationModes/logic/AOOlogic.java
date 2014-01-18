package pacemaker.PulseGenerator.BradycardiaOperationModes.logic;

import pacemaker.PulseGenerator.PacingPulse;

public class AOOlogic implements Runnable {

	private double atrialAmplitude;
	private double atrialPulseWidth;
	
	public AOOlogic(double atrialAmplitude, double atrialPulseWidth){
		this.atrialAmplitude = atrialAmplitude;
		this.atrialPulseWidth = atrialPulseWidth;
	}
	
	@Override
	public void run() {
		PacingPulse.atrialPacing(atrialAmplitude,atrialPulseWidth);
		
	}

}
