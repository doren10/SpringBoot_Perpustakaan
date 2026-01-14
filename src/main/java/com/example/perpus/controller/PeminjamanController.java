package com.example.perpus.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.perpus.entity.Peminjaman;
import com.example.perpus.service.PeminjamanService;


@Controller
public class PeminjamanController {
    @GetMapping("/peminjaman")
    public String showPeminjamanPage(Model model) {
        model.addAttribute("peminjamanForm", new Peminjaman()); // Tambahkan objek kosong untuk form
        return "peminjaman"; // Return nama template HTML
    }
    @GetMapping("/daftar_peminjam")
    public String showPeminjam(Model model) {
        List<Peminjaman> riwayatPeminjaman = peminjamanService.getAllPeminjaman();
        model.addAttribute("riwayatPeminjaman", riwayatPeminjaman);
        return "daftar_peminjam";
    }


    private final PeminjamanService peminjamanService;


    @Autowired
    public PeminjamanController(PeminjamanService peminjamanService) {
        this.peminjamanService = peminjamanService;
    }


    @PostMapping("/peminjaman/submit")
    public String submitPeminjaman(@ModelAttribute("peminjamanForm") Peminjaman peminjaman, Model model) {
        if (peminjaman.getDenda() == null) {
            peminjaman.setDenda(0); // Tetapkan nilai default
        }
         if (peminjaman.getStatus() == null || peminjaman.getStatus().isEmpty()) {
        peminjaman.setStatus("dipinjam"); // Tetapkan nilai default
    }
        peminjamanService.savePeminjaman(peminjaman);
        model.addAttribute("message", "Peminjaman berhasil disimpan!");
        return "redirect:/peminjaman"; // Redirect ke halaman daftar peminjaman
    }
}
