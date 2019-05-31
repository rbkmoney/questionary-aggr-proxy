package com.rbkmoney.questionary.aggr.proxy.serialize.kontur;

import com.rbkmoney.questionary.aggr.proxy.serialize.AbstractThriftDeserializer;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_req.RegIndividualEntity;

public class KonturRegIPDeserializer extends AbstractThriftDeserializer<RegIndividualEntity._Fields, RegIndividualEntity> {

    public KonturRegIPDeserializer() {
        addFieldNameConverter("status", field -> {
            return "status_detail";
        });
    }

    @Override
    protected RegIndividualEntity._Fields getField(String fieldName) {
        return RegIndividualEntity._Fields.findByName(fieldName);
    }

    @Override
    protected RegIndividualEntity newInstance() {
        return new RegIndividualEntity();
    }

}
