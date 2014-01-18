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
 * <code>VVT</code> Class. <br>
 * This class is a bradycardia operation mode that run in permanent mode of the pacemaker. 
 * <br>
 * Chambers Paced: (V) Ventriculum
 * <br>
 * Chambers Sensed: (V) Ventriculum
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
public class VVT extends VOO{
	
	/**
	 * The sensing threshold of the device for ventriculum sense channels.
	 */
	//section 3.4.4
	protected double ventricularSensitivity;
	
	/**
	 * The time interval following an ventricular event during which time ventriculum events shall not inhibit nor trigger pacing.
	 */
	protected double vRP;

	/**
	 * Configure the Bradycardia Operation Mode with the specified information.
     * @param lowerRateLimit The Lower Rate Limit (LRL)
     * @param upperRateLimit The Upper Rate Limit (URL)
     * @param ventricularAmplitude The amplitude of the ventriculum pulse
     * @param ventricularPulseWidth The Width of the ventriculum pulse
     * @param ventricularSensitivity The Ventricular Sensitivity
     * @param vRP The Ventricular Refractory Period
     */
	public VVT(double lowerRateLimit, double upperRateLimit,
			double ventricularAmplitude, double ventricularPulseWidth,
			double ventricularSensitivity, double vRP) {
		
		super(lowerRateLimit, upperRateLimit,
				ventricularAmplitude, ventricularPulseWidth);
		
		this.ventricularSensitivity = ventricularSensitivity;
		this.vRP = vRP;
	}

	@Override
	public void run() {
		super.run();
		System.out.println("VVT: Funcionalidade não testada ainda");
		
		RealtimeThread sensingTriggered = new RealtimeThread(null, null, null, null, null, new AATlogic(ventricularAmplitude,ventricularPulseWidth,vRP));
		
		sensingTriggered.start();
	}
	
	/**
	 * Return the Ventricular Sensitivity of the BOM
	 * @return The Ventricular Sensitivity
	 */
	public double getVentricularSensitivity() {
		return ventricularSensitivity;
	}

	/**
	 * Modify the Ventricular Sensitivity of the pacemaker
	 * @param ventricularSensitivity The actual Ventricular Sensitivity of the current BOM
	 */
	public void setVentricularSensitivity(double ventricularSensitivity) {
		this.ventricularSensitivity = ventricularSensitivity;
	}

	/**
	 * Return the Ventricular Refractory Period of the BOM
	 * @return The Ventricular Refractory Period
	 */
	public double getVRP() {
		return vRP;
	}

	/**
	 * Modify the Ventricular Refractory Period of the pacemaker
	 * @param aRP The actual Ventricular Refractory Period of the current BOM
	 */
	public void setVRP(double vRP) {
		this.vRP = vRP;
	}

}
