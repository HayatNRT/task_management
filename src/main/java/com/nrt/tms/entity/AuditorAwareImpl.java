package com.nrt.tms.entity;

import com.nrt.tms.config.CustomUserDetail;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (principal instanceof CustomUserDetail) {
                CustomUserDetail customUserDetail = (CustomUserDetail) principal;
                ApplicationUser applicationUser = customUserDetail.getUser();
                return Optional.ofNullable(applicationUser.getUid());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
