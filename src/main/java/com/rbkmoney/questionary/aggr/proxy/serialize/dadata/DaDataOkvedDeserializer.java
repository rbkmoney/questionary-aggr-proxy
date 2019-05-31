package com.rbkmoney.questionary.aggr.proxy.serialize.dadata;

import com.rbkmoney.questionary.aggr.proxy.serialize.AbstractThriftDeserializer;
import com.rbkmoney.questionary_proxy_aggr.dadata_okved2.OkvedContent;

public class DaDataOkvedDeserializer extends AbstractThriftDeserializer<OkvedContent._Fields, OkvedContent> {
    @Override
    protected OkvedContent._Fields getField(String fieldName) {
        return OkvedContent._Fields.findByName(fieldName);
    }

    @Override
    protected OkvedContent newInstance() {
        return new OkvedContent();
    }
}
