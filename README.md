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

  ![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/c7f92d0e4639203f2dac8ba92f1aec2b57bf5077/Source%20Images%20Program%20Investasi/UML/UML%20Investasi-Keseluruhan%20Alur.png)

  Diagram UML di atas menggambarkan arsitektur dari program investasi ini. Program diawali dari kelas "Main", yang menjalankan metode "main()" untuk memulai aplikasi. Kelas ini menggunakan "AuthService" untuk mengelola proses autentikasi, di mana pengguna dapat login sebagai "Admin" atau "Customer", yang keduanya merupakan turunan dari kelas abstrak "User". Setelah autentikasi berhasil, kendali beralih ke "MenuService", yang menyediakan berbagai menu pilihan untuk mengelola produk investasi tergantung role yang dipilih. Input dari pengguna dikendalikan oleh kelas "InputUtil", yang berfungsi untuk membaca masukan dari terminal. Investasi yang tersedia diwakili oleh kelas "Saham" dan "SBN", masing-masing memiliki atribut seperti "nama", "harga", dan informasi tambahan terkait. Setiap "Customer" memiliki objek "Portofolio", yang berisi data investasi berupa peta nama instrumen ke jumlah unit dan harga beli. Relasi antar kelas menunjukkan bahwa "Main" bergantung pada "AuthService" dan "AuthService" juga bergantung ke "Main", "AuthService" mengelola objek "User", dan "MenuService" berinteraksi dengan hampir ke semua entitas seperti "Customer", "Saham", "SBN", serta "Portofolio" untuk menjalankan operasi program investasi.
  
# Alur Program Investasi
   Program ini adalah program investasi sederhana yang dijalankan lewat terminal. Pertama-tama, pengguna login dengan username dan password yang sudah disediakan. Setelah berhasil login, pengguna akan diarahkan ke menu sesuai dengan perannya, apakah sebagai admin atau customer. Admin bisa menambah saham, mengubah harga saham, dan menambah produk SBN. Sementara customer bisa membeli atau menjual saham, membeli SBN, melakukan simulasi investasi SBN, dan melihat portofolio investasinya. Semua data disimpan langsung di program tanpa database, dan input dari pengguna divalidasi supaya input tidak salah.
   
## Login
   Pada awal program, pengguna harus melakukan login dengan memasukkan username dan password. Data username dan password ini sudah ditentukan sebelumnya (hardcoded) di dalam program. Saat pengguna mengetikkan identitasnya, sistem akan mencocokkan input tersebut dengan data yang ada. Jika username dan password sesuai, pengguna akan berhasil masuk dan diarahkan ke menu utama sesuai dengan perannya, apakah sebagai admin atau customer. Proses login ini bertujuan untuk membedakan hak akses antara admin dan customer di dalam sistem.


### Login Admin

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Login/Admin/Login%20Admin.png)
   Pertama-tama kita input identitas yaitu, username dan password khusus admin. Gambar di atas merupakan screenshot login page admin yang kita sudah isi dengan username dan password khusus admin.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Login/Admin/Berhasil%20login%20admin.png)
   Setelah itu akan tampil pesan bahwa kita berhasil login sebagai admin.


#### Validasi Login Admin

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Login/Admin/Validasi%20kosong.png)
   Jika kita menginput data identitas yang kosong, akan tampil pesan yang mengatakan kalau kita harus mengisi identitas dengan lengkap dan program akan meminta untuk input ulang.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Login/Admin/Validasi%20salah%20identitas.png)
   Jika kita salah memasukkan data identitas, maka akan tampil pesan yang mengatakan kalau identitas yang kita input salah dan program akan meminta untuk input ulang.


### Login Customer

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Login/Customer/Login%20user.png)
   Pertama-tama kita input identitas yaitu, username dan password khusus customer. Gambar di atas merupakan screenshot login page customer yang kita sudah isi dengan username dan password khusus customer.
   
![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Login/Customer/Berhasil%20login%20user.png)
       Setelah itu akan tampil pesan bahwa kita berhasil login sebagai admin. Pengguna dapat menekan enter untuk melanjutkan program.

#### Validasi Login Customer

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Login/Customer/Validasi%20identitas%20kosong.png)
   Jika kita melakukan input data identitas yang kosong, akan tampil pesan yang mengatakan kalau kita harus mengisi identitas dengan lengkap dan program akan meminta untuk input ulang.
   
![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Login/Customer/Validasi%20salah%20identitas.png)
   Jika kita salah memasukkan data identitas, maka akan tampil pesan error, lalu enter dan pengguna harus melakukan input ulang.

## Skenario Role Admin
   Setelah berhasil login sebagai admin, pengguna akan diarahkan ke menu khusus admin. Di dalam menu ini admin memiliki tugas untuk mengelola data investasi yang ada dalam sistem. Admin dapat menambahkan saham baru dengan mengisi kode, nama perusahaan, dan harga saham. Admin juga bisa mengubah harga saham yang sudah terdaftar untuk menyesuaikan nilai pasar. Selain itu, admin diberi akses untuk menambahkan produk SBN (Surat Berharga Negara) baru, lengkap dengan bunga, jangka waktu, tanggal jatuh tempo, dan kuota nasional. Setelah selesai, admin juga bisa logout dari sistem.


