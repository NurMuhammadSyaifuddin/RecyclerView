# RecyclerView

## Demo
https://user-images.githubusercontent.com/68520848/173992527-5a9252cc-bace-4378-af8b-d54368b22a54.mp4

#### Buka build.gradle level module (app), tambahkan plugin kotlinx-parcelize
``` Ruby
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
    id 'kotlin-parcelize'
}
```

#### Tambahkan View Binding pada build.gradle level module (app) dalam scope android
``` Ruby
    buildFeatures {
        viewBinding true
    }
```

#### Tambahkan library Glide dan Circle Image di dalam scope dependencies
``` Ruby
    // Circle Image
    implementation 'de.hdodenhof:circleimageview:3.1.0'

    // Glide
    implementation 'com.github.bumptech.glide:glide:4.13.0'
```

#### Buat Data Class yang menampung data President
``` Ruby
@Parcelize
data class PresidentModel(
    val poster: String,
    val name: String,
    val desc: String
): Parcelable
```

#### Buat object Repository yang menampung data president
``` Ruby
package com.project.recyclerview

object Repository {
    val presidents = listOf(
        PresidentModel("president1", "Dr. Ir. H. Soekarno", "Dr. Ir. H. SOEKARNO lahir dari keturunan bangsawan Jawa, waktu kecil bernama Kusno yang kemudian akrab dengan panggilan Bung Karno saja. la hanya beberapa tahun hidup bahagia bersama orang tuanya di Blitar. Tamat SD tinggal di Surabaya, indekost di rumah H.O.S. Cokroaminoto, politisi kawakan tokoh Syarikat Islam. Sambil belajar, Soekarno menggembleng jiwa nasionalismenya.\n" +
                "\n" +
                "Lulus SLTA, Soekarno melanjutkan sekolahnya ke ITB di Bandung. Setelah meraih title Ir. pada tahun 1926, H.O.S. Cokroaminoto mengambilnya sebagai menantu. Soekarno kemudian mendirikan PNI (Partai Nasional Indonesia, 1927) dan berhasil merumuskan ajaran Marhaen. Karena merasa khawatir, penjajah Belanda kemudian menjebloskan Soekarno ke penjara Sukamiskin, Bandung (29 Desember 1929). Delapan bulan kemudian baru disidangkan di pengadilan dengan tuduhan mengambil bagian dalam suatu organisasi yang bertujuan melakukan kejahatan di samping usaha menggulingkan kekuasaan Hindia-Belanda. Dalam pembelaannya berjudul Indonesia Menggugat, dengan gagah berani Bung Karno menelanjangi kemurtadan bangsa yang mengaku lebih maju itu. Pada tahun 1933, Belanda membuang Bung Karno ke Endeh, Flores, kemudian memindahkannya ke Bengkulu."),
        PresidentModel("president2", "Soeharto", "SOEHARTO, terlahir dari pasangan suami istri Sukirah dan Kertoredjo. Dulu orang tua itu cuma berharap anak tunggalnya asal bisa membantu di sawah saja. Syukur kalau dapat melanjutkan jabatan menjadi ulu-ulu di kampung mereka, Kemusuk, Argomulyo, Yogyakarta.\n" +
                "\n" +
                "Pak Harto harus bersusah payah untuk bisa sekolah, SD dan SMPnya diselesaikan sampai beberapa kali pindah dari Twir, Yogyakarta, Wuryantoro, Solo, Wonogiri dan Yogyakarta. Disamping itu ia masih menyempatkan sekolah Agama, agar mendapat ilmu dan keteladanan untuk beribadah kepada Tuhan Yang Maha Esa. Kemudian karena terpanggil untuk membela tanah air, Soeharto, si anak desa itu melanjutkan Sekolah Bintara di Gombong.\n" +
                "Setelah terpilih menjadi prajurit teladan, pangkat bintara itu tak lama kemudian menjadi Sersan. Di jaman Jepang Pak Harto masuk polisi, lalu pindah ke Peta sampai berpangkat Komandan Pelopor. Ia resmi menjadi anggota TNI pada 5 Oktober 1945 ketika berusia 24 tahun. Sampai terakhir berpangkat Jenderal."),
        PresidentModel("president3", "B.J. Habibie", "BACHARUDDIN JUSUF HABIBIE, menjadi presiden pada tanggal 21 Mei 1998 menggantikan Jendral Soeharto yang meletakkan jabatan karena dipaksa mundur oleh rakyat. Sebelumnya, B.J. Habibie menjadi wakil presiden Rl ke tujuh periode 1998-2003, tapi ia hanya memangku jabatannya selama kurang lebih 2 bulan.\n" +
                "\n" +
                "Dalam usia 13 tahun, Rudy, demikian Habibie biasa dipanggil, ditinggal wafat ayahnya, Alwie Abdul Jalil Habibie, bekas Kepala Jawatan Pertanian Sulawesi Selatan. Ibunya, RA Tuti Marini Puspowardjo yang asal Yogyakarta menganjurkan Habibie berangkat ke Bandung untuk masuk SMP, kemudian ia menyusul setelah anaknya kelas dua SMA. Setahun di ITB, atas usaha ibunya, Habibie mendapat beasiswa P&K untuk belajar di Jerman Barat. Gelar insinyur mesin dan Kontruksi pesawat terbang diraih Habibie pada usia 21 tahun, ia kemudian meneruskan sekolahnya lagi dengan biaya sendiri. Waktu lulus, Habibie orang pertama di luar Jerman, setelah perang dunia ke II yang membuat skripsi mengenai aeronautika."),
        PresidentModel("president4", "K.H. Abdurrahman Wahid", "GUS DUR, demikian K.H . Abdurrahman Wahid biasa dipanggil, seorang ulama muda yang gemar humor. Luwes bergaul, sikapnya terbuka. Banyak yang menaruh harapan besar ketika ia terpilih sebagai ketua PBNU dalam Muktamar NU ke-27 di Pondok Pesantren Salafiah Safi’yah Sukorejo,Situbondo, Jawa Timur. Apalagi sejak Muktamar itu, NU secara resmi kembali ke Khittah 1926. Artinya NU akan meninggalkan politik praktis dan\n" +
                "tidak ada lagi ikatan organisatoris dengan PPP.\n" +
                "\n" +
                "Tokoh yang tak dapat melihat dengan sempurna ini boleh jadi merupakan satu-satunya presiden di dunia yang terpilih secara demokrasi oleh wakil rakyat. Komposisi keanggotaan DPR-MPR hasil pemilu tahun 1999 rupanya lebih suka memilih Gus Dur, dan enggan memberikan suaranya kepada Megawati Soekarno Putri, satu-satunya pesaing di waktu itu, karena alasan gender."),
        PresidentModel("president5", "Megawati Soekarno Putri", "DYAH PERMATA MEGAWATI SOEKARNO PUTRI, melewatkan masa pendidikannya sejak SD sampai SMA di perguruan Cikini, Jakarta. Megawati yang sempat kuliah di Fakultas Pertanian dan Fakultas Fisiologi di UI tak dapat menyelesaikan kuliahnya karena kemelut politik pasca perebutan kekuasaan dari Soekarno oleh Soeharto pada tahun 1966.\n" +
                "\n" +
                "Rupanya pemerintah tak menghendaki Megawati menjadi pemimpin politik, sebab dengan tampilnya Megawati dikhawatirkan akan mengancam kekuasaan Soeharto. Dengan berbagai cara rezim Soeharto terus menerus berusaha menggusur Megawati dari PDI. Menjelang pemilu 1996 digelar kongres PDI di Medan, dalam penghelatan itu, Soeryadi mantan ketua PDI diangkat lagi menjadi ketua PDI menggantikan Mega. Pendukung Mega marah dan menduduki kantor DPP PDI. Maka terjadilah peristiwa yang dikenal dengan peristiwa 27 Juli."),
        PresidentModel("president6", "Susilo Bambang Yudhoyono", "Presiden Rl Ke VI: 2004-2009. Pria berperawakan tinggi besar ini kian berkibar namanya di era Presiden Gus Dur. Susilo Bambang Yudhoyono, Bahkan Gus Dur pada saat itu sempat menyebut jenderal bintang empat itu sebagai calon presiden yang oke punya.\n" +
                "\n" +
                "Susilo Bambang Yudhoyono, yang lazim disebut pers dengan SBY, lahir di Pacitan, Jateng, 9 September 1949. Karier militernya mulai melonjak setelah SBY menjadi Komandan Peleton di Yonif Linud 330 pada 1974. SBY lantas menjadi Komandan Peleton Yonif 330 pada 1996, dan 1981 menjadi Perwira Operasi MabesTNI AD. Tahun 1996 SBY menjabat sebagai Chief Ministry of Military Observer di Bosnia Herzegovina, lalu meloncat menjadi Assospol Kassospol TNI."),
        PresidentModel("president7", "Ir. H. Joko Widodo", "Jokowi kecil sempat merasakan pahitnya kehidupan saat rumahnya tergusur. Rumah petak sekaligus tempat usaha kayu ayahnya di daerah Cinderejo Lor, digusur dan dijadikan pusat jasa travel. Sang bunda menuturkan bahwa Jokowi kecil adalah sosok pendiam, namun pandai bergaul. Jokowi sebagai orang yang selalu mengalah untuk menghindari pertengkaran. Sikap tersebut diwarisi dari kedua orangtuanya yang selalu mengajarkan makna ikhlas dan bertanggung jawab.\n" +
                "\n" +
                "Jokowi selalu berjalan kaki menuju sekolahnya, disaat temanya bersepeda ontel. Kala itu sekolah tidak terlalu jauh dari rumah dan cukup berjalan kaki. Bakti kepada orangtua ditunjukkan lewat sikap juga sejumlah prestasi. Saat menjadi Walikota Solo hingga menjadi Gubernur DKI Jakarta, orang tidak pernah menyangka perjalanan hidup Joko kecil anak tukang kayu itu kini menjadi orang nomor satu di Indonesia.\n" +
                "\n" +
                "Setelah lulus SMA kemudian melanjutkan kuliah di Fakultas Kehutanan Universitas Gajah Mada lulus tahun 1985, dirinya merantau ke Aceh dan bekerja di salah satu BUMN. Ia kembali ke Solo dan bekerja di Perusahaan yang bergerak di bidang perkayuan, CV. Roda Jati. Tahun 1998 dirinya memulai berbisnis sendiri bermodal dari pengalaman yang dimiliki. Dengan kerja keras, ketekunan dan keuletan, akhirnya Jokowi berhasil mengembangkan bisnisnya dan menjadi seorang eksportir mebel.\n" +
                "\n" +
                "Pada tahun 2005 Jokowi memutuskan untuk mencalonkan diri sebagai Walikota Solo bersama partai politik PDI Perjuangan beliau menjabat selama dua kali masa bakti 2005-2015. Dalam masa jabatannya, ia diwakili F.X. Hadi Rudyatmo sebagai wakil walikota.. Banyak yang meragukan kemampuan pria yang berprofesi sebagai pedagang mebel dan taman ini bahkan hingga saat terpilih menjadi Walikota Solo. Selama kepemimpinannya, Solo banyak mengalami kemajuan oleh gebrakan progresif dilakukannya. Ia banyak mengambil contoh pengembangan kota-kota di Eropa yang sering ia kunjungi dalam rangka perjalanan bisnisnya.\n" +
                "\n" +
                "Di bawah kepemimpinannya, Solo mengalami perubahan yang pesat. Pada tahun 2007 Surakarta juga telah menjadi tuan rumah Festival Musik Dunia (FMD) yang diadakan di kompleks Benteng Vastenburg yang terancam digusur untuk dijadikan pusat bisnis dan perbelanjaan. Langkahnya berlanjut dengan keberhasilan Surakarta menjadi tuan rumah Konferensi Organisasi Kota-kota Warisan Dunia pada bulan Oktober 2008. FMD pada tahun 2008 diselenggarakan di komplek Istana Mangkunegaran.\n" +
                "\n" +
                "Tahun 2012, Beliau bersama dengan Ir. Basuki Tjahaja Purnama, M.M. (Ahok) menjadi gubernur dan wakil gubernur DKI Jakarta dan selanjutnya menjadi Presiden Indonesia bersama wakilnya Jusuf Kalla.")
    )
}
```

