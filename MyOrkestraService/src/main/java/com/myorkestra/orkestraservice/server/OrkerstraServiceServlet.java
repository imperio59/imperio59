package com.myorkestra.orkestraservice.server;

import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.server.TServlet;

import com.myorkestra.orkestraservice.thrift.gen.OrkestraService;

public class OrkerstraServiceServlet extends TServlet 
{
	public OrkerstraServiceServlet() 
	{
		super(new OrkestraService.Processor<OrkestraServiceImpl>(new OrkestraServiceImpl()), new TJSONProtocol.Factory());
	}
}
