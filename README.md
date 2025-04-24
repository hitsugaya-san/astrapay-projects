# 📝 Simple Notes Application

Aplikasi sederhana untuk membuat, menampilkan, dan menghapus catatan (**notes**) menggunakan:

- 🧠 Backend: Java Spring Boot (berbasis [Astrapay starter project](https://github.com/astrapay/astrapay-spring-boot-external))
- 🎨 Frontend: Angular 2
- 💾 Penyimpanan data: In-memory (tanpa database)

---

## 🚀 Fitur Utama

- Menampilkan daftar catatan
- Menambah catatan baru
- Menghapus catatan yang ada
- Validasi form di backend dan frontend (catatan tidak boleh kosong)

---

## ⚙️ Cara Menjalankan Aplikasi

### 1. Jalankan Backend (Spring Boot)

```bash
cd astrapay-spring-boot-external
./mvnw spring-boot:run
```

API akan berjalan di: `http://localhost:8080/api/notes`

## 🛠️ API Endpoints

| Method | Endpoint            | Deskripsi                |
|--------|---------------------|--------------------------|
| GET    | `/api/notes`        | Ambil semua catatan      |
| POST   | `/api/notes`        | Tambah catatan baru      |
| DELETE | `/api/notes/{id}`   | Hapus catatan berdasarkan ID |

---

### 2. Jalankan Frontend (Angular 2)

```bash
cd astrapay-angular
npm install
ng serve
```

Aplikasi dapat diakses di: `http://localhost:4200`

---

## ✅ Validasi

- Catatan **tidak boleh kosong**
- Backend dan Frontend sama-sama melakukan validasi
- Jika validasi gagal, akan ditampilkan pesan error yang sesuai

---

## 📸 Screenshots

- hasil project nya ada di folder screenshots

---