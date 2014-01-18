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

import pacemaker.PulseGenerator.BradycardiaOperationModes.logic.AOOlogic;

/**
 * <code>AOO</code> Class. <br>
 * This class is a bradycardia operation mode that run in permanent mode of the pacemaker. 
 * <br>
 * Chambers Paced: (A) Atrium
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
public class AOO extends RateLimits{

	/**
	 * The programmable voltage of the atrium pulses.
	 */
	protected double atrialAmplitude;
	
	/**
	 * The programmable width of the atrium pulses.
	 */
	protected double atrialPulseWidth;
	
	/**
	 * Configure the Bradycardia Operation Mode with the specified information.
     * @param lowerRateLimit The Lower Rate Limit (LRL)
     * @param upperRateLimit The Upper Rate Limit (URL)
     * @param atrialAmplitude The amplitude of the atrium pulse
     * @param atrialPulseWidth The Width of the atrium pulse
     */
	public AOO(double lowerRateLimit, double upperRateLimit,
			double atrialAmplitude, double atrialPulseWidth){

		this.lowerRateLimit = lowerRateLimit;
		this.upperRateLimit = upperRateLimit;
		this.atrialAmplitude = atrialAmplitude;
		this.atrialPulseWidth = atrialPulseWidth;
	}

	@Override
	public void run() {
		System.out.println("AOO: Funcionalidade não testada ainda");
		
		//AOOlogic logica = new AOOlogic();
		AsyncEventHandler handler = new AsyncEventHandler( new AOOlogic(atrialAmplitude, atrialPulseWidth) );
		
		double intervalo/*em segundos*/= 60/lowerRateLimit;
		RelativeTime interval =  new RelativeTime( (int)intervalo*1000/*parte inteira*/,0/*parte fracionaria*/);
		
		PeriodicTimer paced = new PeriodicTimer(null, interval, handler);
		paced.start();
	}

	/**
	 * Return the Atrial Amplitude(Voltage of the pulse) of the BOM
	 * @return The Atrial Amplitude(Voltage of the pulse)
	 */
	public double getAtrialAmplitude() {
		return atrialAmplitude;
	}

	/**
	 * Modify the Atrial Amplitude(Voltage of the pulse) of the pacemaker
	 * @param atrialAmplitude The actual Atrial Amplitude(Voltage of the pulse) of the current BOM
	 */
	public void setAtrialAmplitude(double atrialAmplitude) {
		this.atrialAmplitude = atrialAmplitude;
	}

	/**
	 * Return the Atrial Width(Width of the pulse) of the BOM
	 * @return The Atrial Width(Width of the pulse)
	 */
	public double getAtrialPulseWidth() {
		return atrialPulseWidth;
	}

	/**
	 * Modify the Atrial Width(Width of the pulse) of the pacemaker
	 * @param atrialPulseWidth The actual Atrial Width(Width of the pulse) of the current BOM
	 */
	public void setAtrialPulseWidth(double atrialPulseWidth) {
		this.atrialPulseWidth = atrialPulseWidth;
	}
}
