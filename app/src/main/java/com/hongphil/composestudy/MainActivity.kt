package com.hongphil.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.insert
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hongphil.composestudy.ui.theme.ComposeStudyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeStudyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Components()
                }
            }
        }
    }
}

@Composable
fun Components() {

    var toggle = false
    val buttonBackgroundColor = remember {
        mutableStateOf(Color.Red)
    }

    val buttonText = remember {
        mutableStateOf("Button")
    }

    val valueOnTextField = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
//                buttonBackgroundColor.value = Color.Green
                if (toggle) {
                    buttonText.value = "Clicked!"
                    toggle = !toggle
                } else {
                    buttonText.value = "Touched"
                    toggle = !toggle

                }
            },
            modifier = Modifier.size(250.dp, 60.dp),
            // use 'containerColor' instead of 'backgroundColor' from Material 3
            colors = ButtonDefaults.buttonColors(containerColor = buttonBackgroundColor.value),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(3.dp, Color.Black)
        ) {
            Text(
                text = buttonText.value,
                color = Color.White,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.size(30.dp))
        HongTextField()
        /*
        TextField(
            value = valueOnTextField.value,
            onValueChange = { valueOnTextField.value = it },
            label = { Text(text = "Enter your name")},
            modifier = Modifier.width(300.dp),
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.Gray,
                focusedContainerColor = Color.Blue,
                unfocusedContainerColor = Color.Green,
                focusedLabelColor = Color.Red,
                unfocusedLabelColor = Color.White,
                focusedIndicatorColor = Color.Green,
                unfocusedIndicatorColor = Color.Red,
            ),
            textStyle = MaterialTheme.typography.bodyMedium,
            maxLines = 2,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            visualTransformation = PasswordVisualTransformation()
        )
        */
    }
}



@Preview(showBackground = true)
@Composable
fun ComponentsPreview() {
    ComposeStudyTheme {
        Components()
    }
}

@Composable
fun HongTextField () {
    val state = rememberTextFieldState("")

    val passwordTransformation = OutputTransformation {
        val length = length
        replace(0, length, "*".repeat(length))
    }

    TextField(
        state = state,
        label = { Text("비밀번호") },
        outputTransformation = passwordTransformation)
}