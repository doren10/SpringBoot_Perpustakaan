package com.example.perpus.controller;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.perpus.entity.Peminjaman;
import com.example.perpus.repository.PeminjamanRepository;
import com.example.perpus.service.PeminjamanService;
@Controller
public class PeminjamanAdminController {
    @Autowired
    private PeminjamanRepository peminjamanRepository;
    @GetMapping("/peminjamanadmin")
    public String showPeminjamanAdmin(Model model) {
        List<Peminjaman> listPeminjaman = peminjamanRepository.findAll();
        model.addAttribute("listPeminjaman", listPeminjaman);
        model.addAttribute("peminjamanadminForm", new Peminjaman()); // Tambahkan objek kosong untuk form
        return "peminjaman_admin";  // This will map to /src/main/resources/templates/data_diri.html
    }
    private final PeminjamanService peminjamanService;
    @Autowired
    public PeminjamanAdminController(PeminjamanService peminjamanService) {
        this.peminjamanService = peminjamanService;
    }


    @PostMapping("/peminjamanadmin/submit")
    public String submitPeminjaman(@ModelAttribute("peminjamanadminForm") Peminjaman peminjaman, Model model) {
        if (peminjaman.getDenda() == null) {
            peminjaman.setDenda(0); // Tetapkan nilai default
        }
         if (peminjaman.getStatus() == null || peminjaman.getStatus().isEmpty()) {
        peminjaman.setStatus("dipinjam"); // Tetapkan nilai default
    }
        peminjamanService.savePeminjaman(peminjaman);
        model.addAttribute("message", "Peminjaman berhasil disimpan!");
        return "redirect:/peminjamanadmin"; // Redirect ke halaman daftar peminjaman
    }


    @PostMapping("/pengembalianadmin/submit")
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


        return "redirect:/peminjamanadmin"; // Alihkan ke halaman lain
    }


}

