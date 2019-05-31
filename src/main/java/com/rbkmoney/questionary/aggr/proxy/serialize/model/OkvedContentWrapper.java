package com.rbkmoney.questionary.aggr.proxy.serialize.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rbkmoney.questionary_proxy_aggr.dadata_okved2.OkvedContent;

public class OkvedContentWrapper {

    @JsonProperty
    private String value;

    @JsonProperty(value = "unrestricted_value")
    private String unrestrictedValue;

    @JsonProperty(value = "data")
    private OkvedContent okvedContent;

    public OkvedContent getOkvedContent() {
        okvedContent.setValue(value);
        okvedContent.setUnrestrictedValue(unrestrictedValue);
        return okvedContent;
    }
}
