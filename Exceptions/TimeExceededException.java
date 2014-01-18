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
 * Germano Poliano R. Gualberto    10/04/2013     Exceção usada quando algum tempo é excedido durante a execução
 */

package pacemaker.Exceptions;

/**
 * <code>TimeExceedException</code> Class. <br>
 * Exception class used to indicate when a operation exceed the determined time to execute.
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
@SuppressWarnings("serial")
public class TimeExceededException extends Exception{

	/**
     * Exception constructor stating what was the reason for launching the exception.
     * @param message The message that indicates why the exception was thrown.
     */
    public TimeExceededException(String message) {
            super(message);
    }
}
