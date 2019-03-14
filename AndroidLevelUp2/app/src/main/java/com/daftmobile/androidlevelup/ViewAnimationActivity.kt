package com.daftmobile.androidlevelup

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_square.*

class ViewAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        square.setOnClickListener(this::rotateWithXml)
    }

    private fun rotateWithXml(view: View) {
        val animation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation)
        view.startAnimation(animation)
    }

    private fun rotate(view: View) {
        val animation = RotateAnimation(0f, 720f, view.width / 2f, view.height / 2f).apply {
            duration = 1000L
            interpolator = AccelerateDecelerateInterpolator()
            repeatMode = Animation.REVERSE
            repeatCount = 4
        }
        view.startAnimation(animation)
    }
}
