package com.rbkmoney.questionary.aggr.proxy.serialize.kontur;

import com.rbkmoney.questionary.aggr.proxy.serialize.AbstractThriftDeserializer;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_beneficial_owner.BeneficialOwnerOther;

public class KonturBeneficialOwnerOtherDeserializer extends AbstractThriftDeserializer<BeneficialOwnerOther._Fields, BeneficialOwnerOther> {

    public KonturBeneficialOwnerOtherDeserializer() {
        addFieldNameConverter("fullName", field -> "fullname");
    }

    @Override
    protected BeneficialOwnerOther._Fields getField(String fieldName) {
        return BeneficialOwnerOther._Fields.findByName(fieldName);
    }

    @Override
    protected BeneficialOwnerOther newInstance() {
        return new BeneficialOwnerOther();
    }
}
