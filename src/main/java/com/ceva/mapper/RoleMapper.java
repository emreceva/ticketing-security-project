package com.ceva.mapper;

import com.ceva.dto.RoleDTO;
import com.ceva.entity.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

   private final ModelMapper modelMapper;

    public RoleMapper(ModelMapper modelMapper) {

        this.modelMapper = modelMapper;
    }

    //convertToEntity
    public Role convertToEntity(RoleDTO dto){

        return modelMapper.map(dto,Role.class);
    }

    //convertToDto
    public RoleDTO convertToDto(Role entity){

        return modelMapper.map(entity,RoleDTO.class);
    }
}