#### Ubah kode pada layout activity_main
``` Ruby
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv_presidents"
        android:layout_width="@dimen/dp_0"
        android:layout_height="@dimen/dp_0"
        app:layout_constraintTop_toTopOf="parent"
        android:padding="@dimen/dp_8"
        android:clipToPadding="false"
        tools:listitem="@layout/item_list_president"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintEnd_toEndOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

#### Buat activity baru dengan nama DetailActivity.kt dan ubah kode pada layout activity_detail
``` Ruby
<?xml version="1.0" encoding="utf-8"?>
<androidx.core.widget.NestedScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fillViewport="true"
    tools:context=".DetailActivity">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <ImageView
            android:id="@+id/img_poster"
            android:layout_width="match_parent"
            android:layout_height="@dimen/dp_450"
            android:scaleType="centerCrop"
            android:src="@android:color/darker_gray"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent"
            tools:ignore="ContentDescription" />

        <TextView
            android:id="@+id/tv_name"
            android:layout_width="@dimen/dp_0"
            android:layout_height="wrap_content"
            android:layout_marginStart="@dimen/dp_16"
            android:layout_marginEnd="@dimen/dp_16"
            tools:text="Nur Muhammad Syaifuddin"
            android:textSize="@dimen/sp_18"
            android:textColor="@color/black"
            android:textStyle="bold"
            android:layout_marginTop="@dimen/dp_32"
            app:layout_constraintTop_toBottomOf="@id/img_poster"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintEnd_toEndOf="parent"/>

        <TextView
            android:id="@+id/tv_desc"
            android:layout_width="@dimen/dp_0"
            android:layout_height="wrap_content"
            android:layout_marginTop="@dimen/dp_16"
            android:layout_marginBottom="@dimen/dp_32"
            android:lineSpacingExtra="@dimen/dp_4"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="@id/tv_name"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="@id/tv_name"
            app:layout_constraintTop_toBottomOf="@id/tv_name"
            app:layout_constraintVertical_bias="0.0"
            tools:text="@tools:sample/lorem/random" />

    </androidx.constraintlayout.widget.ConstraintLayout>