### Validasi Menu Admin

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/b478db250f056a31ef37a4c6e29c4dd69d1ae202/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Milih%20salah%20input.png)
   Jika kita menginput angka atau huruf selain yang tertera pada Menu Admin maka program akan menampilkan pesan kesalahan.
   
![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/b478db250f056a31ef37a4c6e29c4dd69d1ae202/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Validasi%20salah%20input.png)
   Gambar di atas merupakan pesan kesalahan saat kita salah input, kemudian program akan meminta input ulang.


### Saham

   ![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/b478db250f056a31ef37a4c6e29c4dd69d1ae202/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Milih%20pilihan%20saham.png)
   Jika admin memilih opsi "1. Saham" pada Menu Admin, admin akan dapat menambahkan saham baru dengan cara memasukkan kode saham, nama perusahaan, serta harga saham. Selain itu, admin juga dapat memperbarui harga saham yang sudah ada agar sesuai dengan perubahan nilai pasar. Berikut merupakan skenario-skenarionya,


#### Tambah Saham

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Menambahkan%20saham/Milih%20pilihan%201.png)
   Admin dapat memilih opsi "1. Tambah Saham" pada menu Kelola Saham untuk menambahkan saham baru.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Menambahkan%20saham/Menambahkan%20saham.png)
   Misal kita menambahkan saham perusahaan Tesla, pertama kita isi kode saham, lalu tambahkan nama perusahaan, dan isi harga sahamnya.


##### Validasi Tambah Saham

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Menambahkan%20saham/Kode%20saham%20sama.png)
   Jika kita menginput kode saham yang sama, maka akan tampil pesan bahwa kode saham tersebut sudah ada dan program akan meminta untuk input ulang.


#### Mengubah Harga Saham

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Mengubah%20saham/Memilih%20pilihan%202.png)
   Admin dapat memilih opsi "2. Ubah Harga Saham" pada menu Kelola Saham untuk mengubah harga saham.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Mengubah%20saham/Melihat%20saham%20yang%20ingin%20diubah.png)
   Admin dapat melihat daftar saham dan melihat saham apa yang harganya akan diubah.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Mengubah%20saham/Mengubah%20harga%20saham.png)
   Misal kita mengubah harga saham Tesla yang tadinya seharga Rp5.000.000 menjadi Rp6.000.000.


##### Validasi Mengubah Harga Saham

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Mengubah%20saham/Saham%20kosong.png)
   Jika belum ada saham yang dibuat, maka program akan menampilkan pesan bahwa belum ada saham yang tercatat.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Mengubah%20saham/Salah%20input%20nama.png)
![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Mengubah%20saham/Peringatan%20tidak%20ada%20saham.png)
   Jika kita salah menginput kode saham, maka program akan menampilkan pesan bahwa saham dengan kode tersebut tidak ditemukan.


#### Melihat Daftar Saham

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Melihat%20saham/Memilih%20pilihan%203.png)
   Admin dapat memilih opsi "3. Lihat Daftar Saham" pada menu Kelola Saham untuk melihat daftar saham.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Melihat%20saham/Melihat%20daftar%20saham.png)
   Setelah itu program akan menampilkan keseluruhan daftar saham yang telah dibuat.


##### Validasi Melihat Daftar Saham

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Melihat%20saham/Saham%20kosong.png)
   Jika daftar saham kosong, maka program akan menampilkan pesan bahwa belum ada saham yang tercatat.


#### Menghapus Saham

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Menghapus%20saham/Memilih%20pilihan%204.png)
   Admin dapat memilih opsi "4. Hapus Saham" pada menu Kelola Saham untuk menghapus saham yang telah dibuat.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/2cc436688747c8a6c2cf5205c262203e1fb2eaa7/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Menghapus%20saham/Menghapus%20saham.png)
   Lalu admin diminta untuk menginput kode saham yang ingin dihapus, setelah itu program akan menampilkan bahwa saham berhasil dihapus.


##### Validasi Menghapus Saham

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/b478db250f056a31ef37a4c6e29c4dd69d1ae202/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Admin/Saham/Menghapus%20saham/Saham%20kosong.png)
   Jika tidak ada saham untuk dihapus, maka program akan menampilkan bahwa belum ada saham yang tersedia.




![image alt]()


![image alt]()


![image alt]()


![image alt]()


![image alt]()


![image alt]()


![image alt]()
### SBN






## Skenario Role Customer
   Setelah berhasil login sebagai customer(user), pengguna akan diarahkan ke menu khusus customer. Di dalam menu ini customer dapat membeli saham, menjual saham. Selain membeli saham, customer juga dapat membeli SBN, melihat simulasi bunga SBN, melihat portofolio dari produk investasi yang dimiliki. Apabila sudah selesai menggunakan program, customer juga dapat melakukan logout.

