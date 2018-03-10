package com.dsr.spring.soapservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.dsr.spring.soapservice.data.CountrySampleData;
import com.dsr.spring.soapservice.data.GetCountryRequest;
import com.dsr.spring.soapservice.data.GetCountryResponse;


@Endpoint
public class CountryEndPoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private CountrySampleData countryRepository;

	@Autowired
	public CountryEndPoint(CountrySampleData countryRepository) {
		this.countryRepository = countryRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = ""
			+ ""
			+ "")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
}