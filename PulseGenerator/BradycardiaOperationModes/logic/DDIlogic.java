package pacemaker.PulseGenerator.BradycardiaOperationModes.logic;

import pacemaker.PulseGenerator.PacingPulse;
import pacemaker.PulseGenerator.SensingPulse;

public class DDIlogic implements Runnable {

	private double atrialAmplitude;
	private double atrialPulseWidth;
	private double ventricularAmplitude;
	private double ventricularPulseWidth;
	
	public DDIlogic(double atrialAmplitude, double atrialPulseWidth,
			double ventricularAmplitude, double ventricularPulseWidth){
		
		this.atrialAmplitude = atrialAmplitude;
		this.atrialPulseWidth = atrialPulseWidth;
		this.ventricularAmplitude = ventricularAmplitude;
		this.ventricularPulseWidth = ventricularPulseWidth;
	}
	
	@Override
	public void run() {
		if (SensingPulse.atrialSensing()){
			//inhibite the action
			PacingPulse.atrialPacing(atrialAmplitude, atrialPulseWidth);
		}
		
		//falta definir os periodos refratarios
		if (SensingPulse.ventricularSensing()){
			//trigger the action
			PacingPulse.ventricularPacing(ventricularAmplitude, ventricularPulseWidth);
		}
		
	}

}
