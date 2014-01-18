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
 * Germano Poliano R. Gualberto    10/04/2013     Classe abstracta base para todos os BOM que podem operar em modo permanente
 */
package pacemaker.PulseGenerator.BradycardiaOperationModes;

/**
 * <code>Rate Limits</code> Class. <br>
 * This class is the base to most of the bradycardia operation mode's that run in permanent mode of the pacemaker. 
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
public abstract class RateLimits implements Runnable{

	/**
	 * The Lower Rate Limit (LRL) is the number of generator pace pulses delivered per minute in the atrium or ventricle.
	 */
	protected double lowerRateLimit;
	
	/**
	 * The Upper Rate Limit (URL) is the maximum rate at which the paced ventricular rate will track sensed atrial events. 
	 */
	protected double upperRateLimit;
	
	/**
	 * The URL interval is the minimum time between a ventricular event and the next ventricular pace.
	 */
	// Faz sentido usar esse parametro? Ele não está na tabela mas é citado no texto. Pag29 seção 5.2
	protected double upperRateLimitInterval;

	/**
	 * Return the Lower Rate Limit of the BOM
	 * @return The Lower Rate Limit
	 */
	public double getLowerRateLimit() {
		return lowerRateLimit;
	}

	/**
	 * Modify the Lower Rate Limit of the pacemaker
	 * @param lowerRateLimit The actual Lower Rate Limit of the current BOM
	 */
	public void setLowerRateLimit(double lowerRateLimit) {
		this.lowerRateLimit = lowerRateLimit;
	}

	/**
	 * Return the Upper Rate Limit of the BOM
	 * @return The Upper Rate Limit
	 */
	public double getUpperRateLimit() {
		return upperRateLimit;
	}

	/**
	 * Modify the Upper Rate Limit of the pacemaker
	 * @param upperRateLimit The actual Upper Rate Limit of the current BOM
	 */
	public void setUpperRateLimit(double upperRateLimit) {
		this.upperRateLimit = upperRateLimit;
	}

	/**
	 * Return the URL Interval of the BOM
	 * @return The URL Interval
	 */
	public double getUpperRateLimitInterval() {
		return upperRateLimitInterval;
	}

	/**
	 * Modify the URL Interval of the pacemaker
	 * @param upperRateLimitInterval The actual Upper Rate Limit Interval of the current BOM
	 */
	public void setUpperRateLimitInterval(double upperRateLimitInterval) {
		this.upperRateLimitInterval = upperRateLimitInterval;
	}
	

}
