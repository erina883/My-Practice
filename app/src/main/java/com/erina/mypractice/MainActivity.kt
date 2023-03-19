package com.erina.mypractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.erina.mypractice.databinding.ActivityMainBinding
import com.example.recycleview.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val celedList = listOf<Celeb>(
        Celeb("Rose", roseBio, roseImg),
        Celeb("tulip", tulipBio, tulipImg),
        Celeb("beli", beliBio, beliImg),
        Celeb("Rose", rose1Bio, rose1Img),
        Celeb("tulip", tulip1Bio, tulip1Img),
        Celeb("beli", beli1Bio, beli1Img) )
    lateinit var celebAdapter: CelebAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        celebAdapter = CelebAdapter(this@MainActivity)
        celebAdapter.submitList(celedList)

        binding.nameRCV.adapter = celebAdapter

    }
}