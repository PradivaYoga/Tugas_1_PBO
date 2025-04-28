# Tugas_1_PBO
Nama Anggota:
- Steven Satyam Wijanarko (2405551036)
- I Gede Pradiva Yoga Krisnanda (2405551099)

# Daftar Isi:
1. [Program Investasi](#Program-Investasi)
2. [Diagram UML](#Diagram-UML-Program-Investasi)
3. [Alur Program](#Alur-Program-Investasi)
   1. [Login](#login)
   2. [Skenario Role Admin](#Skenario-Role-Admin)
   3. [Skenario Role Customer](#Skenario-Role-Customer)
   4. [Validasi](#Validasi)

# Program Investasi
  Program Investasi dengan menggunakan Pemrograman Berbasis Objek/ Object Oriented Programming dengan bahasa pemrograman Java adalah suatu program investasi yang dimana terdapat dua produk investasi di dalamnya yakni saham dan SBN (Surat Berharga Negara). Program investasi ini juga dapat diakses oleh dua jenis user, yakni Admin dan Customer. 
  Admin memiliki hak akses untuk menambah, menghapus, dan mengupdate data saham serta SBN, sedangkan Customer dapat melihat daftar saham dan SBN yang tersedia, serta melakukan investasi pada kedua instrumen tersebut. Setiap investasi yang dilakukan oleh Customer disimpan dalam objek Investasi, yang mencatat jenis investasi (saham atau SBN) beserta jumlah dan detail lainnya. 
  
  Kemudian untuk username dan password sudah terdata secara hardcode di dalam program,
  Untuk melakukan login sebagai Admin:
  username: admin
  password: admin123

  Untuk melakukan login sebagai Customer:
  username: user
  password: user123
  
  Setelah melakukan login, baik Admin maupun Customer selanjutnya akan ditampilkan menu pilihan sesuai role yang dipilih. Berikut merupakan tampilan menu dari setiap user:
  
  Tampilan Menu Admin:
  1. Saham
  2. SBN
  3. Logout

     Admin>Saham:
     1. Tambah Saham
     2. Ubah Harga Saham
     3. Lihat Daftar Saham
     4. Hapus Saham
     5. Kembali

     Admin>SBN:
     1. Tambah SBN
     2. Lihat Daftar SBN
     3. Hapus SBN
     4. Kembali

  Tampilan Menu Customer:
  1. Beli Saham
  2. Jual Saham
  3. Beli SBN
  4. Simulasi Bunga SBN
  5. Lihat Portofolio
  6. Logout

# Diagram UML Program Investasi
  Di bawah ini merupakan gambar dari diagram UML yang menggambarkan hubungan antar kelas yang menyusun program investasi ini.
  
# Alur Program Investasi
   Program ini adalah program investasi sederhana yang dijalankan lewat terminal. Pertama-tama, pengguna login dengan username dan password yang sudah disediakan. Setelah berhasil login, pengguna akan diarahkan ke menu sesuai dengan perannya, apakah sebagai admin atau customer. Admin bisa menambah saham, mengubah harga saham, dan menambah produk SBN. Sementara customer bisa membeli atau menjual saham, membeli SBN, melakukan simulasi investasi SBN, dan melihat portofolio investasinya. Semua data disimpan langsung di program tanpa database, dan input dari pengguna divalidasi supaya input tidak salah.
   
## Login
   Pada awal program, pengguna harus melakukan login dengan memasukkan username dan password. Data username dan password ini sudah ditentukan sebelumnya (hardcoded) di dalam program. Saat pengguna mengetikkan identitasnya, sistem akan mencocokkan input tersebut dengan data yang ada. Jika username dan password sesuai, pengguna akan berhasil masuk dan diarahkan ke menu utama sesuai dengan perannya, apakah sebagai admin atau customer. Proses login ini bertujuan untuk membedakan hak akses antara admin dan customer di dalam sistem.

### Login Admin
   Pertama-tama kita input identitas yaitu, username dan password khusus admin


### Login Customer


## Skenario Role Admin


## Skenario Role Customer


## Validasi
   
