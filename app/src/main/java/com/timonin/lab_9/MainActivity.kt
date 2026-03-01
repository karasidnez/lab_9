package com.timonin.lab_9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.timonin.lab_9.data.Datasource
import com.timonin.lab_9.model.Game
import com.timonin.lab_9.ui.theme.Lab_9Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_9Theme {
                GameCatalogApp()
            }
        }
    }
}

@Composable
fun GameCard(
    game: Game,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 8.dp
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(game.imageResourceId),
                contentDescription = stringResource(game.titleResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(game.titleResourceId),
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(game.descriptionResourceId),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun NavigationButtons(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(stringResource(R.string.previous))
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = onNextClick,
            modifier = Modifier.weight(1f)
        ) {
            Text(stringResource(R.string.next))
        }
    }
}

@Composable
fun GameCatalogApp() {
    val games = remember { Datasource().loadGameList() }
    var currentIndex by remember { mutableStateOf(0) }

    fun nextGame() {
        currentIndex = (currentIndex + 1) % games.size
    }

    fun previousGame() {
        currentIndex = if (currentIndex > 0) currentIndex - 1 else games.size - 1
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GameCard(
            game = games[currentIndex],
            modifier = Modifier.weight(1f)
        )

        // Индикатор текущей позиции
        Text(
            text = "${currentIndex + 1} / ${games.size}",
            modifier = Modifier.padding(8.dp)
        )

        NavigationButtons(
            onPreviousClick = ::previousGame,
            onNextClick = ::nextGame
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GameCatalogAppPreview() {
    Lab_9Theme {
        GameCatalogApp()
    }
}