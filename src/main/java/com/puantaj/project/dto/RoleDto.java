package com.puantaj.project.dto;

import com.puantaj.project.models.ERole;
import lombok.Data;

@Data
public class RoleDto {
    private ERole name;
    private String description;
}
