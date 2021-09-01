package dev.pastukhov.telegram.ui.fragments

import dev.pastukhov.telegram.R
import dev.pastukhov.telegram.databinding.FragmentEnterPhoneNumberBinding
import dev.pastukhov.telegram.replaceFragment
import dev.pastukhov.telegram.showToast


class EnterPhoneNumberFragment : BaseFragment(R.layout.fragment_enter_phone_number) {

    private lateinit var binding: FragmentEnterPhoneNumberBinding


    override fun onResume() {
        super.onResume()
        binding = FragmentEnterPhoneNumberBinding.inflate(layoutInflater)

        binding.registerInputPhoneNumber.setOnClickListener { sendCode() }
    }


    private fun sendCode() {
        if (binding.registerInputPhoneNumber.text.toString().isEmpty()){
            showToast(getString(R.string.register_toast_enter_phone))
        } else {
            replaceFragment(EnterCodeFragment())
        }
    }
}
