import androidx.compose.ui.window.ComposeUIViewController

@Suppress("unused")
fun MainViewController(onComposeClick: () -> Unit) = ComposeUIViewController {
    App(onComposeClick)
}
