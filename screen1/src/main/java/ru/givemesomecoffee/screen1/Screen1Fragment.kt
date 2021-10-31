package ru.givemesomecoffee.screen1

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class Screen1Fragment: Fragment(R.layout.fragment_screen1) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireView().findViewById<Button>(R.id.button).setOnClickListener {
            findNavController().navigate(Uri.parse("myapp://screen2"))
        }
    }
}