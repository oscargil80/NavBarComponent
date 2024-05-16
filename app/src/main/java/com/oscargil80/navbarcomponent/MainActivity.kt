package com.oscargil80.navbarcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.oscargil80.navbarcomponent.R.*
import com.oscargil80.navbarcomponent.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val favoritoFragment = FavoritoFragment()
        val musicaFragment = MusicaFragment()
        val notificacionFragment = NotificacionFragment()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_fav -> {
                    setCurrentFragmnent(favoritoFragment)
                    true
                }
                R.id.nav_music -> {
                    setCurrentFragmnent(musicaFragment)
                    true
                }
                R.id.nav_noti -> {
                    setCurrentFragmnent(notificacionFragment)
                    true
                }
                else -> false
            }
        }

        binding.bottomNavigationView.getOrCreateBadge(R.id.nav_noti).apply {
            isVisible = true
            number = 10
        }
    }

    private fun setCurrentFragmnent(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(id.containerView, fragment)
            commit()
        }
    }
}
