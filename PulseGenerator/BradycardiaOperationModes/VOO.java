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

import javax.realtime.AsyncEventHandler;
import javax.realtime.PeriodicTimer;
import javax.realtime.RelativeTime;
import pacemaker.PulseGenerator.BradycardiaOperationModes.logic.VOOlogic;

/**
 * <code>VOO</code> Class. <br>
 * This class is a bradycardia operation mode that run in permanent mode of the pacemaker. 
 * <br>
 * Chambers Paced: (V) Ventriculum
 * <br>
 * Chambers Sensed: (O) None
 * <br>
 * Response to Sensing: (O) None
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
public class VOO extends RateLimits{
	
	/**
	 * The programmable voltage of the ventriculum pulses.
	 */
	protected double ventricularAmplitude;
	
	/**
	 * The programmable width of the ventriculum pulses.
	 */
	protected double ventricularPulseWidth;
	
	/**
	 * Configure the Bradycardia Operation Mode with the specified information.
     * @param lowerRateLimit The Lower Rate Limit (LRL)
     * @param upperRateLimit The Upper Rate Limit (URL)
     * @param ventricularAmplitude The amplitude of the ventriculum pulse
     * @param ventricularPulseWidth The Width of the ventriculum pulse
     */
	public VOO(double lowerRateLimit, double upperRateLimit,
			double ventricularAmplitude, double ventricularPulseWidth){

		this.lowerRateLimit = lowerRateLimit;
		this.upperRateLimit = upperRateLimit;
		this.ventricularAmplitude = ventricularAmplitude;
		this.ventricularPulseWidth = ventricularPulseWidth;
	}
	
	@Override
	public void run() {
		System.out.println("VOO: Funcionalidade não testada ainda");
		
		AsyncEventHandler handler = new AsyncEventHandler( new VOOlogic(ventricularAmplitude, ventricularPulseWidth) );
		
		double intervalo/*em segundos*/= 60/lowerRateLimit;
		RelativeTime interval =  new RelativeTime( (int)intervalo*10/*parte inteira*/,0/*parte fracionaria*/);
		
		PeriodicTimer paced = new PeriodicTimer(null, interval, handler);
		paced.start();
	}
	
	/**
	 * Return the Ventricular Amplitude(Voltage of the pulse) of the BOM
	 * @return The Ventricular Amplitude(Voltage of the pulse)
	 */
	public double getVentricularAmplitude() {
		return ventricularAmplitude;
	}

	/**
	 * Modify the Ventricular Amplitude(Voltage of the pulse) of the pacemaker
	 * @param ventricularAmplitude The actual Ventricular Amplitude(Voltage of the pulse) of the current BOM
	 */
	public void setVentricularAmplitude(double ventricularAmplitude) {
		this.ventricularAmplitude = ventricularAmplitude;
	}

	/**
	 * Return the Ventricular Width(Width of the pulse) of the BOM
	 * @return The Ventricular Width(Width of the pulse)
	 */
	public double getVentricularPulseWidth() {
		return ventricularPulseWidth;
	}

	/**
	 * Modify the Ventricular Width(Width of the pulse) of the pacemaker
	 * @param ventricularPulseWidth The actual Ventricular Width(Width of the pulse) of the current BOM
	 */
	public void setVentricularPulseWidth(double ventricularPulseWidth) {
		this.ventricularPulseWidth = ventricularPulseWidth;
	}
}
