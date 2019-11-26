/**
 * 
 */
package com.bmc.practice.design.pattern.creational.abstractfactoryAnimesh;

/**
 * @author Animesh
 * @version 1.0
 * @since 07-March-2019
 */
public class SoundHighPitched implements ISoundKingdom {

	@Override
	public String getAnimalInfo() {
		return "The sound generated is High Pitched";
	}
	
	@Override
	public String getActualSound() {
		return "Actual High Pitched sound is eeeeeeeeeeeeeeeeee.";
	}
	
	@Override
	public String toString() {
		return "The sound generated is High Pitched";
	}
}
