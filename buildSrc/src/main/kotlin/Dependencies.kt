import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    const val composeMaterial = "androidx.compose.material3:material3:${Versions.composeMaterial3}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeRuntime = "androidx.compose.runtime:runtime:${Versions.compose}"

    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navVersion}"

    const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilCompose}"


    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltViewModelAndroid = "androidx.hilt:hilt-navigation-compose:${Versions.hiltnavigation}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"

    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    const val lifecycleViewmodelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleViewModelCompose}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.gson}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinCoroutinesTest}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
    const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
    const val archCoreTesting = "androidx.arch.core:core-testing:${Versions.archCoreTesting}"
    const val truth = "com.google.truth:truth:${Versions.truth}"
}

fun DependencyHandler.room() {
    implementation(Dependencies.roomRuntime)
    implementation(Dependencies.roomKtx)
    kapt(Dependencies.roomCompiler)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.retrofit)
    implementation(Dependencies.retrofitGsonConverter)
    implementation(Dependencies.gson)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.okHttpLoggingInterceptor)
}

fun DependencyHandler.gson(){
    implementation(Dependencies.gson)
}

fun DependencyHandler.compose() {
    implementation(Dependencies.composeUi)
    implementation(Dependencies.composeRuntime)
    implementation(Dependencies.composeUiGraphics)
    implementation(Dependencies.composeUiTooling)
    implementation(Dependencies.composeMaterial)
    debugImplementation(Dependencies.composeUiToolingPreview)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)
}

fun DependencyHandler.hiltViewModel() {
    implementation(Dependencies.hiltViewModelAndroid)
}

fun DependencyHandler.coilCompose(){
    implementation(Dependencies.coilCompose)
}

fun DependencyHandler.navigationCompose() {
    implementation(Dependencies.navigationCompose)
}

fun DependencyHandler.lifecycleViewModelCompose() {
    implementation(Dependencies.lifecycleViewmodelCompose)
}

fun DependencyHandler.coroutinesTest(){
    test(Dependencies.coroutinesTest)
}

fun DependencyHandler.mockitoCore(){
    test(Dependencies.mockitoCore)
}

fun DependencyHandler.mockitoKotlin(){
    test(Dependencies.mockitoKotlin)
}

fun DependencyHandler.archCoreTesting(){
    test(Dependencies.archCoreTesting)
}

fun DependencyHandler.truth(){
    test(Dependencies.truth)
}
