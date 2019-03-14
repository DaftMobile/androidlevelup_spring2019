package com.daftmobile.androidlevelup

import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import kotlinx.android.synthetic.main.activity_square.*

class ConstraintSetActivity : AppCompatActivity() {

    private lateinit var nextConstraints: ConstraintSet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        nextConstraints = ConstraintSet().apply {
            clone(contentView.context, R.layout.activity_square_alter)
        }
        square.setOnClickListener {
            relayout(contentView)
        }
    }

    private fun relayout(contentView: ConstraintLayout) {
        // create new constraints
        val oldConstraints = ConstraintSet().apply {
            clone(contentView)
        }
        // create custom transition
        val transition = ChangeBounds().apply {
            interpolator = OvershootInterpolator()
        }
        // begin transition
        TransitionManager.beginDelayedTransition(contentView, transition)
        // apply new constraints
        nextConstraints.applyTo(contentView)
        // set old constraints as new
        nextConstraints = oldConstraints
    }
}
