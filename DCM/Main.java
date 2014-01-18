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
 * Germano Poliano R. Gualberto    10/04/2013     Essa classe servirá como a interface do uso do sistema para o usuário
 */
package pacemaker.DCM;

import java.util.Scanner;

import pacemaker.PulseGenerator.BradycardiaOperationModes.AOO;
import pacemaker.PulseGenerator.BradycardiaOperationModes.VOO;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Running in permanent mode...\n\n");
		System.out.println("Choose your BOM:");
		
		printOptions();
		
		int choosedOption = input.nextInt();
		
		switch (choosedOption){
			case 1:
				System.out.println("\nAOO choosed");
				runAOO();
				break;
			case 2:
				System.out.println("\nVOO choosed");
				runVOO();
				break;
		}
		
	}

	
	
	private static void runVOO() {
		Scanner input = new Scanner(System.in);
		System.out.println("\n\nEnter Low Rate Limit: ");
		double lrl = input.nextDouble();
		System.out.println("\n\nEnter Upper Rate Limit: ");
		double url = input.nextDouble();
		System.out.println("\n\nEnter Ventricular Amplitude: ");
		double va = input.nextDouble();
		System.out.println("\n\nEnter Ventricular Pulse Width: ");
		double vpw = input.nextDouble();
		
		VOO modeOperating = new VOO(lrl, url, va, vpw);
		modeOperating.run();
		
	}



	private static void runAOO() {
		Scanner input = new Scanner(System.in);
		System.out.println("\n\nEnter Low Rate Limit: ");
		double lrl = input.nextDouble();
		System.out.println("\n\nEnter Upper Rate Limit: ");
		double url = input.nextDouble();
		System.out.println("\n\nEnter Atrial Amplitude: ");
		double aa = input.nextDouble();
		System.out.println("\n\nEnter Atrial Pulse Width: ");
		double apw = input.nextDouble();
		
		AOO modeOperating = new AOO(lrl, url, aa, apw);
		modeOperating.run();
		
		
	}



	private static void printOptions() {
		System.out.println("1- AOO");
		System.out.println("2- VOO");
	}

//	printOpeningMessage();
//	showModeOperationOptions();
//	-showTemporaryModeOptions();
//	--ConfigureBOM();
//	--ShowInBOM
//	-showPermanentModeOptions();
//	--ConfigureBOM();
//	--ShowInBOM	
}
