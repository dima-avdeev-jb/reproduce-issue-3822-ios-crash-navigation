import androidx.compose.ui.window.ComposeUIViewController

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController { App() }

public object CoffeeSelectorsMobileUIViewController2 {
    public fun make(onComposeClick: () -> Unit): UIViewController {
        return ComposeUIViewController {
            CoffeeSelectorsMobile(onComposeClick)
        }
    }
}

@Composable
internal fun CoffeeSelectorsMobile(onComposeClick: () -> Unit) {
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
                content = {
                    Column(
                        Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        LazyColumn() {
                            repeat(5) {
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
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Box(Modifier.height(25.dp).fillMaxWidth()
                                                .graphicsLayer {}
                                                .background(Color.Yellow)
                                                .clickable { onComposeClick() }
                                            ) {
                                                Text("CLICK ME")
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
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                Modifier.fillMaxWidth()
                                    .height(15.dp)
                                    .graphicsLayer {
                                        shape = RoundedCornerShape(4.dp)
                                        clip = true
                                    }
                                    .background(Color.LightGray)
                                    .graphicsLayer {
                                        shape = RoundedCornerShape(4.dp)
                                        clip = true
                                    }
                            ) {
                                Box(Modifier.fillMaxSize().background(Color.Transparent))
                            }
                            Spacer(Modifier.size(6.dp))
                            Canvas(modifier = Modifier.fillMaxWidth().height(15.dp)) {

                            }
                        }

                    }
                    Column(
                        Modifier.weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(3),
                            contentPadding = PaddingValues(horizontal = 15.dp),
                        ) {
                            repeat(100) {
                                item {
                                    Spacer(Modifier.height(4.dp).background(Color.DarkGray))
                                }
                            }
                        }
                    }
                }
            )
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
