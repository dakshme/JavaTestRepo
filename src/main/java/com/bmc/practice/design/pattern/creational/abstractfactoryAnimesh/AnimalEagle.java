/**
 * 
 */
package com.bmc.practice.design.pattern.creational.abstractfactoryAnimesh;

/**
 * @author Animesh
 * @version 1.0
 * @since 07-March-2019
 */
public class AnimalEagle implements IAnimalKingdom {

	@Override
	public String getAnimalInfo() {
		return "Animal name is Harpy Eagle";
	}
	
	@Override
	public String getAnimalHabitat() {
		return "Habitat of Eagle is Sky";
	}
	
	@Override
	public String toString() {
		return "Animal name is Harpy Eagle";
	}
}
