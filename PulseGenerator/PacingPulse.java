package pacemaker.PulseGenerator;

public class PacingPulse {

//	paced a pulse width : Z (∗ms∗)
//	paced v pulse width : Z (∗ms∗)
//	paced a pulse amp : Z (∗mV ∗)
//	paced v pulse amp : Z (∗mV ∗)
//	last p a pulse : Z (∗TIME ∗)
//	last p v pulse : Z (∗TIME ∗)
	public static void atrialPacing(double amplitude, double pulseWidth){
		System.out.printf("\nAtrial Paced\nAmplitude: %f\nPulse Width: %f",amplitude,pulseWidth);
	}
	public static void ventricularPacing(double amplitude, double pulseWidth){
		System.out.printf("\nVentricular Paced\nAmplitude: %f\nPulse Width: %f",amplitude,pulseWidth);
	}
}
