package com.lanterna.lanternaapp

import android.hardware.camera2.CameraManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lanterna.lanternaapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding;
    private var estado = false;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.lanterna.setOnClickListener{
            if(!estado){
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_ligada)
                estado = true
                luzLanterna(estado);
            } else{
                binding.lanterna.setImageResource(R.drawable.ic_lanterna_desligada)
                estado = false;
                luzLanterna(estado);
            }
        }
    }

    private fun luzLanterna(estado: Boolean){
        val cameraManager: CameraManager = getSystemService(CAMERA_SERVICE) as CameraManager;
        val cameraId: String?

        try {
            cameraId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraId,estado)
        } catch(e: Exception){}


    }



}