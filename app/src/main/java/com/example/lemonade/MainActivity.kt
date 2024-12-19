package com.example.lemonade

//import android.graphics.fonts.FontFamily
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LamonadeMain(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
val headingFont = FontFamily(
    Font(R.font.bungee, FontWeight.Normal)
)
@Composable
fun LamonadeCenter(modifier: Modifier = Modifier) {
    var counter by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "CLICK IT..",
            fontSize = 20.sp,
            fontFamily = headingFont
        )
        Spacer(modifier = Modifier.height(20.dp))
        Box {
            when (counter) {
                1 -> {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val image = painterResource(R.drawable.lemon_tree)
                        Image(
                            painter = image,
                            contentDescription = counter.toString(),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable{
                                    counter = 2
                                }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = stringResource(R.string.pickLemon),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                2 -> {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val image = painterResource(R.drawable.lemon_squeeze)
                        Image(
                            painter = image,
                            contentDescription = counter.toString(),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable{
                                    counter = 3
                                }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = stringResource(R.string.squeze),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                3 -> {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val image = painterResource(R.drawable.lemon_drink)
                        Image(
                            painter = image,
                            contentDescription = counter.toString(),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable{
                                    counter = 4
                                }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = stringResource(R.string.drink),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
                4 -> {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val image = painterResource(R.drawable.lemon_restart)
                        Image(
                            painter = image,
                            contentDescription = counter.toString(),
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable{
                                    counter = 1
                                }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = stringResource(R.string.finished),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LamonadeMain(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth() // Ensures the Column spans the full width
            .padding(top = 40.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Box(
            modifier = Modifier
                .background(color = Color.Yellow)
                .fillMaxWidth(), // Ensures the Box spans the full width
            contentAlignment = Alignment.Center // Aligns all content within the Box
        ) {
            Text(
                text = stringResource(R.string.topTitle),
                fontFamily = headingFont,
//                fontWeight = FontWeight.Bold,
                fontSize = 16.sp, // Adjusted font size for better visibility
                modifier = Modifier.padding(top = 7.dp, bottom = 7.dp),
                textAlign = TextAlign.Center // Ensures the text is centered inside the Box
            )
        }
    }
    Column (modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
            LamonadeCenter()
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LamonadeMain(modifier = Modifier)
    }
}
