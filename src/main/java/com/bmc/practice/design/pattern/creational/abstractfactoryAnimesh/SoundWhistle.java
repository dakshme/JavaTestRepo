/**
 * 
 */
package com.bmc.practice.design.pattern.creational.abstractfactoryAnimesh;

/**
 * @author Animesh
 * @version 1.0
 * @since 07-March-2019
 */
public class SoundWhistle implements ISoundKingdom {

	@Override
	public String getAnimalInfo() {
		return "The sound generated is a Whistle";
	}
	
	@Override
	public String getActualSound() {
		return "Actual Whistling sound is vvvvvhhhhhheeeeeeeeeeee.";
	}
	
	@Override
	public String toString() {
		return "The sound generated is a Whistle";
	}
}
