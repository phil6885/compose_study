package com.hongphil.composestudy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
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
//    CheckBox()
    RadioButtonGroup()
    /*
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

        val myImage = remember {
            mutableStateOf(R.drawable.second_image)
        }

        val textFieldState = rememberTextFieldState("")
        */
    /*
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = myImage.value),
                contentDescription = "First Image",
                modifier = Modifier.size(300.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.size(30.dp))

            Button(
                onClick = {
    //                buttonBackgroundColor.value = Color.Green
                    if (toggle) {
                        myImage.value = R.drawable.first_image
                        toggle = !toggle
                    } else {
                        myImage.value = R.drawable.second_image
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
            HongTextField(textFieldState)
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
        */
}


@Preview(showBackground = true)
@Composable
fun ComponentsPreview() {
    ComposeStudyTheme {
        Components()
    }
}


@Composable
fun HongTextField(state: TextFieldState) {
//    val state = rememberTextFieldState("")

    val passwordTransformation = OutputTransformation {
        val length = length
        replace(0, length, "*".repeat(length))
    }

    TextField(
        state = state,
        label = { Text("비밀번호") },
        outputTransformation = passwordTransformation
    )
}

@Composable
fun CheckBox() {
    val malecheckedStatus = remember { mutableStateOf(false) }
    val femalecheckedStatus = remember { mutableStateOf(true) }
    val gender = remember { mutableStateOf("Female") }
    val backgroundColor = remember {
        mutableStateOf(Color.Green)
    }


    val myColor = 0xFFE91E63
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ///////////////////////////
        val radioIndex = remember {
            mutableStateOf(0)
        }
        val radioList = listOf("Red", "Green", "Blue")

        radioList.forEachIndexed {position, name ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start

            ) {
                RadioButton(
                    selected = position == radioIndex.value,
                    onClick = {
                        radioIndex.value = position
                        gender.value = name
                    },
                )
                Spacer(modifier = Modifier.size(20.dp))
                Text(text = name)
            }
        }
        //////////////////////////

        Text(
            //if the inner 'remember' is changed,
            // the inclding 'remember' is also  changed and triggered
            text = "Gender is\n${gender.value}",
            fontSize = 24.sp,
            color = Color.White,
            modifier = Modifier
                .width(300.dp)
                .background(backgroundColor.value)
                .padding(20.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.size(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = malecheckedStatus.value,
                onCheckedChange = {
                    malecheckedStatus.value = it
                    femalecheckedStatus.value = !it
                    gender.value = "Male"
                },
                colors = CheckboxDefaults.colors(Color(myColor))
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Male")

        }

        Spacer(modifier = Modifier.size(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = femalecheckedStatus.value,
                onCheckedChange = {
                    femalecheckedStatus.value = it
                    malecheckedStatus.value = !it
                    gender.value = "Female"
                },
                colors = CheckboxDefaults.colors(Color(myColor))
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "Female")
        }
    }
}


@Composable
fun RadioButtonGroup() {
    val radioOptions = listOf("Option A", "Option B", "Option C")

    // Tracks the currently selected option
    var selectedOption by remember { mutableStateOf(radioOptions[0]) }

    // 1. Wrap the container in selectableGroup() for screen readers
    Column(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            // 2. Make the entire Row selectable for a larger touch target
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = { selectedOption = text },
                        role = Role.RadioButton // Informs accessibility services
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 3. Set RadioButton onClick to null so the Row handles interactions
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Text(
                    text = text,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }
}