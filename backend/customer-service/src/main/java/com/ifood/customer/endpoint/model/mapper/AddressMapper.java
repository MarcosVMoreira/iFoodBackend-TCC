package com.ifood.customer.endpoint.model.mapper;

import com.ifood.customer.endpoint.model.dto.AddressDTO;
import com.ifood.customer.endpoint.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO addressToAdressDTO (Address address);

    Address addressDTOToAddress (AddressDTO addressDTO);

}

