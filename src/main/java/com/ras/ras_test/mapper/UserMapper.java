package com.ras.ras_test.mapper;

import com.ras.ras_test.dto.UserDTO;
import com.ras.ras_test.model.SubscriptionType;
import com.ras.ras_test.model.User;
import com.ras.ras_test.model.UserType;

public class UserMapper {

    public static User fromDtoToEntity(UserDTO dto, UserType ut, SubscriptionType st) {
        return User.builder()
                .id(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .phone(dto.getPhone())
                .dtSubscription(dto.getDtSubscription())
                .dtExpiration(dto.getDtExpiration())
                .idUserType(ut)
                .idSubscriptionsType(st)
                .build();
    }
}
