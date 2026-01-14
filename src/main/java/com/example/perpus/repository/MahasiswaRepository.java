package com.example.perpus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.perpus.entity.Mahasiswa;




public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Integer> {
        Mahasiswa findByUsername(String username);
        long count();
}

