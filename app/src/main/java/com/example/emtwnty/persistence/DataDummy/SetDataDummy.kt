package com.example.emtwnty.persistence.DataDummy

import com.example.emtwnty.R
import com.example.emtwnty.persistence.*

/** -Tanggal Pengerjaan:
 *  - 7 Mei 2020
 *  - 8 mei 2020
 *  - 9 mei 2020
 *  - 10 mei 2020
 *  - 11 mei 2020
 *  - 14 Mei 2020
 *  - 15 Mei 2020
 *  - 16 mei 2020
 *  Nama : Muiz Ahsanu Haqi
 *  Kelas: IF-5
 *  NIM  : 10117199
 * */

class SetDataDummy {
    companion object{
        fun createDataSet(): ArrayList<FriendsList>{
            val list = ArrayList<FriendsList>()
            list.add(
                FriendsList(1,"Faiz Zainul","Pukis", R.drawable.pukis)
            )
            list.add(
                FriendsList(2,"Iqbal Atma","Bale",R.drawable.iqbal)
            )
            list.add(
                FriendsList(3,"Annisa Salsabilla","Ann",R.drawable.sabil)
            )
            return list
        }

        fun dailyDataSet():ArrayList<Daily>{
            val list = ArrayList<Daily>()
            list.add(
                Daily(1,"Solat Subuh","4:30 AM","true")
            )
            list.add(
                Daily(2,"Olahraga","7:00 AM","false")
            )
            list.add(
                Daily(3,"Sarapan","9:00 AM","false")
            )
            list.add(
                Daily(4,"Mengerjakan Tugas","7:30 PM","false")
            )
            return list
        }

        fun galleryDataSet(): ArrayList<GalleryEntity>{
            val list = ArrayList<GalleryEntity>()
            list.add(
                GalleryEntity(1,"https://i.ibb.co/4dnB6yb/553-5532812-bungo-stray-dogs-do-dazai-hd-png-download.png")
            )
            list.add(GalleryEntity(2,"https://i.ibb.co/PDLWJtJ/naruto.png"))
            list.add(GalleryEntity(3,"https://i.ibb.co/4ms8pWL/1529036384203.jpg"))
            list.add(GalleryEntity(4,"https://i.ibb.co/t2NqXCV/wp2382610.jpg"))
            list.add(GalleryEntity(5,"https://i.ibb.co/Q93nYFZ/MTBMB-book5.jpg"))
            list.add(GalleryEntity(6,"https://i.ibb.co/WfGvs4g/EUMLx-NXWAAE6-Vf-I.jpg"))
            return list
        }

        fun musicVideoDataSet(): ArrayList<MusicVideoEntity>{
            val list = ArrayList<MusicVideoEntity>()
            list.add(MusicVideoEntity(1,"Billie Eillish - Everything I Wanted","Billie Eillish","qCTMq7xvdXU"))
            list.add(MusicVideoEntity(2,"Chintya Gabriella - Percaya Aku","Chintya Gabriella","kEKCOKnoCqY"))
            list.add(MusicVideoEntity(3,"Mawar De Jongh - Lebih Dari Egoku","Mawar De Jongh","pNnAUwWnyNg"))
            return list
        }

        fun profileDataSet(): ArrayList<ProfileEntity>{
            val list = ArrayList<ProfileEntity>()
            list.add(
                ProfileEntity(
                    1,
                    "Muiz Ahsanu Haqi",
                    R.drawable.me,
                    "Saya adalah mahasiswa di Universitas Komputer Indonesia yang bercita-cita menjadi Software Developers. Saya seorang perfectionist dan selalu negative thinking",
                    "087823604892",
                    "muizahsanu@gmail.com",
                    "muiz.ahsanu",
                    "link map"
                )
            )
            return list
        }
    }
}