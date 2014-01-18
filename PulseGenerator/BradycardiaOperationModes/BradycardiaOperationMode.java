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
 * Germano Poliano R. Gualberto    26/03/2013     Classe que define o modo de operação. De acordo com os parametros que recebe, define quais parametros devem ser usados
 */
package pacemaker.PulseGenerator.BradycardiaOperationModes;



/**
 * <code>BradycardiaOperationMode</code> Class. <br>
 * This class is responsible to select the bradycardia operation mode of the pacemaker. 
 *  
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
public class BradycardiaOperationMode {
	
	/**
	 * Select the appropriated set of chambers that must be paced or sensed
	 * <br>
	 * <b>O</b> : None
	 * <br>
	 * <b>A</b> : Atrium
	 * <br>
	 * <b>V</b> : Ventricule
	 * <br>
	 * <b>D</b> : Dual (Both Atrium and Ventricule)
	 */
	public enum Chambers{
		O,A,V,D;
	}
	
	/**
	 * Select the appropriated Response to Sensing
	 * <br>
	 * <b>O</b> : None
	 * <br>
	 * <b>T</b> : Triggered
	 * <br>
	 * <b>I</b> : Inhibited
	 * <br>
	 * <b>D</b> : Tracked
	 */
	public enum ResponseToSensing{
		O,T,I,D;
	}
	
	/**
	 * Select if the parameter optional Rate Modulation is used
	 * <br>
	 * <b>R</b> : Rate Modulation
	 */
	public enum RateModulation{
		R;
	}
	
	private Chambers chambersPaced;
	private Chambers chambersSensed;
	private ResponseToSensing response;
	private RateModulation rate;

	//modos:	
	//	Off DDD VDD DDI DOO
	//	 AOO AAI VOO VVI AAT VVT
	//	DDDR VDDR DDIR DOOR
	//	AOOR AAIR VOOR VVIR
	
	/**
	 * Configure the Bradycardia Operation Mode with the specified information.
     * @param chambersPaced The Chambers Paced
     * @param chambersSensed The Chambers Sensed
     * @param response The response to Sensing
     */
	public BradycardiaOperationMode(Chambers chambersPaced, Chambers chambersSensed, ResponseToSensing response){
		this.chambersPaced = chambersPaced;
		this.chambersSensed = chambersSensed;
		this.response = response;
	}
	
	/**
     * Configure the Bradycardia Operation Mode with the specified information.
     * <br> For a while, this constructor can't be used because the Accelerometer Component of the pacemaker is not implemented
     * @param chambersPaced The Chambers Paced
     * @param chambersSensed The Chambers Sensed
     * @param response The response to Sensing
     * @param rate This parameter is optional. It describes the Rate Modulation
     */
	public BradycardiaOperationMode(Chambers chambersPaced, Chambers chambersSensed, ResponseToSensing response, RateModulation rate){
		this( chambersPaced, chambersSensed, response);
		this.rate = rate;
	}

	/**
	 * Return the Chambers Paced by the pacemaker
	 * @return The Chambers Paced
	 */
	public Chambers getChambersPaced() {
		return chambersPaced;
	}

	/**
	 * Modify the Chambers Paced by the pacemaker
	 * @param chambersPaced The actual set of chambers that must be paced
	 */
	public void setChambersPaced(Chambers chambersPaced) {
		this.chambersPaced = chambersPaced;
	}

	/**
	 * Return the Chambers Sensed by the pacemaker
	 * @return The Chambers Sensed
	 */
	public Chambers getChambersSensed() {
		return chambersSensed;
	}

	/**
	 * Modify the Chambers Sensed by the pacemaker
	 * @param chambersSensed The actual set of chambers that must be Sensed
	 */
	public void setChambersSensed(Chambers chambersSensed) {
		this.chambersSensed = chambersSensed;
	}

	/**
	 * Return the Response to Sensing by the pacemaker
	 * @return The Response to Sensing
	 */
	public ResponseToSensing getResponse() {
		return response;
	}

	/**
	 * Modify the Response to Sensing by the pacemaker
	 * @param response The actual response that must be executed in Response to Sensing
	 */
	public void setResponse(ResponseToSensing response) {
		this.response = response;
	}

	/**
	 * Return the Rate Modulation by the pacemaker
	 * @return The Rate Modulation
	 */
	public RateModulation getRate() {
		return rate;
	}

	/**
	 * Modify the Rate Modulation by the pacemaker
	 * @param rate The actual rate
	 */
	public void setRate(RateModulation rate) {
		this.rate = rate;
	}	
	
}
