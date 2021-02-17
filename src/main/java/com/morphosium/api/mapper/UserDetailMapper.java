package com.morphosium.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserDetailMapper {

    UserDetailMapper INSTANCE = Mappers.getMapper(UserDetailMapper.class);


}