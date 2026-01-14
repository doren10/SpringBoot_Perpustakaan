package com.example.perpus.controller;


import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.perpus.entity.Peminjaman;
import com.example.perpus.repository.PeminjamanRepository;
import com.example.perpus.service.PeminjamanService;


@Controller
public class PengembalianController {
    @Autowired
    private PeminjamanRepository peminjamanRepository;


     @GetMapping("/pengembalian")
    public String showPengembalian(Model model) {
        List<Peminjaman> listPeminjaman = peminjamanRepository.findAll();
        model.addAttribute("listPeminjaman", listPeminjaman);
        return "pengembalian";  // This will map to /src/main/resources/templates/data_diri.html
    }
    @Autowired
    private PeminjamanService peminjamanService;
    @PostMapping("/pengembalian/submit")
    public String updatePengembalian(
        @RequestParam("id") Long id,
        @RequestParam("tanggalPengembalian") String tanggalPengembalianStr,
        Model model
    ) {
        // Konversi string ke LocalDate
        LocalDate tanggalPengembalianBaru = LocalDate.parse(tanggalPengembalianStr);


        // Update pengembalian
        Peminjaman updatedPeminjaman = peminjamanService.updatePengembalian(id, tanggalPengembalianBaru);


        // Tambahkan ke model untuk konfirmasi di frontend (opsional)
        model.addAttribute("updatedPeminjaman", updatedPeminjaman);


        return "redirect:/pengembalian"; // Alihkan ke halaman lain
    }
}

