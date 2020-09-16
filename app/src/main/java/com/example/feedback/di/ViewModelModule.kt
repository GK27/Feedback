package com.example.feedback.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.feedback.di.ViewModelKey
import com.example.feedback.factory.AppViewModelFactory
import com.example.feedback.view.ui.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Suppress("unused")
@Module
internal abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    internal abstract fun bindMainActivityViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(appViewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}
