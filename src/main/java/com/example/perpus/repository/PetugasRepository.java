package com.example.perpus.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.perpus.entity.Petugas;


public interface PetugasRepository extends JpaRepository<Petugas, Integer> {
        Petugas findByUsername(String username);
        long count();
}

