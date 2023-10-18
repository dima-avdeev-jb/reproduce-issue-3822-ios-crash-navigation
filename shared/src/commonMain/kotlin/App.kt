import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.dp
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@Composable
fun App(onComposeClick: () -> Unit) {
    MaterialTheme(
        colors = darkColors(
            primary = Color.Black,
            primaryVariant = Color.Black.copy(alpha = 0.7f),
            surface = Color.Black.copy(alpha = 0.9f),
            background = Color.Black,
            onBackground = Color.LightGray,
        )
    ) {
        Box(Modifier) {
            Column(
                Modifier.windowInsetsPadding(WindowInsets.systemBars)
            ) {
                MaterialTheme(
                    typography = Typography(
                        body1 = TextStyle(
                            fontFamily = ledFontFamily3
                        ),
                    ),
                ) {
                    Box(Modifier.height(25.dp).width(250.dp)
                        .graphicsLayer {}
                        .background(Color.Yellow)
                        .clickable { onComposeClick() }
                    ) {
                        Text("CLICK ME MULTIPLE TIMES")
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalEncodingApi::class)
val ledFontFamily3 = FontFamily(
    Font(
        identity = "led_panel_panels_station_on",
        data = Base64.decode(fontBase64),
    )
)
