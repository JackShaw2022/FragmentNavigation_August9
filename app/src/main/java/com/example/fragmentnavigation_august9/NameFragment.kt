package com.example.fragmentnavigation_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentnavigation_august9.databinding.FragmentNameBinding
import com.example.fragmentnavigation_august9.viewModel.UserViewModel

class NameFragment : Fragment() {
    private var _binding: FragmentNameBinding? = null
    private val binding: FragmentNameBinding get() = _binding!!

    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewModel = ViewModelProvider(this@NameFragment)[UserViewModel::class.java]

            firstNameEt.editText?.addTextChangedListener{ text ->
                nextBtn.isEnabled = text.toString().length > 4
            }
            nextBtn.setOnClickListener {
                    val firstName = firstNameEt.editText?.text.toString()
                    val lastName = lastNameEt.editText?.text.toString()

                    val userName = UserName(firstName, lastName)
                    viewModel.addUserName(userName)
                    val direction =
                        com.example.fragmentnavigation_august9.NameFragmentDirections.nameFragmentToPasswordFragmentAction()
                    findNavController().navigate(direction)
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}