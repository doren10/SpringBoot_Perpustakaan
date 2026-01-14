package com.example.perpus.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.perpus.entity.Mahasiswa;
import com.example.perpus.entity.Petugas;
import com.example.perpus.service.PenggunaService;


@Controller
public class PenggunaController {


    @Autowired
    private PenggunaService penggunaService;


    // Menampilkan semua pengguna (Mahasiswa dan Petugas)
    @GetMapping("/pengguna")
    public String getAllPengguna(Model model) {
        // Ambil semua data mahasiswa dan petugas
        model.addAttribute("mahasiswaList", penggunaService.getAllMahasiswa());
        model.addAttribute("petugasList", penggunaService.getAllPetugas());
        model.addAttribute("mahasiswa", new Mahasiswa());
        model.addAttribute("petugas", new Petugas());
        return "pengguna"; // Nama file template Thymeleaf
    }


    // Menampilkan form untuk menambah mahasiswa
    @GetMapping("/mahasiswa/form")
    public String showTambahMahasiswaForm(Model model) {
        model.addAttribute("Mahasiswa", new Mahasiswa());
        return "tambah-mahasiswa"; // Nama file template HTML untuk form
    }
    // Menambahkan mahasiswa baru
    @PostMapping("/mahasiswa/submit")
    public String tambahMahasiswa(@ModelAttribute("mahasiswa") Mahasiswa mahasiswa) {
        // Panggil service untuk menyimpan data mahasiswa ke database
        penggunaService.saveMahasiswa(mahasiswa);
        return "redirect:/pengguna"; // Redirect ke halaman pengguna
    }
    @GetMapping("/petugas/form")
    public String showTambahPetugasForm(Model model) {
        model.addAttribute("Petugas", new Petugas());
        return "tambah-petugas"; // Nama file template HTML untuk form
    }
    // Menambahkan mahasiswa baru
    @PostMapping("/petugas/submit")
    public String tambahPetugas(@ModelAttribute("petugas") Petugas petugas) {
        // Panggil service untuk menyimpan data mahasiswa ke database
        penggunaService.savePetugas(petugas);
        return "redirect:/pengguna"; // Redirect ke halaman pengguna
    }


    // Menghapus pengguna berdasarkan ID
    @PostMapping("/pengguna/delete/{id}")
    public String deletePengguna(@PathVariable("id") Integer id) {
        // Panggil service untuk menghapus pengguna berdasarkan ID
        penggunaService.deletePenggunaById(id);
        return "redirect:/pengguna"; // Redirect ke halaman pengguna setelah dihapus
    }
}