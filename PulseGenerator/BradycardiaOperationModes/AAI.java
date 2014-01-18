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

/**
 * <code>AAI</code> Class. <br>
 * This class is a bradycardia operation mode that run in permanent mode of the pacemaker. 
 * <br>
 * Chambers Paced: (A) Atrium
 * <br>
 * Chambers Sensed: (A) Atrium
 * <br>
 * Response to Sensing: (I) Inhibited
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
//Seguindo a tabela, eu não deveria implementar as funcionalidades:
//1Rate Smoothing
//2Hysteresis
//O que faria essa classe ser igual à AAT
public class AAI extends AAT{
	
	/**
	 * Rate Smoothing shall limit the pacing rate change that occurs due to precipitous changes in the intrinsic rate.
	 * <br>
	 * The increase in pacing rate shall not exceed the Rate Smoothing Up percentage.
	 */
	protected double rateSmoothingUp;
	
	/**
	 * Rate Smoothing shall limit the pacing rate change that occurs due to precipitous changes in the intrinsic rate.
	 * <br>
	 * The increase in pacing rate shall not exceed the Rate Smoothing Up percentage.
	 */
	protected double rateSmoothingDown;
	
	/**
	 * Configure the Bradycardia Operation Mode with the specified information.
     * @param lowerRateLimit The Lower Rate Limit (LRL)
     * @param upperRateLimit The Upper Rate Limit (URL)
     * @param atrialAmplitude The amplitude of the atrium pulse
     * @param atrialPulseWidth The Width of the atrium pulse
     * @param atrialSensitivity The Atrial Sensitivity
     * @param aRP The Atrial Refractory Period
     * @param pVARP The Post Vetricular-Atrial Refractory Period
     * @param rateSmoothingUp The limit rate that the pace can change to up
     * @param rateSmoothingDown The limit rate that the pace can change to down
     */
	public AAI(double lowerRateLimit, double upperRateLimit,
			double atrialAmplitude, double atrialPulseWidth,
			double atrialSensitivity, double aRP, double pVARP,
			double rateSmoothingUp,	double rateSmoothingDown){
		
		super(lowerRateLimit, upperRateLimit,
			atrialAmplitude, atrialPulseWidth,
			atrialSensitivity, aRP, pVARP);
		
		this.rateSmoothingUp = rateSmoothingUp;
		this.rateSmoothingDown = rateSmoothingDown;
	}

	// Hysteresis na lógica no momento certo seção 5.8
	@Override
	public void run() {
		super.run();
		System.out.println("AAI: Funcionalidade não implementada ainda");
	}
	
	/**
	 * Return the Rate Smoothing UP (percent) of the BOM
	 * @return The Rate Smoothing UP (percentage)
	 */
	public double getRateSmoothingUp() {
		return rateSmoothingUp;
	}

	/**
	 * Modify the Rate Smoothing UP (percent) of the pacemaker
	 * @param rateSmoothingUp The actual Rate Smoothing UP (percent) of the current BOM
	 */
	public void setRateSmoothingUp(double rateSmoothingUp) {
		this.rateSmoothingUp = rateSmoothingUp;
	}

	/**
	 * Return the Rate Smoothing Down (percent) of the BOM
	 * @return The Rate Smoothing Down (percentage)
	 */
	public double getRateSmoothingDown() {
		return rateSmoothingDown;
	}

	/**
	 * Modify the Rate Smoothing Down (percent) of the pacemaker
	 * @param rateSmoothingDown The actual Rate Smoothing Down (percent) of the current BOM
	 */
	public void setRateSmoothingDown(double rateSmoothingDown) {
		this.rateSmoothingDown = rateSmoothingDown;
	}
	
	
}
