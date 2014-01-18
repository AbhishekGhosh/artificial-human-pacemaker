package pacemaker.PulseGenerator.BradycardiaOperationModes.logic;

import pacemaker.PulseGenerator.PacingPulse;

public class VOOlogic implements Runnable {

	private double ventricularAmplitude;
	private double ventricularPulseWidth;
	
	public VOOlogic(double ventricularAmplitude, double ventricularPulseWidth){
		this.ventricularAmplitude = ventricularAmplitude;
		this.ventricularPulseWidth = ventricularPulseWidth;
	}
	
	@Override
	public void run() {
		PacingPulse.ventricularPacing(ventricularAmplitude,ventricularPulseWidth);
		
	}

}