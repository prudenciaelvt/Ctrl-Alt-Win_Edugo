package com.example.edugo_app.data

data class lessoncard(
    val judul: String,
    val kelas: String,
    val classCode: String,
    val jumlahsiswa: String,
    val jumlahtugas: String,
    val persentase: String,
    val score: String
)

val desainGrafisCard = lessoncard (
    judul = "Desain Grafis 1",
    kelas = "Desain Komunikasi Visual",
    classCode = "1DKV",
    jumlahsiswa = "20 Siswa",
    jumlahtugas = "7 Tugas",
    persentase = "100%",
    score = "80"
)

val matematikaCard = lessoncard (
    judul = "Matematika",
    kelas = "Desain Komunikasi Visual",
    classCode = "1DKC",
    jumlahsiswa = "20 Siswa",
    jumlahtugas = "7 Tugas",
    persentase = "80%",
    score = "90"
)
