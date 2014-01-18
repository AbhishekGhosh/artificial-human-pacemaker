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
 * Germano Poliano R. Gualberto    12/04/2013     Um dos BOMs
 *                                                Esse BOM e seus descendentes herdam carcteristicas de AOO e VOO
 *                                                Mas por causa de limitações da linguagem Java quanto a herança,
 *                                                Basicamente tou copiando parte do código dessas classes e colando aqui
 */
package pacemaker.PulseGenerator.BradycardiaOperationModes;

import javax.realtime.AsyncEventHandler;
import javax.realtime.PeriodicTimer;
import javax.realtime.RelativeTime;
import pacemaker.PulseGenerator.BradycardiaOperationModes.logic.DOOlogic;


/**
 * <code>DOO</code> Class. <br>
 * This class is a bradycardia operation mode that run in permanent mode of the pacemaker. 
 * <br>
 * Chambers Paced: (D) Dual (Both Atrium and Vetriculum)
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
public class DOO extends RateLimits{
	
	/**
	 * The AV delay shall be the programmable time period from an atrial event (either intrinsic or paced) to a ventricular pace.
	 */
	protected double fixedAVDelay;
	
	/**
	 * The programmable voltage of the atrium pulses.
	 */
	protected double atrialAmplitude;
	
	/**
	 * The programmable voltage of the ventriculum pulses.
	 */
	protected double ventricularAmplitude;
	
	/**
	 * The programmable width of the atrium pulses.
	 */
	protected double atrialPulseWidth;
	
	/**
	 * The programmable width of the ventriculum pulses.
	 */
	protected double ventricularPulseWidth;
	
	/**
	 * Configure the Bradycardia Operation Mode with the specified information.
     * @param lowerRateLimit The Lower Rate Limit (LRL)
     * @param upperRateLimit The Upper Rate Limit (URL)
     * @param fixedAVDelay The Fixed Atrial-Ventricular Delay
     * @param atrialAmplitude The amplitude of the atrium pulse
     * @param ventricularAmplitude The amplitude of the ventriculum pulse
     * @param atrialPulseWidth The Width of the atrium pulse
     * @param ventricularPulseWidth The Width of the ventriculum pulse
     */
	public DOO(double lowerRateLimit, double upperRateLimit,
			double fixedAVDelay,
			double atrialAmplitude, double ventricularAmplitude,
			double atrialPulseWidth, double ventricularPulseWidth){

		this.lowerRateLimit = lowerRateLimit;
		this.upperRateLimit = upperRateLimit;
		this.atrialAmplitude = atrialAmplitude;
		this.ventricularAmplitude = ventricularAmplitude;
		this.atrialPulseWidth = atrialPulseWidth;
		this.ventricularPulseWidth = ventricularPulseWidth;
	}
	
	@Override
	public void run() {
		System.out.println("DOO: Funcionalidade não testada ainda");
		
		AsyncEventHandler handler = new AsyncEventHandler( new DOOlogic(atrialAmplitude, atrialPulseWidth, ventricularAmplitude, ventricularPulseWidth) );
		
		double intervalo/*em segundos*/= 60/lowerRateLimit;
		RelativeTime interval =  new RelativeTime( (int)intervalo*10/*parte inteira*/,0/*parte fracionaria*/);
		
		PeriodicTimer paced = new PeriodicTimer(null, interval, handler);
		
		paced.start();
		
	}
	
	/**
	 * Return the Fixed Atrial-Ventricular Delay of the BOM
	 * @return The Fixed Atrial-Ventricular Delay
	 */
	public double getFixedAVDelay(){
		return fixedAVDelay;
	}
	
	/**
	 * Modify the Fixed Atrial-Ventricular Delay of the pacemaker
	 * @param fixedAVDelay The actual Fixed Atrial-Ventricular Delay of the current BOM
	 */
	public void setFixedAVDelay(double fixedAVDelay){
		this.fixedAVDelay = fixedAVDelay;
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
