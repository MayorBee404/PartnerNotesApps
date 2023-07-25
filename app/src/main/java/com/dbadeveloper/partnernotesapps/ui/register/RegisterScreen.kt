package com.dbadeveloper.partnernotesapps.ui.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.dbadeveloper.partnernotesapps.R
import com.dbadeveloper.partnernotesapps.ui.component.InputType
import com.dbadeveloper.partnernotesapps.ui.login.TextInput

@Composable
fun RegisterScreen(navHostController: NavHostController) {
}


@Composable
fun Register (alpha: Float){
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment =  Alignment.Bottom),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Icon(
            modifier = Modifier
                .size(100.dp)
                .padding(24.dp)
                .alpha(alpha = alpha),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(id = R.string.logo_content_description),
            tint = MaterialTheme.colorScheme.primary,
        )
    }
    TextInput(InputType.Name, alpha)
    TextInput(InputType.Email, alpha)
    TextInput(InputType.Password, alpha)
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .alpha(alpha = alpha),

        ) {
        Text(
            text = "SIGN UP",
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
            text = "Do you have an account?",
            modifier = Modifier.padding(end = 8.dp),
            color = MaterialTheme.colorScheme.primary,
        )
        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = "SIGN IN",
                style = MaterialTheme.typography.titleMedium
            )

        }
    }
}