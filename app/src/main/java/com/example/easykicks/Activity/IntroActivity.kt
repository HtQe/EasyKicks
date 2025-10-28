package com.example.easykicks.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.easykicks.MainActivity
import com.example.easykicks.R
import com.example.easykicks.databinding.ActivityIntroBinding

class IntroActivity : BaseActivity() {
    lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            startBTN.setOnClickListener {startActivity(Intent(this@IntroActivity, MainActivity::class.java))}
        }

    }
}