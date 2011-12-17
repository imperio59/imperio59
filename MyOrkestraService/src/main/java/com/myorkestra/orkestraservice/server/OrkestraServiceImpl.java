package com.myorkestra.orkestraservice.server;

import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;

import com.myorkestra.orkestraservice.thrift.gen.InvalidRequestException;
import com.myorkestra.orkestraservice.thrift.gen.OrkestraService.Iface;

public class OrkestraServiceImpl implements Iface {

	@Override
	public String sayHi(String input) throws InvalidRequestException,
			TException 
	{
		if (input == null || StringUtils.isBlank(input))
		{
			throw new InvalidRequestException(1, "No or Blank input.");
		}
		
		return "Hello " +  input;
	}

}
