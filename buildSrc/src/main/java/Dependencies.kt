
object Versions {
    const val coreKtx = "1.9.0"
    const val lifecycleRuntime = "2.3.1"
    const val activityCompose = "1.3.1"
    const val composeUi = "1.2.0"
    const val material = "1.2.0"
    const val hilt = "2.44"
    const val hiltNavigation = "1.0.0"
    const val navigationCompose = "2.5.3"
    const val junit = "4.13.2"
    const val androidxJunit = "1.1.5"
    const val androidxEspresso = "3.5.1"
    const val room = "2.5.0"
}

object Dependencies {
    const val androidxCoreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidxLifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntime}"
    const val androidxActivityCompose = "androidx.activity:activity-compose:${Versions.activityCompose}"
    const val androidxComposeUi = "androidx.compose.ui:ui:${Versions.composeUi}"
    const val androidxComposeUiPreviewTool = "androidx.compose.ui:ui-tooling-preview:${Versions.composeUi}"
    const val androidxMaterial = "androidx.compose.material:material:${Versions.material}"

    // Hilt
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltNavigation = "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    // Room
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    // Navigation
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.navigationCompose}"

    // Test
    const val junit = "junit:junit:${Versions.junit}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val androidxEspresso = "androidx.test.espresso:espresso-core:${Versions.androidxEspresso}"
    const val composeUiTolling = "androidx.compose.ui:ui-tooling:${Versions.composeUi}"
    const val composeUiTest = "androidx.compose.ui:ui-test-manifest:${Versions.composeUi}"
    const val composeJunit = "androidx.compose.ui:ui-test-junit4:${Versions.composeUi}"


}