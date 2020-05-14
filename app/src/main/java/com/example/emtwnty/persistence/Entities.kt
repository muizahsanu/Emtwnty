package com.example.emtwnty.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

/** -Tanggal Pengerjaan:
 *  - 14 mei 2020
 *  - 15 Mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

@Entity(tableName = "daily")
data class Daily(
    @PrimaryKey
    val id: Int,
    val judul_aktivitas: String,
    val waktu_aktivitas: String
)

@Entity(tableName = "friendslist")
data class FriendsList(
    @PrimaryKey
    val id: Int,
    val nama_lengkap: String,
    val nama_panggilan: String,
    val image: Int
)

@Entity(tableName = "galleryEntity")
data class GalleryEntity(
    @PrimaryKey
    val id: Int,
    val image: String
)

@Entity(tableName = "musicVideo")
data class MusicVideoEntity(
    @PrimaryKey
    val id: Int,
    val judulMusic: String,
    val penyanyi: String,
    val videoUri: String
)

@Entity(tableName = "profile")
data class ProfileEntity(
    @PrimaryKey
    val id: Int,
    val nama: String,
    val profileImage: Int,
    val descDiri: String,
    val phoneNumber: String,
    val email: String,
    val instagram: String,
    val mapDir: String
)