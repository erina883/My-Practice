package com.erina.mypractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.erina.mypractice.databinding.ActivityDeatlsBinding
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.util.FitPolicy

class Deatls : AppCompatActivity() {
    lateinit var binding: ActivityDeatlsBinding

    private lateinit var pdfView: PDFView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeatlsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pdfView = findViewById(R.id.pdf_view)

        val topicDetails = intent.getStringExtra("topicDetails")

        if (topicDetails != null) {
            val assetFileName = "pdfs/" + topicDetails
            displayFromAsset(assetFileName)
        }

    }

    private fun displayFromAsset(assetFileName: String) {
        val inputStream = assets.open(assetFileName)
        pdfView.fromStream(inputStream)
            .enableSwipe(true)
            .enableDoubletap(true)
            .defaultPage(0)
            .enableAnnotationRendering(false)
            .password(null)
            .scrollHandle(null)
            .enableAntialiasing(true)
            .spacing(3)
            .pageFitPolicy(FitPolicy.WIDTH)
            .load()
    }
}