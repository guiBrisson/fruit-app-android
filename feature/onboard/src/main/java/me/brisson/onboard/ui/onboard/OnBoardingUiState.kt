package me.brisson.onboard.ui.onboard

data class OnBoardingUiState(
    val component: OnBoardingComponent = OnBoardingComponent.FIRST_COMPONENT
)

enum class OnBoardingComponent{
    FIRST_COMPONENT, SECOND_COMPONENT
}
