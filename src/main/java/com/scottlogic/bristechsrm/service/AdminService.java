package com.scottlogic.bristechsrm.service;

import com.scottlogic.bristechsrm.domain.Admin;

public interface AdminService {
    Iterable<Admin> getAdmins();
    void add(final Admin admin);
}