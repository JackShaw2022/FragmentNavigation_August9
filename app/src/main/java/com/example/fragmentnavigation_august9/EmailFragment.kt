package com.example.fragmentnavigation_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fragmentnavigation_august9.data.UserEmail
import com.example.fragmentnavigation_august9.databinding.FragmentEmailBinding
import com.example.fragmentnavigation_august9.viewModel.UserViewModel

class EmailFragment: Fragment() {

    private var _binding: FragmentEmailBinding? = null
    private val binding: FragmentEmailBinding get() = _binding!!

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewModel = ViewModelProvider(this@EmailFragment)[UserViewModel::class.java]

            emailEt.editText?.addTextChangedListener{ text ->
                nextBtn.isEnabled = text.toString().length > 4
            }
            nextBtn.setOnClickListener {
                val email = emailEt.editText?.text.toString()

                val userEmail = UserEmail(email)
                viewModel.addUserEmail(userEmail)

                val directions =
                    com.example.fragmentnavigation_august9.EmailFragmentDirections.emailFragmentToPasswordFragmentAction()

                findNavController().navigate(directions)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}