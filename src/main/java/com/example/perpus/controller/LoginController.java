package com.example.perpus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.perpus.entity.Mahasiswa;
import com.example.perpus.entity.Peminjaman;
import com.example.perpus.entity.Petugas;
import com.example.perpus.repository.PeminjamanRepository;
import com.example.perpus.repository.MahasiswaRepository;
import com.example.perpus.repository.PetugasRepository;
import com.example.perpus.service.DaftarBukuService;
import com.example.perpus.service.LoginService;
import com.example.perpus.service.PeminjamanService;

@Controller
public class LoginController {

    @Autowired
    private DaftarBukuService daftarBukuService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private PeminjamanService peminjamanService;
    @Autowired
    private PeminjamanRepository peminjamanRepository;
    @Autowired
    private PetugasRepository petugasRepository;
    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logoutPage() {
        return "redirect:/login";
    }

    // @GetMapping("/dashboardpetugas")
    // public String showPetugasDashboard() {
    //     return "admin";
    // }

    @GetMapping("/dashboardadmin")
    public String showAdminDashboard(Model model) {
        long totalBooksBorrowed = peminjamanRepository.countByStatus("dipinjam");
        long totalBooksKembali = peminjamanRepository.countByStatus("kembali");        
        long totalBooks = totalBooksBorrowed + totalBooksKembali;
        long totalMahasiswa = mahasiswaRepository.count();
        long totalPetugas = petugasRepository.count();
        long total = totalMahasiswa + totalPetugas;


        Long totalBooksAvailable = daftarBukuService.getTotalBooksAvailable();

        model.addAttribute("totalBooksBorrowed", totalBooksBorrowed);
        model.addAttribute("totalBooksKembali", totalBooksKembali);
        model.addAttribute("totalBooksAvailable", totalBooksAvailable);
        model.addAttribute("totalBooks", totalBooks);
        model.addAttribute("totalAnggota", total);


        return "admin";
    }

    @GetMapping("/dashboarduser")
    public String showMahasiswaDashboard(Model model) {
        long totalBooksBorrowed = peminjamanRepository.countByStatus("dipinjam");
        long totalBooksKembali = peminjamanRepository.countByStatus("kembali");
        Long totalBooksAvailable = daftarBukuService.getTotalBooksAvailable();

        model.addAttribute("totalBooksBorrowed", totalBooksBorrowed);
        model.addAttribute("totalBooksKembali", totalBooksKembali);
        model.addAttribute("totalBooksAvailable", totalBooksAvailable);

        List<Peminjaman> riwayatPeminjaman = peminjamanService.getAllPeminjaman();
        model.addAttribute("riwayatPeminjaman", riwayatPeminjaman);

        return "user";
    }

    // @PostMapping("/pengguna/delete/{id}")
    // public String deleteUser(@PathVariable Integer id) {
    //     loginService.deleteUser(id);
    //     return "redirect:/pengguna";
    // }

    // @GetMapping("/daftar_peminjam")
    // public String showPeminjam(Model model) {
    //     List<Peminjaman> riwayatPeminjaman = peminjamanService.getAllPeminjaman();
    //     model.addAttribute("riwayatPeminjaman", riwayatPeminjaman);
    //     return "daftar_peminjam";
    // }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        Object user = loginService.validateLogin(username, password); // Mengembalikan Mahasiswa atau Petugas

        if (user != null) {
            if (user instanceof Mahasiswa) {
                return "redirect:/dashboarduser";
            } else if (user instanceof Petugas) {
                return "redirect:/dashboardadmin";
            } else {
                model.addAttribute("error", "Invalid role");
                return "login";
            }
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
