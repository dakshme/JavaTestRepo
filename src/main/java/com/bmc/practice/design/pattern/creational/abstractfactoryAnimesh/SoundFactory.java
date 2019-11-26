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
public class SoundFactory implements IAbstractFactory {
	
	private static SoundFactory soundFactory = new SoundFactory();
	private Map<String, ISoundKingdom> soundNameToSoundInstanceMap = new ConcurrentHashMap<>();

	@Override
	public IAbstractFactory getFactoryInstance( String factoryName ) {
		if( soundFactory == null ) {
			soundFactory = new SoundFactory();
		}
		
		return soundFactory;
	}
	
	public static IAbstractFactory getAnimalFactoryInstance() {
		if( soundFactory == null ) {
			soundFactory = new SoundFactory();
		}
		
		return soundFactory;
	}
	
	@Override
	public IAnimalInfo getConcreteInstance( String concreteInstanceName ) {
		return this.getSoundKingdomInstance( concreteInstanceName );
	}
	
	/**
	 * Creates the Concrete instance and returns back
	 * 
	 * @param animalName
	 * @return soundKingdom SoundKingdom
	 */
	public ISoundKingdom getSoundKingdomInstance( String animalName ) {
		ISoundKingdom soundKingdom = null;
		
		if( animalName != null && !animalName.isEmpty() ) {
			switch( animalName ) {
				case AbstractFactoryConstants.ANIMAL_NAME_WHALE	:	
					
					if( soundFactory.soundNameToSoundInstanceMap.containsKey( animalName ) ) {
						soundKingdom = soundFactory.soundNameToSoundInstanceMap.get( animalName );
					} else {
						soundKingdom = new SoundWhistle();
						soundFactory.soundNameToSoundInstanceMap.put( animalName, soundKingdom );
					}
					
					break;
									
				case AbstractFactoryConstants.ANIMAL_NAME_TIGER	:	
					
					if( soundFactory.soundNameToSoundInstanceMap.containsKey( animalName ) ) {
						soundKingdom = soundFactory.soundNameToSoundInstanceMap.get( animalName );
					} else {
						soundKingdom = new SoundRoar();
						soundFactory.soundNameToSoundInstanceMap.put( animalName, soundKingdom );
					}
					
					break;
									
				case AbstractFactoryConstants.ANIMAL_NAME_EAGLE	:	
					
					if( soundFactory.soundNameToSoundInstanceMap.containsKey( animalName ) ) {
						soundKingdom = soundFactory.soundNameToSoundInstanceMap.get( animalName );
					} else {
						soundKingdom = new SoundHighPitched();
						soundFactory.soundNameToSoundInstanceMap.put( animalName, soundKingdom );
					}
					
					break;
									
				default	:	
					
					soundKingdom = null;
					break;
			}
		}
		
		return soundKingdom;
	}
}
