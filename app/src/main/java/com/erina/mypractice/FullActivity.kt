package com.erina.mypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.erina.mypractice.databinding.ActivityFullBinding

class FullActivity : AppCompatActivity() {
    lateinit var binding: ActivityFullBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var imageLink = intent.getStringExtra("img")
        Glide.with(this@FullActivity).load(imageLink).into(binding.fullImg)
    }
}