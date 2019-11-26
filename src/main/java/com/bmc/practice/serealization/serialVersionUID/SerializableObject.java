package com.bmc.practice.serealization.serialVersionUID;

/*
 * Now even if we add ew variables to this class still de-serialization
 * will happen due to fixed value of serialVersionUID.
 */
import java.io.Serializable;

public class SerializableObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	int i =10;
	int j=20;
	int k=40;
}
