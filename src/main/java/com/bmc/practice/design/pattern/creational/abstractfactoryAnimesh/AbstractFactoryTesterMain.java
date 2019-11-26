/**
 * 
 */
package com.bmc.practice.design.pattern.creational.abstractfactoryAnimesh;

/**
 * @author Animesh
 * @version 1.0
 * @since 07-March-2019
 */
public class AbstractFactoryTesterMain {

	public static void main( String[] args ) {
		IAbstractFactory factoryLevelOneInstance = AbstractFactory.getFactoryInstance( AbstractFactoryConstants.ANIMAL_FACTORY_NAME );
		IAnimalInfo concreteInstance = factoryLevelOneInstance.getConcreteInstance( AbstractFactoryConstants.ANIMAL_NAME_WHALE );
		
		System.out.println( concreteInstance.getAnimalInfo() );
		System.out.println( ( ( IAnimalKingdom )concreteInstance ).getAnimalHabitat() );
		
		System.out.println( "---------------------------------------------------------------------------------------------------" );
		
		factoryLevelOneInstance = AbstractFactory.getFactoryInstance( AbstractFactoryConstants.SOUND_FACTORY_NAME );
		concreteInstance = factoryLevelOneInstance.getConcreteInstance( AbstractFactoryConstants.ANIMAL_NAME_TIGER );
		
		System.out.println( concreteInstance.getAnimalInfo() );
		System.out.println( ( ( ISoundKingdom )concreteInstance ).getActualSound() );
	}
}
