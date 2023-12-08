package com.dbadeveloper.partnernotesapps.di

import com.dbadeveloper.partnernotesapps.data.repository.AuthRepository
import com.dbadeveloper.partnernotesapps.data.source.remote.RemoteDataSource
import com.dbadeveloper.partnernotesapps.domain.interactor.LoginInteractor
import com.dbadeveloper.partnernotesapps.domain.interactor.RegisterInteractor
import com.dbadeveloper.partnernotesapps.domain.repository.IAuthRepository
import com.dbadeveloper.partnernotesapps.domain.usecase.LoginUseCase
import com.dbadeveloper.partnernotesapps.domain.usecase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideAuthRepository(remoteDataSource: RemoteDataSource): IAuthRepository {
        return AuthRepository(remoteDataSource)
    }

    @Provides
    fun provideLoginInteractor(authRepository: AuthRepository): LoginUseCase {
        return LoginInteractor(authRepository)
    }

    @Provides
    fun provideRegisterInteractor(authRepository: AuthRepository): RegisterUseCase {
        return RegisterInteractor(authRepository)
    }

}