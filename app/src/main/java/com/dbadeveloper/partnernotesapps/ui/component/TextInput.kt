package com.dbadeveloper.partnernotesapps.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(inputType: InputType, alpha: Float, value: String) {
    var value : String by remember { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = { value = it},
        modifier = Modifier
            .fillMaxWidth()
            .alpha(alpha = alpha),
        leadingIcon = {
            Icon(imageVector = inputType.icon,
                contentDescription = inputType.label
            )
        },
        label = {
            Text(text = inputType.label)
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(50.dp),
        singleLine = true,
        keyboardOptions = inputType.keyboardOptions,
        visualTransformation = inputType.visualTransformation
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputPassword(inputType: InputType, alpha: Float, value: String) {
    var value : String by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    TextField(
        value = value,
        onValueChange = { value = it},
        modifier = Modifier
            .fillMaxWidth()
            .alpha(alpha = alpha),
        leadingIcon = {
            Icon(imageVector = inputType.icon,
                contentDescription = inputType.label
            )
        },
        trailingIcon = {
            if (showPassword) {
                IconButton(onClick = { showPassword = false }) {
                    Icon(
                        imageVector = Icons.Filled.Visibility,
                        contentDescription = "hide_password"
                    )
                }
            } else {
                IconButton(
                    onClick = { showPassword = true }) {
                    Icon(
                        imageVector = Icons.Filled.VisibilityOff,
                        contentDescription = "hide_password"
                    )
                }
            }
        },
        visualTransformation = if (showPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        label = {
            Text(text = inputType.label)
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(50.dp),
        singleLine = true,
        keyboardOptions = inputType.keyboardOptions,
    )
}