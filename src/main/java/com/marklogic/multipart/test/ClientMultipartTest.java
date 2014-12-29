package com.marklogic.multipart.test;

import java.io.ByteArrayInputStream;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.MultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;


public class ClientMultipartTest {

	public static void main(String[] args) {
	
		Client client = ClientBuilder.newClient()
				.register(MultiPartFeature.class);
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic("user101", "password101");
		WebTarget webTarget = client.target("http://rh6-intel64-perf-1:9900/poll.xqy")
				.queryParam("domain", "15643207601807538105")
				.queryParam("target", "7989731150090911629");
		webTarget.register(feature);
//		Invocation.Builder invocationBuilder = webTarget.request("multipart/flexrep");
//		Response response = invocationBuilder.get();
//		System.out.println(response.getStatus());
//		System.out.println(response.readEntity(String.class));		
		MultiPart response = webTarget.request("multipart/flexrep").get(MultiPart.class);

		for (BodyPart bp : response.getBodyParts()) {
			String s = bp.getEntityAs(String.class);
			System.out.print(s);
		}

		
	}
}
