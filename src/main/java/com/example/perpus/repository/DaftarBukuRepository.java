package com.example.perpus.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.perpus.entity.DaftarBuku;

@Repository

public interface DaftarBukuRepository extends JpaRepository<DaftarBuku, String>{
    @Query("SELECT COUNT(b) FROM DaftarBuku b")
    Long countTotalBooks();
}