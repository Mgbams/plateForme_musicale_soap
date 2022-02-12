package fr.orsys.kingsley.plateforme_musicale_soap_services.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import io.spring.guides.gs_producing_web_service.GetMusicaleRequest;
import io.spring.guides.gs_producing_web_service.GetMusicaleResponse;

@Endpoint
public class MusicaleEndpoint {
	private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private MusicaleRepository musicaleRepository;

	@Autowired
	public MusicaleEndpoint(MusicaleRepository musicaleRepository) {
		this.musicaleRepository = musicaleRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMusicaleRequest")
	@ResponsePayload
	public GetMusicaleResponse getMusicale(@RequestPayload GetMusicaleRequest request) {
		GetMusicaleResponse response = new GetMusicaleResponse();
		response.setCountry(musicaleRepository.findMusicale(request.getName()));

		return response;
	}
}
