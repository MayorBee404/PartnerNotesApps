package com.dbadeveloper.partnernotesapps.compose.login

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
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
import com.dbadeveloper.partnernotesapps.compose.component.InputType
import com.dbadeveloper.partnernotesapps.compose.component.TextInput
import com.dbadeveloper.partnernotesapps.compose.component.TextInputPassword
import com.dbadeveloper.partnernotesapps.ui.navigation.Screen
import com.dbadeveloper.partnernotesapps.ui.theme.PartnerNotesAppsTheme
import kotlinx.coroutines.delay

@Composable
fun LoginScreen(navHostController: NavHostController) {
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

    Login(alphaAnimation.value, navHostController)

}
@Composable
fun Login (alpha: Float, navHostController: NavHostController) {

    var emailValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .padding(24.dp)
            .systemBarsPadding()
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
        TextInput(InputType.Email, alpha){
            value -> emailValue = value
        }
        TextInputPassword(InputType.Password, alpha){
            value -> passwordValue = value
        }
        Button(
            onClick = { context.checkLogin(emailValue, passwordValue) },
            modifier = Modifier
                .fillMaxWidth()
                .alpha(alpha = alpha),

        ) {
            Text(
                text = "SIGN IN",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp))
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
                text = "Don't have an account?",
                modifier = Modifier.padding(end = 8.dp),
                color = MaterialTheme.colorScheme.primary,
            )
            TextButton(onClick = { navHostController.navigate(Screen.Register.route) }) {
                Text(
                    text = "SIGN UP",
                    style = MaterialTheme.typography.titleMedium
                )

            }
        }
    }
}

private fun Context.doLogin() {
    Toast.makeText(
        this,
        "Something went wrong! Try again later!",
        Toast.LENGTH_SHORT
    ).show()

}

fun Context.checkLogin (email: String, password: String): Boolean {
    if (email == "admin@admin.com" && password == "admin"){
        Toast.makeText(
            this,
            "Logged in successfully!",
            Toast.LENGTH_SHORT
        ).show()
        return true
    }
    Toast.makeText(
        this, " Email & Password not valid!",
        Toast.LENGTH_SHORT
    ).show()
    return false

}



@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun LoginScreenPreview() {
    PartnerNotesAppsTheme {
        Surface{
            Login(
                alpha = 1f,
                navHostController = rememberNavController()
            )
        }
    }
}
