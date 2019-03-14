package com.daftmobile.androidlevelup

import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import kotlinx.android.synthetic.main.activity_spring.*

class SpringActivity : AppCompatActivity() {
    private var dX = 0f
    private var dY = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spring)

        springButton.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    dX = event.rawX
                    dY = event.rawY
                }
                MotionEvent.ACTION_MOVE -> view.animate()
                        .translationX(event.rawX - dX)
                        .translationY(event.rawY - dY)
                        .setDuration(0)
                        .start()
                MotionEvent.ACTION_UP -> {
                    SpringAnimation(view, DynamicAnimation.TRANSLATION_Y, 0f)
                            .start()
                    SpringAnimation(view, DynamicAnimation.TRANSLATION_X, 0f)
                            .start()
                }
                else -> return@setOnTouchListener false
            }
            true
        }
    }
}
