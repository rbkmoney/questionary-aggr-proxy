package com.rbkmoney.questionary.aggr.proxy.service.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbkmoney.damsel.questionary_proxy_aggr.KonturFocusRequestException;
import com.rbkmoney.questionary.aggr.proxy.config.settings.KonturFocusSettings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class KonturFocusApi {

    private static final String REQ_URL = "https://focus-api.kontur.ru/api3/req?key={token}";

    private static final String EGR_DETAILS = "https://focus-api.kontur.ru/api3/egrDetails?key={token}";

    private static final String LICENCES = "https://focus-api.kontur.ru/api3/licences?key={token}";

    private final RestTemplate restTemplate;

    private final KonturFocusSettings konturFocusSettings;

    public KonturFocusApi(RestTemplate restTemplate,
                          KonturFocusSettings konturFocusSettings,
                          ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.konturFocusSettings = konturFocusSettings;
    }

    public ResponseEntity<String> reqRequest(List<String> orgnList, List<String> innList) throws KonturFocusRequestException {
        final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(REQ_URL);
        uriComponentsBuilder.queryParam("ogrn", String.join(",", orgnList));
        uriComponentsBuilder.queryParam("inn", String.join(",", innList));

        return sendRequest(uriComponentsBuilder, String.class);
    }

    public ResponseEntity<String> licenseRequest(List<String> orgnList, List<String> innList) throws KonturFocusRequestException {
        final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(LICENCES);
        uriComponentsBuilder.queryParam("ogrn", String.join(",", orgnList));
        uriComponentsBuilder.queryParam("inn", String.join(",", innList));

        return sendRequest(uriComponentsBuilder, String.class);
    }

    public ResponseEntity<String> egrDetailsRequest(List<String> orgnList, List<String> innList) throws KonturFocusRequestException {
        final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(EGR_DETAILS);
        uriComponentsBuilder.queryParam("ogrn", String.join(",", orgnList));
        uriComponentsBuilder.queryParam("inn", String.join(",", innList));

        return sendRequest(uriComponentsBuilder, String.class);
    }

    private <T> ResponseEntity<T> sendRequest(UriComponentsBuilder uriComponentsBuilder, Class<T> responseType) throws KonturFocusRequestException {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        final Map<String, String> uriParams = new HashMap<>();
        uriParams.put("token", konturFocusSettings.getToken());
        final URI uri = uriComponentsBuilder.buildAndExpand(uriParams).toUri();
        final HttpEntity<?> entity = new HttpEntity<>(headers);
        try {
            log.info("KonturFocus request: {}", uri.toString());
            return restTemplate.exchange(uri, HttpMethod.GET, entity, responseType);
        } catch (Exception e) {
            throw new KonturFocusRequestException(e.getMessage());
        }
    }

}
