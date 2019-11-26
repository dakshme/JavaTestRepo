/**
 * 
 */
package com.bmc.practice.design.pattern.creational.abstractfactoryAnimesh;

/**
 * @author Animesh
 * @version 1.0
 * @since 05-March-2019
 */
public interface IAbstractFactory {
	
	public static final String ANIMAL_FACTORY = "AnimalFactory";
	public static final String SOUND_FACTORY = "SoundFactory";
	
	public abstract IAbstractFactory getFactoryInstance( String factoryName );
	public abstract IAnimalInfo getConcreteInstance( String concreteInstanceName );
}
