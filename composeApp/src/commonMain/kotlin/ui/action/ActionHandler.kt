package ui.action

typealias ClickHandler = () -> Unit

class ActionHandler(
    val onHomeButtonClick: ClickHandler = { },
    val onSearchButtonClick: ClickHandler = { },
    val onAddButtonClick: ClickHandler = { },
    val onNotificationButtonClick: ClickHandler = { },
    val onProfileButtonClick: ClickHandler = { },

    )