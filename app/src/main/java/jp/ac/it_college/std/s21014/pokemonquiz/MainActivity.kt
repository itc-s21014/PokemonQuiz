package jp.ac.it_college.std.s21014.pokemonquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.ac.it_college.std.s21014.pokemonquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        title = getString(R.string.app_name)
        setContentView(binding.root)
        initJsonData(assets)
    }

    override fun onBackPressed() {
    }
}