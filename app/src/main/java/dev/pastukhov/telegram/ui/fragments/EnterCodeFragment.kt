package dev.pastukhov.telegram.ui.fragments

import androidx.fragment.app.Fragment
import dev.pastukhov.telegram.AppTextWatcher
import dev.pastukhov.telegram.R
import dev.pastukhov.telegram.databinding.FragmentEnterCodeBinding
import dev.pastukhov.telegram.showToast

class EnterCodeFragment : Fragment(R.layout.fragment_enter_code) {

    private lateinit var binding: FragmentEnterCodeBinding

    override fun onStart() {
        super.onStart()

        binding = FragmentEnterCodeBinding.inflate(layoutInflater)

        binding.registerInputCode.addTextChangedListener(AppTextWatcher {
            val string = binding.registerInputCode.text.toString()
            if (string.length == 6) {
                verifyCode()
            }
        })
    }

    fun verifyCode() {
        showToast("OK")
    }
}
