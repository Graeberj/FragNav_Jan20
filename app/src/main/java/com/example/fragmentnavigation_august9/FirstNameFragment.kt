package com.example.fragmentnavigation_august9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.fragmentnavigation_august9.FirstNameFragmentDirections.*
import com.example.fragmentnavigation_august9.databinding.FragmentFirstNameBinding
import com.example.fragmentnavigation_august9.SignUpCompleteFragment

class FirstNameFragment : Fragment() {

    private var _binding: FragmentFirstNameBinding? = null
    private val binding: FragmentFirstNameBinding get() = _binding!!
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstNameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[UserViewModel::class.java]
        with(binding) {

            nameEt.editText?.addTextChangedListener {
                toast(it.toString())
            }
            nextBtn.setOnClickListener {
                    val firstName = nameEt.editText?.text.toString()
                    val lastName = lastNameEt.editText?.text.toString()
                    val user = User(firstName, lastName, null, null)

                    viewModel.addUser(user)
                    val direction = actionFirstNameFragmentToEmailFragment()
                    findNavController().navigate(direction)
                }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}