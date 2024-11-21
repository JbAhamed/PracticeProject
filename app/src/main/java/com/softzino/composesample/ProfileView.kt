import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun OTPScreen() {
    val size = 4

    val otpDigits = remember(size) { mutableStateListOf<String>() }

    repeat(size) {
        otpDigits.add("")
    }

    // FocusRequesters for each input field
    val focusRequesters = List(size) { FocusRequester() }

    val focusManager = LocalFocusManager.current

    LaunchedEffect(Unit) {
        delay(100)
        focusRequesters[0].requestFocus()
    }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Enter OTP",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 24.dp),
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            for (i in 0 until size) {
                OTPDigitBox(
                    value = otpDigits[i],
                    onValueChange = { newValue ->
                        if (newValue.length <= 1) {
                            otpDigits[i] = newValue
                            if (newValue.isNotEmpty()) {
                                if (i < size - 1) {
                                    focusRequesters[i + 1].requestFocus()
                                }
                            } else if (i > 0) {
                                focusRequesters[i - 1].requestFocus()
                            }
                        } else {
                            if (i < size - 1 && otpDigits[i + 1].isEmpty()) {
                                otpDigits[i + 1] = newValue.last().toString()
                                focusRequesters[i + 1].requestFocus()
                            }
                        }
                    },
                    focusRequester = focusRequesters[i],
                    modifier =
                        Modifier
                            .weight(1f)
                            .padding(horizontal = 4.dp),
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val otp = otpDigits.joinToString("")
                println("OTP entered: $otp")
            },
            modifier = Modifier.padding(top = 24.dp),
        ) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun OTPDigitBox(
    value: String,
    onValueChange: (String) -> Unit,
    focusRequester: FocusRequester,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = TextFieldValue(value, selection = TextRange(value.length)),
        onValueChange = {
            onValueChange(it.text)
        },
        singleLine = true,
        textStyle =
            TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.W600,
            ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier =
            modifier.focusRequester(focusRequester),
        colors =
            TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Transparent,
                errorCursorColor = Color.Transparent,
            ),
    )
}
