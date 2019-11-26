/**
 * 
 */
package com.bmc.practice.design.pattern.creational.abstractfactoryAnimesh;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Animesh
 * @version 1.0
 * @since 05-March-2019
 */
public class AbstractFactory {
	
	private static AbstractFactory abstractFactory = new AbstractFactory();
	private Map<String, IAbstractFactory> factoryNameToObjMap = new ConcurrentHashMap<>();
	
	public static IAbstractFactory getFactoryInstance( String factoryName ) {
		IAbstractFactory iAbstractFactory = null;
		
		if( null != factoryName && !factoryName.isEmpty() ) {
			switch( factoryName ) {
				case AbstractFactoryConstants.ANIMAL_FACTORY_NAME 	:	
						
					if( abstractFactory.factoryNameToObjMap.containsKey( factoryName ) ) {
						iAbstractFactory = abstractFactory.factoryNameToObjMap.get( factoryName );
					} else {
						iAbstractFactory = new AnimalFactory();
						abstractFactory.factoryNameToObjMap.put( factoryName, iAbstractFactory );
					}
					
					break;
									
				case AbstractFactoryConstants.SOUND_FACTORY_NAME	:	
						
					if( abstractFactory.factoryNameToObjMap.containsKey( factoryName ) ) {
						iAbstractFactory = abstractFactory.factoryNameToObjMap.get( factoryName );
					} else {
						iAbstractFactory = new SoundFactory();
						abstractFactory.factoryNameToObjMap.put( factoryName, iAbstractFactory );
					}
					
					break;
									
				default :
					
					iAbstractFactory = null;
					break;
			}
		}
		
		return iAbstractFactory;
	}
}
