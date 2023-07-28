package com.puantaj.project.service;

import com.puantaj.project.models.ERole;
public interface RoleService {

        void createRole(ERole name, String description);
        void updateRole(Long roleId, String description);
        void deleteRole(Long roleId);
}
