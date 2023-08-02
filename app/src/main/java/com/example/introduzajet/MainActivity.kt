package com.example.introduzajet

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.introduzajet.ui.theme.DebugButtonColors
import com.example.introduzajet.ui.theme.ErrorButtonColors
import com.example.introduzajet.ui.theme.InfoButtonColors
import com.example.introduzajet.ui.theme.IntroduzajetTheme
import com.example.introduzajet.ui.theme.WarningButtonColors
import kotlinx.coroutines.runBlocking

const val TAG = "teste Androd"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroduzajetTheme {
                // A surface container using the 'background' color from the theme
                    App()
            }
        }
    }
}

@Composable
fun App() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Greeting("Android")
            ActionButton(
                text = "Debug",
                buttonColors = DebugButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Log.d(TAG, "App clicou em Debug")

            }
            ActionButton(
                text = "Info",
                buttonColors = InfoButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Log.d(TAG, "App clicou em INFO")
            }
            ActionButton(
                text = "Warnig",
                buttonColors = WarningButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Log.d(TAG, "App clicou em Warnig")
            }
            ActionButton(
                text = "Error",
                buttonColors = ErrorButtonColors(),
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Log.d(TAG, "App clicou em Error")
            }
        }
    }
}


@Preview(showBackground = true, widthDp = 150, heightDp = 200)
@Composable
fun AppPreview(){
    IntroduzajetTheme {
        App()

    }
}

@Composable
 fun ActionButton(
    text: String,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier,
    block: () -> Unit,
    ){
    ElevatedButton(
        onClick = block,
        shape = RoundedCornerShape(5.dp),
        colors = buttonColors,
        modifier = modifier,
    ){
Text(text = text)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview (showBackground = true)
@Composable
fun ActionButtonPreview(){
    ActionButton(text = " Cadastrar"){

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IntroduzajetTheme {
        Greeting("Android")
    }
}