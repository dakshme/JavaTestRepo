/**
 * 
 */
package com.bmc.practice.design.pattern.creational.abstractfactoryAnimesh;

/**
 * @author Animesh
 * @version 1.0
 * @since 07-March-2019
 */
public class SoundRoar implements ISoundKingdom {

	@Override
	public String getAnimalInfo() {
		return "The sound generated is a Roar";
	}
	
	@Override
	public String getActualSound() {
		return "Actual Roaring sound is wwwwwwooooooooaaaaaaaaaa.";
	}
	
	@Override
	public String toString() {
		return "The sound generated is a Roar";
	}
}
