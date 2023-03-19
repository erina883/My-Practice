package com.erina.mypractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erina.mypractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    var namelist = listOf<String>("Erina", "Ayesha", "Abdullah", "Abuhasan", "Erina", "Ayesha", "Abdullah", "Abuhasan","Erina", "Ayesha", "Abdullah", "Abuhasan")
    lateinit var nameAadapter: NameAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nameAadapter = NameAdapter()
        nameAadapter.submitList(namelist)

        binding.nameRCV.adapter = nameAadapter

    }
}