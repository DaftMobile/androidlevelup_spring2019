package pl.daftacademy.androidlevelup.view.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import pl.daftacademy.androidlevelup.R
import pl.daftacademy.androidlevelup.view.constraint.ConstraintActivity
import pl.daftacademy.androidlevelup.view.old.OldActivity
import pl.daftacademy.androidlevelup.view.styled.StyledActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlin.reflect.KClass

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        btnOld.onClickStartActivity(OldActivity::class)
        btnConstraint.onClickStartActivity(ConstraintActivity::class)
        btnStyled.onClickStartActivity(StyledActivity::class)
    }

    private fun <T : Activity> View.onClickStartActivity(activityClass: KClass<T>) =
        setOnClickListener { startActivity(Intent(this@HomeActivity, activityClass.java)) }
}