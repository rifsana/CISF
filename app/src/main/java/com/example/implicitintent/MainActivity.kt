package com.example.implicitintent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.hardware.camera2.CameraManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val webButton= findViewById<CardView>(R.id.CardWeb)
        val cameraButton= findViewById<CardView>(R.id.CardCamera)
        val snapButton= findViewById<CardView>(R.id.Snapchat)

        webButton.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("https://www.instagram.com/")
            startActivity(intent)


        }

        cameraButton.setOnClickListener {
            val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)


        }

        var isFlashOn = false

        val flashlightButton = findViewById<CardView>(R.id.CardFlashlight)

        flashlightButton.setOnClickListener {
            val cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
            val cameraId = cameraManager.cameraIdList[0]

            try {
                isFlashOn = !isFlashOn
                cameraManager.setTorchMode(cameraId, isFlashOn)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        snapButton.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW)
            intent.data= Uri.parse("https://www.snapchat.com/")
            startActivity(intent)


        }

    }
}