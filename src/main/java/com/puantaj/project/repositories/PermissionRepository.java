package com.puantaj.project.repositories;

import com.puantaj.project.models.EPermission;
import com.puantaj.project.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Optional<Permission> findByName(EPermission name);
}
