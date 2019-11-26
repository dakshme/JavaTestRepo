package com.bmc.practice.strings;

import org.apache.commons.lang3.StringUtils;

public class StringPadding {

	//Left padding with space using StringUtils.leftPad() 
	public void leftPaddingWithSpaceUsingStringUtils () {
		
		System.out.println( "["+StringUtils.leftPad("howtodoinjava", 20, " ")+"]" );
		System.out.println( "["+StringUtils.leftPad("howtodoinjava", 30, " ")+"]" );
		System.out.println( "["+StringUtils.leftPad("howtodoinjava", 15, " ")+"]" );
		
	}
	
	//Left padding with zero's using StringUtils.leftPad()
	public void leftPaddingWithZeroUsingStringUtils () {
		System.out.println( StringUtils.leftPad("0123456789", 10, "0") );
		System.out.println( StringUtils.leftPad("789", 10, "0") );
		System.out.println( StringUtils.leftPad("56789", 10, "0") );
	}
	
	//Using StringUtils.rightPad
	public void rightPadding() {
		
		System.out.println("Right padding with");
		System.out.println( StringUtils.rightPad("howtodoinjava", 20, " ") + "]");
		System.out.println( StringUtils.rightPad("howtodoinjava", 30, " ") + "]");
		System.out.println( StringUtils.rightPad("howtodoinjava", 15, " ") + "]");
		
		System.out.println("With Zero Using StringUtils");
		System.out.println( StringUtils.rightPad("0123456789", 10, "0") );
		System.out.println( StringUtils.rightPad("0123", 10, "0") );
		System.out.println( StringUtils.rightPad("012345", 10, "0") );
	}

	//Padding with space using String.format() 
	public void PaddingWithSpaceUsingStringFormat () {
		
		//%1$s = first argument, %2$s = second argument, 25 includes original string plus padding length
		System.out.println( "Left Padding using String Format ["+ String.format("%1$"+25+"s" , "HowToDoInJava")+"]" );
		System.out.println( "Left Padding using String Format ["+ String.format("%"+25+"s" , "HowToDoInJava")+"]" );
		System.out.println( "Right Padding using String Format ["+String.format("%1$-"+25+"s", "HowToDoInJava")+"]" );
		System.out.println( "Right Padding using String Format ["+String.format("%-"+25+"s", "HowToDoInJava")+"]" );	
	}
	
	//Padding with space using other program logic 
	public void PaddingWithSpaceUsingLogic () {
		StringBuilder builderRight = new StringBuilder("howtodoinjava");
		
		//pad right
		int len = 20;
		while(len != 0) {
			builderRight.append(" ");	//append at the end	
			len--;
		}
		System.out.println( "Right Padding ["+ builderRight.toString() +"]");
		// one more way, 30 length including original plus padding
		System.out.println("One more way right pad ["+String.format("%-30s", "OneMoreWayRightPad").replace(' ', '*')+"]");
		
		//pad left
		len = 20;
		StringBuilder builderLeft = new StringBuilder("howtodoinjava");
		builderLeft = builderLeft.reverse(); // reverse initial string
		while(len != 0) {
			builderLeft.append(" ");	//append at the end	
			len--;
		}
		System.out.println( "Left Padding ["+ builderLeft.reverse().toString() +"]");
		// one more way, 30 length including original plus padding
		System.out.println("One more way left pad ["+String.format("%30s", "OneMoreWayLeftPad").replace(' ', '*')+"]");
	}
}
