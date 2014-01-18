package pacemaker.PulseGenerator.BradycardiaOperationModes.logic;

import pacemaker.PulseGenerator.PacingPulse;

public class DOOlogic implements Runnable {

	private double atrialAmplitude;
	private double atrialPulseWidth;
	private double ventricularAmplitude;
	private double ventricularPulseWidth;
	
	public DOOlogic(double atrialAmplitude, double atrialPulseWidth,
			double ventricularAmplitude, double ventricularPulseWidth){
		
		this.atrialAmplitude = atrialAmplitude;
		this.atrialPulseWidth = atrialPulseWidth;
		this.ventricularAmplitude = ventricularAmplitude;
		this.ventricularPulseWidth = ventricularPulseWidth;
	}
	
	@Override
	public void run() {
		PacingPulse.atrialPacing(atrialAmplitude,atrialPulseWidth);
		PacingPulse.ventricularPacing(ventricularAmplitude, ventricularPulseWidth);
		
	}

}
