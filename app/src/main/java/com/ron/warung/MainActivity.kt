package com.ron.warung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaPelanggan = findViewById<EditText>(R.id.namapelanggan)
        val namaBarang = findViewById<EditText>(R.id.namabarang)
        val jumlahBeli = findViewById<EditText>(R.id.jumlahbeli)
        val Harga = findViewById<EditText>(R.id.harga)
        val uangBayar = findViewById<EditText>(R.id.uangbayar)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val totalBelanja = findViewById<TextView>(R.id.totalbelanja)
        val uangkembalian = findViewById<TextView>(R.id.uangkembali)
        val Bonus = findViewById<TextView>(R.id.bonus)
        val keterangan = findViewById<TextView>(R.id.keterangan)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val btnKeluar = findViewById<Button>(R.id.btnKeluar)


        btnProses.setOnClickListener{
            var total: Int = 0
            var uangkembali: Int = 0
            val jumlahBeli = Integer.parseInt(jumlahBeli.text.toString())
            val harga = Integer.parseInt(Harga.text.toString())
            val uangbayar = Integer.parseInt(uangBayar.text.toString())

            total = jumlahBeli * harga
           uangkembali = uangbayar - harga

            totalBelanja.text = "Total Belanja: "+total.toString()
            uangkembalian.text = "Uang Kembali: "+uangkembali.toString()

            if (uangBayar==totalBelanja) {
                keterangan.text = "Keterangan: uang pas"
            }
            if (uangbayar>total) {
                keterangan.text = "Keterangan: Kembalian"+ abs(uangkembali)
            }
            if (uangbayar<total) {
                keterangan.text = "Keterangan: uang kurang"+ uangkembali
            }

            if(total>= 200000) {
                Bonus.text = "Bonus: Mouse"
            }else if(total>= 400000) {
                Bonus.text = "Bonus: Keyboard"
            }else if(total>= 600000) {
                Bonus.text = "Bonus: Hardisk"
            } else {
                Bonus.text = "Bonus: Tidak ada Bonus"
            }

        }
        btnReset.setOnClickListener{
            namaPelanggan.setText("")
            namaBarang.setText("")
            jumlahBeli.setText("")
            Harga.setText("")
            uangBayar.setText("")
            totalBelanja.setText("Total Belanja:")
            uangkembalian.setText("Uang Kembali:")
            Bonus.setText("Bonus:")
            keterangan.setText("Keterangan:")

            Toast.makeText(getApplicationContext(),"Data sudah direset", Toast.LENGTH_LONG).show();
        }
        btnKeluar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                moveTaskToBack(true);

    }
}