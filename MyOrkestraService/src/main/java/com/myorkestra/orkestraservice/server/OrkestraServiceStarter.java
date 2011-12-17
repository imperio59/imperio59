package com.myorkestra.orkestraservice.server;
import org.apache.log4j.PropertyConfigurator;
import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TSimpleJSONProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TServerTransport;
import org.apache.thrift.transport.TTransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myorkestra.orkestraservice.thrift.gen.OrkestraService;
import com.myorkestra.orkestraservice.thrift.gen.OrkestraService.Processor;


public class OrkestraServiceStarter
{
	private static final Logger LOGGER = LoggerFactory.getLogger(TThreadPoolServer.class.getName());
	
	public static void main(final String[] args)
	{
		PropertyConfigurator.configure(args[0]);
		try {
			TServerTransport port = new TNonblockingServerSocket(4242);
			Args serverArgs = new Args(port);
			serverArgs.maxWorkerThreads(128);//Don't run away with my sockets.
			serverArgs.protocolFactory(new TJSONProtocol.Factory());
			
			Processor<OrkestraServiceImpl> processor = new OrkestraService.Processor<OrkestraServiceImpl>(new OrkestraServiceImpl());
			
			serverArgs.processorFactory(new TProcessorFactory(processor));
			
			TServer server = new TSimpleServer(serverArgs);
			
			server.serve();
			
		} catch (TTransportException e) {
			LOGGER.error("Transport error.", e);
			System.exit(1);
		}
		
		System.exit(0);
	}
}
