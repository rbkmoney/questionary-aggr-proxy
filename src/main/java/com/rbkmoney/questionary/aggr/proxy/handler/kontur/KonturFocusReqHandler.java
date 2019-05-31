package com.rbkmoney.questionary.aggr.proxy.handler.kontur;

import com.fasterxml.jackson.core.type.TypeReference;
import com.rbkmoney.questionary.aggr.proxy.service.api.KonturFocusApi;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_api.KonturFocusRequest;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_api.KonturFocusResponse;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_req.RegResponse;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_req.ReqQuery;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class KonturFocusReqHandler extends AbstractKonturFocusHandler {

    public KonturFocusReqHandler(KonturFocusApi konturFocusApi) {
        super(konturFocusApi);
    }

    @Override
    protected KonturFocusResponse handleRequest(KonturFocusRequest request) throws Exception {
        if (!request.isSetReqQuery()) {
            throw new IllegalArgumentException("Need to specify req query");
        }
        final ReqQuery reqQuery = request.getReqQuery();
        log.debug("ReqQuery: {}", reqQuery);
        final ResponseEntity<String> responseEntity = konturFocusApi.reqRequest(reqQuery.getOgrn(), reqQuery.getInn());

        final List<RegResponse> regResponseList = getObjectMapper().readValue(responseEntity.getBody(), new TypeReference<List<RegResponse>>() {
        });

        return KonturFocusResponse.req_response(regResponseList);
    }
}
