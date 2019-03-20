package pl.daftacademy.androidlevelup.view.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_content.*
import pl.daftacademy.androidlevelup.R

const val NAME_EXTRA = "NAME_EXTRA"

class ContentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_content, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = arguments?.getString(NAME_EXTRA) ?: throw IllegalStateException("Required name argument")
        txtName.text = name
    }

    companion object {
        fun create(name: String): ContentFragment {
            val fragment = ContentFragment()
            val args = Bundle()
            args.putString(NAME_EXTRA, name)
            fragment.arguments = args
            return fragment
        }
    }
}