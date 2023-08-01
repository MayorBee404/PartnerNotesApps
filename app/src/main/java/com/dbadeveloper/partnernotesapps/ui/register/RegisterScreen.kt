package com.dbadeveloper.partnernotesapps.ui.register

import android.content.Context
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dbadeveloper.partnernotesapps.R
import com.dbadeveloper.partnernotesapps.navigation.Screen
import com.dbadeveloper.partnernotesapps.ui.component.InputType
import com.dbadeveloper.partnernotesapps.ui.component.TextInput
import com.dbadeveloper.partnernotesapps.ui.component.TextInputPassword
import com.dbadeveloper.partnernotesapps.ui.theme.PartnerNotesAppsTheme
import kotlinx.coroutines.delay

@Composable
fun RegisterScreen(navHostController: NavHostController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        ), label = ""
    )
    LaunchedEffect(key1 = true ) {
        startAnimation = true
        delay(3000)
    }

    Register(alphaAnimation.value, navHostController)
}


@Composable
fun Register (alpha: Float, navHostController: NavHostController){

    val nameValue by remember { mutableStateOf("") }
    val usernameValue by remember { mutableStateOf("") }
    val passwordValue by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(24.dp)
            .navigationBarsPadding().imePadding()
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment =  Alignment.Bottom),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 24.dp)
                .alpha(alpha = alpha),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.logo_content_description),
            tint = MaterialTheme.colorScheme.primary,
        )
        TextInput(InputType.Name, alpha, nameValue)
        TextInput(InputType.Username, alpha, usernameValue)
        TextInputPassword(InputType.Password, alpha, passwordValue)
        Button(
            onClick = { context.doRegister() },
            modifier = Modifier
                .fillMaxWidth()
                .alpha(alpha = alpha),

            ) {
            Text(
                text = "SIGN UP",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )
        }
        Divider(
            color = MaterialTheme.colorScheme.primary,
            thickness = 1.dp,
            modifier = Modifier
                .padding(
                    top = 18.dp,
                )
                .alpha(alpha = alpha)
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Do have an account?",
                modifier = Modifier.padding(end = 8.dp),
                color = MaterialTheme.colorScheme.primary,
            )
            TextButton(onClick = { navHostController.navigate(Screen.Login.route) }) {
                Text(
                    text = "SIGN IN",
                    style = MaterialTheme.typography.titleMedium
                )

            }
        }
    }
}

private fun Context.doRegister() {
    Toast.makeText(
        this,
        "Something went wrong, try again later!",
        Toast.LENGTH_SHORT
    ).show()
}

fun CheckRegister(fullname: String, username: String, password: String): Boolean {
    return true
}

@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun RegisterScreenPreview() {
    PartnerNotesAppsTheme {
        Surface{
            Register(alpha = 1f, navHostController = rememberNavController())
        }
    }
}
