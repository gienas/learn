package io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;

public class PojoPerson implements Serializable {

	{
		name = "ludwig";
	}
	
	private String name = "zinold";
	private Integer age;
	private BigDecimal salary;
	private transient PojoAdress adress;

	{
		name = "rudi";
	}
	
	public PojoPerson(PojoAdress adress, Integer age, String name,
			BigDecimal salary) {
		super();
		this.adress = adress;
		this.age = age;
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public PojoAdress getAdress() {
		return adress;
	}

	public void setAdress(PojoAdress adress) {
		this.adress = adress;
	}

	private void writeObject(ObjectOutputStream pmOut) throws IOException {
		pmOut.defaultWriteObject();
		byte[] lvbyte = new byte[128];
		int i = 0;
		for ( byte lvByte: adress.getAdress().getBytes())
		{
			lvbyte[i++] = lvByte;
			if ( i == 128 ) return;
		}	
		pmOut.write(lvbyte);
	}

	private void readObject(ObjectInputStream pmIn) throws IOException {
		try {
			pmIn.defaultReadObject();
			byte[] lvbyte = new byte[128];
			int count =  pmIn.read(lvbyte);
			adress = new PojoAdress( new String(lvbyte ) );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
