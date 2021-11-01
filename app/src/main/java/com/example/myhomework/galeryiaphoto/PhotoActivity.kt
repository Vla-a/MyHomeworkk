package com.example.myhomework.galeryiaphoto

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.myhomework.databinding.ActivityPhotoBinding

class PhotoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPhotoBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bClick.setOnClickListener {
            openGalleryForImage()

        }

    }
    private fun openGalleryForImage() {
        //вызов галереи
//        val intent = Intent(Intent.ACTION_PICK)
//        intent.type = "image/*"
//        startActivityForResult(intent, REQUEST_TAKE_PHOTO)

        //вызов камеры
        val bInt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(bInt, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {


        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_TAKE_PHOTO){
            binding.image.setImageBitmap(data?.extras?.get("data") as Bitmap) // handle chosen image
        }else {
            super.onActivityResult(requestCode, resultCode, data)
        }



    }
    companion object {
        private val REQUEST_TAKE_PHOTO = 24
        private val REQUEST_CODE = 24
         }

}