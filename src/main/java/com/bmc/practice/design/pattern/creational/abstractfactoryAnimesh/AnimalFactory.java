/**
 * 
 */
package com.bmc.practice.design.pattern.creational.abstractfactoryAnimesh;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Animesh
 * @version 1.0
 * @since 07-March-2019
 */
public class AnimalFactory implements IAbstractFactory {
	
	private static AnimalFactory animalFactory = new AnimalFactory();
	private Map<String, IAnimalKingdom> animalNameToAnimalInstaceMap = new ConcurrentHashMap<>();

	@Override
	public IAbstractFactory getFactoryInstance( String factoryName ) {
		if( animalFactory == null ) {
			animalFactory = new AnimalFactory();
		}
		
		return animalFactory;
	}
	
	public static IAbstractFactory getAnimalFactoryInstance() {
		if( animalFactory == null ) {
			animalFactory = new AnimalFactory();
		}
		
		return animalFactory;
	}
	
	@Override
	public IAnimalInfo getConcreteInstance( String concreteInstanceName ) {
		return this.getAnimalKingdomInstance( concreteInstanceName );
	}
	
	/**
	 * Creates the Concrete instance and returns back
	 * 
	 * @param animalName
	 * @return animalKingdom AnimalKingdom
	 */
	public IAnimalKingdom getAnimalKingdomInstance( String animalName ) {
		IAnimalKingdom animalKingdom = null;
		
		if( animalName != null && !animalName.isEmpty() ) {
			switch( animalName ) {
				case AbstractFactoryConstants.ANIMAL_NAME_WHALE	:	
					
					if( animalFactory.animalNameToAnimalInstaceMap.containsKey( animalName ) ) {
						animalKingdom = animalFactory.animalNameToAnimalInstaceMap.get( animalName );
					} else {
						animalKingdom = new AnimalWhale();
						animalFactory.animalNameToAnimalInstaceMap.put( animalName, animalKingdom );
					}
					
					break;
									
				case AbstractFactoryConstants.ANIMAL_NAME_TIGER	:	
					
					if( animalFactory.animalNameToAnimalInstaceMap.containsKey( animalName ) ) {
						animalKingdom = animalFactory.animalNameToAnimalInstaceMap.get( animalName );
					} else {
						animalKingdom = new AnimalTiger();
						animalFactory.animalNameToAnimalInstaceMap.put( animalName, animalKingdom );
					}
					
					break;
									
				case AbstractFactoryConstants.ANIMAL_NAME_EAGLE	:	
					
					if( animalFactory.animalNameToAnimalInstaceMap.containsKey( animalName ) ) {
						animalKingdom = animalFactory.animalNameToAnimalInstaceMap.get( animalName );
					} else {
						animalKingdom = new AnimalEagle();
						animalFactory.animalNameToAnimalInstaceMap.put( animalName, animalKingdom );
					}
					
					break;
									
				default	:
					
					animalKingdom = null;
					break;
			}
		}
		
		return animalKingdom;
	}
}