</androidx.core.widget.NestedScrollView>
```

#### Download gambar presiden dari RecyclerView/app/src/main/res/drawable, lalu drag&drop ke file drawable
![image](https://user-images.githubusercontent.com/68520848/173885104-6c76d1ac-d894-4277-9300-90b2892bcd17.png)

#### Buat layout resource file baru dengan nama item_list_president.xml, kemudian ubah kode didalamnya
``` Ruby
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:padding="@dimen/dp_8">

    <de.hdodenhof.circleimageview.CircleImageView
        android:id="@+id/img_poster"
        android:layout_width="@dimen/dp_84"
        android:layout_height="@dimen/dp_84"
        android:scaleType="centerCrop"
        android:src="@android:color/darker_gray"
        android:layout_marginBottom="@dimen/dp_8"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintBottom_toBottomOf="parent"/>

    <TextView
        android:id="@+id/tv_name"
        android:layout_width="@dimen/dp_0"
        android:layout_height="wrap_content"
        tools:text="Nur Muhammad Syaifuddin"
        android:layout_marginStart="@dimen/dp_32"
        android:layout_marginEnd="@dimen/dp_32"
        android:textSize="@dimen/sp_18"
        android:textColor="@color/black"
        android:maxLines="1"
        android:ellipsize="end"
        app:layout_constraintTop_toTopOf="@id/img_poster"
        app:layout_constraintStart_toEndOf="@id/img_poster"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintBottom_toBottomOf="@id/img_poster"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

