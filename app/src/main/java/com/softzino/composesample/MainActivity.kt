package com.softzino.composesample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import com.softzino.autoofix.ui.theme.ComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ComposeSampleTheme {
                Scaffold(
                    modifier =
                    Modifier
                        .imePadding()
                        .statusBarsPadding(),
                ) { innerPadding ->

                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier
) {

    Column { }
    CustomLayout(content = {
        Text("Hellow")
        Text("low")
    })
}


@Composable
fun CustomLayout(
    content: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier
) {
    Layout(
        content = { Column(content = content) },
        measurePolicy = { measurable, constrains ->

            val placeables = measurable.map {
                it.measure(
                    constrains.copy(
                        minWidth = constrains.minWidth + 10,
                        maxWidth = constrains.maxWidth + 10
                    )
                )
            }

            layout(width = placeables.sumOf { it.width }, height = placeables.sumOf { it.height }) {
                placeables.forEach {
                    it.place(0, 0)
                }

            }


        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeSampleTheme {
        Greeting(

        )
    }
}

