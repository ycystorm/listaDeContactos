package co.edu.sena.proyecto.model.tutorial2

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.edu.sena.proyecto.model.tutorial2.ui.theme.Tutorial2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Tutorial2Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Column {
                        MessageCard(Message("Lina", "Te envio un mensaje"))
                        MessageCard(
                            Message(
                                "Colleague",
                                "Test...Test...Test..."
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "List of Android versions:\n" +
                                        "Android KitKat (API 19)\n" +
                                        "Android Lollipop (API 21)\n" +
                                        "Android Marshmallow (API 23)\n" +
                                        "Android Nougat (API 24)\n" +
                                        "Android Oreo (API 26)\n" +
                                        "Android Pie (API 28)\n" +
                                        "Android 10 (API 29)\n" +
                                        "Android 11 (API 30)\n" +
                                        "Android 12 (API 31)\n"
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "I think Kotlin is my favorite programming language.\n" +
                                        "It's so much fun!"
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "Searching for alternatives to XML layouts..."
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "Hey, take a look at Jetpack Compose, it's great!\n" +
                                        "It's the Android's modern toolkit for building native UI." +
                                        "It simplifies and accelerates UI development on Android." +
                                        "Less code, powerful tools, and intuitive Kotlin APIs :)"
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "It's available from API 21+ :)"
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "Android Studio next version's name is Arctic Fox"
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "I didn't know you can now run the emulator directly from Android Studio"
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "Compose Previews are great to check quickly how a composable layout looks like"
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "Previews are also interactive after enabling the experimental setting"
                            )
                        )
                        MessageCard(
                            Message(
                                "Colleague",
                                "Have you tried writing build.gradle with KTS?"
                            )
                        )
                    }

                }
            }
        }
    }
}


data class Message(val author: String, val body: String)

@Composable
fun MessageCard(msg: Message) {
    // Add padding around our message
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.bokuno),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(20.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleLarge
            )
            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )

            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Preview
@Composable
fun PreviewMessageCard() {
    Tutorial2Theme {
        Surface {
            MessageCard(
                msg = Message(" Lina", "Take a look at Jetpack Compose, it's great!")
            )
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    Tutorial2Theme {
        Conversation(Tutorial.conversationSample)
    }
}