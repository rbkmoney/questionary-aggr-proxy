package com.rbkmoney.questionary.aggr.proxy.serialize.dadata;

import com.fasterxml.jackson.databind.JsonNode;
import com.rbkmoney.questionary.aggr.proxy.serialize.AbstractThriftDeserializer;
import com.rbkmoney.questionary.aggr.proxy.serialize.extractor.AddressFieldExtractor;
import com.rbkmoney.questionary.aggr.proxy.serialize.extractor.FieldExtractor;
import com.rbkmoney.questionary.aggr.proxy.util.CommonHelper;
import com.rbkmoney.questionary_proxy_aggr.dadata_address.Address;
import com.rbkmoney.questionary_proxy_aggr.dadata_party.PartyContent;

public class DaDataPartyContentDeserializer extends AbstractThriftDeserializer<PartyContent._Fields, PartyContent> {

    public DaDataPartyContentDeserializer() {
        addCustomFieldExtractor("address", new PartyAddressFieldExtractor());
        addCustomFieldExtractor("ogrn_date", (instance, node) -> {
            instance.setOgrnDate(CommonHelper.stringToLocalDateTime(node.toString()).toString());
        });
    }

    @Override
    protected PartyContent._Fields getField(String fieldName) {
        return PartyContent._Fields.findByName(fieldName);
    }

    @Override
    protected PartyContent newInstance() {
        return new PartyContent();
    }

    private static final class PartyAddressFieldExtractor implements FieldExtractor<PartyContent> {

        private final AddressFieldExtractor addressFieldExtractor;

        PartyAddressFieldExtractor() {
            this.addressFieldExtractor = new AddressFieldExtractor();
        }

        @Override
        public void extract(PartyContent instance, JsonNode node) {
            final Address address = new Address();
            addressFieldExtractor.extract(address, node);
            instance.setAddress(address);
        }
    }

}
