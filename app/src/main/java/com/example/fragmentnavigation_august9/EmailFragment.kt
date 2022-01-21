package com.example.fragmentnavigation_august9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fragmentnavigation_august9.EmailFragmentDirections.*
import com.example.fragmentnavigation_august9.databinding.FragmentEmailBinding


class EmailFragment : Fragment() {
    private var _binding: FragmentEmailBinding? = null
    private val binding: FragmentEmailBinding get() =_binding!!
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        with(binding){
            nextBtn.setOnClickListener {
//                val firstName =
//                val lastName = lastNameEt.editText?.text.toString()
//                val email = emailEt.editText?.text.toString()
//                val user = User(firstName, lastName)
//                viewModel.addUser(user)
                val direction = actionEmailFragmentToPasswordFragment()
                findNavController().navigate(direction)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}