### Beli Saham

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Beli%20saham/Milih%20pilihan%201.png)
   Setelah login sebagai customer, pengguna akan diberi menu pilihan customer. Gambar di atas menunjukkan pengguna memilih pilihan 1, yang mana pilihan 1 merupakan menu untuk melakukan pembelian saham.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Beli%20saham/Lihat%20daftar%20saham.png)
   Setelah memilih menu 1 dan menekan enter, maka akan ditampilkan daftar saham terlebih dahulu. Kemudian diarahkan untuk menekan enter untuk langkah selanjutnya.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Beli%20saham/Berhasil%20beli%20saham.png)
   Setelah itu pengguna diarahkan untuk memasukkan kode saham, jumlah lembar saham yang akan dibeli. Dan muncul pesan pembelian saham berhasil, lalu pengguna diarahkan untuk menekan enter.

#### Validasi Beli Saham

![image alt]()


![image alt]()



### Jual Saham

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Jual%20saham/Milih%20jual%20saham.png)
   Gambar di atas menunjukkan pengguna memilih pilihan 2, yang mana pilihan 2 merupakan menu untuk melakukan penjualan saham.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Jual%20saham/Input%20saham%20yg%20dijual.png)
   Selanjutnya ditampilkan jumlah saham yang dimiliki. Kemudian pengguna diarahkan untuk memasukkan kode saham dan jumlah lembar saham yang ingin dijual. Pengguna diarahkan untuk menekan enter agar dapat menuju ke langkah selanjutnya.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Jual%20saham/Penjualan%20berhasil.png)
   Muncul pesan penjualan saham berhasil yang menandakan saham sudah berhasil terjual. Pengguna dapat menekan enter untuk melanjutkan.

#### Validasi Jual Saham

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Jual%20saham/Pesan%20validasi.png)
   Apabila pengguna memasukkan kode saham yang tidak sesuai atau jumlah lembar saham yang tidak sesuai, maka akan muncul pesan validasi seperti pada gambar di atas.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Jual%20saham/Validasi%20penjualan.png)
   Pengguna juga tidak boleh memberi input kosong, apabila melakukannya maka akan muncul pesan error seperti gambar di atas.

### Beli SBN

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Beli%20SBN/Milih%20beli%20SBN.png)
   Selanjutnya merupakan skenario apabila customer memilih menu 3 yakni menu untuk membeli saham. Setelah memilih menu 3 customer diarahkan untuk menekan enter.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Beli%20SBN/Tampilan%20daftar%20SBN.png)
   Setelah menekan enter, maka sistem clear screen bekerja dan menampilkan daftar SBN apa saja yang tersedia.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Beli%20SBN/Beli%20SBN.png)
   Lalu pengguna diarahkan untuk memasukkan nama SBN dan nominal pembelian SBN. Kemudian akan muncul pesan pembelian berhasil dan tekan enter untuk melanjutkan program.

#### Validasi Beli SBN

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Beli%20SBN/Val%20sistem%20klo%20lebih%20dari%20kuota%20nasional.png)
   Apabila customer melakukan pembelian melewati batas kuota nasional yang tersedia, maka akan muncul pesan error seperti gambar di atas.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Beli%20SBN/Validasi%20SBN.png)
   Jika customer tidak memasukkan data apapun, maka akan muncul pesan error bahwa input tidak boleh kosong dan pengguna diarahkan untuk memasukkan data ulang.

### Simulasi Bunga SBN

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Simulasi%20bunga%20SBN/Memilih%20simulasi.png)
   Customer juga dapat melihat simulasi dari bunga SBN yang dimiliki, dengan cara memilih menu pilihan nomor 4.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Simulasi%20bunga%20SBN/Tampilan%202.png)
   Kemudian setelah memilih menu 4, akan ditampilkan perkiraan bunga SBN perbulan. Lalu pengguna diarahkan untuk menekan enter.

### Lihat Portofolio

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Portofolio/Memilih%20portofolio.png)
   Selain itu, customer juga dapat melihat portofolio dari semua produk investasi yang dimiliki, baik saham maupun SBN.

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Portofolio/Tampilan%20portofolio.png)
   Kemudian akan ditampilkan portofolio dari customer yang memuat nilai saham yang dimiliki, nama SBN yang dimiliki, simulasi bunga dari masing-masing SBN dan total bunga SBN.

### Validasi Menu Customer

![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Milih%20salah%20input.png)
![image alt](https://github.com/PradivaYoga/Tugas_1_PBO/blob/28a79e9cfa12007979e1f354090cad10361d2e4f/Source%20Images%20Program%20Investasi/SS%20Tugas%201/Customer/Validasi%20salah%20input.png)
   Apabila customer melakukan input yang tidak sesuai, seperti angka yang tidak ada dalam menu ataupun huruf dan char lainnya, maka akan ditampilkan pesan error seperti gambar di atas.
   



