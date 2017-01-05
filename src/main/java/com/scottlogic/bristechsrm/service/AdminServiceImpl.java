package com.scottlogic.bristechsrm.service;


import com.scottlogic.bristechsrm.dao.AdminRepository;
import com.scottlogic.bristechsrm.domain.Admin;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Iterable<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public void add(final Admin admin) {
        adminRepository.save(admin);
    }
}