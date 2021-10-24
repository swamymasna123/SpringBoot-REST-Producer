package com.swamy.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class EmpIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		int count = new Random().nextInt(1000);
//		String prefix = "EMP";
//		String suffix = "-";
//		return prefix + suffix + count;
		return count;
	}

}

