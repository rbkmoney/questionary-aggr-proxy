package com.rbkmoney.questionary.aggr.proxy.serialize.kontur;

import com.rbkmoney.questionary.aggr.proxy.serialize.AbstractThriftDeserializer;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerUl;

public class KonturBeneficialOwnerUlDeserializer extends AbstractThriftDeserializer<BeneficialOwnerUl._Fields, BeneficialOwnerUl> {

    public KonturBeneficialOwnerUlDeserializer() {
        addFieldNameConverter("fullName", field -> "fullname");
    }

    @Override
    protected BeneficialOwnerUl._Fields getField(String fieldName) {
        return BeneficialOwnerUl._Fields.findByName(fieldName);
    }

    @Override
    protected BeneficialOwnerUl newInstance() {
        return new BeneficialOwnerUl();
    }
}
