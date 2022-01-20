package com.example.fragmentnavigation_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.fragmentnavigation_august9.databinding.FragmentNameBinding

class NameFragment : Fragment() {
    private var _binding: FragmentNameBinding? = null
    private val binding: FragmentNameBinding get() = _binding!!

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

            firstNameEt.editText?.addTextChangedListener{ text ->
                nextBtn.isEnabled = text.toString().length > 4
            }
            nextBtn.setOnClickListener {
                    val firstName = firstNameEt.convertToString()
                    val lastName = lastNameEt.convertToString()

                    val direction =
                        NameFragmentDirections.nameFragmentToPasswordFragmentAction(
                            firstName,
                            lastName
                        )
                    findNavController().navigate(direction)
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}