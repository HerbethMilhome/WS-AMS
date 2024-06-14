package com.ras.ras_test.mapper;

import com.ras.ras_test.dto.SubscriptionTypeDTO;
import com.ras.ras_test.model.SubscriptionType;

public class SubscriptionTypeMapper {

    public static SubscriptionType fromDtoToEntity(SubscriptionTypeDTO type) {
        return SubscriptionType.builder()
                .id(type.getId())
                .name(type.getName())
                .accessMonths(type.getAccessMonths())
                .price(type.getPrice())
                .productKey(type.getProductKey())
                .build();
    }
}
