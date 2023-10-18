import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        val brush = Brush.horizontalGradient(
            0.0f to MaterialTheme.colors.primary,
            0.05f to MaterialTheme.colors.primaryVariant,
            0.5f to MaterialTheme.colors.surface,
            1.0f to MaterialTheme.colors.primary,
        )
        Box(Modifier) {
            Column(
                Modifier.background(brush),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Column(Modifier.windowInsetsPadding(WindowInsets.systemBars)) {
                    LazyColumn() {
                        item {
                            MaterialTheme(
                                typography = Typography(
                                    body1 = TextStyle(
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 16.sp,
                                        letterSpacing = 0.5.sp,
                                        fontFamily = ledFontFamily3
                                    ),
                                ),
                            ) {
                                Row(
                                    Modifier
                                        .fillMaxWidth()
                                        .height(30.dp),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Box(Modifier.height(25.dp).width(250.dp)
                                        .graphicsLayer {}
                                        .background(Color.Yellow)
                                        .clickable { onComposeClick() }
                                    ) {
                                        Text("CLICK ME MULTIPLE TIMES")
                                    }

                                    Box(
                                        Modifier
                                            .fillMaxSize(0.03f)
                                            .fillMaxHeight()
                                    ) {
                                        Box(
                                            Modifier.fillMaxSize()
                                                .graphicsLayer {
                                                    shape = RoundedCornerShape(6.dp)
                                                    clip = true
                                                }
                                        ) {
                                            Box(
                                                Modifier
                                                    .fillMaxSize()
                                                    .background(
                                                        color = Color.LightGray
                                                    )
                                            )
                                        }
                                        Text("")
                                    }

                                }
                            }
                        }
                    }
                }
            }
            //Overlay
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(0.1f))
            )
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
