package com.example.perpus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.perpus.entity.DaftarBuku;
import com.example.perpus.service.DaftarBukuService;

@Controller
public class DaftarBukuController {

    @Autowired
    private DaftarBukuService daftarBukuService;

    @GetMapping("/daftar_buku")
    public String showDaftarBuku(Model model) {
        List<DaftarBuku> books = daftarBukuService.getAllBooks();
        Long totalBooksAvailable = daftarBukuService.getTotalBooksAvailable();
        model.addAttribute("books", books);
        model.addAttribute("totalBooksAvailable", totalBooksAvailable); // Mengirim total buku tersedia ke view

        return "daftar_buku"; 
    }

    @GetMapping("/daftar_tambah_buku")
    public String showBook(Model model) {
        List<DaftarBuku> books = daftarBukuService.getAllBooks();
        // model.addAttribute("book", new DaftarBuku());
        model.addAttribute("books", books);
        model.addAttribute("bookForm", new DaftarBuku());
        return "daftar_tambah_buku";
    }

    @GetMapping("/book/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("bookForm", new DaftarBuku()); // Initialize a new book form
        return "add_book"; // Map to the add_book.html view
    }

    @PostMapping("/book/submit")
    public String submitBook(@ModelAttribute("bookForm") DaftarBuku book) {
        daftarBukuService.tambahBuku(book); // Save the book
        return "redirect:/daftar_tambah_buku"; // Redirect to the add book form after submission
    }

    @PostMapping("/book/update")
    public String updateBook(@ModelAttribute("bookForm") DaftarBuku book) {
        daftarBukuService.updateBook(book); // Perbarui data di database
        return "redirect:/daftar_tambah_buku"; // Redirect kembali ke halaman daftar
    }

    @GetMapping("/daftar_tambah_buku/{idBook}")
    public String showEditBookForm(@PathVariable("idBook") String idBook, Model model) {
        DaftarBuku book = daftarBukuService.getBookById(idBook); // Ambil data berdasarkan idBook
        model.addAttribute("bookForm", book); // Isi form dengan data buku
        return "daftar_tambah_buku"; // Tampilkan halaman form dengan data yang diisi
    }

    @PostMapping("/book/delete/{idBook}")
    public String deleteBook(@PathVariable("idBook") String idBook) {
        daftarBukuService.deleteBookById(idBook); // Hapus buku berdasarkan ID
        return "redirect:/daftar_tambah_buku"; // Redirect kembali ke halaman daftar buku
    }
}
