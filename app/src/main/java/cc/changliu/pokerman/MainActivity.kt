package cc.changliu.pokerman

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.animation.doOnEnd
import androidx.core.view.isVisible
import cc.changliu.pokerman.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var index = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.cardForeground.setOnClickListener {
            binding.cardForeground.setImageDrawable(currentDrawable(index++))
        }
    }

    private fun currentDrawable(index: Int) = AppCompatResources.getDrawable(
        this, imgIds[index % imgIds.size]
    )

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.show_grid -> {
            binding.cardGrid.isVisible = !binding.cardGrid.isVisible
            true
        }

        R.id.feeling_lucky -> {
            val animator1 = ObjectAnimator.ofFloat(binding.cardForeground, "rotationX", 0.0f, 360.0f)
            val animator2 = ObjectAnimator.ofFloat(binding.cardForeground, "alpha", 1.0f, 0.0f)
            val animator3 = ObjectAnimator.ofFloat(binding.cardBackground, "rotationY", 0.0f, 360.0f)
            AnimatorSet().setDuration(800L).apply {
                playTogether(animator1, animator2, animator3)
                doOnEnd {
                    binding.cardForeground.alpha = 1.0f
                    binding.cardForeground.setImageDrawable(currentDrawable(Random.nextInt(0, 9)))
                }
                start()
            }
            true
        }

        else -> super.onOptionsItemSelected(item)
    }

    companion object {
        private val imgIds = arrayOf(
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
    }
}