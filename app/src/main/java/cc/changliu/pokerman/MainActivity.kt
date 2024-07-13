package cc.changliu.pokerman

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cc.changliu.pokerman.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var count = 1

    override fun onCreate(savedInstanceState: Bundle?) {
//        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        val imgIds = arrayOf(
            R.drawable.red_joker,
            R.drawable.black_joker,
            R.drawable.ace_of_spades,
            R.drawable.ace_of_hearts,
            R.drawable.ace_of_clubs,
            R.drawable.ace_of_diamonds,
            R.drawable.ten_of_spades,
            R.drawable.ten_of_hearts,
            R.drawable.ten_of_clubs,
            R.drawable.ten_of_diamonds
        )
        binding.viewer1.setOnClickListener {
            binding.viewer1.setImageDrawable(
                AppCompatResources.getDrawable(this, imgIds[count++ % imgIds.size])
            )
        }
    }
}