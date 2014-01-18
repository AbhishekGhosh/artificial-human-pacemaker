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
 * Germano Poliano R. Gualberto   13/04/2013     Um dos BOMs
 *                                               Esse BOM e seus descendentes herdam carcteristicas de DDI,VDD e VVI
 *                                               Mas por causa de limitações da linguagem Java quanto a herança,
 *                                               Basicamente tou copiando parte do código de algumas dessas classes e colando aqui
 */
package pacemaker.PulseGenerator.BradycardiaOperationModes;

/**
 * <code>DDD</code> Class. <br>
 * This class is a bradycardia operation mode that run in permanent mode of the pacemaker. 
 * <br>
 * Chambers Paced: (D) Dual (Both Atrium and Vetriculum)
 * <br>
 * Chambers Sensed: (D) Dual (Both Atrium and Vetriculum)
 * <br>
 * Response to Sensing: (D) Tracked
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
//1PVARP Extension
//2Hysteresis
//3Rate Smoothing
//4AT Detection
// 1ATR Duration
// 2ATR Fallback Mode
// 3ATR Fallback Time
//O que faria essa classe ser igual à DDI
public class DDD extends DDI{

	//fixedAVDelay deve ser dinamico seção 5.3.3
	
	/**
	 * The maximum limit that the AV Delay can vary in Dynamic mode.
	 */
	protected double maximumPacedAVDelay;
	
	/**
	 * The minimum limit that the AV Delay can vary in Dynamic mode.
	 */
	protected double minimumPacedAVDelay;
	
	/*
	 * Sensed AV Delay Offset
	 * The Sensed AV Delay Offset option shall shorten the AV delay following a tracked atrial sense.
	 * ?Mas reduzir como?
    */
	
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
     * @param fixedAVDelay The Fixed Atrial-Ventricular Delay
     * @param atrialAmplitude The amplitude of the atrium pulse
     * @param ventricularAmplitude The amplitude of the ventriculum pulse
     * @param atrialPulseWidth The Width of the atrium pulse
     * @param ventricularPulseWidth The Width of the ventriculum pulse
     * @param atrialSensitivity The Atrial Sensitivity
     * @param ventricularSensitivity The Ventricular Sensitivity
     * @param aRP The Atrial Refractory Period
     * @param vRP The Ventricular Refractory Period
     * @param pVARP The Post Ventricular-Atrial Refractory Period
     * @param rateSmoothingUp The limit rate that the pace can change to up
     * @param rateSmoothingDown The limit rate that the pace can change to down
     */
	//Essa classe deve usar Atrial Tachycardia Response como um componente interno
	// PVARP is extended section 5.4.4
	// Hysteresis na lógica no momento certo seção 5.8
	public DDD(double lowerRateLimit, double upperRateLimit,
			double fixedAVDelay,
			double atrialAmplitude, double ventricularAmplitude,
			double atrialPulseWidth, double ventricularPulseWidth,
			double atrialSensitivity, double ventricularSensitivity,
			double aRP,	double vRP,	double pVARP,
			double rateSmoothingUp,	double rateSmoothingDown){

		super(lowerRateLimit, upperRateLimit,
			fixedAVDelay,
			atrialAmplitude, ventricularAmplitude,
			atrialPulseWidth, ventricularPulseWidth,
			atrialSensitivity,ventricularSensitivity ,
		    aRP,vRP,pVARP);
		
		this.rateSmoothingUp = rateSmoothingUp;
		this.rateSmoothingDown = rateSmoothingDown;
		
	}
	
	
	// algoritmo do avdelay dinamico: seção 5.3.3
	// PVARP is extended section 5.4.4
	// Hysteresis na lógica no momento certo seção 5.8
	// Usar Atrial Tachycardia Response na lógica no momento correto
	// seção 5.6
	@Override
	public void run() {
		super.run();
		System.out.println("DDD: Funcionalidade não implementada ainda");
	}
	
	
	/**
	 * Return the Maximum Paced Atrial-Ventricular Delay of the BOM
	 * @return Maximum Paced Atrial-Ventricular Delay
	 */
	public double getMaximumPacedAVDelay(){
		return maximumPacedAVDelay;
	}
	
	/**
	 * Modify the Maximum Paced Atrial-Ventricular Delay of the pacemaker
	 * @param maximumPacedAVDelay The actual Maximum Paced Atrial-Ventricular Delay of the current BOM
	 */
	public void setMaximumPacedAVDelay(double maximumPacedAVDelay){
		this.maximumPacedAVDelay = maximumPacedAVDelay;
	}
	
	/**
	 * Return the Minimum Paced Atrial-Ventricular Delay of the BOM
	 * @return Minimum Paced Atrial-Ventricular Delay
	 */
	public double getMinimumPacedAVDelay(){
		return minimumPacedAVDelay;
	}
	
	/**
	 * Modify the Minimum Paced Atrial-Ventricular Delay of the pacemaker
	 * @param minimumPacedAVDelay The actual Minimum Paced Atrial-Ventricular Delay of the current BOM
	 */
	public void setMinimumPacedAVDelay(double minimumPacedAVDelay){
		this.minimumPacedAVDelay = minimumPacedAVDelay;
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
