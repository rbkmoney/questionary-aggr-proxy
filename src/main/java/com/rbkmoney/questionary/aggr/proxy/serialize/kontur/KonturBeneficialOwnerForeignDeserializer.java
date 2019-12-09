package com.rbkmoney.questionary.aggr.proxy.serialize.kontur;

import com.rbkmoney.questionary.aggr.proxy.serialize.AbstractThriftDeserializer;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerForeign;

public class KonturBeneficialOwnerForeignDeserializer extends AbstractThriftDeserializer<BeneficialOwnerForeign._Fields, BeneficialOwnerForeign> {

    public KonturBeneficialOwnerForeignDeserializer() {
        addFieldNameConverter("fullName", field -> "fullname");
    }

    @Override
    protected BeneficialOwnerForeign._Fields getField(String fieldName) {
        return BeneficialOwnerForeign._Fields.findByName(fieldName);
    }

    @Override
    protected BeneficialOwnerForeign newInstance() {
        return new BeneficialOwnerForeign();
    }
}
