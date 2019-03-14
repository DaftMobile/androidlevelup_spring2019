package com.daftmobile.androidlevelup

import android.animation.AnimatorInflater
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_square.*

class PropertyAnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        square.setOnClickListener(::rotateWithCode)
    }

    private fun rotate(view: View) {
        val animator = AnimatorInflater.loadAnimator(this, R.animator.rotate_animator)
        animator.setTarget(view)
        animator.start()
    }

    private fun rotateWithCode(view: View) {
        val animator = view.animate()
                .rotationBy(720f)
                .scaleX(2.0f)
                .scaleY(2.0f)
                .setDuration(1000L)
                .setInterpolator(AccelerateDecelerateInterpolator())
        animator.start()
    }
}
