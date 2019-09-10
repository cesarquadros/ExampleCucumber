package com.example.demo.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateErrorHandler implements ResponseErrorHandler{

	private static final Logger LOG = LoggerFactory.getLogger(RestTemplateErrorHandler.class);

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		boolean hasError = false;
		if(response.getStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR) {
			hasError = true;
		}
		return hasError;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		LOG.error(response.getBody().toString());
	}
}