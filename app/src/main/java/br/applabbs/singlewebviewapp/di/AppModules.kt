package br.applabbs.singlewebviewapp.di

import br.applabbs.singlewebviewapp.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object AppModules {

    private const val abvService = "AbvService"

    val serviceModules = module {
        //single(named(abvService)) { makeService<ABVService>(BuildConfig.BASE_URL) }
        viewModel { SplashViewModel() }
//        viewModel { LoginViewModel(get(), FirebaseAuth.getInstance(), get()) }
//        viewModel { MainViewModel(get(), FirebaseFirestore.getInstance())}
//        viewModel { IncluirViewModel(get(), FirebaseFirestore.getInstance()) }
//        viewModel { DetalhesViewModel(get(), FirebaseFirestore.getInstance()) }

    }

//    val netModules = module {
//        single<Network> { NetworkImpl(get()) }
//    }
//
//    val dataSourceModules = module {
//        single<UserRemoteDataSource> {
//            UserRemoteDataSourceImpl(
//                get(named(abvService)),
//                get(named(userResponseToUser))
//            )
//        }
//
//        single<HomeRemoteDataSource> {
//            HomeRemoteDataSourceImpl(
//                get(named(abvService)),
//                get(named(homeResponseToHome))
//            )
//        }
//
//        single<CheckinRemoteDataSource> {
//            CheckinRemoteDataSourceImpl(
//                get(named(abvService)),
//                get(named(checkinResponseToCheckin))
//            )
//        }
//    }
//
//    val repositoryModules = module {
//        single<UserRepository> { UserRepositoryImpl(get()) }
//        single<HomeRepository> { HomeRepositoryImpl(get()) }
//        single<CheckinRepository> { CheckinRepositoryImpl(get()) }
//    }
}
