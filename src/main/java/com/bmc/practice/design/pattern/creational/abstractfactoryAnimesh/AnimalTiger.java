/**
 * 
 */
package com.bmc.practice.design.pattern.creational.abstractfactoryAnimesh;

/**
 * @author Animesh
 * @version 1.0
 * @since 07-March-2019
 */
public class AnimalTiger implements IAnimalKingdom {

	@Override
	public String getAnimalInfo() {
		return "Animal name is Royal Bengal Tiger";
	}
	
	@Override
	public String getAnimalHabitat() {
		return "Habitat of Tiger is Forest";
	}
	
	@Override
	public String toString() {
		return "Animal name is Royal Bengal Tiger";
	}
}
