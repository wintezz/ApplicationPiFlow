package com.alexpetrov.applicationpi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alexpetrov.applicationpi.databinding.ActivityMainBinding
import com.alexpetrov.applicationpi.fragments.FragmentA
import com.alexpetrov.applicationpi.fragments.FragmentB

/* Flow — это класс, который может возвращать несколько объектов по очереди или сразу.
   Он работает на основе корутин и представляет собой поток данных, которые можно обрабатывать асинхронно.
   С помощью Flow можно отправлять запросы на сервер
   или в базу данных без блокирования основного потока приложения.*/

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerA, FragmentA.newInstance())
            .commit()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.containerB, FragmentB.newInstance())
            .commit()
    }
}