#### Buat Adapter untuk bind item_list_president.xml
``` Ruby
package com.project.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.project.recyclerview.databinding.ItemListPresidentBinding

class PresidentListAdapter: RecyclerView.Adapter<PresidentListAdapter.ViewHolder>() {

    private var listener: ((PresidentModel) -> Unit)? = null


    var presidents = mutableListOf<PresidentModel>()
    set(value) {
        val callback = DivCallbackPresident(field, value)
        val result = DiffUtil.calculateDiff(callback)
        field.clear()
        field.addAll(value)
        result.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(private val binding:  ItemListPresidentBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(president: PresidentModel) {

            val id = itemView.context.resources.getIdentifier(
                president.poster,
                "drawable",
                itemView.context.packageName
            )

            binding.apply {
                Glide
                    .with(itemView.context)
                    .load(id)
                    .placeholder(android.R.color.darker_gray)
                    .into(imgPoster)

                tvName.text = president.name

                listener?.let {
                    itemView.setOnClickListener {
                        it(president)
                    }
                }

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder = ItemListPresidentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewHolder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(presidents[position])
    }

    override fun getItemCount(): Int = presidents.size

    fun onClick(listener: ((PresidentModel) -> Unit)?){
        this.listener = listener
    }
}
```

#### Karena penggunaan notifyDataSetChanged() sudah depreceted, disarankan menggunakan DiffUtil.Callback()
``` Ruby
package com.project.recyclerview

import androidx.recyclerview.widget.DiffUtil

class DivCallbackPresident(private val oldPresidents: List<PresidentModel>, private val newPresidents: List<PresidentModel>): DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldPresidents.size

    override fun getNewListSize(): Int = newPresidents.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldPresidents[oldItemPosition].name == newPresidents[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldPresidents[oldItemPosition].name == newPresidents[newItemPosition].name
}
```

#### Selanjutnya lakukan setup RecyclerView pada MainActivity.kt
``` Ruby
package com.project.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var adapter: PresidentListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Presidents of Indonesian"

        adapter = PresidentListAdapter().apply {
            onClick {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_DATA, it)
                startActivity(intent)
            }
        }

        setUpPresidentList()
    }

    private fun setUpPresidentList() {
        binding.apply {
            adapter.presidents = Repository.presidents as MutableList<PresidentModel>
            rvPresidents.setHasFixedSize(true)
            rvPresidents.adapter = adapter
        }
    }

}
```

#### Terakhir, tangkap data intent yang dikirim dari MainActivity.kt ke DetailActivity.kt
``` Ruby
package com.project.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.project.recyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Detail"

        getDetailPresident()
    }

    private fun getDetailPresident() {
        binding.apply {
            val president = intent?.extras?.getParcelable<PresidentModel>(EXTRA_DATA)

            val id = resources.getIdentifier(president?.poster.toString(), "drawable", packageName)

            Glide
                .with(this@DetailActivity)
                .load(id)
                .placeholder(android.R.color.darker_gray)
                .into(imgPoster)

            tvName.text = president?.name.toString()
            tvDesc.text = president?.desc.toString()
        }
    }

    companion object{
        const val EXTRA_DATA = "extra_data"
    }
}
```
