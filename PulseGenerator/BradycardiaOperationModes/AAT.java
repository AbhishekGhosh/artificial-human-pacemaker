/*
 * pacemaker
 * (C) Copyright 2013 Federal University of Campina Grande (UFCG)
 * 
 * This file is part of pacemaker.
 *
 * pacemaker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * pacemaker is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with pacemaker.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * REVISION HISTORY:
 * Author                           Date           Brief Description
 * -------------------------------- -------------- ------------------------------
 * Germano Poliano R. Gualberto    10/04/2013     Um dos BOMs
 */
package pacemaker.PulseGenerator.BradycardiaOperationModes;

import javax.realtime.RealtimeThread;

import pacemaker.PulseGenerator.BradycardiaOperationModes.logic.AATlogic;

/**
 * <code>AAT</code> Class. <br>
 * This class is a bradycardia operation mode that run in permanent mode of the pacemaker. 
 * <br>
 * Chambers Paced: (A) Atrium
 * <br>
 * Chambers Sensed: (A) Atrium
 * <br>
 * Response to Sensing: (T) Triggered
 * <br> 
 * @author Germano Poliano Rodrigues Gualberto  ( <a href="mailto:germano.poliano.gualberto@ccc.ufcg.edu.br">germano.poliano.gualberto@ccc.ufcg.edu.br</a> )
 * 
 * @version alpha
 * <br>
 * pacemaker
 * <br>
 * (C) Copyright 2013 Federal University of Campina Grande (UFCG)
 * <br>
 * <a href="criar um site e colocar o endereço aqui">https://sites.google.com(...)</a>
 */
public class AAT extends AOO{

	/**
	 * The sensing threshold of the device for atrial sense channels.
	 */
	//section 3.4.4
	protected double atrialSensitivity;
	
	/**
	 * The time interval following an atrial event during which time atrial events shall not inhibit nor trigger pacing.
	 */
	protected double aRP;
	
	/**
	 * The time interval following a ventricular event when an atrial cardiac event shall not: 
	 * <br>
	 * 1. Inhibit an atrial pace. 
	 * <br>
	 * 2. Trigger a ventricular pace.
	 */
	//section 5.4.3
	protected double pVARP;
	
	/**
	 * Configure the Bradycardia Operation Mode with the specified information.
     * @param lowerRateLimit The Lower Rate Limit (LRL)
     * @param upperRateLimit The Upper Rate Limit (URL)
     * @param atrialAmplitude The amplitude of the atrium pulse
     * @param atrialPulseWidth The Width of the atrium pulse
     * @param atrialSensitivity The Atrial Sensitivity
     * @param aRP The Atrial Refractory Period
     * @param pVARP The Post Vetricular-Atrial Refractory Period
     */
	public AAT(double lowerRateLimit, double upperRateLimit,
			double atrialAmplitude, double atrialPulseWidth,
			double atrialSensitivity, double aRP, double pVARP) {
		
		super(lowerRateLimit, upperRateLimit,
				atrialAmplitude, atrialPulseWidth);
		
		//não entendi onde usar
		this.atrialSensitivity = atrialSensitivity;
		this.aRP = aRP;
		//não entendi onde usar
		this.pVARP = pVARP;
	}

	@Override
	public void run() {
		super.run();
		System.out.println("AAT: Funcionalidade não testada ainda");
		
		RealtimeThread sensingTriggered = new RealtimeThread(null, null, null, null, null, new AATlogic(atrialAmplitude,atrialPulseWidth,aRP));
		
		sensingTriggered.start();
	}
	
	/**
	 * Return the Atrial Sensitivity of the BOM
	 * @return The Atrial Sensitivity
	 */
	public double getAtrialSensitivity() {
		return atrialSensitivity;
	}

	/**
	 * Modify the Atrial Sensitivity of the pacemaker
	 * @param atrialSensitivity The actual Atrial Sensitivity of the current BOM
	 */
	public void setAtrialSensitivity(double atrialSensitivity) {
		this.atrialSensitivity = atrialSensitivity;
	}

	/**
	 * Return the Atrial Refractory Period of the BOM
	 * @return The Atrial Refractory Period
	 */
	public double getARP() {
		return aRP;
	}

	/**
	 * Modify the Atrial Refractory Period of the pacemaker
	 * @param aRP The actual Atrial Refractory Period of the current BOM
	 */
	public void setARP(double aRP) {
		this.aRP = aRP;
	}

	/**
	 * Return the Post Ventricular-Atrial Refractory Period of the BOM
	 * @return The Post Ventricular-Atrial Refractory Period
	 */
	public double getPVARP() {
		return pVARP;
	}

	/**
	 * Modify the Post Ventricular-Atrial Refractory Period of the pacemaker
	 * @param pVARP The actual Post Ventricular-Atrial Refractory Period of the current BOM
	 */
	public void setPVARP(double pVARP) {
		this.pVARP = pVARP;
	}
}
