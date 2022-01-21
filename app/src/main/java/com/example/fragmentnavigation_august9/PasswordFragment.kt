package com.example.fragmentnavigation_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentnavigation_august9.databinding.FragmentPasswordBinding
import com.example.fragmentnavigation_august9.viewModel.UserViewModel

class PasswordFragment : Fragment() {

    private var _binding: FragmentPasswordBinding? = null
    private val binding: FragmentPasswordBinding get() = _binding!!

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this@PasswordFragment)[UserViewModel::class.java]

        with(binding) {
            passwordEt.editText?.addTextChangedListener{ text ->
                nextBtn.isEnabled = text.toString().length > 4
            }
            nextBtn.setOnClickListener {
                val password = passwordEt.editText?.text.toString()

                val userPassword = UserPassword(password)

                viewModel.addUserPassword(userPassword)

                val directions =
                    com.example.fragmentnavigation_august9.PasswordFragmentDirections.passwordFragmentToSignUpCompleteFragment()

                findNavController().navigate(directions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}