package com.rbkmoney.questionary.aggr.proxy.serialize.kontur;

import com.rbkmoney.questionary.aggr.proxy.serialize.AbstractThriftDeserializer;
import com.rbkmoney.questionary.aggr.proxy.serialize.converter.UnionThriftFieldConverter;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_req.Contractor;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_req.RegIndividualEntity;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_req.RegLegalEntity;
import com.rbkmoney.questionary_proxy_aggr.kontur_focus_req.RegResponse;

public class KonturRegResponseDeserializer extends AbstractThriftDeserializer<RegResponse._Fields, RegResponse> {

    private static final ContractorIPConverter CONTRACTOR_IP_CONVERTER = new ContractorIPConverter();

    private static final ContractorULConverter CONTRACTOR_UL_CONVERTER = new ContractorULConverter();

    public KonturRegResponseDeserializer() {
        addFieldNameConverter("IP", field -> {
            return "private_entity";
        });
        addFieldNameConverter("UL", field -> {
            return "private_entity";
        });
        addUnionFieldConverter("IP", CONTRACTOR_IP_CONVERTER);
        addUnionFieldConverter("UL", CONTRACTOR_UL_CONVERTER);
    }

    @Override
    protected RegResponse._Fields getField(String fieldName) {
        return RegResponse._Fields.findByName(fieldName);
    }

    @Override
    protected RegResponse newInstance() {
        return new RegResponse();
    }

    private static final class ContractorIPConverter implements UnionThriftFieldConverter<Contractor, RegIndividualEntity> {

        @Override
        public Contractor union(RegIndividualEntity thriftInstance) {
            return Contractor.individual_entity(thriftInstance);
        }

        @Override
        public Class<RegIndividualEntity> type() {
            return RegIndividualEntity.class;
        }

    }

    private static final class ContractorULConverter implements UnionThriftFieldConverter<Contractor, RegLegalEntity> {

        @Override
        public Contractor union(RegLegalEntity thriftInstance) {
            return Contractor.legal_entity(thriftInstance);
        }

        @Override
        public Class<RegLegalEntity> type() {
            return RegLegalEntity.class;
        }

    }

}
